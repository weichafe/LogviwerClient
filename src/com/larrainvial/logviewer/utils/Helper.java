package com.larrainvial.logviewer.utils;

import com.larrainvial.logviewer.model.ModelLatency;
import com.larrainvial.logviewer.model.ModelRoutingData;
import org.apache.log4j.Logger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;

public class Helper {

    private static Logger logger = Logger.getLogger(Helper.class.getName());

    public static Boolean isSolicitud(ModelRoutingData modelRoutingData){

        if (modelRoutingData.messageByType.equals("D")) return true;
        else if (modelRoutingData.messageByType.equals("G")) return true;
        else if (modelRoutingData.messageByType.equals("F")) return true;
        else return false;

    }


    public static Boolean isASK(ModelRoutingData modelRoutingData){

        if (modelRoutingData.execType.equals("F")) return true;
        else if (modelRoutingData.execType.equals("New")) return true;
        else if (modelRoutingData.execType.equals("Cancel")) return true;
        else if (modelRoutingData.execType.equals("Replaced")) return true;
        else if (modelRoutingData.execType.equals("Rejected")) return true;
        else if (modelRoutingData.execType.equals("Expired")) return true;
        else if (modelRoutingData.execType.equals("Restated")) return true;
        else if (modelRoutingData.execType.equals("Suspended")) return true;
        else if (modelRoutingData.execType.equals("Done for day")) return true;
        else return false;

    }


    public static void printLatency(ModelLatency latencyVO){
        logger.info("Latency superior a 400 mm");
        logger.info("clOrdID " + latencyVO.clOrdID);
        logger.info("nameAlgo " + latencyVO.nameAlgo);
        logger.info("timeStart " + latencyVO.timeStart);
        logger.info("timeEnd " + latencyVO.timeEnd);
        logger.info("timeLatency " + latencyVO.timeLatency);
        logger.info(latencyVO.routing);
        logger.info("----------");
    }


    public synchronized static String adrToLocal(String symbolLocal){

        //XBOG
        if (symbolLocal.equals("AVAL")) return "PFAVAL";
        if (symbolLocal.equals("AVH")) return "PFAVH";
        if (symbolLocal.equals("CIB")) return "PFBCOLOM";
        if (symbolLocal.equals("EC")) return "ECOPETROL";

        //XTSE
        if (symbolLocal.equals("PRE")) return "PREC";
        if (symbolLocal.equals("CNE")) return "CNEC";

        //XSGO
        if (symbolLocal.equals("BCH")) return "CHILE";
        if (symbolLocal.equals("LFL")) return "LAN";
        if (symbolLocal.equals("BSAC")) return "BSANTANDER";
        if (symbolLocal.equals("CNCO")) return "CENCOSUD";
        if (symbolLocal.equals("CCU")) return "CCU";
        if (symbolLocal.equals("BCA")) return "CORPBANCA";
        if (symbolLocal.equals("AKO.A")) return "ANDINA-A";
        if (symbolLocal.equals("AKO/A")) return "ANDINA-A";
        if (symbolLocal.equals("AKO/B")) return "ANDINA-B";
        if (symbolLocal.equals("AKO.B")) return "ANDINA-B";
        if (symbolLocal.equals("AKO A")) return "ANDINA-A";
        if (symbolLocal.equals("AKO B")) return "ANDINA-B";
        if (symbolLocal.equals("EOC")) return "ENDESA";
        if (symbolLocal.equals("ENI")) return "ENERSIS";
        if (symbolLocal.equals("SQM")) return "SQM-B";
        if (symbolLocal.equals("VCO")) return "CONCHATORO";

        return symbolLocal;
    }

    public synchronized int positions(String symbolLocal){

        //XBOG
        if (symbolLocal.equals("PFAVAL"))      return 0;
        if (symbolLocal.equals("PFAVH"))       return 2;
        if (symbolLocal.equals("PFBCOLOM"))    return 3;
        if (symbolLocal.equals("ECOPETROL"))   return 1;

        //XTSE
        if (symbolLocal.equals("PREC"))        return 0;
        if (symbolLocal.equals("CNEC"))        return 1;

        //XSGO
        if (symbolLocal.equals("CHILE"))       return 0;
        if (symbolLocal.equals("LAN"))         return 2;
        if (symbolLocal.equals("BSANTANDER"))  return 3;
        if (symbolLocal.equals("CENCOSUD"))    return 4;
        if (symbolLocal.equals("CCU"))         return 5;
        if (symbolLocal.equals("CORPBANCA"))   return 6;
        if (symbolLocal.equals("ANDINA-A"))    return 7;
        if (symbolLocal.equals("ANDINA-B"))    return 8;
        if (symbolLocal.equals("ENDESA"))      return 9;
        if (symbolLocal.equals("ENERSIS"))     return 10;
        if (symbolLocal.equals("SQM-B"))       return 11;
        if (symbolLocal.equals("CONCHATORO"))  return 1;

        return 0;
    }

