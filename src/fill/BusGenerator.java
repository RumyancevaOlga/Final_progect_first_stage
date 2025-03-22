package fill;

import collection.CustomArrayList;
import model.Bus;

import java.util.Random;

public class BusGenerator {
    private static final Random RANDOM = new Random();
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
    public static Bus randomBus() {
        int number = RANDOM.nextInt(1,1000); // Случайный номер от 1 до 999
        String model = MODELS[RANDOM.nextInt(MODELS.length)]; // Случайная модель из списка
        int mileage = RANDOM.nextInt(1000000); // Случайный пробег от 0 до 999999
        return new Bus.Builder()
                .number(number)
                .model(model)
                .mileage(mileage)
                .build();
    }

//    пример использования:
    public static void main(String[] args) {
        CustomArrayList<Bus> buses = new CustomArrayList<>();

        for (int i = 0; i < 10; i++) {
            buses.add(randomBus());
        }
        System.out.println(buses);
    }
}
