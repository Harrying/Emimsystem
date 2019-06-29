package com.briup.environment.util;

import java.util.Properties;

public interface WossModule {
	/**
	 * 将所需要的配置信息传递进该类，该类得到配置信息后进行初始化。<br/>
	 * 建议在执行该类其他方法之前，先执行这个方法
	 * @param properties 一个Properties实例封装了初始化所需的各种配置信息
	 * @throws Exception
	 */
	public void init(Properties properties)throws Exception;

}
