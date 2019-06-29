package com.briup.environment.server;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface Server extends WossModule{
	/**
	 * �÷��������������Server���񣬿�ʼ���տͻ��˴��ݵ���Ϣ��<br/>
	 * ���ҵ���DBStore�����յ����ݳ־û�
	 * @return ���ܵ�Environment���ݵļ���
	 * @throws Exception
	 */
	public Collection<Environment> reciver()throws Exception;
}
