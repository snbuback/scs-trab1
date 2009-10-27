package com.pucrj.scs.trab3.log;

import com.pucrj.scs.trab3.event.Event;
import java.util.Date;

public interface FileModificationEvent extends Event {
 
	private String fileName;
	 
	private String host;
	 
	private String ip;
	 
	private Date date;
	 
}
 
