package com.larrainvial.utils;

import com.larrainvial.event.ConnectToServerEvent;
import com.larrainvial.trading.emp.Controller;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Helper {

    private static boolean exception = true;
    private static boolean alertBloolean = true;

    public static synchronized void exception(Exception e) {

        try {

            if(!exception) return;

            Platform.runLater(new Runnable() {

                public void run() {

                    Alert alertException = new Alert(Alert.AlertType.ERROR);
                    alertException.setTitle("Exception Dialog");
                    alertException.setHeaderText("Look, an Exception Dialog");
                    alertException.setContentText(e.toString());

                    Exception ex = new FileNotFoundException(e.toString());

                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    ex.printStackTrace(pw);
                    String exceptionText = sw.toString();

                    Label label = new Label("The exception stacktrace was:");

                    TextArea textArea = new TextArea(exceptionText);
                    textArea.setEditable(false);
                    textArea.setWrapText(true);

                    textArea.setMaxWidth(Double.MAX_VALUE);
                    textArea.setMaxHeight(Double.MAX_VALUE);
                    GridPane.setVgrow(textArea, Priority.ALWAYS);
                    GridPane.setHgrow(textArea, Priority.ALWAYS);

                    GridPane expContent = new GridPane();
                    expContent.setMaxWidth(Double.MAX_VALUE);
                    expContent.add(label, 0, 0);
                    expContent.add(textArea, 0, 1);

                    alertException.getDialogPane().setExpandableContent(expContent);
                    exception = false;
                    alertException.showAndWait();

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    alertException.hide();
                    exception = true;

                }
            });

            e.printStackTrace();

        }catch (Exception ex){
            ex.printStackTrace();

        }
    }

    public static synchronized void  alert(String headerText, String contentText1){

        if(!alertBloolean) return;

        Platform.runLater(new Runnable() {
            public void run() {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText(headerText);
                alert.setContentText(contentText1);

                alert.show();
                alertBloolean = false;

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                alert.hide();
                alertBloolean = true;


                }
            });
    }

    public void connect(String id, String ip, int host){
        Controller.dispatchEvent(new ConnectToServerEvent(this, id, ip, host));
    }




}
