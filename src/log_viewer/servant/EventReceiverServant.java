/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log_viewer.servant;

import event_service.EventSinkPOA;
import log_monitor.FileModificationEvent;
import log_monitor.FileModificationEventHelper;
import org.omg.CORBA.Any;
import scs.core.servant.ComponentContext;

/**
 *
 * @author snbuback
 */
public class EventReceiverServant extends EventSinkPOA {

    private final ComponentContext context;

    public EventReceiverServant(ComponentContext context) {
        this.context = context;
    }

    @Override
    public void push(Any ev) {
        FileModificationEvent fme = FileModificationEventHelper.extract(ev);
        // Joga a mensagem para o monitoringServant
        MonitoringServant notifier = (MonitoringServant)context.getFacets().get(LogViewerFactory.FACET_MONITORING);
        notifier.notifyModification(fme);
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
