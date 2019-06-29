package com.briup.environment.client;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface Client extends WossModule{
	/**
	 * send方法用于与服务器端进行交互，发送Environment集合至服务器端。
	 * @param coll
	 * @throws Exception
	 */
	public void send(Collection<Environment> coll)throws Exception;

}






