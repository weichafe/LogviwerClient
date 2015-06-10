package com.larrainvial.connection;

import com.larrainvial.Repository;
import com.larrainvial.logviwer.vo.StrategyDataVO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client extends Thread {

    private Object object;

    private String id;
    private String ip;

    public Client(String id, String ip) {
        this.id = id;
        this.ip = ip;
    }

    @Override
    public void run() {

        try {

            Repository.socket = new Socket(ip, 10578);
            System.out.println(id + " inciando Cliente");

            Repository.sendMessage = new DataOutputStream(Repository.socket.getOutputStream());
            Repository.receivedMessage = new DataInputStream(Repository.socket.getInputStream());

            Repository.sendMessage.writeUTF(id);

            ObjectInputStream objectInput = new ObjectInputStream(Repository.socket.getInputStream());

            Object object = (StrategyDataVO) objectInput.readObject();
            StrategyDataVO strategyDataVO = (StrategyDataVO) object;
            //Controller.dispatchEvent(new SendAllDataToViewEvent(this, strategyDataVO));
            System.out.println();


            //server.close();
            //cliente.close();

        } catch (Exception e) {
            //Helper.exception(e);
            e.printStackTrace();
            System.out.println(object);


        } finally {
            try {
                Repository.socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
