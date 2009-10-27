package event_service;


/**
* event_service/ChannelCollectionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from events.idl
* Tuesday, October 27, 2009 9:23:50 PM BRST
*/

abstract public class ChannelCollectionHelper
{
  private static String  _id = "IDL:event_service/ChannelCollection:1.0";

  public static void insert (org.omg.CORBA.Any a, event_service.ChannelCollection that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static event_service.ChannelCollection extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (event_service.ChannelCollectionHelper.id (), "ChannelCollection");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static event_service.ChannelCollection read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ChannelCollectionStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, event_service.ChannelCollection value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static event_service.ChannelCollection narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof event_service.ChannelCollection)
      return (event_service.ChannelCollection)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      event_service._ChannelCollectionStub stub = new event_service._ChannelCollectionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static event_service.ChannelCollection unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof event_service.ChannelCollection)
      return (event_service.ChannelCollection)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      event_service._ChannelCollectionStub stub = new event_service._ChannelCollectionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
