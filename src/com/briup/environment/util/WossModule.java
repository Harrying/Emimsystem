package com.briup.environment.util;

import java.util.Properties;

public interface WossModule {
	/**
	 * ������Ҫ��������Ϣ���ݽ����࣬����õ�������Ϣ����г�ʼ����<br/>
	 * ������ִ�и�����������֮ǰ����ִ���������
	 * @param properties һ��Propertiesʵ����װ�˳�ʼ������ĸ���������Ϣ
	 * @throws Exception
	 */
	public void init(Properties properties)throws Exception;

}
