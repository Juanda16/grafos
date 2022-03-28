package domain.view;

import domain.model.Grafo;
import domain.model.MatrizTripletas;
import domain.model.Tripleta;
import domain.util.FileTo;
import domain.view.constants.DisconnectedStationsConstants;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DisconnectedStationsView {

    public static void index(Grafo adyacencia) {
        System.out.print(DisconnectedStationsConstants.TITLE);
        System.out.println(DisconnectedStationsConstants.SUBTITLE);

        try {
            leeArchivo(FileTo.direccion);
            System.out.println(DisconnectedStationsConstants.RESULT);
            algoritmoDeWarshall(pasarDeArrayAMatrizAdya());
            
        } catch (IOException ex) {
            Logger.getLogger(DisconnectedStationsView.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Método para mostrar las bases incomunicadas.
        
        
    }

    static void algoritmoDeWarshall(int[][] adya) {
        int n = adya.length - 1;
        int[][] adyaMas = new int[adya.length][adya.length];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                adyaMas[i][j] = adya[i][j];
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (adyaMas[i][k] == 1 && adyaMas[k][j] == 1 && i != j) {
                        adyaMas[i][j] = 1;
                    }
                }
            }
        }
        ArrayList<Integer> vectorDeFilas = new ArrayList<>();
        ArrayList<Integer> noSePuede = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                vectorDeFilas.add(adyaMas[i][j]);
            }
            if (vectorDeFilas.contains(1) == false) {
                noSePuede.add(i);
            }
            vectorDeFilas.clear();
        }
        if (!noSePuede.isEmpty()) {
            System.out.println("No se pueden enviar ningun mensaje desde la base \n" + noSePuede);
        } else {
            System.out.println("Se pueden enviar mensajes desde cualquier base ");
        }
    }

    static BufferedReader lector;
    static String linea;
    static String[] partes = null;
    static ArrayList<String> arrayPartes=new ArrayList<>();

    static void leeArchivo(String nombreArchivo) throws FileNotFoundException, IOException {

        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(";");
                añadirAlArray(partes);
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void añadirAlArray(String[] partes) {
        for (int i = 0; i < partes.length; i++) {
            arrayPartes.add(partes[i]);
        }
    }

    static int[][] pasarDeArrayAMatrizAdya() {
        int tamañoT = (int) Math.sqrt(arrayPartes.size());
        int[][] datosT = new int[tamañoT + 1][tamañoT + 1];
        int[][] adyaT = new int[tamañoT + 1][tamañoT + 1];
       
        for (int i = 1; i < tamañoT + 1; i++) {          // AQUI PASO LOS DATOS QUE ESTABAN EN EL ARRAY A LA MATRIZ
            for (int j = 1; j < tamañoT + 1; j++) {      //ME QUEDAN ORDENADOS POR FILA Y COLUMNA IGUAL QUE LOS DATOS
                datosT[i][j] = Integer.parseInt(arrayPartes.get(0));     //ORIGINALES
                arrayPartes.remove(0);
                if (datosT[i][j] != 0) {
                    adyaT[i][j] = 1;
                } else {
                    adyaT[i][j] = 0;
                }
            }
        }
        return adyaT;
    }
}
