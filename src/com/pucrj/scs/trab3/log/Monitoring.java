package com.pucrj.scs.trab3.log;


/**
 * Contém operações para buscar a lista de modificações existente e 
 * também para limpar a lista de modificações.
 */
public interface Monitoring {
 
	public abstract FileModificationEvent[] getModifications();
	/**
	 *  
	 */
	public abstract void clear();
}
 
