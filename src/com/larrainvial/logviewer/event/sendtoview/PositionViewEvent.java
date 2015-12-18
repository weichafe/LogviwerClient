package com.larrainvial.logviewer.event.sendtoview;

import com.larrainvial.bo.Algo;
import com.larrainvial.logviewer.model.ModelRoutingData;
import com.larrainvial.trading.emp.Event;

public class PositionViewEvent extends Event {

    public Algo algo;
    public ModelRoutingData modelRoutingData;

    public PositionViewEvent(Object source, ModelRoutingData modelRoutingData) {
        super(source);
        this.algo = (Algo) source;
        this.modelRoutingData = modelRoutingData;

    }
}
