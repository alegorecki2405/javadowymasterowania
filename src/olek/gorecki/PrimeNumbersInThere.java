package olek.gorecki;

public class PrimeNumbersInThere {
    public int primeNumbers(int num) {
        int licznik = 0;
        for(int i = 2;i<num;i++) {
            if(isPrime(i)){
                licznik+=1;
            }
        }
        return licznik;
    }

    public boolean isPrime(int x) {
        for(int i = 2;i<x;i++) {
            if(x%i==0) {
                return false;
            }
        }
        return true;
    }
}
