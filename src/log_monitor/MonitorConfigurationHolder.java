package log_monitor;

/**
* log_monitor/MonitorConfigurationHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Tuesday, October 27, 2009 9:37:08 PM BRST
*/

public final class MonitorConfigurationHolder implements org.omg.CORBA.portable.Streamable
{
  public log_monitor.MonitorConfiguration value = null;

  public MonitorConfigurationHolder ()
  {
  }

  public MonitorConfigurationHolder (log_monitor.MonitorConfiguration initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = log_monitor.MonitorConfigurationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    log_monitor.MonitorConfigurationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return log_monitor.MonitorConfigurationHelper.type ();
  }

}
