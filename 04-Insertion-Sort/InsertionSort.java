import java.util.Scanner;
public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size Of Array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter Array Elements:");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        insertion(arr);
    }
    public static void insertion(int[] arr){
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int pos = i;
            while(pos > 0 && arr[pos-1] > key){
                arr[pos] = arr[pos-1];
                --pos;
            }
            arr[pos] = key;
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
