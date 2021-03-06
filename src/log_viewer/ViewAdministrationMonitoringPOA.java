package log_viewer;


/**
* log_viewer/ViewAdministrationMonitoringPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Sunday, November 8, 2009 6:21:06 PM BRST
*/

public abstract class ViewAdministrationMonitoringPOA extends org.omg.PortableServer.Servant
 implements log_viewer.ViewAdministrationMonitoringOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("pause", new java.lang.Integer (0));
    _methods.put ("resume", new java.lang.Integer (1));
    _methods.put ("isPaused", new java.lang.Integer (2));
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
       case 0:  // log_viewer/ViewAdministrationMonitoring/pause
       {
         this.pause ();
         out = $rh.createReply();
         break;
       }

       case 1:  // log_viewer/ViewAdministrationMonitoring/resume
       {
         this.resume ();
         out = $rh.createReply();
         break;
       }

       case 2:  // log_viewer/ViewAdministrationMonitoring/isPaused
       {
         boolean $result = false;
         $result = this.isPaused ();
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:log_viewer/ViewAdministrationMonitoring:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ViewAdministrationMonitoring _this() 
  {
    return ViewAdministrationMonitoringHelper.narrow(
    super._this_object());
  }

  public ViewAdministrationMonitoring _this(org.omg.CORBA.ORB orb) 
  {
    return ViewAdministrationMonitoringHelper.narrow(
    super._this_object(orb));
  }


} // class ViewAdministrationMonitoringPOA
