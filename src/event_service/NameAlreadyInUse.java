package event_service;


/**
* event_service/NameAlreadyInUse.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from events.idl
* Tuesday, October 27, 2009 9:23:50 PM BRST
*/

public final class NameAlreadyInUse extends org.omg.CORBA.UserException
{
  public String name = null;

  public NameAlreadyInUse ()
  {
    super(NameAlreadyInUseHelper.id());
  } // ctor

  public NameAlreadyInUse (String _name)
  {
    super(NameAlreadyInUseHelper.id());
    name = _name;
  } // ctor


  public NameAlreadyInUse (String $reason, String _name)
  {
    super(NameAlreadyInUseHelper.id() + "  " + $reason);
    name = _name;
  } // ctor

} // class NameAlreadyInUse
