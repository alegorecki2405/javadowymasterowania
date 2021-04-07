package olek.gorecki;

public class BuildingUpAWord {
    public static boolean canBuild(String[] array) {
        for(int i=0;i< array.length-1;i++) {
            String str1 = array[i];
            String str2 = array[i+1].substring(0, array[i+1].length()-1);
            String str3 = array[i+1].substring(1);
            if (!str1.equals(str2) && !str1.equals(str3)) {
                return false;
            }
        }
        return true;
    }
}
