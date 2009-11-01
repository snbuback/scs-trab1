/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package event_service.servant;

import event_service.ChannelFactoryPOA;
import event_service.InvalidName;
import event_service.NameAlreadyInUse;
import scs.core.IComponent;
import scs.core.servant.ComponentContext;

/**
 * CRIAR, DESTRUIR, OFERECER acesso aos CANAIS DE EVENTOS
 * @author edward
 */
public class FactoryServant extends ChannelFactoryPOA{

    private final ComponentContext context;

    public FactoryServant(ComponentContext context) {
        super();
        this.context = context;
    }


    /** 
     * Cria um novo canal de eventos de nome "name"
     * @return uma instancia de componente que representa el canal creado
     */
    @Override
    public IComponent create(String name) throws NameAlreadyInUse {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Fecha o canal de eventos de nome "name"
     * @return void
     */
    @Override
    public void destroy(String name) throws InvalidName {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
