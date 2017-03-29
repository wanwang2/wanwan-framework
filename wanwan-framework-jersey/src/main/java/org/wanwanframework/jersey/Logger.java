package org.wanwanframework.jersey;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Logger {

	public static void warn(Object object, String message, Exception e) {
		Log log = LogFactory.getLog(object.getClass().getName());
		if(log.isWarnEnabled()) {
			if(e == null) {
				log.warn(message);
			} else {
				log.warn(message, e);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void info(Class clazz, String message) {
		Log log = LogFactory.getLog(clazz.getName());
		if(log.isInfoEnabled()) {
			log.info(message);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void error(Class clazz, String message) {
		Log log = LogFactory.getLog(clazz.getName());
		if(log.isErrorEnabled()) {
			log.error(message);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void log(Class clazz, String message) {
		Log log = LogFactory.getLog(clazz.getName());
		if(log.isTraceEnabled()) {
			log.trace(message);
		}
		
	}
}
