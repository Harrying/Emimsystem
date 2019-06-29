package com.briup.environment.util;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;

public interface Configuration {
	/**
	 * ��ȡ��־ģ���ʵ��
	 * @return ��־����
	 * @throws Exception
	 */
	public Log getLogger()throws Exception;
	/**
	 * ��ȡ�������˵�ʵ��
	 * @return ����������
	 * @throws Exception
	 */
	public Server getServer()throws Exception;
	/**
	 * ��ȡ�ͻ��˵�ʵ��
	 * @return  �ͻ��˶���
	 * @throws Exception
	 */
	public Client getClient()throws Exception;
	/**
	 * ��ȡ���ģ���ʵ��
	 * @return  ������
	 * @throws Exception
	 */
	public DBStore getDbStore()throws Exception;
	/**
	 * ��ȡ�ɼ�ģ���ʵ��
	 * @return  �ɼ�����
	 * @throws Exception
	 */
	public Gather getGather()throws Exception;
	/**
	 * ��ȡ��¼ģ���ʵ��
	 * @return  ��¼����
	 * @throws Exception
	 */
	
	public Backup getBackup() throws Exception;
	//public Login getLogin()throws Exception;
}
