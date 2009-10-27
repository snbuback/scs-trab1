package com.pucrj.scs.trab3.log.monitorImpl;

import com.pucrj.scs.trab3.log.MonitorConfiguration;
import java.io.File;

public class MonitorConfigurationImpl implements MonitorConfiguration {
 
	private FileMonitoring[] filesToMonitoring;
	 
	/**
	 *  
	 */
	public void verifyModifications() {
	 
	}
	 
	/**
	 * Gera um evento de modificação
	 * Disparar o evento gerado
	 * Atualiza a hora do arquivo no fileMonitoring
	 *
	 *  
	 */
	public void generateFileModifcationEvent(FileMonitoring file) {
	 
	}
	 
	/**
	 * @see com.pucrj.scs.trab3.Log.MonitorConfiguration#addFile(java.io.File)
	 */
	public void addFile(File file) {
	 
	}
	 
	/**
	 * @see com.pucrj.scs.trab3.Log.MonitorConfiguration#getMonitoringFiles()
	 */
	public String[] getMonitoringFiles() {
		return null;
	}
	 
	/**
	 * @see com.pucrj.scs.trab3.Log.MonitorConfiguration#getHost()
	 * 
	 *  
	 */
	public void getHost() {
	 
	}
	 
}
 
