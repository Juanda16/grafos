package domain.controller;

import domain.model.Grafo;
import domain.view.BestPathView;

public class BestPathController {

    public static void index(Grafo adyacencia) {
        BestPathView.index(adyacencia);
    }
    
}
