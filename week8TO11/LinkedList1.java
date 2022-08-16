package CourseWork.week8TO11;

import java.util.Scanner;

//addNode at first, print in recursion, detect and remove cycle
public class LinkedList1 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    static Node tail = null;
    public static int size = 0;

    public static void addNode(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
    }

    public void printList() {
        System.out.println();
        System.out.println("Elements in the List:-");
        for (Node i = head; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }

    public void printListR() {
        System.out.println();
        System.out.println("Elements in the List:-");
        System.out.println(head.data);
        if (head == null) {
            return;
        }
        head = head.next;
        printListR();
    }

    public void RemoveTail() {
        size--; // removes last node
        Node current = head;
        while (current.next != tail) { // If no tail given current.next.next!=null
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public void RemoveHead() {
        size--;
        head = head.next;
    }

    public int getDataAtAnyPos(int pos) {
        Node current = head;
        for (int i = 2; i <= pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getSize() {
        return size;
    }
}
