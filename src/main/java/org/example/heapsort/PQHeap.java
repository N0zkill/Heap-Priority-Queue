package org.example.heapsort;

import java.util.Arrays;

/**
 * A max-heap priority queue
 */

public class PQHeap implements PriorityQueue {
    private Player[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    public PQHeap() {
        heap = new Player[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Copy constructor that is a deep copy of another PQHeap.
     *
     * @param other The PQHeap copy.
     */

    public PQHeap(PQHeap other) {
        this.heap = Arrays.copyOf(other.heap, other.heap.length);
        this.size = other.size;
    }


    public PQHeap createClone() {
        return new PQHeap(this);
    }

    /**
     * Adds a player to the heap.
     *
     * @param player The player added.
     */
    @Override
    public void add(Player player) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = player;
        heapifyUp(size);
        size++;
    }

    /**
     * Retrieves and removes the player with the highest score from the heap.
     *
     * @return Return highest score, or null if the heap is empty.
     */

    @Override
    public Player getHighestScorePlayer() {
        if (isEmpty()) return null;
        Player max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    /**
     * Resizes the heap array when it reaches max.
     */

    private void resize() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index].getScore() > heap[parent].getScore()) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }





    /**
     * Maintains the heap property after removal by moving a node down.
     *
     * @param index The index of the root element after removal.
     */
    private void heapifyDown(int index) {
        while (index < size / 2) { // Only non-leaf nodes
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = left;

            if (right < size && heap[right].getScore() > heap[left].getScore()) {
                largest = right;
            }

            if (heap[index].getScore() >= heap[largest].getScore()) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param i  first element.
     * @param j  second element.
     */

    private void swap(int i, int j) {
        Player temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    /**
     * Clears the heap.
     */
    @Override
    public void clear() {
        size = 0;
        heap = new Player[DEFAULT_CAPACITY];
    }


    /**
     *
     * @return The number of elements in the heap.
     */
    @Override
    public int getSize() {
        return size;
    }



    /**
     *
     * @return True if the heap is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

