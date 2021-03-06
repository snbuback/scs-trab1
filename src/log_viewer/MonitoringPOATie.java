package log_viewer;


/**
* log_viewer/MonitoringPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Sunday, November 8, 2009 6:21:06 PM BRST
*/

public class MonitoringPOATie extends MonitoringPOA
{

  // Constructors

  public MonitoringPOATie ( log_viewer.MonitoringOperations delegate ) {
      this._impl = delegate;
  }
  public MonitoringPOATie ( log_viewer.MonitoringOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public log_viewer.MonitoringOperations _delegate() {
      return this._impl;
  }
  public void _delegate (log_viewer.MonitoringOperations delegate ) {
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
  public log_monitor.FileModificationEvent[] getModifications ()
  {
    return _impl.getModifications();
  } // getModifications

  public void clear ()
  {
    _impl.clear();
  } // clear

  private log_viewer.MonitoringOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class MonitoringPOATie
