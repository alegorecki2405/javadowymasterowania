package olek.gorecki;

import java.util.*;
import java.util.stream.IntStream;

public class FindTheOddInteger {
    public static int findOdd(int[] array) {
        int[] numbers = IntStream.of(array).distinct().toArray();
        for (int number : numbers) {
            int licznik = 0;
            for (int i : array) {
                if (number == i) {
                    licznik += 1;
                }
            }
            if (licznik % 2 != 0) {
                return number;
            }
        }
        return -1;
    }
}
