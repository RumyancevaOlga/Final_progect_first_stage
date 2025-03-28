package strategy;

import collection.CustomArrayList;
import fill.InputHandler;

public class ManualFillingStrategy<T> implements DataFillingStrategy<T> {
    //inputHandler — это объект, реализующий интерфейс InputHandler<T>,
    //  который конкретно обрабатывает ввод пользователя и создает объекты T.
    private final InputHandler<T> inputHandler;

//Конструктор
    public ManualFillingStrategy(InputHandler<T> inputHandler) {
        this.inputHandler = inputHandler;
    }
//Переопределение метода fillData из интерфейса DataFillingStrategy<T>.
    //Создаёт список объектов T и заполняет его, запрашивая ввод size раз.
    @Override
    public CustomArrayList<T> fillData(int size) {
        //Создаётся новый экземпляр CustomArrayList<T>, в который будем добавлять введённые данные.
        CustomArrayList<T> result = new CustomArrayList<>();
        //В цикле повторяем ввод size раз (то есть запрашивает size объектов T).
        for (int i = 0; i < size; i++) {
            //Уведомляет пользователя о том, какой по счёту элемент он вводит.
            System.out.println("Ввод элемента " + (i + 1) + ":");
            //Добавляем новый объект в список
            result.add(inputHandler.input());
        }
        return result;
    }
}