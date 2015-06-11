package com.larrainvial.listener;

import com.larrainvial.Repository;
import com.larrainvial.event.ConnectToServerEvent;
import com.larrainvial.event.ReceivedDataToViewEvent;
import com.larrainvial.logviwer.vo.StrategyDataVO;
import com.larrainvial.trading.emp.Controller;
import com.larrainvial.trading.emp.Event;
import com.larrainvial.trading.emp.Listener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ConnectToServerListener implements Listener {

    @Override
    public void eventOccurred(Event event){

        try {

            ConnectToServerEvent ev = (ConnectToServerEvent) event;

            Repository.socket = new Socket(ev.ip, ev.host);
            System.out.println(ev.id + " inciando Cliente");

            Repository.sendMessage = new DataOutputStream(Repository.socket.getOutputStream());
            Repository.receivedMessage = new DataInputStream(Repository.socket.getInputStream());

            Repository.sendMessage.writeUTF(ev.id);

            ObjectInputStream objectInput = new ObjectInputStream(Repository.socket.getInputStream());

            Object object = (StrategyDataVO) objectInput.readObject();
            StrategyDataVO strategyDataVO = (StrategyDataVO) object;

            Controller.dispatchEvent(new ReceivedDataToViewEvent(this, strategyDataVO));


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
