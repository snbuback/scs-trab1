package com.pucrj.scs.trab3.event;

import scs.core.IComponent;

public interface ChannelFactory {
 
	public abstract IComponent create(String name);
	public abstract void destroy(String name);
}
 
