package olek.gorecki;

import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] array) {
        int [] x = new int[array.length];
        for(int i=0;i<array.length;i++) {
            x[array.length-1-i] = array[i];
        }
        System.out.println("Array = "+Arrays.toString(array));
        System.out.println("Reversed array = "+Arrays.toString(x));
    }
}
