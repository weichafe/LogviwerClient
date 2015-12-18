package com.larrainvial.logviewer.event.utils;

import com.larrainvial.bo.Algo;
import com.larrainvial.logviewer.model.ModelMarketData;
import com.larrainvial.logviewer.model.ModelRoutingData;
import com.larrainvial.trading.emp.Event;

public class AlertEvent extends Event {

    public ModelMarketData modelMarketData;
    public ModelRoutingData modelRoutingData;
    public String execType;
    public String messageByType;
    public String typeMarket;
    public Algo algo;
    public String text;
    public String hour;

    public AlertEvent(Object source, ModelMarketData modelMarketData, String typeMarket) {
        super(source);
        this.algo = (Algo) source;
        this.modelMarketData = modelMarketData;
        this.messageByType = modelMarketData.messageByType;
        this.typeMarket = typeMarket;
        this.text = modelMarketData.text;
        this.hour = modelMarketData.hour;
    }

    public AlertEvent(Object source, ModelRoutingData modelRoutingData, String typeMarket) {
        super(source);
        this.algo = (Algo) source;
        this.modelRoutingData = modelRoutingData;
        this.execType = modelRoutingData.execType;
        this.messageByType = modelRoutingData.messageByType;
        this.typeMarket = typeMarket;
        this.text = modelRoutingData.text;
        this.hour = modelRoutingData.hour;

    }

}
