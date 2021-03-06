package com.larrainvial;

import com.larrainvial.bo.Algo;
import com.larrainvial.logviewer.model.ModelProcess;
import com.larrainvial.logviewer.model.ModelRoutingData;
import com.larrainvial.logviewer.utils.PropertiesFile;
import com.larrainvial.sellside.orders.Orders;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import quickfix.SessionID;
import quickfix.SocketAcceptor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

public class Repository {

    public static Socket socket;

    public static DataOutputStream sendMessage;
    public static DataInputStream receivedMessage;

    public static Stage primaryStage;
    public static Scene scene;
    public static TabPane tabPanePrincipalTabPanel;
    public static FXMLLoader rootLayout_Loader = new FXMLLoader();
    public static FXMLLoader principalTabPanel_Loader = new FXMLLoader();
    public static HashMap<String, Algo> strategy = new HashMap<String, Algo>();
    public static PropertiesFile logviewer;
    public static String locationPath;
    public static PropertiesFile killProcess;
    public static boolean exception = true;

    public static LinkedHashMap<String, ModelProcess> coreStrategy = new LinkedHashMap<String, ModelProcess>();

    public static String year = new SimpleDateFormat("yyyy/MM/dd").format(new Date()).replace("/", "");
    public static String nameFileQuickFix;
    public static String log4j;

    public static com.larrainvial.sellside.utils.PropertiesFile buySide;
    public static SocketAcceptor socketAcceptor;
    public static SessionID sessionID;
    public static String socketAcceptPort;
    public static String senderCompID;
    public static String targetCompID;

    public static String date;
    public static String XPUS_NAME;
    public static String XPUS_UUID;

    public static HashMap<String, String> UUID = new HashMap<String, String>();
    public static Map<String, Orders> executionWorkOrderBuy = Collections.synchronizedMap(new LinkedHashMap<String, Orders>());
    public static Map<String, Orders> executionWorkOrderSell = Collections.synchronizedMap(new LinkedHashMap<String, Orders>());

    public static Map<String, ModelRoutingData> sellSideMasterListHash = Collections.synchronizedMap(new LinkedHashMap<String, ModelRoutingData>());
    public static Algo sellside;


    public static void deleteOrder(){
        executionWorkOrderBuy.clear();
        executionWorkOrderSell.clear();

        if(sellside.sellsideTableView != null){
            sellside.sellsideTableView.getItems().clear();
        }

        //logger.info(Constants.ORDERS_DELETED);
    }



}