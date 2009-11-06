/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package log_viewer.servant;

import java.io.File;
import scs.container.LoadFailure;
import scs.core.IComponent;
import scs.core.IComponentHelper;
import scs.core.servant.ComponentBuilder;
import scs.core.servant.ComponentContext;

/**
 *
 * @author snbuback
 */
public class LogViewerFactory {

    // Facet names
    public static final String FACET_ICOMPONENT = IComponent.class.getSimpleName();
    public static final String FACET_VIEWADMINISTRATION = "ViewAdministration";
    public static final String FACET_MONITORING = "Monitoring";
    public static final String FACET_EVENT_SINK = "EventReceiver";

    public IComponent create(ComponentBuilder builder, String[] args) throws LoadFailure {
        try {
            String templateFilename = new String("conf" + File.separator + "LogMonitor.template");
            String descriptionFilename = new String("conf" + File.separator + "LogMonitor.java.all.desc");
            ComponentContext context = builder.newComponent(templateFilename, descriptionFilename);
            //NotifyServant notifier = (NotifyServant)context.getFacets().get(FACET_NOTIFY);
            return IComponentHelper.narrow(context.getFacetDescs().get(FACET_ICOMPONENT).facet_ref);
        } catch (Exception e) {
            throw new LoadFailure(e.getLocalizedMessage());
        }

    }
}
