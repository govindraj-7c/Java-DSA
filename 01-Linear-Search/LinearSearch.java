import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Array :");
        int size = sc.nextInt();
        System.out.println("Enter "+size+" Elements:");
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter KEY value:");
        int key = sc.nextInt();
        for(int i=0; i<size; i++){
            if(arr[i] == key){
                System.out.println(key+" is present at "+(i+1)+" position.");
                break;
            }
        }
    }
}
