package strategy;


import collection.CustomArrayList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class FileFillingStrategy<T> implements DataFillingStrategy<T> {
    private final String filePath; //Хранит путь к файлу, откуда будут загружаться данные.
    //Функция-преобразователь, которая берет массив строк из файла и создаёт объект типа T
    private final Function<String[], T> mapper;

    //Конструктор
    public FileFillingStrategy(String filePath, Function<String[], T> mapper) {
        this.filePath = filePath;
        this.mapper = mapper;
    }

    @Override
    public CustomArrayList<T> fillData(int size) {
        //Создаём пустой список result, куда будем добавлять загруженные объекты.
        CustomArrayList<T> result = new CustomArrayList<>();
        try {
            //считываем все строки из файла в список List<String> lines.
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            //Перебираем строки, но не больше, чем size (запрашиваемый размер списка).
            //Если в файле меньше строк, чем size, читаем только доступные.
            for (int i = 0; i < Math.min(size, lines.size()); i++) {
                String[] parts = lines.get(i).split(";"); //Разделяем строку на части
                //Преобразуем parts в объект T с помощью mapper.apply(parts)
                //mapper.apply(parts) создаёт объект нужного типа (например, Bus).
                T mappedObject = mapper.apply(parts);
                //Проверяем if (mappedObject != null), чтобы избежать NullPointerException.
                if (mappedObject != null) {
                    //Добавляем объект в result
                    result.add(mapper.apply(parts));
                }
            }
            //Если произошла ошибка (IOException или InvalidPathException), выводим сообщение
        } catch (IOException | InvalidPathException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return result;
    }

}
