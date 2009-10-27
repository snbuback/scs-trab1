package com.pucrj.scs.trab3.log;

import event_service.Event;
import java.util.Date;

public interface FileModificationEvent extends Event {
 
	private String fileName;
	 
	private String host;
	 
	private String ip;
	 
	private Date date;
	 
}
 
