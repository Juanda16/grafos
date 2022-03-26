package domain.view;

import domain.model.Grafo;
import domain.view.constants.StationGroupsConstants;

public class StationGroupsView {

    public static void index(Grafo adyacencia) {
        System.out.print(StationGroupsConstants.TITLE);
        System.out.println(StationGroupsConstants.SUBTITLE);
        System.out.println(StationGroupsConstants.RESULT);
        try {
            System.out.println(adyacencia.hayAislados().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
