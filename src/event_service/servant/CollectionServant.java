/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package event_service.servant;

import event_service.ChannelCollectionPOA;
import event_service.ChannelDescr;
import event_service.InvalidName;
import java.util.Hashtable;
import java.util.Map;
import scs.core.IComponent;
import scs.core.servant.ComponentContext;

/**
 *
 * @author edward
 */
public class CollectionServant extends ChannelCollectionPOA{

    private final ComponentContext context;

    private final Map<String, IComponent> channels = new Hashtable<String, IComponent>();

    public CollectionServant(ComponentContext context) {
        super();
        this.context = context;
    }

    public void registerNewChannel(String name, IComponent comp) {
        channels.put(name, comp);
    }

    public IComponent removeChannel(String name) throws InvalidName {
        IComponent c = channels.remove(name);
        if (c == null) {
            throw new InvalidName(name);
        }
        return c;
    }

    /**
     * 
     * @param nome do canal "name"
     * @return 
     */
    @Override
    public IComponent getChannel(String name) {
        IComponent channel = channels.get(name);
        return channel;
    }

    /**
     * 
     * @return descrição de eventos
     */
    @Override
    public ChannelDescr[] getAll() {
        int qde = channels.size();
        ChannelDescr[] chns = new ChannelDescr[qde];
        int i=0;
        for (Map.Entry<String, IComponent> entry : this.channels.entrySet()) {
            ChannelDescr cd = new ChannelDescr(entry.getKey(), entry.getValue());
            chns[i++] = cd;
        }
        return chns;
    }

}
