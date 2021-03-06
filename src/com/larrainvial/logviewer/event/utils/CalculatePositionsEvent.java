package com.larrainvial.logviewer.event.utils;

import com.larrainvial.bo.Algo;
import com.larrainvial.logviewer.model.ModelRoutingData;
import com.larrainvial.trading.emp.Event;

public class CalculatePositionsEvent extends Event {

    public Algo algo;
    public ModelRoutingData modelRoutingData;
    public String typeMarket;

    public CalculatePositionsEvent(Object source, ModelRoutingData modelRoutingData, String typeMarket) {
        super(source);
        this.algo = (Algo) source;
        this.modelRoutingData = modelRoutingData;
        this.typeMarket = typeMarket;

    }

}
