package com.larrainvial.logviewer.fxvo;

import com.larrainvial.logviewer.model.ModelLatency;
import com.larrainvial.logviewer.utils.Helper;
import com.larrainvial.logviewer.utils.Notifier;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class Dialog {

    public static synchronized void latency(ModelLatency latencyVO) {

        try {

            String text = "Name Algo : " + latencyVO.nameAlgo + "\n";
            text += "ClOrdID: " + latencyVO.clOrdID + "\n";
            text += "Routing: " + latencyVO.routing + "\n";
            text += "Latency: " + latencyVO.timeLatency + " mm" + "\n";

            final String finalText = text;

            Platform.runLater(new Runnable() {
                public void run() {
                    Notifier.INSTANCE.notifyWarning("Latency", finalText);
                }
            });


        } catch (Exception ex) {
            ex.printStackTrace();
            Helper.printerLog(ex.toString());
            Notifier.INSTANCE.notifyError("Error", ex.toString());
        }
    }


    public static synchronized void about() {

        try {

            Platform.runLater(new Runnable() {

                public void run() {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("LOG VIEWER LARRAINVIAL");
                    alert.setContentText("Author: Etrading\n");
                    alert.showAndWait();
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
            Helper.printerLog(ex.toString());
            Notifier.INSTANCE.notifyError("Error", ex.toString());
        }
    }

}
