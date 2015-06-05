package com.larrainvial;

import com.larrainvial.connection.Client;
import com.larrainvial.utils.Control;
import com.larrainvial.utils.Helper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {

            ArrayList<Thread> clients = new ArrayList<Thread>();

            clients.add(new Client(1));

            for (int i = 0; i < 5; i++) {
                clients.add(new Client(i));
            }
            for (Thread thread : clients) {
                thread.start();
            }

            Repository.primaryStage = primaryStage;
            Repository.primaryStage.setTitle("Log Viwer");

            Repository.rootLayout_Loader.setLocation(MainApp.class.getResource("/view/rootLayout.fxml"));
            BorderPane rootLayout_Loader = (BorderPane) Repository.rootLayout_Loader.load();

            Repository.principalTabPanel_Loader.setLocation(MainApp.class.getResource("/view/PrincipalTabPanel.fxml"));
            Repository.tabPanePrincipalTabPanel = (TabPane) Repository.principalTabPanel_Loader.load();
            rootLayout_Loader.setCenter(Repository.tabPanePrincipalTabPanel);

            Scene scene = new Scene(rootLayout_Loader);
            primaryStage.setScene(scene);

            primaryStage.show();

            Control.initializaAll();

        } catch (Exception e){
            Helper.exception(e);
        }

    }


    public static void main(String[] args) {

        launch(args);
    }

}



