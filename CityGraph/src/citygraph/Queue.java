/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citygraph;

/**
 *
 * @author 90551
 */
public class Queue {


    private int size;
    private Node first;
    private Node last;

    private static class Node {
        private int item;
        private Node next;

        public Node(int item) {
            this.item = item;
        }
    }

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (!isEmpty()) {
            return first.item;
        }
        // Throw an exception for empty queue
        throw new java.util.NoSuchElementException("Queue is empty");
    }

    public void enqueue(int entry) {
        Node newNode = new Node(entry);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            // Throw an exception for empty queue
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        Node tmp = first;
        first = first.next;
        tmp.next = null;
        size--;
        return tmp.item;
    }
}




