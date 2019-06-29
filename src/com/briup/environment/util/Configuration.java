package com.briup.environment.util;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;

public interface Configuration {
	/**
	 * 获取日志模块的实例
	 * @return 日志对象
	 * @throws Exception
	 */
	public Log getLogger()throws Exception;
	/**
	 * 获取服务器端的实例
	 * @return 服务器对象
	 * @throws Exception
	 */
	public Server getServer()throws Exception;
	/**
	 * 获取客户端的实例
	 * @return  客户端对象
	 * @throws Exception
	 */
	public Client getClient()throws Exception;
	/**
	 * 获取入库模块的实例
	 * @return  入库对象
	 * @throws Exception
	 */
	public DBStore getDbStore()throws Exception;
	/**
	 * 获取采集模块的实例
	 * @return  采集对象
	 * @throws Exception
	 */
	public Gather getGather()throws Exception;
	/**
	 * 获取登录模块的实例
	 * @return  登录对象
	 * @throws Exception
	 */
	
	public Backup getBackup() throws Exception;
	//public Login getLogin()throws Exception;
}
