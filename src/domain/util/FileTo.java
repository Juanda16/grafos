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

            MatrizTripletas matrizTripletas = new MatrizTripletas(200, 200);

            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            int rawController = 0;

            while (null != line) {

                String[] fields = line.split(SEPARATOR);
                // fields = removeTrailingQuotes(fields);
                fields[0] = fields[0].replaceAll("@", "");
                for (int columnController = 0; columnController < fields.length; columnController++) {
                    matrizTripletas.setCelda(rawController, columnController,
                            Double.parseDouble(fields[columnController]));

                }

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
