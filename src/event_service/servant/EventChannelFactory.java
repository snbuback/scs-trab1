package event_service.servant;


import scs.core.IComponent;

public class EventChannelFactory  {

    /** Nome da faceta IComponent */
    public static final String FACET_ICOMPONENT =
            IComponent.class.getSimpleName();
    /** Nome da faceta Hello */
    public static final String FACET_SINK = "Sink";
    /** Nome do receptáculo OtherHello */
    public static final String RECEPT_SOURCE = "Source";
}
