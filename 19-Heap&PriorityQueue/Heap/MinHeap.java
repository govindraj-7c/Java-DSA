package Heap;

import java.util.ArrayList;

public class MinHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int val){
            arr.add(val);
            int idxV = arr.size()-1;  //Index Of Inserted Element...
            int idxPar = (idxV - 1)/2; // parent Index...

            while(arr.get(idxV) < arr.get(idxPar)){
                int temp = arr.get(idxV);
                arr.set(idxV, arr.get(idxPar));
                arr.set(idxPar, temp);

                idxV = idxPar;
                idxPar = (idxV-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int idx){
            int leftChild = 2*idx+1;
            int rightChild = 2*idx+2;
            int minIdx = idx;

            if(leftChild < arr.size() && arr.get(minIdx) > arr.get(leftChild)){
                minIdx = leftChild;
            }

            if(rightChild < arr.size() && arr.get(minIdx) > arr.get(rightChild)){
                minIdx = rightChild;
            }

            if(minIdx != idx){
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove(){
            int data = arr.get(0);

            //Swap first Element with last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //Delete Last Element
            arr.remove(arr.size()-1);

            //Call Heapify Function to balance the Heap
            heapify(0);

            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);
//        heap.add(10);

        while (!heap.isEmpty()){
            System.out.print(heap.peek()+" ");
            heap.remove();
        }
    }
}
