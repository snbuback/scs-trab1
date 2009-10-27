package event_service;


/**
* event_service/EventSinkPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from events.idl
* Tuesday, October 27, 2009 9:23:50 PM BRST
*/

public class EventSinkPOATie extends EventSinkPOA
{

  // Constructors

  public EventSinkPOATie ( event_service.EventSinkOperations delegate ) {
      this._impl = delegate;
  }
  public EventSinkPOATie ( event_service.EventSinkOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public event_service.EventSinkOperations _delegate() {
      return this._impl;
  }
  public void _delegate (event_service.EventSinkOperations delegate ) {
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
  public void push (org.omg.CORBA.Any ev)
  {
    _impl.push(ev);
  } // push

  public void disconnect ()
  {
    _impl.disconnect();
  } // disconnect

  private event_service.EventSinkOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class EventSinkPOATie
