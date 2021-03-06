package log_monitor;


/**
* log_monitor/MonitorConfigurationPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Sunday, November 8, 2009 6:21:06 PM BRST
*/

public abstract class MonitorConfigurationPOA extends org.omg.PortableServer.Servant
 implements log_monitor.MonitorConfigurationOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getInterval", new java.lang.Integer (0));
    _methods.put ("setInterval", new java.lang.Integer (1));
    _methods.put ("addFile", new java.lang.Integer (2));
    _methods.put ("getMonitoringFiles", new java.lang.Integer (3));
    _methods.put ("getHost", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // log_monitor/MonitorConfiguration/getInterval
       {
         long $result = (long)0;
         $result = this.getInterval ();
         out = $rh.createReply();
         out.write_longlong ($result);
         break;
       }

       case 1:  // log_monitor/MonitorConfiguration/setInterval
       {
         long interval = in.read_longlong ();
         this.setInterval (interval);
         out = $rh.createReply();
         break;
       }

       case 2:  // log_monitor/MonitorConfiguration/addFile
       {
         String file = in.read_string ();
         this.addFile (file);
         out = $rh.createReply();
         break;
       }

       case 3:  // log_monitor/MonitorConfiguration/getMonitoringFiles
       {
         String $result[] = null;
         $result = this.getMonitoringFiles ();
         out = $rh.createReply();
         util.StringSeqHelper.write (out, $result);
         break;
       }

       case 4:  // log_monitor/MonitorConfiguration/getHost
       {
         String $result = null;
         $result = this.getHost ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:log_monitor/MonitorConfiguration:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public MonitorConfiguration _this() 
  {
    return MonitorConfigurationHelper.narrow(
    super._this_object());
  }

  public MonitorConfiguration _this(org.omg.CORBA.ORB orb) 
  {
    return MonitorConfigurationHelper.narrow(
    super._this_object(orb));
  }


} // class MonitorConfigurationPOA
