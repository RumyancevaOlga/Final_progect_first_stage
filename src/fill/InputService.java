package fill;

import collection.CustomArrayList;

public class InputService {
    public <T> CustomArrayList<T> inputMultiple(InputHandler<T> handler, int count) {
        CustomArrayList<T> list = new CustomArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + " элемент:");
            T item = handler.input();
            list.add(item);
        }

        return list;
    }
}
