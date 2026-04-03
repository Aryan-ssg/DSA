import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        // reverseString("abcd", 4);
        // firstAndLastOcc("aabbcddrr", -1, -1, 0, 'c');
        // String s=moveX("asdfxxxfghjxfxg", "", 0, 0);
        // System.out.println(s);
        // int [] arr={1,1};
        // strictlySorted(arr,0);
        // int[] arr = new int[26];
        // String s = removeDuplicate("awsedrfgthbfdas", "", arr, 0);
        // System.out.println(s);
        List<String> lst=subsequences("aaa", 0, new ArrayList<String>(),"" );
        for(int i=0;i<lst.size();i++){
            System.out.println(lst.get(i));
        }
    }

    public static List<String> subsequences(String str, int n, List<String> sequences, String seq) {

        if (n == str.length()) {
            for(int i=0;i<sequences.size();i++){
                if(sequences.get(i).equals(seq)){
                    return sequences;
                }
            }
            sequences.add(seq);
            return sequences;
        }
        subsequences(str, n + 1, sequences, seq + str.charAt(n));

        subsequences(str, n + 1, sequences, seq);

        return sequences;

    }

    public static String removeDuplicate(String str, String newString, int[] arr, int n) {

        if (n == str.length()) {
            return newString;
        }

        if ((arr[((int) str.charAt(n)) - 97] == 1)) {
            return removeDuplicate(str, newString, arr, n + 1);
        } else {
            newString += str.charAt(n);
            arr[((int) str.charAt(n)) - 97] = 1;
            return removeDuplicate(str, newString, arr, n + 1);
        }

    }

    public static void reverseString(String str, int n) {

        if (n == 0) {
            System.out.println();
            return;
        }

        System.out.print(str.charAt(n - 1));
        reverseString(str, n - 1);
    }

    public static void firstAndLastOcc(String str, int firstind, int lastind, int n, char element) {

        if (n == str.length()) {
            System.out.println("Index of first occurence : " + firstind);
            System.out.println("Index of last occurence : " + lastind);
            return;
        }
        if (str.charAt(n) == element && firstind == -1) {
            firstind = n;
        }
        if (str.charAt(n) == element) {
            lastind = n;
        }
        firstAndLastOcc(str, firstind, lastind, n + 1, element);

    }

    public static void strictlySorted(int[] arr, int n) {
        if (n == arr.length - 1) {
            System.out.println("Strictly sorted");
            return;
        }
        if (arr[n] >= arr[n + 1]) {
            System.out.println("Not Strictly sorted");
            return;
        }
        strictlySorted(arr, n + 1);
    }

    public static String moveX(String s, String newString, int n, int count) {

        if (n == s.length()) {
            for (int i = 0; i < count; i++) {
                newString += 'x';
            }
            return newString;
        }
        if (s.charAt(n) == 'x') {
            count++;
        } else {
            newString += s.charAt(n);
        }
        return moveX(s, newString, n + 1, count);

    }
}