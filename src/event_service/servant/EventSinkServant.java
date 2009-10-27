/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package event_service.servant;

import event_service.EventSinkPOA;
import org.omg.CORBA.Any;

/**
 *
 * @author snbuback
 */
public class EventSinkServant extends EventSinkPOA {

    @Override
    public void push(Any ev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
