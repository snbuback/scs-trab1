package scs.demos.helloworld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Timer;
import java.util.TimerTask;
import org.omg.CORBA.ORB;

import scs.core.IComponent;
import scs.core.IComponentHelper;

public class BasicClientApp {

  public static void main(String[] args) {
    try {

        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                new File("sdsds").lastModified();
            }
        }
            , 0, 10000);
      // ORB initialization
      ORB orb = ORB.init(args, null);

      BufferedReader in = new BufferedReader(new FileReader("conf/hello.ior"));
      String ior = in.readLine();

      IComponent iComponentFacet =
        IComponentHelper.narrow(orb.string_to_object(ior)._get_component());
      iComponentFacet.startup();

      Hello helloFacet =
        HelloHelper.narrow(iComponentFacet.getFacetByName("Hello"));
      helloFacet.sayHello();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.err.println("Error using the component!");
    }
  }
}
