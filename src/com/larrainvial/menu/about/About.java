package com.larrainvial.menu.about;


import com.larrainvial.sellside.StartSellSide;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import java.util.logging.Level;

public class About {

    public AnchorPane ventanaPrincipal;
    public VBox general = new VBox();
    private static Logger logger = Logger.getLogger(About.class.getName());

    public About(Stage primaryStage){

        try {

            FXMLLoader loader = new FXMLLoader(StartSellSide.class.getResource("view/about.fxml"));
            ventanaPrincipal = (AnchorPane) loader.load();
            ventanaPrincipal.setPrefWidth(300);
            ventanaPrincipal.setPrefHeight(200);

            general.prefWidthProperty().bind(ventanaPrincipal.widthProperty());
            ventanaPrincipal.getChildren().addAll(general);

            HBox text = new HBox();
            text.setAlignment(Pos.CENTER);

            StringBuffer texto = new StringBuffer();
            texto.append("\n\n\n");
            texto.append("Etrading\n");
            texto.append("Gerencia de Sitemas\n");
            texto.append("Larrainvial 2015\n");
            texto.append("Version terrible Chora 1.0.0.3 16/11/2015\n");
            texto.append("Version terrible ni que Choriza 1.0.0.4 25/11/2015\n");
            texto.append("Version destripadora 1.0.0.5 09/12/2015\n");

            Label label1 = new Label(texto.toString());
            text.getChildren().addAll(label1);
            general.getChildren().addAll(text);

            Stage santiago = new Stage();
            santiago.initOwner(primaryStage);

            Scene scene = new Scene(ventanaPrincipal);
            santiago.setScene(scene);
            santiago.show();

        } catch (Exception ex){
            logger.error(Level.SEVERE, ex);
        }


    }
}
