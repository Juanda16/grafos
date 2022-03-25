package domain.view;

import java.util.Scanner;

import domain.controller.MainController;
import domain.model.Grafo;
import domain.view.constants.MainConstants;

public class Index {
    static Scanner read = new Scanner(System.in);
    
    public static void mainScreen(Grafo adyacencia) {
        System.out.println(MainConstants.SUBTITLE);
        for (String author : MainConstants.AUTHORS)
            System.out.print(author);
        
        char select;
        do {
            for (String option : MainConstants.MAIN_MENU_OPTIONS) {
                System.out.println(option);
            }

            select = read.next().charAt(0);
            MainController.index(select, adyacencia);

        } while (select != '.');
    }
}
