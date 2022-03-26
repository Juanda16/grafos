package domain.view;

import domain.model.Grafo;
import domain.view.constants.DisconnectedStationsConstants;

public class DisconnectedStationsView {

    public static void index(Grafo adyacencia) {
        System.out.print(DisconnectedStationsConstants.TITLE);
        System.out.println(DisconnectedStationsConstants.SUBTITLE);

        // Método para mostrar las bases incomunicadas.

        System.out.println(DisconnectedStationsConstants.RESULT);
    }
}
