package domain.view;

import java.util.Scanner;

import domain.model.Grafo;
import domain.view.constants.BestPathConstants;

public class BestPathView {
    static Scanner read = new Scanner(System.in);

    public static void index(Grafo adyacencia) {
        System.out.print(BestPathConstants.TITLE);
        char response;
        do {
            System.out.println(BestPathConstants.SUBTITLE);
            String baseA = read.nextLine();
            if (baseA.equals("0"))
                break; 
            System.out.println(BestPathConstants.NOTES);
            String baseB = read.nextLine();
            System.out.println(BestPathConstants.RESULT);            
            int baseAint = Integer.parseInt(baseA);
            int baseBint = Integer.parseInt(baseB);
            adyacencia.mejorCamino(baseAint, baseBint);
            do {
                System.out.print(BestPathConstants.QUESTION);
                response = read.next().charAt(0);
                read.nextLine();
            } while (response != 'y' && response != 'n');
        } while (response == 'y');   
    }    
}
