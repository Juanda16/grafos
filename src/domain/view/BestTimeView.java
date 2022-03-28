package domain.view;

import java.util.Scanner;

import domain.model.Grafo;
import domain.view.constants.BestTimeConstants;

public class BestTimeView {
    static Scanner read = new Scanner(System.in);

    public static void index(Grafo adyacencia) {
        System.out.print(BestTimeConstants.TITLE);
        char response;
        do {
            System.out.println(BestTimeConstants.SUBTITLE);
            String baseA = read.nextLine();
            if (baseA.equals("0"))
                break;
            System.out.println(BestTimeConstants.NOTES);
            String baseB = read.nextLine();
            System.out.println(BestTimeConstants.RESULT);
            int baseAint = Integer.parseInt(baseA);
            int baseBint = Integer.parseInt(baseB);
            int time = adyacencia.dijkstra(baseAint, baseBint);
            if (time == -1) {
                System.out.printf("no hay un camino posible \n");
            } else {
                System.out.printf("El mejor tiempo entre %d y %d es %d\n", baseAint, baseBint, time);
            }
            do {
                System.out.print(BestTimeConstants.QUESTION);
                response = read.next().charAt(0);
                read.nextLine();
            } while (response != 'y' && response != 'n');
        } while (response == 'y');
    }
}
