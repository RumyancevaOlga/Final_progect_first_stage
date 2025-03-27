package strategy;


import collection.CustomArrayList;

public interface DataFillingStrategy<T> {
    //Метод fillData должен быть реализован в классах, которые используют этот интерфейс
    //int size — количество элементов, которые нужно заполнить.
    //CustomArrayList<T> — список объектов типа T (например, автобусы, студенты и т. д.).
    CustomArrayList<T> fillData(int size);
}
