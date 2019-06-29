package com.briup.environment.server;

import java.util.Collection;
import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface DBStore extends WossModule{
	/**
	 * 将BIDR集合进行持久化 。
	 * @param coll 需要储存的Environment集合
	 * @throws Exception
	 */
	public void saveDb(Collection<Environment> coll)throws Exception;
}
