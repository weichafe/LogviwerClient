package com.larrainvial;

import com.larrainvial.logviewer.StartLogviewer;
import com.larrainvial.logviewer.adaptador.QuickFixAdapter;
import com.larrainvial.sellside.StartSellSide;
import com.larrainvial.trading.utils.PropertiesFile;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MainApp extends Application {

    public static PropertiesFile propertiesFile;
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static final Logger logger = Logger.getLogger(MainApp.class.getName());

    @Override
    public void start(Stage primaryStage) {

        try {

            //Todo: Sell Side
            StartSellSide startSellSide = new StartSellSide();

            //Todo: Logviewer
            StartLogviewer startLogviewer = new StartLogviewer(primaryStage);


        } catch (Exception ex){
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) {

        try {

            propertiesFile = new PropertiesFile(args[0]);

            new QuickFixAdapter(propertiesFile.getPropertiesString("qFixFile"));

            if (isWindows()) {
                Repository.locationPath = "C:\\Program Files (x86)\\LarrainVial\\Logviewer\\Resources\\";
                PropertyConfigurator.configure(Repository.locationPath + "log4jWindows.properties");
                logger.info("Server is Windows");
                logger.info("LocalPath " + Repository.locationPath);
                Repository.nameFileQuickFix = "windows.ini";

            } else if (isMac()) {
                logger.info("Server is Mac");

            } else if (isUnix()) {
                Repository.locationPath = "/opt/Logviewer/Resources/";
                PropertyConfigurator.configure(Repository.locationPath + "log4jLinux.properties");
                logger.info("Server is Unix or Linux");
                logger.info("LocalPath " + Repository.locationPath);
                Repository.nameFileQuickFix = "linux.ini";
            }

            launch(args);

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static boolean isWindows() throws Exception {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() throws Exception {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() throws Exception {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

}



