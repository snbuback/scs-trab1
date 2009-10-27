package com.pucrj.scs.trab3.log;

import java.io.File;

public interface MonitorConfiguration {
 
	/**
	 * Intervalo de tempo que em as modificações serão lidas
	 */
	private Long interval;
	 
	public abstract void addFile(File file);
	public abstract String[] getMonitoringFiles();
	/**
	 *  
	 */
	public abstract void getHost();
}
 
