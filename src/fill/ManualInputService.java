package fill;

import collection.CustomArrayList;

import java.util.Scanner;

public class ManualInputService {
    public static <T> CustomArrayList<T> inputMultiple(InputHandler<T> handler) {
        CustomArrayList<T> list = new CustomArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько элементов хотите ввести? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Элемент #" + (i + 1));
            T item = handler.input();
            list.add(item);
        }

        return list;
    }
}
