package com.larrainvial.connection;

import com.larrainvial.Algo;
import com.larrainvial.event.SendAllDataToViewEvent;
import com.larrainvial.logviwer.model.ModelMarketData;
import com.larrainvial.trading.emp.Controller;
import com.larrainvial.utils.Helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client extends Thread {

    protected DataOutputStream cliente;
    protected DataInputStream server;
    private int id;

    public Client(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {

            Socket socket = new Socket("127.0.0.1", 10578);

            System.out.println(id + " envia saludo");


            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());

            Object object = (HashMap<String, Algo> ) objectInput.readObject();
            HashMap<String, Algo> algo = (HashMap<String, Algo>) object;

            Controller.dispatchEvent(new SendAllDataToViewEvent(this, algo));


            server.close();
            //cliente.close();



        } catch (Exception e) {
            //Helper.exception(e);
            e.printStackTrace();
        }
    }


}
