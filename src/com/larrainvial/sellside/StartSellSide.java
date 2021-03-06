package com.larrainvial.sellside;


import com.larrainvial.Repository;
import com.larrainvial.bo.Algo;
import com.larrainvial.sellside.utils.PropertiesFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StartSellSide {

    public StartSellSide(){

        Repository.buySide  = new PropertiesFile(Repository.locationPath + "SellSide.properties");

        Repository.XPUS_NAME = Repository.buySide.getPropertiesString("XPUS.NAME");
        Repository.XPUS_UUID = Repository.buySide.getPropertiesString("XPUS.UUID");

        String[] XPUS_NAME = Repository.XPUS_NAME.split(",");
        String[] XPUS_UUID = Repository.XPUS_UUID.split(",");

        for (int i=0; i < XPUS_NAME.length; i++) {
            Repository.UUID.put(XPUS_NAME[i], XPUS_UUID[i]);
        }

        Repository.date = new SimpleDateFormat("yyyyMMdd").format(new Date());

        Control.initialize();

        Repository.sellside =  new Algo();

    }
}
