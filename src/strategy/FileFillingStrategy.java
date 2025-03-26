package strategy;


import collection.CustomArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class FileFillingStrategy<T> implements DataFillingStrategy<T> {
    private final String filePath;
    private final Function<String[], T> mapper;

    public FileFillingStrategy(String filePath, Function<String[], T> mapper) {
        this.filePath = filePath;
        this.mapper = mapper;
    }

    @Override
    public CustomArrayList<T> fillData(int size) {
        CustomArrayList<T> result = new CustomArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < Math.min(size, lines.size()); i++) {
                String[] parts = lines.get(i).split(";");
                T mappedObject = mapper.apply(parts);
                if (mappedObject != null) {
                result.add(mapper.apply(parts));
                }
            }
            if (lines.size() < size) System.out.printf("В файле недостаточно данных. Размер массива будет " +
                    "меньше ожидаемого: %d", lines.size());
        } catch (IOException | InvalidPathException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return result;
    }

}
