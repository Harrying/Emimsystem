package com.briup.environment.client;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface Client extends WossModule{
	/**
	 * send����������������˽��н���������Environment�������������ˡ�
	 * @param coll
	 * @throws Exception
	 */
	public void send(Collection<Environment> coll)throws Exception;

}






