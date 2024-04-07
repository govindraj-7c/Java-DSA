import java.util.Scanner;

public class AscendingOrder {
    private void heapify(int idx, int[] arr, int size){
        int leftChild = 2*idx+1;
        int rightChild = 2*idx+2;
        int maxIdx = idx;

        if(leftChild < size && arr[leftChild] > arr[maxIdx]){
            maxIdx = leftChild;
        }

        if(rightChild < size && arr[rightChild] > arr[maxIdx]){
            maxIdx = rightChild;
        }

        if(maxIdx != idx){
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[idx];
            arr[idx] = temp;

            heapify(maxIdx, arr, size);
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
        AscendingOrder as = new AscendingOrder();
        System.out.println("Enter Size of Array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter Array Elements:");
        for (int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        as.heapSort(arr,size);
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
