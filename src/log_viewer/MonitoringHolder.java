package log_viewer;

/**
* log_viewer/MonitoringHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Sunday, November 8, 2009 6:21:06 PM BRST
*/

public final class MonitoringHolder implements org.omg.CORBA.portable.Streamable
{
  public log_viewer.Monitoring value = null;

  public MonitoringHolder ()
  {
  }

  public MonitoringHolder (log_viewer.Monitoring initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = log_viewer.MonitoringHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    log_viewer.MonitoringHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return log_viewer.MonitoringHelper.type ();
  }

}
