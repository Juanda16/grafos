package domain.util;

import java.io.*;
import java.util.Stack;

import domain.MatrizTripletas;

public class FileTo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";
    public static final String COLON_SEPARATOR = ":";

    /**
     * @param filePath
     * @return MatrizEnTripleta
     * @throws IOException
     */

    public static MatrizTripletas matrizTripletas(String filePath) throws IOException {

        BufferedReader br = null;

        try {

            MatrizTripletas matrizTripletas = new MatrizTripletas(9, 9);

            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            int rowController = 1;

            while (null != line) {

                String[] fields = line.split(SEPARATOR);
                // fields = removeTrailingQuotes(fields);
                fields[0] = fields[0].replaceAll("@", "");
                for (int columnController = 1; columnController <= fields.length; columnController++) {
                    matrizTripletas.setCelda(rowController, columnController,
                            Double.parseDouble(fields[columnController - 1]));

                }
                rowController++;
                line = br.readLine();
            }
            return matrizTripletas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (null != br) {
                br.close();
            }
        }
    }
}
