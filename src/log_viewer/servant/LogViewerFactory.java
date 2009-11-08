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
    public static final String FACET_EVENT_RECEIVER = "EventReceiver";

    public IComponent create(ComponentBuilder builder, Object[] args) throws LoadFailure {
        try {
            String templateFilename = new String("conf" + File.separator + "LogViewer.template");
            String descriptionFilename = new String("conf" + File.separator + "LogViewer.java.all.desc");
            ComponentContext context = builder.newComponent(templateFilename, descriptionFilename);
            return IComponentHelper.narrow(context.getFacetDescs().get(FACET_ICOMPONENT).facet_ref);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LoadFailure(e.getLocalizedMessage());
        }

    }
}
