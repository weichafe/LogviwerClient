package com.larrainvial.listener;


import com.larrainvial.Repository;
import com.larrainvial.event.SendAllDataToViewEvent;
import com.larrainvial.trading.emp.Controller;
import com.larrainvial.trading.emp.Event;
import com.larrainvial.trading.emp.Listener;

public class SendAllDataToViewListener  implements Listener {

    @Override
    public void eventOccurred(Event event){

        try {

            SendAllDataToViewEvent ev = (SendAllDataToViewEvent) event;

            Repository.strategy.putAll(ev.algo);

            System.out.println();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
