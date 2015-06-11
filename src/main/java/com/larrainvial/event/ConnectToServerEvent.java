package com.larrainvial.event;

import com.larrainvial.trading.emp.Event;


public class ConnectToServerEvent extends Event {

    public String id;
    public String ip;
    public int host;

    public ConnectToServerEvent(Object source, String id, String ip, int host) {
        super(source);
        this.id = id;
        this.ip = ip;
        this.host = host;
    }
}
