package strategy;

import collection.CustomArrayList;

import java.util.function.Supplier;

public class ManualFillingStrategy<T> implements DataFillingStrategy<T> {
    private final Supplier<T> inputSupplier;

    public ManualFillingStrategy(Supplier<T> inputSupplier) {
        this.inputSupplier = inputSupplier;
    }

    @Override
    public CustomArrayList<T> fillData(int size) {
        CustomArrayList<T> result = new CustomArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Ввод элемента " + (i + 1) + ":");
            result.add(inputSupplier.get());
        }
        return result;
    }

}