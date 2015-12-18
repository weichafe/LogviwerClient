package com.larrainvial.logviewer.event.sendtoview;

import com.larrainvial.bo.Algo;
import com.larrainvial.logviewer.model.ModelMarketData;
import com.larrainvial.trading.emp.Event;

public class LastPriceEvent  extends Event {

    public Algo algo;
    public ModelMarketData modelMarketData;

    public LastPriceEvent(Object source, ModelMarketData modelMarketData) {
        super(source);
        this.algo = (Algo) source;
        this.modelMarketData = modelMarketData;
    }
}
