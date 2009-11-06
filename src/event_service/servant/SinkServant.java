    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package event_service.servant;

import event_service.EventSink;
import event_service.EventSinkPOA;
import event_service.InvalidName;
import org.omg.CORBA.Any;
import scs.core.ConnectionDescription;
import scs.core.servant.ComponentContext;

/**
 * Faceta Sink
 * Implementa un Canal de Eventos
 * Usada pelos publicadores de eventos quando quiserem enviar notificações atraves do canal.
 *
 * @author snbuback
 */
public class SinkServant extends EventSinkPOA {

    private final ComponentContext context;

    // nome do canal
    private String name;
    
    public SinkServant(ComponentContext context) {
        super();
        this.context = context;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param ev
     */
    @Override
    public void push(Any ev) {
        ConnectionDescription cds[] = this.context.getReceptacleDescs().get(EventChannelFactory.RECEPT_SOURCE).connections;
        for (ConnectionDescription cd: cds) {
            System.out.println("Fazendo push em " + cd.id);
            ((EventSink) cd.objref).push(ev);
        }
    }

    @Override
    public void disconnect() {
        System.out.println("Apagando o canal de eventos " + this.name);

        ConnectionDescription cds[] = this.context.getReceptacleDescs().get(EventChannelFactory.RECEPT_SOURCE).connections;
        for (ConnectionDescription cd: cds) {
            System.out.println("\tFazendo disconect em " + cd.id);
            ((EventSink) cd.objref).disconnect();
        }


        CollectionServant collectionServant = (CollectionServant) this.context.getFacetDescs().get(EventServiceFactory.FACET_COLLECTION).facet_ref;
        try {
            collectionServant.removeChannel(getName());
        } catch (InvalidName e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
