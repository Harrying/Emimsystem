package com.briup.environment.client;

import java.util.Collection;
import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface Gather extends WossModule{
	/**
	 * �ɼ����ܼҾӵĻ�����Ϣ�������ݷ�װΪEnvironment���Ϸ��ء�
	 * @return �ɼ���װEnvironment���ݵļ���
	 * @throws Exception
	 */
	public Collection<Environment> gather()throws Exception;
}
