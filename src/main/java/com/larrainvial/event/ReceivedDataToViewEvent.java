package com.larrainvial.event;

import com.larrainvial.logviwer.vo.StrategyDataVO;
import com.larrainvial.trading.emp.Event;

public class ReceivedDataToViewEvent extends Event {

    public StrategyDataVO strategyDataVO;

    public ReceivedDataToViewEvent(Object source, StrategyDataVO strategyDataVO) {

        super(source);
        this.strategyDataVO = strategyDataVO;
    }
}
