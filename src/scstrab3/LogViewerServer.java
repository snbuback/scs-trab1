/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scstrab3;

import event_service.ChannelFactory;
import event_service.ChannelFactoryHelper;
import event_service.EventSink;
import event_service.EventSinkHelper;
import event_service.servant.EventChannelFactory;
import event_service.servant.EventServiceFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import log_monitor.FileModificationEvent;
import log_viewer.Monitoring;
import log_viewer.MonitoringHelper;
import log_viewer.ViewAdministrationMonitoring;
import log_viewer.ViewAdministrationMonitoringHelper;
import log_viewer.servant.LogViewerFactory;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import scs.core.IComponent;
import scs.core.IComponentHelper;
import scs.core.IReceptacles;
import scs.core.IReceptaclesHelper;
import scs.core.servant.ComponentBuilder;

/**
 *
 * @author snbuback
 */
public class LogViewerServer {

    private static final String NOME_CANAL = "monitoramento-arquivos";

    public static void main(String[] args) throws Exception {
        // ORB initialization
        final ORB orb = ORB.init(args, null);

        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();

        // SCS Basic API - Component Builder offers main methods
        ComponentBuilder builder = new ComponentBuilder(poa, orb);

        // Cria event service
        IComponent icEventService = new EventServiceFactory().create(builder, null);

        // Obtém a faceta Factory
        ChannelFactory eventService_factory = ChannelFactoryHelper.narrow(icEventService.getFacetByName(EventServiceFactory.FACET_FACTORY));

        // Cria um EventChannel
        IComponent icEventChannel = eventService_factory.create(NOME_CANAL);
        EventSink sinkEventChannel = EventSinkHelper.narrow(icEventChannel.getFacetByName(EventChannelFactory.FACET_SINK));

        // Instancia o LogViewer
        IComponent icLogViewer = new LogViewerFactory().create(builder, null);
        icLogViewer.startup();
        EventSink sinkLogViewer = EventSinkHelper.narrow(icLogViewer.getFacetByName(LogViewerFactory.FACET_EVENT_RECEIVER));

        // Pluga o LogViewer no EventChannel
        IReceptacles irEventChannel = IReceptaclesHelper.narrow(icEventChannel.getFacetByName("IReceptacles"));
        irEventChannel.connect("Source", sinkLogViewer);

        // Pluga o LogMonitor no EventChannel
        List<String> iors = listaIORs(args);
        for (String ior : iors) {
            System.out.println("Conectando " + ior);
            IComponent icLogMonitor = IComponentHelper.narrow(orb.string_to_object(ior));
            icLogMonitor.startup();

            IReceptacles irLogMonitor = IReceptaclesHelper.narrow(icLogMonitor.getFacetByName("IReceptacles"));
            irLogMonitor.connect("Source", sinkEventChannel);
        }

        // Inicia o orb em outra thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Waiting for the remote requests
                orb.run();
            }
        }).start();

        // Obtem as facets Monitoring e ViewConfiguration do LogViewer
        Monitoring monitoring = MonitoringHelper.narrow(icLogViewer.getFacetByName(LogViewerFactory.FACET_MONITORING));
        ViewAdministrationMonitoring va = ViewAdministrationMonitoringHelper.narrow(icLogViewer.getFacetByName(LogViewerFactory.FACET_VIEWADMINISTRATION));

        Scanner sc = new Scanner(System.in);
        t: do {
            System.out.println("*************************************************************************************" );
            System.out.println("Digite uma letra abaixo e ENTER para: " + (va.isPaused() ? "(PAUSED!)" : "") + "\n" );
            System.out.println("\tp : pausar");
            System.out.println("\tr : resume");
            System.out.println("\tl : lista modificações");
            System.out.println("\tc : limpar lista de modificações");

            char l = sc.next().charAt(0);
            switch (l) {
                case 'p':
                    va.pause();
                    break;
                case 'r':
                    va.resume();
                    break;
                case 'l':
                    for (FileModificationEvent fme: monitoring.getModifications()) {
                        System.out.println(fme.fileName);
                        System.out.println("Data: " + new Date(fme.date));
                        System.out.println("Host: " + fme.host + " / " + fme.ip);
                        System.out.println();
                    }
                    break;
                case 'c':
                    monitoring.clear();
                    break;
            }
        } while (true);

    }

    private static List<String> listaIORs(String args[]) throws IOException {
        return Arrays.asList(args);

//        BufferedReader in = new BufferedReader(new FileReader("/tmp/servers.ior"));
//        List<String> iors = new ArrayList<String>();
//        do {
//            String ior = in.readLine();
//            if (ior == null) {
//                break;
//            }
//            iors.add(ior);
//        } while (true);
//        return iors;
    }
}
