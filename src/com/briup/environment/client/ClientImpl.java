package com.briup.environment.client;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.ConfigurationAWare;
import com.briup.environment.util.Log;
import com.briup.environment.util.LogImpl;

/*
 * �ͻ���ʵ���࣬��Ҫ������������ ���� ���϶���
 */
public class ClientImpl implements Client,ConfigurationAWare {

	private String serverIp;
	private int serverPort;
	
	private Configuration config;
	
	@Override
	public void setConfiguration(Configuration config) throws Exception {
		this.config = config;
	}
	
	@Override
	public void init(Properties properties) throws Exception {
		serverIp = properties.getProperty("serverIp");
		String sPort = properties.getProperty("serverPort");
		serverPort = Integer.parseInt(sPort);
	}

	//��дsend��������coll���϶��� ���͵���������
	@Override
	public void send(Collection<Environment> coll) throws Exception {
		Log logger = config.getLogger();
		
		//1.�һ���ͻ���
		Socket client = 
				new Socket(InetAddress.getByName(serverIp), serverPort);
		logger.info("�ͻ������ӵ��������ɹ�...");
		
		//2.��ȡ���ݴ����������
		ObjectOutputStream oos = 
				new ObjectOutputStream(client.getOutputStream());
		
		//3.����coll��������
		oos.writeObject(coll);
		
		//4.�ر��� �ͷ���Դ
		oos.close();
		client.close();
		logger.info("�ͻ��˷������ݳɹ�!");
	}
}