    public synchronized Double ratio(String symbolLocal){

        //XBOG
        if (symbolLocal.equals("PFAVAL"))      return 20d;
        if (symbolLocal.equals("PFAVH"))       return 8d;
        if (symbolLocal.equals("PFBCOLOM"))    return 4d;
        if (symbolLocal.equals("ECOPETROL"))   return 20d;

        //XTSE
        if (symbolLocal.equals("PREC"))        return 1d;
        if (symbolLocal.equals("CNEC"))        return 1d;

        //XSGO
        if (symbolLocal.equals("CHILE"))       return 600d;
        if (symbolLocal.equals("LAN"))         return 1d;
        if (symbolLocal.equals("BSANTANDER"))  return 400d;
        if (symbolLocal.equals("CENCOSUD"))    return 3d;
        if (symbolLocal.equals("CCU"))         return 2d;
        if (symbolLocal.equals("CORPBANCA"))   return 1500d;
        if (symbolLocal.equals("ANDINA-A"))    return 6d;
        if (symbolLocal.equals("ANDINA-B"))    return 6d;
        if (symbolLocal.equals("ENDESA"))      return 30d;
        if (symbolLocal.equals("ENERSIS"))     return 50d;
        if (symbolLocal.equals("SQM-B"))       return 1d;
        if (symbolLocal.equals("CONCHATORO"))  return 50d;

        return 1d;
    }

    public synchronized static Integer position(String symbolLocal){

        //XBOG
        if (symbolLocal.equals("PFAVAL"))      return 1;
        if (symbolLocal.equals("PFAVH"))       return 2;
        if (symbolLocal.equals("PFBCOLOM"))    return 3;
        if (symbolLocal.equals("ECOPETROL"))   return 4;

        //XTSE
        if (symbolLocal.equals("PREC"))        return 1;
        if (symbolLocal.equals("CNEC"))        return 2;

        //XSGO
        if (symbolLocal.equals("CHILE"))       return 1;
        if (symbolLocal.equals("LAN"))         return 2;
        if (symbolLocal.equals("BSANTANDER"))  return 3;
        if (symbolLocal.equals("CENCOSUD"))    return 4;
        if (symbolLocal.equals("CCU"))         return 5;
        if (symbolLocal.equals("CORPBANCA"))   return 6;
        if (symbolLocal.equals("ANDINA-A"))    return 7;
        if (symbolLocal.equals("ANDINA-B"))    return 8;
        if (symbolLocal.equals("ENDESA"))      return 9;
        if (symbolLocal.equals("ENERSIS"))     return 10;
        if (symbolLocal.equals("SQM-B"))       return 11;
        if (symbolLocal.equals("CONCHATORO"))  return 12;

        return 1;
    }

    public synchronized boolean local(String symbolLocal){

        //XBOG
        if (symbolLocal.equals("PFAVAL"))      return true;
        if (symbolLocal.equals("PFAVH"))       return true;
        if (symbolLocal.equals("PFBCOLOM"))    return true;
        if (symbolLocal.equals("ECOPETROL"))   return true;

        //XTSE
        if (symbolLocal.equals("PREC"))        return true;
        if (symbolLocal.equals("CNEC"))        return true;

        //XSGO
        if (symbolLocal.equals("CHILE"))       return true;
        if (symbolLocal.equals("LAN"))         return true;
        if (symbolLocal.equals("BSANTANDER"))  return true;
        if (symbolLocal.equals("CENCOSUD"))    return true;
        if (symbolLocal.equals("CCU"))         return true;
        if (symbolLocal.equals("CORPBANCA"))   return true;
        if (symbolLocal.equals("ANDINA-A"))    return true;
        if (symbolLocal.equals("ANDINA-B"))    return true;
        if (symbolLocal.equals("ENDESA"))      return true;
        if (symbolLocal.equals("ENERSIS"))     return true;
        if (symbolLocal.equals("SQM-B"))       return true;
        if (symbolLocal.equals("CONCHATORO"))  return true;

        return false;
    }

    public static synchronized String side(String side){

        if(side.equals("1")) return "Buy";
        if(side.equals("2")) return "Sell";
        if(side.equals("5")) return "Sell Short";

        return side;
    }

    public static synchronized String orderStatus(String orderStatus){

        if(orderStatus.equals("0")) return "New";
        if(orderStatus.equals("1")) return "Partially filled";
        if(orderStatus.equals("2")) return "Filled";
        if(orderStatus.equals("3")) return "Done for day";
        if(orderStatus.equals("4")) return "Canceled";
        if(orderStatus.equals("5")) return "Replaced";
        if(orderStatus.equals("6")) return "Pending Cancel";
        if(orderStatus.equals("7")) return "Stopped";
        if(orderStatus.equals("8")) return "Rejected";
        if(orderStatus.equals("9")) return "Suspended";
        if(orderStatus.equals("A")) return "Pending New";
        if(orderStatus.equals("B")) return "Calculated";
        if(orderStatus.equals("C")) return "Expired";
        if(orderStatus.equals("C")) return "Accepted for Bidding";
        if(orderStatus.equals("E")) return "Pending Replace";

        return orderStatus;
    }

