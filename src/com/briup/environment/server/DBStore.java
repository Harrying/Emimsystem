package com.briup.environment.server;

import java.util.Collection;
import com.briup.environment.bean.Environment;
import com.briup.environment.util.WossModule;

public interface DBStore extends WossModule{
	/**
	 * ��BIDR���Ͻ��г־û� ��
	 * @param coll ��Ҫ�����Environment����
	 * @throws Exception
	 */
	public void saveDb(Collection<Environment> coll)throws Exception;
}
