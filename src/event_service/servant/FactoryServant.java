/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package event_service.servant;

import event_service.ChannelFactoryPOA;
import event_service.EventSink;
import event_service.EventSinkHelper;
import event_service.InvalidName;
import event_service.NameAlreadyInUse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import scs.core.IComponent;
import scs.core.IComponentHelper;
import scs.core.servant.ComponentContext;

/**
 * CRIAR, DESTRUIR, OFERECER acesso aos CANAIS DE EVENTOS
 * @author edward
 */
public class FactoryServant extends ChannelFactoryPOA {

    private final ComponentContext context;

    public FactoryServant(ComponentContext context) {
        super();
        this.context = context;
    }

    private CollectionServant getCollectionServant() {
            return ((CollectionServant) this.context.getFacets().get(EventServiceFactory.FACET_COLLECTION));
    }

    /** 
     * Cria um novo canal de eventos de nome "name"
     * @return uma instancia de componente que representa el canal creado
     */
    @Override
    public IComponent create(String name) throws NameAlreadyInUse {
    CollectionServant cs = getCollectionServant();
        if (cs.getChannel(name) != null) {
            throw new NameAlreadyInUse(name);
        }

        System.out.println("Criando canal de eventos " + name);
        try {
            String templateFilename = new String("conf" + File.separator + "EventChannel.template");
            String descriptionFilename = new String("conf" + File.separator + "EventChannel.java.all.desc");
            ComponentContext comp = this.context.getBuilder().newComponent(templateFilename, descriptionFilename);
            cs.registerNewChannel(name, IComponentHelper.narrow(comp.getIComponent()));
            ((SinkServant) comp.getFacets().get(EventChannelFactory.FACET_SINK)).setName(name);
            return IComponentHelper.narrow(comp.getIComponent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Fecha o canal de eventos de nome "name"
     * @return void
     */
    @Override
    public void destroy(String name) throws InvalidName {
        System.out.println("Removendo canal de eventos " + name);
        CollectionServant cs = getCollectionServant();
        IComponent channel = cs.removeChannel(name);
        if (channel == null) {
            throw new InvalidName(name);
        }

        EventSink sink = EventSinkHelper.narrow(channel.getFacet(EventChannelFactory.FACET_SINK));
        sink.disconnect();
        
    }
}
