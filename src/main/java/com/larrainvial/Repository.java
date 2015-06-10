package com.larrainvial;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class Repository {

    public static Stage primaryStage;
    public static TabPane tabPanePrincipalTabPanel;
    public static FXMLLoader rootLayout_Loader = new FXMLLoader();
    public static FXMLLoader principalTabPanel_Loader = new FXMLLoader();
    public static HashMap<String, Algo> strategy = new HashMap<String, Algo>();
    public static Socket socket;

    public static DataOutputStream sendMessage;
    public static DataInputStream receivedMessage;

}