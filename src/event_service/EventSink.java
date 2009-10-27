package event_service;

import event_service.Event;

public interface EventSink {
 
	public abstract void push(Event ev);
	public abstract void disconnect();
}
 
