package com.briup.environment.server;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface Server extends WossModule{
	/**
	 * 该方法用于启动这个Server服务，开始接收客户端传递的信息，<br/>
	 * 并且调用DBStore将接收的数据持久化
	 * @return 接受的Environment数据的集合
	 * @throws Exception
	 */
	public Collection<Environment> reciver()throws Exception;
}
