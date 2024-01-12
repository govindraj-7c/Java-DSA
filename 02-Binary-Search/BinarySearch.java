import java.util.Scanner;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Array:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter Array Elements:");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter Key Value to find:");
        int key = sc.nextInt();
        if(search(arr,key) == 0){
            System.out.println("Value Not Found..");
        }else{
            System.out.println("Position : "+search(arr,key));
        }
    }
    public static int search(int[] arr, int key){
        int first = 0, last = arr.length-1;
        int mid = (first+last)/2;
        while(first <= last){
            if(arr[mid] < key){
                first = mid+1;
            } else if (arr[mid] == key) {
                return mid+1;
            } else{
                last = mid-1;
            }
            mid = (first+last)/2;
        }
        return 0;
    }
}
