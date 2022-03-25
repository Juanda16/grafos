package domain.controller;

import domain.model.Grafo;
import domain.view.IsolatedStationsView;

public class IsolatedStationsController {

    public static void index(Grafo adyacencia) {
        IsolatedStationsView.index(adyacencia);
    }    
}
