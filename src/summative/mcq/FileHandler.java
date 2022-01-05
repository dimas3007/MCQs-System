package summative.mcq;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    final private File folder = new File("src/csv");
    private File[] files = folder.listFiles();
    private String[] newFiles = new String[this.files.length];

    public void getListFiles() {
        for (int i = 0; i < this.files.length; i++) {
            if (this.files[i].isFile()) {
                this.newFiles[i] = this.files[i].getName();
            }
        }
    }

    public String[] getNewFiles() {
        return newFiles;
    }

    public List readCsvFile() {
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try {
            inputStream = new Scanner(new File("src/csv/html.csv"));
            while(inputStream.hasNext()){
                String line = inputStream.nextLine();
                String[] values = line.split(";");
                lines.add(Arrays.asList(values));
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
