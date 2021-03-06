package com.larrainvial.logviewer.utils;

import com.larrainvial.bo.Algo;
import com.larrainvial.logviewer.fxvo.Dialog;
import com.larrainvial.logviewer.model.ModelLatency;
import com.larrainvial.logviewer.model.ModelRoutingData;
import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Latency {

    public static int LATENCY_MIN;
    public static int LATENCY_MAX;
    public static int LATENCY_GRAPH;

    public static void latencyLocal(final Algo algo, final ModelRoutingData modelRoutingData) {

        if (!Helper.isRouting(modelRoutingData)) return;
        if (modelRoutingData.execType.equals("F")) return;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                if (algo.latencyLocal.containsKey(modelRoutingData.clOrdID)) {

                    if (!Helper.isASK(modelRoutingData)) return;

                    ModelLatency latencyVO = algo.latencyLocal.get(modelRoutingData.clOrdID);
                    latencyVO.timeEnd = time(modelRoutingData.getHour().trim());
                    latencyVO.timeLatency = latencyVO.timeEnd - latencyVO.timeStart;

                    if (latencyVO.timeLatency >= LATENCY_GRAPH){
                        algo.localRouting.getData().add(new XYChart.Data(algo.countQtyOrderLocal++, latencyVO.timeLatency));
                    }

                    if (latencyVO.timeLatency >= LATENCY_MIN){
                        Helper.printLatency(latencyVO);
                    }

                    if (latencyVO.timeLatency >= LATENCY_MAX){
                        Dialog.latency(latencyVO);
                        Helper.printLatency(latencyVO);
                    }

                    algo.latencyLocal.remove(modelRoutingData.clOrdID);

                } else {

                    if (!Helper.isSolicitud(modelRoutingData)) return;

                    ModelLatency latencyVO = new ModelLatency();
                    latencyVO.clOrdID = modelRoutingData.clOrdID;
                    latencyVO.msgType = modelRoutingData.messageByType;
                    latencyVO.side = modelRoutingData.side;
                    latencyVO.symbol = modelRoutingData.symbol;
                    latencyVO.timeStart = time(modelRoutingData.getHour().trim());
                    latencyVO.routing = Constants.LOCAL;
                    latencyVO.nameAlgo = algo.modelXml.nameAlgo;

                    algo.latencyLocal.put(modelRoutingData.clOrdID, latencyVO);

                }
            }
        });
    }

    public static void latencyADR(final Algo algo, final ModelRoutingData modelRoutingData) {

        if (!Helper.isRouting(modelRoutingData)) return;
        if (modelRoutingData.execType.equals("F")) return;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                if (algo.latencyADR.containsKey(modelRoutingData.clOrdID)) {

                    if (!Helper.isASK(modelRoutingData)) return;

                    ModelLatency latencyVO = algo.latencyADR.get(modelRoutingData.clOrdID);
                    latencyVO.timeEnd = time(modelRoutingData.getHour().trim());
                    latencyVO.timeLatency = latencyVO.timeEnd - latencyVO.timeStart;

                    algo.adrRouting.getData().add(new XYChart.Data(algo.countQtyOrderLocal++, latencyVO.timeLatency));

                    if (latencyVO.timeLatency >= LATENCY_MIN){
                        Helper.printLatency(latencyVO);
                    }

                    if (latencyVO.timeLatency >= LATENCY_MAX){
                        Dialog.latency(latencyVO);
                        Helper.printLatency(latencyVO);
                    }

                    algo.latencyADR.remove(modelRoutingData.clOrdID);

                } else {

                    if (!Helper.isSolicitud(modelRoutingData)) return;

                    ModelLatency latencyVO = new ModelLatency();
                    latencyVO.clOrdID = modelRoutingData.clOrdID;
                    latencyVO.msgType = modelRoutingData.messageByType;
                    latencyVO.side = modelRoutingData.side;
                    latencyVO.symbol = modelRoutingData.symbol;
                    latencyVO.timeStart = time(modelRoutingData.getHour().trim());
                    latencyVO.routing = Constants.ADR;
                    latencyVO.nameAlgo = algo.modelXml.nameAlgo;

                    algo.latencyADR.put(modelRoutingData.clOrdID, latencyVO);

                }
            }
        });
    }

    public static Long time(String time){

        try {

            time = time.substring(0,12);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            Date predefined = sdf.parse(time);

            Timestamp sqlTimestamp = new Timestamp(predefined.getTime());

            return sqlTimestamp.getTime();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
}
