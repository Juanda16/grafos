package domain.controller;

import domain.model.Grafo;
import domain.view.BestTimeView;

public class BestTimeController {

    public static void index(Grafo adyacencia) {
        BestTimeView.index(adyacencia);
    }
    
}
