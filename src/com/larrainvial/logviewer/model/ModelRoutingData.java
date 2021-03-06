package com.larrainvial.logviewer.model;

public class ModelRoutingData {

    public String received = "";
    public String hour = "-";
    public String year = "-";
    public String messageByType = "-";
    public String symbol = "-";

    public String orderID = "-";
    public String clOrdID = "-";
    public String origClOrdID = "-";
    public String clOrdLinkID = "-";
    public String execID = "-";
    public String execType = "-";
    public String ordStatus = "-";
    public String account = "-";
    public String side = "-";

    public String effectiveTime = "-";
    public String text = "-";
    public String expireTime = "-";
    public String exDestination = "-";
    public String securityExchange = "-";

    public Double price = 0d;
    public Double orderQty = 0d;
    public Double lastQty = 0d;
    public Double lastPx = 0d;
    public Double cumQty = 0d;
    public Double avgPx = 0d;
    public Double leavesQty = 0d;
    public Double maxFloor = 0d;

    public ModelRoutingData(){

    }

    public ModelRoutingData(String year, String hour, String messageByType) {

        this.year = year;
        this.messageByType = messageByType;
        this.symbol = "";
        this.hour = hour;
        this.orderID = "";
        this.clOrdID = "";
        this.origClOrdID = "";
        this.clOrdLinkID = "";
        this.execID = "";
        this.execType = "";
        this.ordStatus = "";
        this.account = "";
        this.text = "";
        this.side = "";
        this.effectiveTime = "";
        this.expireTime = "";
        this.exDestination = "";
        this.securityExchange = "";
        this.price = 0d;
        this.lastQty = 0d;
        this.lastPx = 0d;
        this.cumQty = 0d;
        this.avgPx =  0d;
        this.leavesQty = 0d;
        this.maxFloor = 0d;
        this.orderQty = 0d;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public Double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Double orderQty) {
        this.orderQty = orderQty;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMessageByType() {
        return messageByType;
    }

    public void setMessageByType(String messageByType) {
        this.messageByType = messageByType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    public String getOrigClOrdID() {
        return origClOrdID;
    }

    public void setOrigClOrdID(String origClOrdID) {
        this.origClOrdID = origClOrdID;
    }

    public String getClOrdLinkID() {
        return clOrdLinkID;
    }

    public void setClOrdLinkID(String clOrdLinkID) {
        this.clOrdLinkID = clOrdLinkID;
    }

    public String getExecID() {
        return execID;
    }

    public void setExecID(String execID) {
        this.execID = execID;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getExDestination() {
        return exDestination;
    }

    public void setExDestination(String exDestination) {
        this.exDestination = exDestination;
    }

    public String getSecurityExchange() {
        return securityExchange;
    }

    public void setSecurityExchange(String securityExchange) {
        this.securityExchange = securityExchange;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getLastQty() {
        return lastQty;
    }

    public void setLastQty(Double lastQty) {
        this.lastQty = lastQty;
    }

    public Double getLastPx() {
        return lastPx;
    }

    public void setLastPx(Double lastPx) {
        this.lastPx = lastPx;
    }

    public Double getCumQty() {
        return cumQty;
    }

    public void setCumQty(Double cumQty) {
        this.cumQty = cumQty;
    }

    public Double getAvgPx() {
        return avgPx;
    }

    public void setAvgPx(Double avgPx) {
        this.avgPx = avgPx;
    }

    public Double getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(Double leavesQty) {
        this.leavesQty = leavesQty;
    }

    public Double getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(Double maxFloor) {
        this.maxFloor = maxFloor;
    }
}