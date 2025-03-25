package algorithms;

import collection.CustomArrayList;
import model.Student;

import java.util.Comparator;
import java.util.Random;
import java.util.function.ToIntFunction;

public class CustomSort {
    public static <T> void customSort(
            CustomArrayList<T> list,
            Comparator<? super T> comparator,
            ToIntFunction<T> fieldExtractor) {

        int n = list.size();
        // Создаем массив для отметки нечетных элементов
        boolean[] isOdd = new boolean[n];
        // Заполняем массив isOdd
        for (int i = 0; i < n; i++) {
            isOdd[i] = fieldExtractor.applyAsInt(list.get(i)) % 2 != 0;
        }

        for (int i = 0; i < n - 1; i++) {
            // Пропускаем нечетные элементы
            if (isOdd[i]) {
                continue;
            }

            int minIndex = i;

            // Ищем минимальный четный элемент в оставшейся части
            for (int j = i + 1; j < n; j++) {
                if (!isOdd[j] &&
                        comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // Меняем местами только четные элементы
            if (minIndex != i) {
                T temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }
//  Пример:
//    public static void main(String[] args) {
//        final Random RANDOM = new Random();
//        CustomArrayList<Student> studentList = new CustomArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            int groupNumber = RANDOM.nextInt(1,100);
//            double averageGrade = RANDOM.nextDouble(2,5);
//            averageGrade = Math.round(averageGrade * 10) / 10.0;
//            int recordBookNumber = RANDOM.nextInt(1000, 10000);
//            Student stu = new Student.Builder()
//                    .groupNumber(groupNumber)
//                    .averageGrade(averageGrade)
//                    .recordBookNumber(recordBookNumber)
//                    .build();
//            studentList.add(stu);
//            System.out.println(stu);
//        }
//        customSort(
//                studentList,
//                Comparator.comparingInt(Student::getGroupNumber),
//                Student::getGroupNumber
//        );
//        System.out.println("Sorted studentList: ");
//        for (int i = 0; i < studentList.size(); i++) {
//            System.out.println(studentList.get(i));
//        }
//    }
}
