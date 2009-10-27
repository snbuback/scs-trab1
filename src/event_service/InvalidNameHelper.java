package event_service;


/**
* event_service/InvalidNameHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from events.idl
* Tuesday, October 27, 2009 9:23:50 PM BRST
*/

abstract public class InvalidNameHelper
{
  private static String  _id = "IDL:event_service/InvalidName:1.0";

  public static void insert (org.omg.CORBA.Any a, event_service.InvalidName that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static event_service.InvalidName extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "name",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (event_service.InvalidNameHelper.id (), "InvalidName", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static event_service.InvalidName read (org.omg.CORBA.portable.InputStream istream)
  {
    event_service.InvalidName value = new event_service.InvalidName ();
    // read and discard the repository ID
    istream.read_string ();
    value.name = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, event_service.InvalidName value)
  {
    // write the repository ID
    ostream.write_string (id ());
    ostream.write_string (value.name);
  }

}
