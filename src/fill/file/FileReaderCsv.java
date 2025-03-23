package fill.file;

import collection.CustomArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileReaderCsv {

    CustomArrayList<String[]> data;

    public CustomArrayList<String[]> getData() {
        return data;
    }

    public CustomArrayList<String[]> readFile(String path) throws IOException {
        data = new CustomArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("Cp866")))) {
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("Пустой файл!");
                return data;
            }
            else {
                while (line != null) {
                    String[] values = line.split(";");
                    data.add(values);
                    line = br.readLine();
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            return data;
        }
        return data;
    }
}
