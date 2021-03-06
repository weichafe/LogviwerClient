package com.larrainvial.logviewer.controller.algos;

import com.larrainvial.logviewer.model.ModelMarketData;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LastPriceController {

    @FXML
    private TableView<ModelMarketData> lastPrice;

    @FXML
    private TextField filterField;

    @FXML
    private TableColumn<ModelMarketData, String> anio;

    @FXML
    private TableColumn<ModelMarketData, String> hour;

    @FXML
    private TableColumn<ModelMarketData, String> messageByType;

    @FXML
    public TableColumn<ModelMarketData, String> symbol;

    @FXML
    private TextField textField;

    @FXML
    private TableColumn<ModelMarketData, String> buyPx;

    @FXML
    private TableColumn<ModelMarketData, String> buyQty;

    @FXML
    private TableColumn<ModelMarketData, String> sellPx;

    @FXML
    private TableColumn<ModelMarketData, String> sellQty;

    @FXML
    private TableColumn<ModelMarketData, String> closePx;

    @FXML
    private TableColumn<ModelMarketData, String> tradeAmount;

    private boolean filter = false;

    private ObservableList<ModelMarketData> auxFilterData;

    private TextField auxFilterField;


    @FXML
    private synchronized void initialize() throws Exception {

        messageByType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().messageByType));
        symbol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().symbol));
        hour.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hour));
        buyQty.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().buyQty.toString()));
        buyPx.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().buyPx.toString()));
        sellQty.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().sellQty.toString()));
        sellPx.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().sellPx.toString()));
        closePx.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().closePx.toString()));
        tradeAmount.setCellValueFactory(cellData2 -> new SimpleStringProperty(String.valueOf(cellData2.getValue().tradeAmount)));


        messageByType.setCellFactory(column -> {
            return new TableCell<ModelMarketData, String>() {

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null || empty) {
                            setText("");

                        } else {

                            if (item.equals("V")) {
                                setText(item);

                            } else if (item.equals("W")) {
                                setText(item);

                            } else if (item.equals("X")) {
                                setText(item);

                            } else if (item.equals("5")) {
                                setTextFill(Color.RED);
                                setText(item);

                            } else if (item.equals("1")) {
                                setTextFill(Color.AQUA);
                                setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");
                                setText(item);

                            } else if (item.equals("A")) {
                                setTextFill(Color.RED);
                                setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");
                                setText(item);

                            } else {
                                setText(item);
                            }
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

        lastPrice.setVisible(false);
        anio.setVisible(true);
        messageByType.setVisible(true);
        symbol.setVisible(true);
        hour.setVisible(true);
        buyPx.setVisible(true);
        buyQty.setVisible(true);
        sellPx.setVisible(true);
        sellQty.setVisible(true);
        closePx.setVisible(true);

    }


    public TableView<ModelMarketData> getType() {
        return lastPrice;
    }
}
