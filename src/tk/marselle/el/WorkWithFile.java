package tk.marselle.el;



import java.io.*;

public class WorkWithFile {
    private static final int COUNT_OF_MAS = 10;
    private static final String EQUAL_ERROR_MESSAGE = "-1";

    public static String firstParse(String inputFileName, String outputFileName, String subString) throws IOException {

        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        String jsonString = "{";

        if (!exist(outputFileName)) {
            outputFile.createNewFile();
        }

        if (exist(inputFileName)) {
            PrintWriter out = new PrintWriter(outputFile.getAbsoluteFile());
            BufferedReader in = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
            String line;
            int counnOfLines = 0;
            while ((line = in.readLine()) != null) {
                if (findSubString(line, subString) != -1) {
                    counnOfLines += 1;
                }
            }

            in.close();
            in = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));

            String[][] resultMas = new String[counnOfLines][COUNT_OF_MAS];
            int i;
            int k = -1;

            while ((line = in.readLine()) != null) {
                if (findSubString(line, subString) != -1) {
                    k += 1;
                    out.println(line);
                    i = 1;

                    while (!getSubString(line, " ").equals(EQUAL_ERROR_MESSAGE)) {
                        resultMas[k][i] = getSubString(line, " ");
                        line = line.substring(line.indexOf(" ") + 1);
                        i += 1;
                    }
                    while (!getSubString(line, ";").equals(EQUAL_ERROR_MESSAGE)) {
                        resultMas[k][i] = getSubString(line, ";");
                        line = line.substring(line.indexOf(";") + 1);
                        i += 1;
                    }
                    resultMas[k][i] = line;
                    resultMas[k][0] = String.valueOf(k);
                }

            }


            out.close();
            in.close();

            //create JSON



            for (i = 0; i < resultMas.length; i++) {
                jsonString += "\"" + String.valueOf(i) + "\": { \"date\": \"" + resultMas[i][1] + "" +
                        "\",\"time\": \"" + resultMas[i][2] + "\"," + "" +
                        "\"ip\": \"" + resultMas[i][3] + "\"," + "" +
                        "\"manager\": \"" + resultMas[i][5] + "\"," + "" +
                        "\"driver\": \"" + resultMas[i][7] + "\"," + "" +
                        "\"order\": \"" + resultMas[i][8] + "\"}" + "" +
                        "";
                if ((i == resultMas.length-1)) {
                    jsonString += "}";
                } else {
                    jsonString += ",";
                }
            }


        } else {
            System.out.println("Error");
        }
        return jsonString;
    }

    private static boolean exist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    private static int findSubString(String line, String subString) {
        return line.indexOf(subString);
    }

    private static String getSubString(String line, String subString) {
        if (line.contains(subString)) {
            return line.substring(0, line.indexOf(subString));
        } else {
            return "-1";
        }

    }
}
