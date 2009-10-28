package log_viewer;


/**
* log_viewer/_MonitoringStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from logs.idl
* Wednesday, October 28, 2009 3:12:44 AM BRST
*/

public class _MonitoringStub extends org.omg.CORBA.portable.ObjectImpl implements log_viewer.Monitoring
{

  public log_monitor.FileModificationEvent[] getModifications ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getModifications", true);
                $in = _invoke ($out);
                log_monitor.FileModificationEvent $result[] = log_monitor.FileModificationEventSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getModifications (        );
            } finally {
                _releaseReply ($in);
            }
  } // getModifications

  public void clear ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("clear", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                clear (        );
            } finally {
                _releaseReply ($in);
            }
  } // clear

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:log_viewer/Monitoring:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _MonitoringStub
