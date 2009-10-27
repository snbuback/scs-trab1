package scs.demos.helloworld;

import java.io.File;
import java.io.FileWriter;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import scs.core.IComponent;
import scs.core.servant.ComponentBuilder;
import scs.core.servant.ComponentContext;
import scs.demos.helloworld.servant.HelloServant;

public class BasicServerApp {

  // Facet names
  public static final String FACET_ICOMPONENT =
    IComponent.class.getSimpleName();
  public static final String FACET_HELLO = Hello.class.getSimpleName();
  public static final String RECEPT_OTHERHELLO = "OtherHello";

  public static void main(String[] args) {
    try {
      // ORB initialization
      ORB orb = ORB.init(args, null);

      POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      poa.the_POAManager().activate();

      // SCS Basic API - Component Builder offers main methods
      ComponentBuilder builder = new ComponentBuilder(poa, orb);

      String templateFilename =
        new String("conf" + File.separator + "hello.template");
      String descriptionFilename =
        new String("conf" + File.separator + "hello.java.all.desc");
      ComponentContext context =
        builder.newComponent(templateFilename, descriptionFilename);

      HelloServant helloImpl =
        (HelloServant) context.getFacets().get(FACET_HELLO);
      helloImpl.setName("World! I'm the server written in Java!");

      // Saving the CORBA Reference of the Hello facet
      String ior =
        orb.object_to_string(HelloHelper.narrow(context.getFacetDescs().get(
          FACET_HELLO).facet_ref));
      FileWriter file = new FileWriter("conf/hello.ior");
      file.write(ior);
      file.flush();
      file.close();

      // Waiting for the remote requests
      orb.run();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.err.println("Error creating the component!");
    }
  }
}
