package log_monitor;


/**
* log_monitor/FileModificationEventSeqHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Sunday, November 8, 2009 6:21:06 PM BRST
*/

abstract public class FileModificationEventSeqHelper
{
  private static String  _id = "IDL:log_monitor/FileModificationEventSeq:1.0";

  public static void insert (org.omg.CORBA.Any a, log_monitor.FileModificationEvent[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static log_monitor.FileModificationEvent[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = log_monitor.FileModificationEventHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (log_monitor.FileModificationEventSeqHelper.id (), "FileModificationEventSeq", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static log_monitor.FileModificationEvent[] read (org.omg.CORBA.portable.InputStream istream)
  {
    log_monitor.FileModificationEvent value[] = null;
    int _len0 = istream.read_long ();
    value = new log_monitor.FileModificationEvent[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = log_monitor.FileModificationEventHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, log_monitor.FileModificationEvent[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      log_monitor.FileModificationEventHelper.write (ostream, value[_i0]);
  }

}
