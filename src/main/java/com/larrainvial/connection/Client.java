package com.larrainvial.connection;

import com.larrainvial.logviwer.model.ModelMarketData;
import com.larrainvial.utils.Helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client extends Thread {

    protected Socket sk;
    protected DataOutputStream cliente;
    protected DataInputStream server;
    private int id;

    public Client(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {

            sk = new Socket("127.0.0.1", 10578);

            cliente = new DataOutputStream(sk.getOutputStream());
            server = new DataInputStream(sk.getInputStream());

            System.out.println(id + " envía saludo");
            cliente.writeUTF("hola");

            String respuesta="";
            //respuesta = server.readUTF();

            System.out.println(id + " Servidor devuelve saludo: " + respuesta);

            InputStream iStream = this.sk.getInputStream();
            ObjectInputStream oiStream = new ObjectInputStream(iStream);

            ModelMarketData algo = (ModelMarketData) oiStream.readObject();
            System.out.println(algo);

            server.close();
            cliente.close();

            sk.close();

        } catch (Exception e) {
            Helper.exception(e);
        }
    }


}
