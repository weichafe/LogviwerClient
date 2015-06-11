package com.larrainvial.utils;

import com.larrainvial.Algo;
import com.larrainvial.MainApp;
import com.larrainvial.Repository;
import com.larrainvial.event.ConnectToServerEvent;
import com.larrainvial.event.ReceivedDataToViewEvent;
import com.larrainvial.listener.ConnectToServerListener;
import com.larrainvial.listener.ReceivedDataToViewListener;
import com.larrainvial.logviwer.vo.NameStrategyVO;
import com.larrainvial.trading.emp.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Control {

    public static void initializeListener(){

        Controller.addEventListener(ReceivedDataToViewEvent.class, new ReceivedDataToViewListener());
        Controller.addEventListener(ConnectToServerEvent.class, new ConnectToServerListener());

    }

    public static void initializaStrategy(){
        adrarbitrageXsgo();
    }


    public static void adrarbitrageXsgo() {

        try {

            Algo algo = new Algo();

            algo.strategyDataVO.nameAlgo = NameStrategyVO.ADR_ARBITRAGE_XSGO;
            algo.strategyDataVO.mkd_dolar = "MKD_DOLAR";
            algo.strategyDataVO.mkd_local = "MKD_NYSE";
            algo.strategyDataVO.mkd_adr = "MKD_XSGO";
            algo.strategyDataVO.routing_local = "ROUTING_ADR";
            algo.strategyDataVO.routing_adr = "ROUTING_LOCAL";


            SwitchButton switchButtonDolar = new SwitchButton("Dolar", algo);
            Button switchBtn1 = switchButtonDolar.returnButton();
            switchBtn1.setLayoutX(177);
            switchBtn1.setLayoutY(10);

            SwitchButton switchButtonMkd_nyse = new SwitchButton("MKD ADR", algo);
            Button switchBtn2 = switchButtonMkd_nyse.returnButton();
            switchBtn2.setLayoutX(295);
            switchBtn2.setLayoutY(10);

            SwitchButton switchButtonMkd_Local = new SwitchButton("MKD Local", algo);
            Button switchBtn3 = switchButtonMkd_Local.returnButton();
            switchBtn3.setLayoutX(415);
            switchBtn3.setLayoutY(10);

            SwitchButton switchButtonRouting_Local = new SwitchButton("Routing Local", algo);
            Button switchBtn4 = switchButtonRouting_Local.returnButton();
            switchBtn4.setLayoutX(535);
            switchBtn4.setLayoutY(10);

            SwitchButton switchButtonRouting_Adr = new SwitchButton("Routing ADR", algo);
            Button switchBtn5 = switchButtonRouting_Adr.returnButton();
            switchBtn5.setLayoutX(655);
            switchBtn5.setLayoutY(10);

            SwitchButton switchButtonAlert = new SwitchButton("Alert", algo);
            Button switchBtn6 = switchButtonAlert.returnButton();
            switchBtn6.setLayoutX(775);
            switchBtn6.setLayoutY(10);

            algo.mkd_dolar_loader.setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/MarketDataDolarView.fxml"));
            algo.mkd_local_loader.setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/MarketDataAdrView.fxml"));
            algo.mkd_adr_loader.setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/MarketDataLocalView.fxml"));
            algo.routing_adr_loader.setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/RoutingAdrView.fxml"));
            algo.routing_local_loader.setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/RoutingLocalView.fxml"));
            algo.panel_positions_loader.setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/PanelPositionsView.fxml"));


            AnchorPane anchorPane = new AnchorPane();

            anchorPane.getChildren().add((AnchorPane) algo.mkd_dolar_loader.load());
            anchorPane.getChildren().add((AnchorPane) algo.mkd_local_loader.load());
            anchorPane.getChildren().add((AnchorPane) algo.mkd_adr_loader.load());
            anchorPane.getChildren().add((AnchorPane) algo.routing_adr_loader.load());
            anchorPane.getChildren().add((AnchorPane) algo.routing_local_loader.load());
            anchorPane.getChildren().add((AnchorPane) algo.panel_positions_loader.load());

            anchorPane.getChildren().add(switchBtn1);
            anchorPane.getChildren().add(switchBtn2);
            anchorPane.getChildren().add(switchBtn3);
            anchorPane.getChildren().add(switchBtn4);
            anchorPane.getChildren().add(switchBtn5);
            anchorPane.getChildren().add(switchBtn6);

            Repository.tabPanePrincipalTabPanel.getTabs().get(2).setContent(anchorPane);
            Repository.tabPanePrincipalTabPanel.getTabs().get(2).setText(algo.strategyDataVO.nameAlgo);

            com.larrainvial.logviwer.controller.adrarbitragexsgo.MarketDataDolarController getMkd_dolar_loader = algo.mkd_dolar_loader.getController();
            algo.mkd_dolar_tableView = getMkd_dolar_loader.getType();
            algo.dolarMasterList = getMkd_dolar_loader.masterData;

            com.larrainvial.logviwer.controller.adrarbitragexsgo.MarketDataAdrController getMkd_adr_loader = algo.mkd_local_loader.getController();
            algo.mkd_adr_tableView = getMkd_adr_loader.getType();
            algo.mkdAdrMasterList = getMkd_adr_loader.masterData;

            com.larrainvial.logviwer.controller.adrarbitragexsgo.MarketDataLocalController getMkd_local_loader = algo.mkd_adr_loader.getController();
            algo.mkd_local_tableView = getMkd_local_loader.getType();
            algo.mkdLocalMasterList = getMkd_local_loader.masterData;

            com.larrainvial.logviwer.controller.adrarbitragexsgo.RoutingAdrController routing_adr_loader = algo.routing_adr_loader.getController();
            algo.routing_adr_tableView = routing_adr_loader.getType();
            algo.routingAdrMasterList = routing_adr_loader.masterData;

            com.larrainvial.logviwer.controller.adrarbitragexsgo.RoutingLocalController routing_local_loader = algo.routing_local_loader.getController();
            algo.routing_local_tableView = routing_local_loader.getType();
            algo.routingLocalMasterList = routing_local_loader.masterData;

            com.larrainvial.logviwer.controller.adrarbitragexsgo.PanelPositionsController panel_local_loader = algo.panel_positions_loader.getController();
            algo.panel_positions_tableView = panel_local_loader.getType();


            Repository.strategy.put(algo.strategyDataVO.nameAlgo, algo);

        } catch (Exception e) {
            Helper.exception(e);
        }

    }


}