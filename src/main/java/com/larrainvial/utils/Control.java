package com.larrainvial.utils;

import com.larrainvial.Algo;
import com.larrainvial.MainApp;
import com.larrainvial.Repository;
import com.larrainvial.event.SendAllDataToViewEvent;
import com.larrainvial.listener.SendAllDataToViewListener;
import com.larrainvial.trading.emp.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

public class Control {

    public static void initialize(){

        Controller.addEventListener(SendAllDataToViewEvent.class, new SendAllDataToViewListener());

    }

    public  static void initializaAll() throws InterruptedException {

        initializeAdrArbitrageXSGO(2);
        initializeAdrArbitrageXTSE(3);
        initializeAdrArbitrageXBOG(4);

    }


    private static void initializeAdrArbitrageXSGO(int tab){

        try {

            final Algo algo = new Algo();

            algo.setNameAlgo("ADRArbitrage XSGO");
            algo.setMkd_dolar("MKD_DOLAR");
            algo.setMkd_adr("MKD_NYSE");
            algo.setMkd_local("MKD_XSGO");
            algo.setRouting_adr("ROUTING_ADR");
            algo.setRouting_local("ROUTING_LOCAL");
            algo.setTime(1);


            Slider opacityLevel = new Slider(1, 10, Double.valueOf(algo.getTime()));
            opacityLevel.setLayoutX(25);
            opacityLevel.setLayoutY(13);

            opacityLevel.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                    algo.setTime(new_val.doubleValue());
                }
            });


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


            algo.getMkd_dolar_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/MarketDataDolarView.fxml"));
            algo.getMkd_adr_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/MarketDataAdrView.fxml"));
            algo.getMkd_local_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/MarketDataLocalView.fxml"));
            algo.getRouting_adr_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/RoutingAdrView.fxml"));
            algo.getRouting_local_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/RoutingLocalView.fxml"));
            algo.getPanel_positions_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexsgo/PanelPositionsView.fxml"));


            AnchorPane anchorPane = new AnchorPane();
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_dolar_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_adr_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_local_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getRouting_adr_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getRouting_local_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getPanel_positions_loader().load());
            anchorPane.getChildren().add(opacityLevel);
            anchorPane.getChildren().add(switchBtn1);
            anchorPane.getChildren().add(switchBtn2);
            anchorPane.getChildren().add(switchBtn3);
            anchorPane.getChildren().add(switchBtn4);
            anchorPane.getChildren().add(switchBtn5);
            anchorPane.getChildren().add(switchBtn6);


            Repository.tabPanePrincipalTabPanel.getTabs().get(tab).setContent(anchorPane);
            Repository.tabPanePrincipalTabPanel.getTabs().get(tab).setText(algo.getNameAlgo());

            com.larrainvial.controller.adrarbitragexsgo.MarketDataDolarController getMkd_dolar_loader = algo.getMkd_dolar_loader().getController();
            algo.setMkd_dolar_tableView(getMkd_dolar_loader.getType());
            algo.setDolarMasterList(getMkd_dolar_loader.masterData);

            com.larrainvial.controller.adrarbitragexsgo.MarketDataAdrController getMkd_adr_loader = algo.getMkd_adr_loader().getController();
            algo.setMkd_adr_tableView(getMkd_adr_loader.getType());
            algo.setMkdAdrMasterList(getMkd_adr_loader.masterData);

            com.larrainvial.controller.adrarbitragexsgo.MarketDataLocalController getMkd_local_loader = algo.getMkd_local_loader().getController();
            algo.setMkd_local_tableView(getMkd_local_loader.getType());
            algo.setMkdLocalMasterList(getMkd_local_loader.masterData);

            com.larrainvial.controller.adrarbitragexsgo.RoutingAdrController routing_adr_loader = algo.getRouting_adr_loader().getController();
            algo.setRouting_adr_tableView(routing_adr_loader.getType());
            algo.setRoutingAdrMasterList(routing_adr_loader.masterData);

            com.larrainvial.controller.adrarbitragexsgo.RoutingLocalController routing_local_loader = algo.getRouting_local_loader().getController();
            algo.setRouting_local_tableView(routing_local_loader.getType());
            algo.setRoutingLocalMasterList(routing_local_loader.masterData);

            com.larrainvial.controller.adrarbitragexsgo.PanelPositionsController panel_local_loader = algo.getPanel_positions_loader().getController();
            algo.setPanel_positions_tableView(panel_local_loader.getType());

            Repository.strategy.put(algo.getNameAlgo(), algo);

        } catch (Exception e){
            Helper.exception(e);
        }
    }

    private static void initializeAdrArbitrageXTSE(int tab){

        try {

            Algo algo = new Algo();

            algo.setNameAlgo("ADRArbitrage XTSE");
            algo.setMkd_dolar("MKD_DOLAR");
            algo.setMkd_adr("MKD_NYSE");
            algo.setMkd_local("MKD_XSGO");
            algo.setRouting_adr("ROUTING_ADR");
            algo.setRouting_local("ROUTING_LOCAL");
            algo.setTime(1);

            Slider opacityLevel = new Slider(1, 10, Double.valueOf(algo.getTime()));
            opacityLevel.setLayoutX(25);
            opacityLevel.setLayoutY(13);

            opacityLevel.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                    algo.setTime(new_val.doubleValue());
                }
            });

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


            algo.getMkd_dolar_loader().setLocation(MainApp.class.getResource("/view/adrarbitragextse/MarketDataDolarView.fxml"));
            algo.getMkd_adr_loader().setLocation(MainApp.class.getResource("/view/adrarbitragextse/MarketDataAdrView.fxml"));
            algo.getMkd_local_loader().setLocation(MainApp.class.getResource("/view/adrarbitragextse/MarketDataLocalView.fxml"));
            algo.getRouting_adr_loader().setLocation(MainApp.class.getResource("/view/adrarbitragextse/RoutingAdrView.fxml"));
            algo.getRouting_local_loader().setLocation(MainApp.class.getResource("/view/adrarbitragextse/RoutingLocalView.fxml"));
            algo.getPanel_positions_loader().setLocation(MainApp.class.getResource("/view/adrarbitragextse/PanelPositionsView.fxml"));


            AnchorPane anchorPane = new AnchorPane();
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_dolar_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_adr_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_local_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getRouting_adr_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getRouting_local_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getPanel_positions_loader().load());
            anchorPane.getChildren().add(opacityLevel);
            anchorPane.getChildren().add(switchBtn1);
            anchorPane.getChildren().add(switchBtn2);
            anchorPane.getChildren().add(switchBtn3);
            anchorPane.getChildren().add(switchBtn4);
            anchorPane.getChildren().add(switchBtn5);
            anchorPane.getChildren().add(switchBtn6);

            Repository.tabPanePrincipalTabPanel.getTabs().get(tab).setContent(anchorPane);
            Repository.tabPanePrincipalTabPanel.getTabs().get(tab).setText(algo.getNameAlgo());


            com.larrainvial.controller.adrarbitragextse.MarketDataDolarController getMkd_dolar_loader = algo.getMkd_dolar_loader().getController();
            algo.setMkd_dolar_tableView(getMkd_dolar_loader.getType());
            algo.setDolarMasterList(getMkd_dolar_loader.masterData);



            com.larrainvial.controller.adrarbitragextse.MarketDataAdrController getMkd_adr_loader = algo.getMkd_adr_loader().getController();
            algo.setMkd_adr_tableView(getMkd_adr_loader.getType());
            algo.setMkdAdrMasterList(getMkd_adr_loader.masterData);

            com.larrainvial.controller.adrarbitragextse.MarketDataLocalController getMkd_local_loader = algo.getMkd_local_loader().getController();
            algo.setMkd_local_tableView(getMkd_local_loader.getType());
            algo.setMkdLocalMasterList(getMkd_local_loader.masterData);

            com.larrainvial.controller.adrarbitragextse.RoutingAdrController routing_adr_loader = algo.getRouting_adr_loader().getController();
            algo.setRouting_adr_tableView(routing_adr_loader.getType());
            algo.setRoutingAdrMasterList(routing_adr_loader.masterData);

            com.larrainvial.controller.adrarbitragextse.RoutingLocalController routing_local_loader = algo.getRouting_local_loader().getController();
            algo.setRouting_local_tableView(routing_local_loader.getType());
            algo.setRoutingLocalMasterList(routing_local_loader.masterData);

            com.larrainvial.controller.adrarbitragextse.PanelPositionsController panel_local_loader = algo.getPanel_positions_loader().getController();
            algo.setPanel_positions_tableView(panel_local_loader.getType());

            Repository.strategy.put(algo.getNameAlgo(), algo);

        }catch (Exception e){
            Helper.exception(e);
        }
    }

    private static void initializeAdrArbitrageXBOG(int tab){

        try {

            Algo algo = new Algo();


            Slider opacityLevel = new Slider(1, 10, Double.valueOf(algo.getTime()));
            opacityLevel.setLayoutX(25);
            opacityLevel.setLayoutY(13);

            opacityLevel.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                    algo.setTime(new_val.doubleValue());
                }
            });

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


            algo.getMkd_dolar_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexbog/MarketDataDolarView.fxml"));
            algo.getMkd_adr_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexbog/MarketDataAdrView.fxml"));
            algo.getMkd_local_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexbog/MarketDataLocalView.fxml"));
            algo.getRouting_adr_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexbog/RoutingAdrView.fxml"));
            algo.getRouting_local_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexbog/RoutingLocalView.fxml"));
            algo.getPanel_positions_loader().setLocation(MainApp.class.getResource("/view/adrarbitragexbog/PanelPositionsView.fxml"));


            AnchorPane anchorPane = new AnchorPane();
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_dolar_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_adr_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getMkd_local_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getRouting_adr_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getRouting_local_loader().load());
            anchorPane.getChildren().add((AnchorPane) algo.getPanel_positions_loader().load());
            anchorPane.getChildren().add(opacityLevel);
            anchorPane.getChildren().add(switchBtn1);
            anchorPane.getChildren().add(switchBtn2);
            anchorPane.getChildren().add(switchBtn3);
            anchorPane.getChildren().add(switchBtn4);
            anchorPane.getChildren().add(switchBtn5);
            anchorPane.getChildren().add(switchBtn6);

            Repository.tabPanePrincipalTabPanel.getTabs().get(tab).setContent(anchorPane);
            Repository.tabPanePrincipalTabPanel.getTabs().get(tab).setText(algo.getNameAlgo());

            com.larrainvial.controller.adrarbitragexbog.MarketDataDolarController getMkd_dolar_loader = algo.getMkd_dolar_loader().getController();
            algo.setMkd_dolar_tableView(getMkd_dolar_loader.getType());
            algo.setDolarMasterList(getMkd_dolar_loader.masterData);

            com.larrainvial.controller.adrarbitragexbog.MarketDataAdrController getMkd_adr_loader = algo.getMkd_adr_loader().getController();
            algo.setMkd_adr_tableView(getMkd_adr_loader.getType());
            algo.setMkdAdrMasterList(getMkd_adr_loader.masterData);

            com.larrainvial.controller.adrarbitragexbog.MarketDataLocalController getMkd_local_loader = algo.getMkd_local_loader().getController();
            algo.setMkd_local_tableView(getMkd_local_loader.getType());
            algo.setMkdLocalMasterList(getMkd_local_loader.masterData);

            com.larrainvial.controller.adrarbitragexbog.RoutingAdrController routing_adr_loader = algo.getRouting_adr_loader().getController();
            algo.setRouting_adr_tableView(routing_adr_loader.getType());
            algo.setRoutingAdrMasterList(routing_adr_loader.masterData);

            com.larrainvial.controller.adrarbitragexbog.RoutingLocalController routing_local_loader = algo.getRouting_local_loader().getController();
            algo.setRouting_local_tableView(routing_local_loader.getType());
            algo.setRoutingLocalMasterList(routing_local_loader.masterData);

            com.larrainvial.controller.adrarbitragexbog.PanelPositionsController panel_local_loader = algo.getPanel_positions_loader().getController();
            algo.setPanel_positions_tableView(panel_local_loader.getType());

            Repository.strategy.put(algo.getNameAlgo(), algo);


        }catch (Exception e){
            Helper.exception(e);
        }
    }


}