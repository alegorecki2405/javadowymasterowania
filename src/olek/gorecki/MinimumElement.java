package olek.gorecki;

import java.lang.reflect.Array;
import java.util.Scanner;

public class MinimumElement {
    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        return x;
    }

    private static int[] readElements(int x) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[x];
        for(int i = 0;i<x;i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for(int i = 1;i<array.length;i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
