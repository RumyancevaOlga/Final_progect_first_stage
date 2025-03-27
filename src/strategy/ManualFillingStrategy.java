package strategy;

import collection.CustomArrayList;

import java.util.function.Supplier;

public class ManualFillingStrategy<T> implements DataFillingStrategy<T> {
    // inputSupplier хранит функцию, которая создаёт объект T
    //Supplier<T> inputSupplier — это функциональный интерфейс, который не принимает аргументов, но возвращает объект
    private final Supplier<T> inputSupplier;

    //Конструктор, принимает inputSupplier — функцию, которая генерирует объекты T на основе ввода пользователя.
    public ManualFillingStrategy(Supplier<T> inputSupplier) {
        //Сохраняет inputSupplier в поле класса для дальнейшего использования.
        this.inputSupplier = inputSupplier;
    }

    @Override
    public CustomArrayList<T> fillData(int size) {
        //Создаём пустой список result, куда будем добавлять введённые объекты.
        CustomArrayList<T> result = new CustomArrayList<>();
        //Цикл Запрашивает ввод size раз.
        for (int i = 0; i < size; i++) {
            System.out.println("Ввод элемента " + (i + 1) + ":");
            //inputSupplier.get() запрашивает данные у пользователя и создаёт объект T
            result.add(inputSupplier.get());
        }
        return result;
    }

}