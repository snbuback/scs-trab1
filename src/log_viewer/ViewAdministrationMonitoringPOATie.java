package log_viewer;


/**
* log_viewer/ViewAdministrationMonitoringPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Tuesday, October 27, 2009 9:37:08 PM BRST
*/

public class ViewAdministrationMonitoringPOATie extends ViewAdministrationMonitoringPOA
{

  // Constructors

  public ViewAdministrationMonitoringPOATie ( log_viewer.ViewAdministrationMonitoringOperations delegate ) {
      this._impl = delegate;
  }
  public ViewAdministrationMonitoringPOATie ( log_viewer.ViewAdministrationMonitoringOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public log_viewer.ViewAdministrationMonitoringOperations _delegate() {
      return this._impl;
  }
  public void _delegate (log_viewer.ViewAdministrationMonitoringOperations delegate ) {
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
  public String[] getMonitoringFiles ()
  {
    return _impl.getMonitoringFiles();
  } // getMonitoringFiles

  private log_viewer.ViewAdministrationMonitoringOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ViewAdministrationMonitoringPOATie
