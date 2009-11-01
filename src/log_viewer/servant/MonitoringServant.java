/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log_viewer.servant;

import java.util.ArrayList;
import java.util.List;
import log_monitor.FileModificationEvent;
import log_viewer.MonitoringPOA;
import scs.core.servant.ComponentContext;

/**
 *
 * @author snbuback
 */
public class MonitoringServant extends MonitoringPOA {

    private final ComponentContext context;
    private final List<FileModificationEvent> modifications;

    public MonitoringServant(ComponentContext context) {
        this.context = context;
        this.modifications =  new ArrayList<FileModificationEvent>();
    }

    public void notifyModification(FileModificationEvent fme) {
        this.modifications.add(fme);
    }

    @Override
    public FileModificationEvent[] getModifications() {
        FileModificationEvent[] m = new FileModificationEvent[this.modifications.size()];
        this.modifications.toArray(m);
        return m;
    }

    @Override
    public void clear() {
        this.modifications.clear();
    }

}
