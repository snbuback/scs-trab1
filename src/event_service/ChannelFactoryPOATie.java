package event_service;


/**
* event_service/ChannelFactoryPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from events.idl
* Tuesday, October 27, 2009 9:23:50 PM BRST
*/

public class ChannelFactoryPOATie extends ChannelFactoryPOA
{

  // Constructors

  public ChannelFactoryPOATie ( event_service.ChannelFactoryOperations delegate ) {
      this._impl = delegate;
  }
  public ChannelFactoryPOATie ( event_service.ChannelFactoryOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public event_service.ChannelFactoryOperations _delegate() {
      return this._impl;
  }
  public void _delegate (event_service.ChannelFactoryOperations delegate ) {
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
  public scs.core.IComponent create (String name) throws event_service.NameAlreadyInUse
  {
    return _impl.create(name);
  } // create

  public void destroy (String name) throws event_service.InvalidName
  {
    _impl.destroy(name);
  } // destroy

  private event_service.ChannelFactoryOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ChannelFactoryPOATie
