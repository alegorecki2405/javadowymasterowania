package olek.gorecki;

import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int element) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[element];
        for(int i=1;i<=element;i++) {
            int x = scanner.nextInt();
            nums[i-1] = x;
        }
        return nums;
    }
    public static void printArray(int[] array) {
        int len = array.length;
        for(int i=0;i<len;i++) {
            System.out.println("Element "+i+" contents "+array[i]);
        }
    }

    public static int[] sortIntegers(int[] array){
        int len = array.length;
        for(int i=0;i<len-1;i++) {
            for(int j=i+1;j<len;j++) {
                if(array[i]<array[j]) {
                    int x = array[i];
                    int y = array[j];
                    array[i] = y;
                    array[j] = x;
                }
            }
        }
        return array;
    }

}