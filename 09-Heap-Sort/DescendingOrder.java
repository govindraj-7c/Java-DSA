import java.util.Scanner;

public class DescendingOrder {
    private void heapify(int idx, int[] arr, int size){
        int leftChild = 2*idx+1;
        int rightChild = 2*idx+2;
        int minIdx = idx;

        if(leftChild < size && arr[leftChild] < arr[minIdx]){
            minIdx = leftChild;
        }

        if(rightChild < size && arr[rightChild] < arr[minIdx]){
            minIdx = rightChild;
        }

        if(minIdx != idx){
            int temp = arr[minIdx];
            arr[minIdx] = arr[idx];
            arr[idx] = temp;

            heapify(minIdx, arr, size);
        }
    }
    public void heapSort(int[] arr, int n){
        for(int i=n/2; i>=0; i--){
            heapify(i, arr, n);
        }

        for(int i = n-1; i>0; i--){
            //Swap Elements..
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0,arr,i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DescendingOrder ds = new DescendingOrder();
        System.out.println("Enter Size of Array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter Array Elements:");
        for (int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        ds.heapSort(arr,size);
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
