/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log_viewer.servant;

import log_viewer.ViewAdministrationMonitoringPOA;
import scs.core.servant.ComponentContext;

/**
 *
 * @author snbuback
 */
public class ViewAdministrationServant extends ViewAdministrationMonitoringPOA {

    private final ComponentContext context;

    public ViewAdministrationServant(ComponentContext context) {
        this.context = context;
    }

    @Override
    public String[] getMonitoringFiles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
