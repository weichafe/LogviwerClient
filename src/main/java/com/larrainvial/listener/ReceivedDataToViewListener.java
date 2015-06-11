package com.larrainvial.listener;

import com.larrainvial.Algo;
import com.larrainvial.Repository;
import com.larrainvial.event.ReceivedDataToViewEvent;
import com.larrainvial.logviwer.vo.NameStrategyVO;
import com.larrainvial.trading.emp.Event;
import com.larrainvial.trading.emp.Listener;

public class ReceivedDataToViewListener implements Listener {

    private Algo algo;

    @Override
    public void eventOccurred(Event event){

        try {

            ReceivedDataToViewEvent ev = (ReceivedDataToViewEvent) event;

            if (ev.strategyDataVO.nameAlgo.equals(NameStrategyVO.ADR_ARBITRAGE_XSGO)) {

                algo = Repository.strategy.get(NameStrategyVO.ADR_ARBITRAGE_XSGO);

                algo.dolarMasterList.addAll(ev.strategyDataVO.dolarMasterListArray);
                algo.mkd_dolar_tableView.setItems(algo.dolarMasterList);

                algo.mkdAdrMasterList.addAll(ev.strategyDataVO.mkdAdrMasterListArray);
                algo.mkd_adr_tableView.setItems(algo.mkdAdrMasterList);

                algo.mkdLocalMasterList.addAll(ev.strategyDataVO.mkdLocalMasterListArray);
                algo.mkd_local_tableView.setItems(algo.mkdLocalMasterList);

                algo.routingAdrMasterList.addAll(ev.strategyDataVO.routingAdrMasterListArray);
                algo.routing_adr_tableView.setItems(algo.routingAdrMasterList);

                algo.routingLocalMasterList.addAll(ev.strategyDataVO.routingLocalMasterListArray);
                algo.routing_local_tableView.setItems(algo.routingLocalMasterList);

                /*
                for (Map.Entry<String, ModelPositions> e: algo.getPositionsMasterListHash().entrySet()) {

                    try {

                        if (algo.getPositionsMasterListHash().containsKey(e.getKey())) {

                            if (e.getKey().equals(Helper.adrToLocal(ev.modelRoutingData.symbol))) {
                                algo.getPositionsMasterList().remove(algo.getPositionsMasterListHash().get(e.getKey()));
                                algo.getPositionsMasterList().add(algo.getPositionsMasterListHash().get(e.getKey()));
                                algo.getPanel_positions_tableView().setItems(algo.getPositionsMasterList());
                            }
                        }

                    } catch (Exception ex) {
                        Helper.exception(ex);
                    }
                }

                algo.positionsMasterListArray.add(algo.getPositionsMasterListHash().get(e.getKey()));
                algo.getPanel_positions_tableView().setItems(algo.getPositionsMasterList());
                */

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
