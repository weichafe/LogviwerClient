package com.larrainvial.logviewer.adaptador;

import com.larrainvial.bo.Algo;
import com.larrainvial.Repository;
import quickfix.*;
import quickfix.Message;
import quickfix.field.Text;
import quickfix.fix44.*;
import quickfix.fix44.MessageCracker;


public final class QuickFixAdapter extends MessageCracker implements Application {

    public SocketInitiator socketInitiator;


    public QuickFixAdapter(String quickFixIniFile) {

        try {

            SessionSettings sessionSettings = new SessionSettings(quickFixIniFile);
            FileStoreFactory fileStoreFactory = new FileStoreFactory(sessionSettings);
            FileLogFactory fileLogFactory = new FileLogFactory(sessionSettings);
            DefaultMessageFactory defaultMessageFactory = new DefaultMessageFactory();

            this.socketInitiator = new SocketInitiator(this, fileStoreFactory, sessionSettings, fileLogFactory, defaultMessageFactory);
            this.socketInitiator.start();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onCreate(SessionID sessionID) {

        try {



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onLogon(SessionID sessionID) {
        System.out.println("sesion creada");
    }

    public void onLogout(SessionID sessionID) {
    }

    public void toAdmin(Message message, SessionID sessionID) {
        // nothing
    }

    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

        try {
            crack(message, sessionID);
        } catch (UnsupportedMessageType unsupportedMessageType) {
            unsupportedMessageType.printStackTrace();
        }
    }

    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        // nothing
    }

    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

        try {
            crack(message, sessionID);
        } catch (UnsupportedMessageType unsupportedMessageType) {
            unsupportedMessageType.printStackTrace();
        }
    }

    public void onMessage(ExecutionReport executionReport, SessionID sessionID) {
    }

    public void onMessage(OrderCancelReject orderCancelReject, SessionID sessionID) {

    }

    public void onMessage(NewOrderSingle newOrderSingle, SessionID sessionID) throws FieldNotFound {

    }

    public void onMessage(OrderCancelReplaceRequest orderCancelReplaceRequest, SessionID sessionID) throws FieldNotFound {

    }

    public void onMessage(OrderCancelRequest orderCancelRequest, SessionID sessionID) throws FieldNotFound {

    }

    public void onMessage(MarketDataIncrementalRefresh marketDataIncrementalRefresh, SessionID sessionID) throws FieldNotFound {

    }

    public void onMessage(MarketDataRequest marketDataRequest, SessionID sessionID) throws FieldNotFound {

    }

    public void onMessage(MarketDataSnapshotFullRefresh marketDataSnapshotFullRefresh, SessionID sessionID) throws FieldNotFound {

    }



    //TODO: se crean la estrategia a partir de un mensaje especifico
    public void onMessage(AllocationReportAck allocationReportAck, SessionID sessionID) throws FieldNotFound {

        if(allocationReportAck.isSetField(Text.FIELD)){
            Algo algo = new Algo(allocationReportAck.getText().getValue());
            Repository.strategy.put(algo.modelXml.nameAlgo, algo);
        }


    }





}

