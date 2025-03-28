package record;

import collection.CustomArrayList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class FileRecordAdd {
    public void record(Scanner scanner, CustomArrayList customArrayList, int searchElem) throws IOException {
        boolean flag = true;
        while (flag) {
            try {
                System.out.print("Введите путь к файлу: ");
                Path path = Path.of(scanner.nextLine());
                // берем текущую дату
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy", Locale.UK);
                String str = now.format(formatter) + "\n";
                byte[] strToByte = str.getBytes();
                // дозаписываем в существующий файл дату
                Files.write(path, strToByte, StandardOpenOption.APPEND);
                // в цикле записываем элементы списка
                for (int i = 0; i < customArrayList.size(); i++) {
                    str = customArrayList.get(i).toString() + "\n";
                    strToByte = str.getBytes();
                    Files.write(path, strToByte, StandardOpenOption.APPEND);
                }
                // записываем результат поиска
                str = "Looking  for the item is found in the position: " + searchElem + "\n";
                strToByte = str.getBytes();
                Files.write(path, strToByte, StandardOpenOption.APPEND);
                System.out.println("Запись успешно выполнена!");
                flag = false;

            } catch (IOException | InvalidPathException e) {
                System.out.println("Ошибка записи в файл: " + e.getMessage());
            }
        }
    }
}
