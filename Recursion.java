

public class Recursion{
    public static void main(String[] args) {
    //    reverseString("abcd", 4);
    firstAndLastOcc("aabbcddrr", -1, -1, 0, 'c');
    // int [] arr={1,1};
    // strictlySorted(arr,0);

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

    public static void strictlySorted(int[] arr,int n){
        if(n==arr.length-1){
            System.out.println("Strictly sorted");
            return;
        }
        if(arr[n]>=arr[n+1]){
            System.out.println("Not Strictly sorted");
            return;
        }
        strictlySorted(arr, n+1);
    }
}