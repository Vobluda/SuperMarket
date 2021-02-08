package Supermarket;

public class Queue {

    Node head;

    private class Node {
        Customer data;
        Node next;
    }

    public void enqueue(Customer data) {
        Node curr;
        Node node = new Node();
        node.data = data;
        if (head==null) {
            head = node;
        } else {
            curr = head;
            while (curr.next!=null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    public Customer dequeue() {
        if (head==null) {
            System.out.println("HEAD IS NULL IDIOT!");
        }
        Customer data = head.data;
        head = head.next;
        return data;
    }

    public void incrementTime() {
        Node curr;
        curr = head;
        if (head!=null) {
            head.data.incrementTimeWaited();
        }
        if (curr!=null) {
            while (curr.next != null) {
                curr = curr.next;
                curr.data.incrementTimeWaited();
            }
        }
    }

    public int getLen() {
        Node curr;
        curr = head;
        int output = 1;
        if (curr!=null) {
            while (curr.next!=null) {
                curr = curr.next;
                output ++;
            }
        }
        return output;
    }

    public void displayFront() {
        System.out.println("Front of queue: " + head.data);
    }

    public void displayAll() {
        String output = "";
        Node curr = head;
        if (curr!=null) {
            while (curr.next != null) {
                output += curr.data;
                output += ", ";
                curr = curr.next;
            }
            output+=curr.data;
        }
        System.out.print("Entire queue: ");
        System.out.println(output);
    }
}
