package com.pucrj.scs.trab3.event;

import com.pucrj.scs.trab3.event.Event;

public interface EventSink {
 
	public abstract void push(Event ev);
	public abstract void disconnect();
}
 