    public static synchronized String execType(String execType){

        if(execType.equals("0")) return "New";
        if(execType.equals("3")) return "Done for day";
        if(execType.equals("4")) return "Canceled";
        if(execType.equals("5")) return "Replaced";
        if(execType.equals("6")) return "Pending Cancel";
        if(execType.equals("E")) return "Pending Replace";
        if(execType.equals("7")) return "Stopped";
        if(execType.equals("8")) return "Rejected";
        if(execType.equals("9")) return "Suspended";
        if(execType.equals("A")) return "Pending New";
        if(execType.equals("B")) return "Calculated";
        if(execType.equals("C")) return "Expired";
        if(execType.equals("D")) return "Restated";
        if(execType.equals("F")) return "Trade";
        if(execType.equals("G")) return "Trade Correct";
        if(execType.equals("H")) return "Trade Cancel";
        if(execType.equals("I")) return "Order Status";
        if(execType.equals("J")) return "Trade in a Clearing Hold";
        if(execType.equals("K")) return "Trade has been released to Clearingl";
        if(execType.equals("L")) return "Trade Cancel";

        return execType;
    }

    public static void  printerLog(String msg){
        logger.info("----------------");
        logger.info("\n");
        logger.info(new Date());
        logger.info(msg);
        logger.info("\n");
    }


    /*
    public static Boolean isRouting(ModelRoutingData modelRoutingData){

        if (modelRoutingData.messageByType.equals("D")) return true;
        else if (modelRoutingData.messageByType.equals("G")) return true;
        else if (modelRoutingData.messageByType.equals("F")) return true;
        else if (modelRoutingData.messageByType.equals("8")) return true;
        else if (modelRoutingData.messageByType.equals("9")) return true;
        else return false;

    }

    public static Boolean isSolicitud(ModelRoutingData modelRoutingData){

        if (modelRoutingData.messageByType.equals("D")) return true;
        else if (modelRoutingData.messageByType.equals("G")) return true;
        else if (modelRoutingData.messageByType.equals("F")) return true;
        else return false;

    }

    public static Boolean isASK(ModelRoutingData modelRoutingData){

        if (modelRoutingData.execType.equals("F")) return true;
        else if (modelRoutingData.execType.equals("New")) return true;
        else if (modelRoutingData.execType.equals("Cancel")) return true;
        else if (modelRoutingData.execType.equals("Replaced")) return true;
        else if (modelRoutingData.execType.equals("Rejected")) return true;
        else if (modelRoutingData.execType.equals("Expired")) return true;
        else if (modelRoutingData.execType.equals("Restated")) return true;
        else if (modelRoutingData.execType.equals("Suspended")) return true;
        else if (modelRoutingData.execType.equals("Done for day")) return true;
        else return false;

    }

    public static void printLatency(ModelLatency latencyVO){
        logger.info("Latency superior a 400 mm");
        logger.info("clOrdID " + latencyVO.clOrdID);
        logger.info("nameAlgo " + latencyVO.nameAlgo);
        logger.info("timeStart " + latencyVO.timeStart);
        logger.info("timeEnd " + latencyVO.timeEnd);
        logger.info("timeLatency " + latencyVO.timeLatency);
        logger.info(latencyVO.routing);
        logger.info("----------");
    }

    public static void  printerLog(String msg){
        logger.info("----------------");
        logger.info("\n");
        logger.info(new Date());
        logger.info(msg);
        logger.info("\n");
    }
    */

    public static Boolean validateTime(String time){

        try {

            SimpleDateFormat dateFormatGmt = new SimpleDateFormat("HH:mm:ss");
            dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

            SimpleDateFormat dateFormatLocal = new SimpleDateFormat("HH:mm:ss");
            Date datePC = dateFormatLocal.parse(dateFormatGmt.format(new Date()));

            Calendar newDatePC = Calendar.getInstance();
            newDatePC.setTime(datePC);
            newDatePC.set(Calendar.MINUTE, newDatePC.get(Calendar.MINUTE) - 5);
            datePC = newDatePC.getTime();

            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date dateLog = formatter.parse(time);

            return (datePC.before(dateLog)) ? false : true;

        } catch (Exception ex) {
            logger.error(Level.SEVERE, ex);
            ex.printStackTrace();
        }

        return null;

    }

    public static Double formatNumber(double number) {

        DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
        return new Double(df2.format(number)).doubleValue();
    }

    public static Boolean isNumber(String numero){
        try {
            Double.parseDouble(numero);
            return true;

        } catch (NumberFormatException nfe){
            return false;
        }

    }

    public static Boolean isRouting(ModelRoutingData modelRoutingData){

        if (modelRoutingData.messageByType.equals("D")) return true;
        else if (modelRoutingData.messageByType.equals("G")) return true;
        else if (modelRoutingData.messageByType.equals("F")) return true;
        else if (modelRoutingData.messageByType.equals("8")) return true;
        else if (modelRoutingData.messageByType.equals("9")) return true;
        else return false;

    }



}