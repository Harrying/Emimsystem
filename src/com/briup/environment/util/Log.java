package com.briup.environment.util;

public interface Log extends WossModule{
	/**
	 * 记录Debug级别的日志
	 * @param message 需要记录的日志信息
	 */
	public void debug(String message);
	/**
	 * 记录Info级别的日志
	 * @param message 需要记录的日志信息
	 */
	public void info(String message);
	/**
	 * 记录Warn级别的日志
	 * @param message 需要记录的日志信息
	 */
	public void warn(String message);
	/**
	 * 记录Error级别的日志
	 * @param message 需要记录的日志信息
	 */
	public void error(String message);
	/**
	 * 记录Fatal级别的日志
	 * @param message 需要记录的日志信息
	 */
	public void fatal(String message);
}
