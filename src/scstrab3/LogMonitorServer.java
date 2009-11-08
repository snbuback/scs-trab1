/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scstrab3;

import event_service.EventSinkHelper;
import log_monitor.MonitorConfiguration;
import log_monitor.MonitorConfigurationHelper;
import log_monitor.servant.LogMonitorFactory;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import scs.core.IComponent;
import scs.core.servant.ComponentBuilder;

/**
 *
 * @author snbuback
 */
public class LogMonitorServer {

    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();

            // SCS Basic API - Component Builder offers main methods
            ComponentBuilder builder = new ComponentBuilder(poa, orb);

            // Instancia o componente
            IComponent icomponent = new LogMonitorFactory().create(builder, null);

            // Obtem a faceta MonitorConfiguration
            org.omg.CORBA.Object obj = icomponent.getFacetByName(LogMonitorFactory.FACET_MCFG);


            // Faz o cast corba
            MonitorConfiguration m = MonitorConfigurationHelper.narrow(obj);
            m.setInterval(500);
            m.addFile("/tmp/arq1.tmp");
            m.addFile("/tmp/arq2.tmp");



//            String templateFilename = new String("conf" + File.separator + "LogMonitor.template");
//            String descriptionFilename = new String("conf" + File.separator + "LogMonitor.java.all.desc");
//            ComponentContext context = builder.newComponent(templateFilename, descriptionFilename);
//
//            HelloServant helloImpl = (HelloServant) context.getFacets().get(LogMonitorFactory.);
//            helloImpl.setName("World! I'm the server written in Java!");
//
//            // Saving the CORBA Reference of the Hello facet
            String ior = orb.object_to_string(icomponent);
            System.out.println(ior);
//            FileWriter file = new FileWriter("conf/hello.ior");
//            file.write(ior);
//            file.flush();
//            file.close();

            // Waiting for the remote requests
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error creating the component!");
        }
    }
}
