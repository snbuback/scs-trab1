package event_service.servant;

import scs.demos.helloworld.servant.*;
import java.io.File;

import scs.container.ComponentLoaderOperations;
import scs.container.LoadFailure;
import scs.core.IComponent;
import scs.core.IComponentHelper;
import scs.core.servant.ComponentBuilder;
import scs.core.servant.ComponentContext;
import scs.core.servant.ComponentFactory;
import scs.demos.helloworld.Hello;

public class EventChannelFactory implements ComponentFactory {

    /** Nome da faceta IComponent */
    public static final String FACET_ICOMPONENT =
            IComponent.class.getSimpleName();
    /** Nome da faceta Hello */
    public static final String FACET_SINK = "Sink";
    /** Nome do receptáculo OtherHello */
    public static final String RECEPT_SOURCE = "Source";

    /**
     * Método de instanciação de novos componentes
     *
     * @param builder Instância do construtor de componentes SCS
     * @param args Vetor de argumentos originalmente repassado pelo contêiner de
     *        componentes
     */
    public IComponent create(ComponentBuilder builder, String[] args)
            throws LoadFailure {
        try {
            String templateFilename =
                    new String("conf" + File.separator + "EventChannel.template");
            String descriptionFilename =
                    new String("conf" + File.separator + "EventChannel.java.all.desc");
            ComponentContext context =
                    builder.newComponent(templateFilename, descriptionFilename);
            if (args.length > 0) {
                System.out.println("Configurando o nome " + args[0]);
                SinkServant sinkImpl = (SinkServant) context.getFacets().get(FACET_SINK);
                sinkImpl.setName(args[0]);
            }
            return IComponentHelper.narrow(context.getFacetDescs().get(
                    FACET_ICOMPONENT).facet_ref);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error creating instance!");
            throw new LoadFailure();
        }
    }
}
