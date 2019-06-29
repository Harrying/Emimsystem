package com.briup.environment.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.Backup;
import com.briup.environment.util.BackupImpl;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.ConfigurationAWare;
import com.briup.environment.util.Log;

/*
 * 该类主要 用来 数据入库
 */
public class DBStoreImpl implements DBStore,ConfigurationAWare {
	//备份文件路径
	private String backUpPath;
	//数据库四要素
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private Configuration config;

	@Override
	public void setConfiguration(Configuration config) throws Exception {
		this.config = config;
	}
	
	@Override
	public void init(Properties prop) throws Exception {
		backUpPath = prop.getProperty("backUpPath");
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}

	//数据库入库
	@Override
	public void saveDb(Collection<Environment> coll) throws Exception {
		//1.判断备份文件是否存在
		Backup b = config.getBackup();
		Log logger = config.getLogger();
		
		List<Environment> bList = 
				(List<Environment>) b.load(backUpPath);
		
		if(bList != null) {
			//将obj集合 和 coll合并
			bList.addAll(coll);
			coll = bList;
			
			//删除备份文件
			b.deleteBackup(backUpPath);
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		//定义一个 计数器
		int count = 0;
		
		try {
			//1.注册驱动
			Class.forName(driver);
			
			//2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			logger.info("建立数据库连接成功,conn: " + conn);
			
			//修改事务为手动提交
			conn.setAutoCommit(false);
			logger.info("修改事务管理为手动...");
			
			//3.获取ps对象
			String sql = "insert into e_detail values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			//4.填入?值 然后执行sql语句
			logger.info("开始插入数据...");
			logger.info("coll.size: " + coll.size());
			
			for (Environment en : coll) {
				//计数器加1
				count++;
				
				//将每个对象属性值 填入?中
				ps.setString(1, en.getName());
				ps.setString(2, en.getSrcId());
				ps.setString(3, en.getDstId());
				ps.setString(4, en.getSersorAddress());
				ps.setInt(5, en.getCount());
				ps.setString(6, en.getCmd());
				ps.setInt(7, en.getStatus());
				ps.setDouble(8, en.getData());
				long t = en.getGather_date().getTime();
				ps.setDate(9, new java.sql.Date(t));
				
				//添加到批处理中
				ps.addBatch();
				
//				int num;
//				if(count == 245) {
//					//除数为0，则自动抛出异常
//					num = count / 0;
//				}
				
				//每200条或到最后一条 执行批处理 提交事务
				if(count % 200 == 0 || count == coll.size()) {
					//执行批处理
					ps.executeBatch();
					//提交事务
					conn.commit();
					logger.info("目前有 " + count + " 条数据插入成功");
				}
			}
			
			logger.info("插入数据完成，一共插入 " + count + "条数据");
			logger.info("提交事务成功，数据全部成功写入!");
		} catch (Exception e) {
			logger.error("入库过程中第"+count+"条出现异常");
			//输出异常的详细信息
			//e.printStackTrace();
			//logger.error(e.getMessage());
			logger.error(e.toString());
			
			//事务回滚
			conn.rollback();
			logger.info("事务回滚成功!");
			
			//a.获取入库的数据个数
			int size;//200   [0,199] [200,400)
			if(count % 200 == 0) {
				size = count - 200;
			}else {
				size = count - count % 200;
			}
			logger.info("已经入库的数据有: " + size);
			
			//b.获取尚未入库的所有数据
			List<Environment> allList = 
					(List<Environment>)coll;
			List<Environment> noList = 
					allList.subList(size, coll.size());
			logger.info("尚未入库的数据有: " + noList.size());
			
			ArrayList<Environment> noList2 = new ArrayList<>();
			noList2.addAll(noList);
			
			//c.将尚未入库数据写入本地文件
			logger.info("开始备份...");
			Backup bu = new BackupImpl();
			bu.backup(backUpPath, noList2);
			logger.info("备份成功!");
			
		} finally {
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
	}
}
