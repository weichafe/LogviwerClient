package com.larrainvial.logviewer.controller.algos;

import com.larrainvial.logviewer.model.ModelMMBCS;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DecimalFormat;

public class MMBCSController {

    @FXML
    private TableView<ModelMMBCS> mmbcs;

    @FXML
    private TableColumn<ModelMMBCS, String> symbol;

    @FXML
    private TableColumn<ModelMMBCS, String> priceBuy;

    @FXML
    private TableColumn<ModelMMBCS, String> priceSell;

    @FXML
    private TableColumn<ModelMMBCS, String> orderQtyBuy;

    @FXML
    private TableColumn<ModelMMBCS, String> orderQtySell;

    @FXML
    public TableColumn<ModelMMBCS, String> leavesQtyBuy;

    @FXML
    public TableColumn<ModelMMBCS, String> leavesQtySell;

    @FXML
    public TableColumn<ModelMMBCS, String> side;

    @FXML
    private TableColumn<ModelMMBCS, String> cumQtyBuy;

    @FXML
    private TableColumn<ModelMMBCS, String> cumQtySell;

    @FXML
    private TableColumn<ModelMMBCS, String> lastPxBuy;

    @FXML
    private TableColumn<ModelMMBCS, String> lastPxSell;

    @FXML
    private TableColumn<ModelMMBCS, String> lastQtyBuy;

    @FXML
    private TableColumn<ModelMMBCS, String> lastQtySell;

    @FXML
    private TableColumn<ModelMMBCS, String> pxqBuy;

    @FXML
    private TableColumn<ModelMMBCS, String> pxqSell;

    private DecimalFormat numFormat = new DecimalFormat("###,###");



    @FXML
    private synchronized void initialize() throws Exception {

        symbol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().symbol));
        priceBuy.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().priceBuy.toString()));
        orderQtyBuy.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().orderQtyBuy.toString()));
        leavesQtyBuy.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().leavesQtyBuy.toString()));
        cumQtyBuy.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().cumQtyBuy.toString()));
        pxqBuy.setCellValueFactory(cellData2 -> new SimpleStringProperty(String.valueOf(cellData2.getValue().pxqBuy.toString())));
        priceSell.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().priceSell.toString()));
        orderQtySell.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().orderQtySell.toString()));
        leavesQtySell.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().leavesQtySell.toString()));
        cumQtySell.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().cumQtySell.toString()));
        pxqSell.setCellValueFactory(cellData2 -> new SimpleStringProperty(String.valueOf(cellData2.getValue().pxqSell.toString())));


        priceBuy.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        priceBuy.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });


        leavesQtySell.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        leavesQtyBuy.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });


        orderQtyBuy.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        orderQtySell.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        pxqSell.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        pxqBuy.setCellFactory(column -> {
            return new TableCell<ModelMMBCS, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");
                        } else {
                            setText(numFormat.format(Double.valueOf(item)));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });
    }


    @FXML
    private void refreshTableView() throws Exception {

        symbol.setVisible(false);
        side.setVisible(true);

        priceBuy.setVisible(true);
        orderQtyBuy.setVisible(true);
        leavesQtyBuy.setVisible(true);
        cumQtyBuy.setVisible(true);
        lastPxBuy.setVisible(true);
        lastQtyBuy.setVisible(true);
        pxqSell.setVisible(true);

        priceSell.setVisible(true);
        orderQtySell.setVisible(true);
        leavesQtySell.setVisible(true);
        cumQtySell.setVisible(true);
        lastPxSell.setVisible(true);
        lastQtySell.setVisible(true);
        pxqBuy.setVisible(true);
    }

    public TableView<ModelMMBCS> getType() {
        return mmbcs;
    }


}
