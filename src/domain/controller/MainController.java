package domain.controller;

import domain.model.Grafo;

public class MainController {

    public static void index(char select, Grafo adyacencia) {
        switch (select) {
            case '1': BestPathController.index(adyacencia);                    
                break;
            case '2': BestTimeController.index(adyacencia);
                 break;
             case '3': DisconnectedStationsController.index(adyacencia);
                 break;
            case '4': StationGroupsController.index(adyacencia);
                break;
            case '.':
                break;
            default:
                System.out.println("Ingrese un número válido");
        }
    }    
}
