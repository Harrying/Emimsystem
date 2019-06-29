package com.briup.environment.util;

public interface Log extends WossModule{
	/**
	 * ��¼Debug�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void debug(String message);
	/**
	 * ��¼Info�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void info(String message);
	/**
	 * ��¼Warn�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void warn(String message);
	/**
	 * ��¼Error�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void error(String message);
	/**
	 * ��¼Fatal�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void fatal(String message);
}
