package com.briup.environment.client;

import java.util.Collection;
import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface Gather extends WossModule{
	/**
	 * 采集智能家居的环境信息，将数据封装为Environment集合返回。
	 * @return 采集封装Environment数据的集合
	 * @throws Exception
	 */
	public Collection<Environment> gather()throws Exception;
}
