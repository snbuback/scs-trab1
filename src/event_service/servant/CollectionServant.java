/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package event_service.servant;

import event_service.ChannelCollectionPOA;
import event_service.ChannelDescr;
import scs.core.IComponent;
import scs.core.servant.ComponentContext;

/**
 *
 * @author edward
 */
public class CollectionServant extends ChannelCollectionPOA{

    private final ComponentContext context;

    public CollectionServant(ComponentContext context) {
        super();
        this.context = context;
    }


    /**
     * 
     * @param nome do canal "name"
     * @return 
     */
    @Override
    public IComponent getChannel(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @return descrição de eventos
     */
    @Override
    public ChannelDescr[] getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
