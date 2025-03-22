package fill.file;

import collection.CustomArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderCsv {

    CustomArrayList<String[]> data;

    public CustomArrayList<String[]> getData() {
        return data;
    }

    public CustomArrayList readFile(String path, int size) throws IOException {
        data = new CustomArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("Пустой файл!");
                return null;
            }
            else if ((line = br.readLine()) != null) {
                for (int i = 0; i < size ; i++) {
                    if (line != null) {
                        String[] values = line.split(";");
                        data.add(values);
                    }
                    line = br.readLine();
                }
            }
            if (data.size() < size) {
                System.out.printf("В файле мало данных. Количество строк: %d\n", data.size());
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            return null;
        }
        return data;
    }
}
