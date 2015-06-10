package com.larrainvial;

import com.larrainvial.logviwer.model.ModelMarketData;
import com.larrainvial.logviwer.model.ModelPositions;
import com.larrainvial.logviwer.model.ModelRoutingData;
import com.larrainvial.logviwer.vo.StrategyDataVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Algo implements Serializable {

    private static final long serialVersionUID = 8799656478674226639L;

    transient public FXMLLoader mkd_dolar_loader = new FXMLLoader();
    transient public FXMLLoader mkd_local_loader = new FXMLLoader();
    transient public FXMLLoader mkd_adr_loader = new FXMLLoader();
    transient public FXMLLoader routing_adr_loader = new FXMLLoader();
    transient public FXMLLoader routing_local_loader = new FXMLLoader();
    transient public FXMLLoader panel_positions_loader = new FXMLLoader();

    public StrategyDataVO strategyDataVO = new StrategyDataVO();

    transient public ObservableList<ModelMarketData> dolarMasterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelMarketData> dolarFilterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelMarketData> mkdAdrMasterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelMarketData> mkdAdrFilterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelMarketData> mkdLocalMasterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelMarketData> mkdLocalFilterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelRoutingData> routingAdrMasterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelRoutingData> routingAdrFilterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelRoutingData> routingLocalMasterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelRoutingData> routingLocalFilterList = FXCollections.observableArrayList();
    transient public ObservableList<ModelRoutingData> routingBlotterMasterLsit = FXCollections.observableArrayList();
    transient public ObservableList<ModelRoutingData> routingBlotterFilterLsit = FXCollections.observableArrayList();
    transient public ObservableList<ModelPositions> positionsMasterList = FXCollections.observableArrayList();

    public ArrayList<ModelMarketData> dolarMasterListArray = new ArrayList<ModelMarketData>();
    public ArrayList<ModelMarketData> mkdAdrMasterListArray = new ArrayList<ModelMarketData>();
    public ArrayList<ModelMarketData> mkdLocalMasterListArray = new ArrayList<ModelMarketData>();
    public ArrayList<ModelRoutingData> routingAdrMasterListArray = new ArrayList<ModelRoutingData>();
    public ArrayList<ModelRoutingData> routingLocalMasterListArray = new ArrayList<ModelRoutingData>();
    public ArrayList<ModelRoutingData> routingBlotterMasterListArray = new ArrayList<ModelRoutingData>();
    public ArrayList<ModelPositions> positionsMasterListArray = new ArrayList<ModelPositions>();
    public Map<String,ModelPositions> positionsMasterListHash = Collections.synchronizedMap(new LinkedHashMap<String, ModelPositions>());


    transient public boolean mkd_dolar_toggle = false;
    transient public boolean mkd_local_toggle = false;
    transient public boolean mkd_adr_toggle = false;
    transient public boolean routing_local_toggle = false;
    transient public boolean routing_adr_toggle = false;

    transient public boolean alert = false;


}