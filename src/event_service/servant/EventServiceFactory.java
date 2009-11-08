/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package event_service.servant;

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
public class EventServiceFactory {

    // Facet names
    public static final String FACET_ICOMPONENT = IComponent.class.getSimpleName();
    public static final String FACET_FACTORY = "Factory";
    public static final String FACET_COLLECTION = "Collection";

    public IComponent create(ComponentBuilder builder, String[] args) throws LoadFailure {
        try {
            String templateFilename = new String("conf" + File.separator + "EventService.template");
            String descriptionFilename = new String("conf" + File.separator + "EventService.java.all.desc");
            ComponentContext context = builder.newComponent(templateFilename, descriptionFilename);
            //context.getFacetDescs().get(FACET_FACTORY).facet_ref;
            return IComponentHelper.narrow(context.getFacetDescs().get(FACET_ICOMPONENT).facet_ref);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LoadFailure(e.getLocalizedMessage());
        }

    }
}
