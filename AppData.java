package lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String [] header;
    private Integer [][] data;
    private String tmp = "";

    public AppData() throws IOException {
    }

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

    private String dataToString(Integer[] data) {
        tmp = "";
        for (int i = 0; i < data.length; i++) {
            tmp = tmp + data[i].toString();
            if (i != data.length - 1) {
                tmp += ";";
            }
        }
        tmp += "\n";
        return tmp;
    }

    private String headerToString(String[] header) {
        for (int i = 0; i < header.length; i++) {
            tmp = tmp + header[i];
            if (i != header.length - 1) {
                tmp += ";";
            }
        }
        tmp += "\n";
        return tmp;
    }

    private Integer[] stringToData(String str) {
        String[] stringData = str.split(";");

        Integer[] intData = new Integer[stringData.length];
        for (int i = 0; i < stringData.length; i++) {
            intData[i] = Integer.parseInt(stringData[i]);
        }
        return intData;
    }

    public void saveFile(String filename) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(headerToString(header));
           for (Integer[] tmp : data) {
               writer.write(dataToString(tmp));
           }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFile(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> intData = new ArrayList<>();
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                intData.add(stringToData(tmp));
            }
            data = intData.toArray(new Integer[][]{{}});
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


@Override
    public String toString() {
        return "DataCSV" + "\n" +
                "header=" + Arrays.toString(header) + "\n" +
                "data=" + Arrays.deepToString(data);
    }
}
