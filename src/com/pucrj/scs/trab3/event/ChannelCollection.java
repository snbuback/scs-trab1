package com.pucrj.scs.trab3.event;

import scs.core.IComponent;

public interface ChannelCollection {
 
	/**
	 *  
	 */
	public abstract IComponent getChannel(String name);
	public abstract ChannelDescrSeq getAll();
}
 
