package com.larrainvial.event;


import com.larrainvial.Algo;
import com.larrainvial.logviwer.model.ModelMarketData;
import com.larrainvial.trading.emp.Event;
import java.util.ArrayList;
import java.util.HashMap;

public class SendAllDataToViewEvent extends Event {

    public HashMap<String, Algo> algo;

    public SendAllDataToViewEvent(Object source, HashMap<String, Algo> algo) {
        super(source);
        this.algo = algo;
    }
}
