package event_service;

import scs.core.IComponent;

public interface ChannelCollection {
 
	/**
	 *  
	 */
	public abstract IComponent getChannel(String name);
	public abstract ChannelDescrSeq getAll();
}
 
