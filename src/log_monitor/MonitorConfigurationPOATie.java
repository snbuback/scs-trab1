package log_monitor;


/**
* log_monitor/MonitorConfigurationPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Wednesday, October 28, 2009 3:12:44 AM BRST
*/

public class MonitorConfigurationPOATie extends MonitorConfigurationPOA
{

  // Constructors

  public MonitorConfigurationPOATie ( log_monitor.MonitorConfigurationOperations delegate ) {
      this._impl = delegate;
  }
  public MonitorConfigurationPOATie ( log_monitor.MonitorConfigurationOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public log_monitor.MonitorConfigurationOperations _delegate() {
      return this._impl;
  }
  public void _delegate (log_monitor.MonitorConfigurationOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void addFile (String file)
  {
    _impl.addFile(file);
  } // addFile

  public String[] getMonitoringFiles ()
  {
    return _impl.getMonitoringFiles();
  } // getMonitoringFiles

  public String getHost ()
  {
    return _impl.getHost();
  } // getHost

  private log_monitor.MonitorConfigurationOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class MonitorConfigurationPOATie
