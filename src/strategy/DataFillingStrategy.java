package strategy;


import collection.CustomArrayList;

public interface DataFillingStrategy<T> {
    CustomArrayList<T> fillData(int size);
}
