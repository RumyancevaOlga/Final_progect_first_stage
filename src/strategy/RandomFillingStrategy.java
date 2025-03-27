package strategy;


import collection.CustomArrayList;
import fill.InputHandler;

public class RandomFillingStrategy<T> implements DataFillingStrategy<T> {
//generator — это объект, реализующий интерфейс InputHandler<T>Б
    //в котором есть метод input(), содающий объект T
    private final InputHandler<T> generator;

    //Конструктор
    public RandomFillingStrategy(InputHandler<T> generator) {
        this.generator = generator;
    }

    @Override
    ////Переопределение метода fillData из интерфейса DataFillingStrategy<T>.
    public CustomArrayList<T> fillData(int size) {
        //Создаёт список CustomArrayList<T>, который будет заполняться случайными объектами.
        CustomArrayList<T> result = new CustomArrayList<>();
        //В цикле выполняется генерация элементов size раз
        for (int i = 0; i < size; i++) {
            //Вызывается generator.input(), который генерирует случайный объект T.
            //Полученный объект T добавляется в список result.
            result.add(generator.input());
        }
        return result;
    }
}