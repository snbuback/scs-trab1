    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package event_service.servant;

import event_service.EventSinkPOA;
import org.omg.CORBA.Any;
import scs.core.servant.ComponentContext;

/**
 * Faceta Sink
 * Implementa un Canal de Eventos
 * Usada pelos publicadores de eventos quando quiserem enviar notificações atraves do canal.
 *
 * @author snbuback
 */
public class EventSinkServant extends EventSinkPOA {

    private final ComponentContext context;
    
    public EventSinkServant(ComponentContext context) {
        super();
        this.context = context;
    }

    /**
     * 
     * @param ev
     */
    @Override
    public void push(Any ev) {
        //TODO

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
