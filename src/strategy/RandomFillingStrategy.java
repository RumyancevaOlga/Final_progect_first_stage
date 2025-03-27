package strategy;


import collection.CustomArrayList;

import java.util.function.Supplier;

public class RandomFillingStrategy<T> implements DataFillingStrategy<T> {
    //Supplier<T> — это функция без аргументов, но возвращающая объект T
    //generator — это функциональный интерфейс Supplier<T>, который генерирует случайные объекты T.
    private final Supplier<T> generator;
//Конструктор
    public RandomFillingStrategy(Supplier<T> generator) {
        //Принимает Supplier<T> и сохраняет его в поле generator
        this.generator = generator;
    }

    @Override
    //создаем список случайных элементов размером size
    public CustomArrayList<T> fillData(int size) {
        //Создаётся пустой список CustomArrayList<T>, куда будут добавляться случайно сгенерированные объекты T.
        CustomArrayList<T> result = new CustomArrayList<>();
        //Цикл, который выполняется size раз (генерирует size случайных объектов).
        for (int i = 0; i < size; i++) {
            //generator.get() вызывает функцию, переданную в Supplier<T>, чтобы создать случайный объект T.
            //Добавляет этот объект в result.
            result.add(generator.get());
        }
        return result;
    }
}