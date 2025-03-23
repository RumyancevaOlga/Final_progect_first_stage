package fill;

import collection.CustomArrayList;

import java.util.Scanner;

public class InputService {
    public <T> CustomArrayList<T> inputMultiple(InputHandler<T> handler, int count) {
        CustomArrayList<T> list = new CustomArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            System.out.println("Элемент №" + (i + 1));
            T item = handler.input();
            list.add(item);
        }

        return list;
    }
}
