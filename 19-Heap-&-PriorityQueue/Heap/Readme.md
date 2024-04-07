A heap is a specialized tree-based data structure that satisfies the heap property: if P is a parent node of C, then the key of P is greater than or equal to the key of C. The node at the "top" of the heap is called the root node.

The heap is one maximally efficient implementation of an abstract data type called a priority queue, and in fact, priority queues are often referred to as "heaps", regardless of how they may be implemented. In a heap, the highest priority element is always stored at the root. However, a heap is not a sorted structure; it can be regarded as being partially ordered. A heap is a useful data structure when it is necessary to repeatedly remove the object with the highest priority, or when insertions need to be interspersed with removals of the root node.

A common implementation of a heap is the binary heap, in which the tree is a complete binary tree. The heap data structure, specifically the binary heap, was introduced by J. W. J. Williams in 1964, as a data structure for the heapsort sorting algorithm.

**Here are some of the properties of a heap:**

    - The heap is a complete binary tree.
    - The value of each node is greater than or equal to the value of its children.
    - The root node has the largest value in the heap.
    - The heap is often used to implement a priority queue.

Heaps are used in a variety of applications, including:
Sorting algorithms, Priority queues, Graph algorithms, Network routing, and Memory management.