/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citygraph;

/**
 *
 * @author 90551
 */
public class Stack<Item> {
   
    

        private Item[] a;    // holds the items
        private int top;     // number of items in stack

        // create an empty stack with given capacity
        public Stack(int capacity) {
            a = (Item[]) new Object[capacity];   // no generic array creation
        }

        public boolean isEmpty() {
            return top == 0;
        }

        public void push(Item item) {
            a[top++] = item;
        }

        public Item pop() {
            return a[--top];
        }

        @Override
        public String toString() {
            if (!isEmpty()) {
                int x = top;
                String str = "";
                while (x > 0) {
                    x--;
                    str += a[x].toString() + "\n";
                }
                return str;
            }
            return "Stack is empty!";
        }

        
        public Item popBottom() {
            Stack<Item> s1 = new Stack(top - 1);
            while (top > 1) {
                s1.push(pop());
            }
            Item bottom = pop(); // bottom element
            while (!s1.isEmpty()) {
                push(s1.pop());
            }
            return bottom;
        }



}
