package domain.controller;

import domain.model.Grafo;
import domain.view.StationGroupsView;

public class StationGroupsController {

    public static void index(Grafo adyacencia) {
        StationGroupsView.index(adyacencia);
    }
    
}
