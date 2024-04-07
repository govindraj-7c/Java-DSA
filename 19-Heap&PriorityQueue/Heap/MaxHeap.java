package Heap;

import java.util.ArrayList;

public class MaxHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int val){
            arr.add(val);
            int idxV = arr.size()-1;
            int idxPar = (idxV - 1)/2;

            while(arr.get(idxV) > arr.get(idxPar)){
                int temp = arr.get(idxPar);
                arr.set(idxPar, arr.get(idxV));
                arr.set(idxV, temp);

                idxV = idxPar;
                idxPar = (idxV-1)/2;
            }
        }

        private void heapify(int idx){
            int leftChild = 2*idx+1;
            int rightChild = 2*idx+2;
            int maxIdx = idx;

            if(leftChild < arr.size() && arr.get(maxIdx) < arr.get(leftChild)){
                maxIdx = leftChild;
            }

            if(rightChild < arr.size() && arr.get(maxIdx) < arr.get(rightChild)){
                maxIdx = rightChild;
            }

            if(maxIdx != idx){
                int temp = arr.get(maxIdx);
                arr.set(maxIdx, arr.get(idx));
                arr.set(idx, temp);

                heapify(maxIdx);
            }
        }

        public int remove(){
            int data = arr.size()-1;

            //Swapping 1st and last element of Heap
            int temp = arr.get(arr.size()-1);
            arr.set(arr.size()-1, arr.get(0));
            arr.set(0, temp);

            //Deleting last element of Heap
            arr.remove(arr.size()-1);

            //call Heapify
            heapify(0);

            return data;
        }

        public int peek(){
            return arr.get(0);
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
        heap.add(10);

        while (!heap.isEmpty()){
            int temp = heap.peek();
            System.out.print(temp + " ");
            heap.remove();
        }
    }
}
