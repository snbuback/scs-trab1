/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package log_monitor.servant;

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
public class LogMonitorFactory {

    // Facet names
    public static final String FACET_ICOMPONENT = IComponent.class.getSimpleName();
    public static final String FACET_MCFG = "MonitorConfiguration";
    public static final String RECEPT_SOURCES = "Source";

    public IComponent create(ComponentBuilder builder, String[] args) throws LoadFailure {
        try {
            String templateFilename = new String("conf" + File.separator + "LogMonitor.template");
            String descriptionFilename = new String("conf" + File.separator + "LogMonitor.java.all.desc");
            ComponentContext context = builder.newComponent(templateFilename, descriptionFilename);
            return IComponentHelper.narrow(context.getFacetDescs().get(FACET_ICOMPONENT).facet_ref);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LoadFailure(e.getLocalizedMessage());
        }

    }
}
