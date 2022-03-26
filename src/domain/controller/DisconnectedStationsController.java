package domain.controller;

import domain.model.Grafo;
import domain.view.DisconnectedStationsView;

public class DisconnectedStationsController {

    public static void index(Grafo adyacencia) {
        DisconnectedStationsView.index(adyacencia);
    }    
}
