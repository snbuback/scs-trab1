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

    private boolean paused = false;

    public ViewAdministrationServant(ComponentContext context) {
        this.context = context;
    }

    @Override
    public void pause() {
        this.paused = true;
    }

    @Override
    public void resume() {
        this.paused = false;
    }

    @Override
    public boolean isPaused() {
        return this.paused;
    }
}
