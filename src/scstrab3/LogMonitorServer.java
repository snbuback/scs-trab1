/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scstrab3;

import event_service.EventSinkHelper;
import java.util.Scanner;
import log_monitor.MonitorConfiguration;
import log_monitor.MonitorConfigurationHelper;
import log_monitor.servant.LogMonitorFactory;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import scs.core.ConnectionDescription;
import scs.core.IComponent;
import scs.core.IReceptacles;
import scs.core.IReceptaclesHelper;
import scs.core.servant.ComponentBuilder;

/**
 *
 * @author snbuback
 */
public class LogMonitorServer {

    public static void main(String[] args) throws Exception {
        final ORB orb = ORB.init(args, null);

        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();

        // SCS Basic API - Component Builder offers main methods
        ComponentBuilder builder = new ComponentBuilder(poa, orb);

        // Instancia o componente
        final IComponent icomponent = new LogMonitorFactory().create(builder, null);

        // Obtem a faceta MonitorConfiguration
        org.omg.CORBA.Object obj = icomponent.getFacetByName(LogMonitorFactory.FACET_MCFG);


        // Faz o cast corba
        MonitorConfiguration m = MonitorConfigurationHelper.narrow(obj);

        // Configura os arquivos que serão monitorados
        m.setInterval(500);
        m.addFile("/tmp/arq1.tmp");
        m.addFile("/tmp/arq2.tmp");

        // Saving the CORBA Reference of the Hello facet
        String ior = orb.object_to_string(icomponent);
        System.out.println(ior);

        // Inicia o orb em outra thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Waiting for the remote requests
                orb.run();
            }
        }).start();

        System.out.println("CTRL+C para finalizar");

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Desconectando");
                // Obtem o receptaculo Source
                try {
                    IReceptacles ir = IReceptaclesHelper.narrow(icomponent.getFacetByName("IReceptacles"));
                    if (ir.getConnections("Source") != null) {
                        for (ConnectionDescription cd : ir.getConnections("Source")) {
                            EventSinkHelper.narrow(cd.objref).disconnect();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
    }
}
