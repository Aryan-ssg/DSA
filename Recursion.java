

public class Recursion{
    public static void main(String[] args) {
    //    reverseString("abcd", 4);
    firstAndLastOcc("bbcabcaba", -1, -1, 0, 'a');

    }

    public static void reverseString(String str,int n){

        if(n==0){
            System.out.println();
            return;
        }

        System.out.print(str.charAt(n-1));
        reverseString(str,n-1);
    }


    public static void firstAndLastOcc(String str,int firstind,int lastind,int n,char element){

        if(n==str.length()){
            System.out.println("Index of first occurence : "+firstind);
            System.out.println("Index of last occurence : "+lastind);
            return;
        }
        if(str.charAt(n)==element && firstind==-1){
            firstind=n;
        }
        if(str.charAt(n)==element){
            lastind=n;
        }
        firstAndLastOcc(str, firstind, lastind, n+1, element);
        
    }
}