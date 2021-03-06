package com.larrainvial.logviewer.vo;

import com.larrainvial.logviewer.model.ModelMarketData;
import com.larrainvial.logviewer.model.ModelPositions;
import com.larrainvial.logviewer.model.ModelRoutingData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class StrategyDataVO implements Serializable {

    private static final long serialVersionUID = -3623359487215433702L;

    public String nameAlgo;
    public String mkd_dolar;
    public String mkd_local;
    public String mkd_adr;
    public String routing_local;
    public String routing_adr;

    public ArrayList<ModelMarketData> dolarMasterListArray = new ArrayList<ModelMarketData>();
    public ArrayList<ModelMarketData> mkdAdrMasterListArray = new ArrayList<ModelMarketData>();
    public ArrayList<ModelMarketData> mkdLocalMasterListArray = new ArrayList<ModelMarketData>();
    public ArrayList<ModelRoutingData> routingAdrMasterListArray = new ArrayList<ModelRoutingData>();
    public ArrayList<ModelRoutingData> routingLocalMasterListArray = new ArrayList<ModelRoutingData>();
    public ArrayList<ModelRoutingData> routingBlotterMasterListArray = new ArrayList<ModelRoutingData>();
    public ArrayList<ModelPositions> positionsMasterListArray = new ArrayList<ModelPositions>();

    public LinkedHashMap<String,ModelPositions> positionsMasterListHash = new LinkedHashMap<String, ModelPositions>();

}
