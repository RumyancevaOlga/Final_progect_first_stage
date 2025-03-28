package fill.generator;

import fill.InputHandler;
import model.Bus;

import java.util.Random;

public class BusGeneratorInputHandler implements InputHandler<Bus> {
    // Создаём объект класса "Random" для извлечения случайного значения из выбранного диапазона
    private static final Random RANDOM = new Random();
    // Создаём диапазон моделей автобусов
    private static final String[] MODELS = {
            "ANKAI", "AYATS", "BAW", "DAEWOO", "FOTON", "GOLDEN DRAGON",
            "HIGER", "HYUNDAI", "IRISBUS", "ISUZU", "IVECO", "IVECO-AMT",
            "JAC", "KIA", "KING LONG", "LOTOS", "MERCEDES", "NEOPLAN",
            "OTOKAR", "SCANIA", "SETRA", "SEVEREST", "SOLARIS", "SUNLONG",
            "TEMSA", "TOYOTA", "TROLIGA", "VAN HOOL", "VDL", "VOLGABUS",
            "VOLVO", "YUTONG", "ZHONGTONG", "ZONDA", "АВТО-ПРОФИ", "БЕЛКОММУНМАШ",
            "БОГДАН", "ВОЛЖАНИН", "ГАЗ", "ГОЛАЗ", "ЗИЛ", "КАВЗ",
            "КАМАЗ", "КРОНА", "ЛАЗ", "ЛИАЗ", "МАЗ", "МАЗ-КУПАВА",
            "МАРЗ", "НЕМАН", "НЕФАЗ", "ОЛИМП", "ПАЗ", "ПРОМАВТО",
            "РОАЗ", "СИБИРЬ ТРЕЙЛЕР", "СПЕЦТЕХПРОМ", "УРАЛ", "УРАЛ-КУПАВА"};

    @Override
    public Bus input() { // Переопределяем метод "input" интерфейса "InputHandler"
        // Вызываем метод "nextInt" объекта класса "Random" для получения значения типа "int" из указанного диапазона
        int number = RANDOM.nextInt(1,1000); // Случайный номер от 1 до 999
        String model = MODELS[RANDOM.nextInt(MODELS.length)]; // Случайная модель из списка
        int mileage = RANDOM.nextInt(1000000); // Случайный пробег от 0 до 999999
        return new Bus.Builder() // В итоге из полученных значений билдером собираем новый объект класса "Bus"
                .number(number)
                .model(model)
                .mileage(mileage)
                .build();
    }
}
