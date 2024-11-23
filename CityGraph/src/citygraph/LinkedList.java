/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citygraph;

/**
 *
 * @author 90551
 */
public class LinkedList<Integer> {
      Node first, last;
    int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }
 

    public void insertFirst(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }


    public void insertLast(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

 
    public void insertAfter(Node p, int v) {
        Node newNode = new Node(v);
        Node prevNode = search(p.data);
        if (prevNode != null) {
            Node old_prev_next = prevNode.next;
            prevNode.next = newNode;
            newNode.next = old_prev_next;
            size++;
        }
    }

    public Node search(int k) {
        Node tmp = first;
        while (tmp != null) {
            if (tmp.data == k) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public String toString() {
        Node tmp = first;
        String str = "";

        while (tmp != null) {
            str += tmp.data + "->";
            tmp = tmp.next;
        }

        return str;
    }

    public boolean isEmpty() {
        return first == null;
    }

    
    public void removeFirst() {
        first = first.next;
        size--;
    }
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

   
    public void removeLast() {
        Node tmp = first;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
        last = tmp;
        size--;
    }

    public Node removeAfter(Node prev) {
        if (size <= 1) {
            return null;
        }
        Node remove = prev.next;
        prev.next = prev.next.next;
        size--;
        return remove;
    }

    public int getSum() {
        int sum = 0;
        Node tmp = first;
        while (tmp != null) {
            sum += tmp.data;
            tmp = tmp.next;
        }
        return sum;
    }


    private static class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        next = null;
    }


}
}
