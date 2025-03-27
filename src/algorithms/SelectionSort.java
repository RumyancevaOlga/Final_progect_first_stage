package algorithms;

import collection.CustomArrayList;

public class SelectionSort {
    // Сортировка выбором
    //Алгоритм работает за O(n²) и находит минимальный элемент на каждой итерации,
    // затем меняет его местами с текущим элементом.
    //<T extends Comparable<T>>) — принимает элементы типа T, которые могут сравниваться
    //CustomArrayList<T> — список, который нужно отсортировать.
    public static <T extends Comparable<T>> void selectionSort(CustomArrayList<T> list) {
        //Получаем размер списка n, чтобы знать, сколько элементов нужно обработать.
        int n = list.size();
        //Внешний цикл: идём по всем элементам, кроме последнего
        //На каждой итерации ищем минимальный элемент в оставшейся части списка.
        for (int i = 0; i < n - 1; i++) {
            //Сохраняем индекс минимального элемента, который сначала считаем текущим i.
            int minIndex = i;
            //Перебираем оставшиеся элементы
            //Ищем минимальный элемент в правой части списка.
            for (int j = i + 1; j < n; j++) {
                //Сравниваем текущий элемент (list.get(j)) с list.get(minIndex).
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    //Если list.get(j) меньше текущего minIndex, значит, нашли новый минимум.
                    //Обновляем индекс минимального элемента, если нашли новый минимум.
                    minIndex = j;
                }
            }
            // Меняем элементы местами
            //Сохраняем минимальный элемент во временную переменную temp.
            T temp = list.get(minIndex);
            //Заменяем минимальный элемент значением из текущей позиции i.
            list.set(minIndex, list.get(i));
            //Перемещаем минимальный элемент на текущую позицию i.
            list.set(i, temp);
        }
    }
}


