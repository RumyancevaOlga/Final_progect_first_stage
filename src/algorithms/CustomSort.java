package algorithms;

import collection.CustomArrayList;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class CustomSort {
    public static <T> void customSort(
            CustomArrayList<T> list,
            Comparator<? super T> comparator,
            ToIntFunction<T> fieldExtractor) {

        int n = list.size();
        // Создаем массив для отметки нечетных элементов
        boolean[] isOdd = new boolean[n];
        // Заполняем массив isOdd
        for (int i = 0; i < n; i++) {
            isOdd[i] = fieldExtractor.applyAsInt(list.get(i)) % 2 != 0;
        }

        for (int i = 0; i < n - 1; i++) {
            // Пропускаем нечетные элементы
            if (isOdd[i]) {
                continue;
            }

            int minIndex = i;

            // Ищем минимальный четный элемент в оставшейся части
            for (int j = i + 1; j < n; j++) {
                if (!isOdd[j] &&
                        comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // Меняем местами только четные элементы
            if (minIndex != i) {
                T temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }
}
