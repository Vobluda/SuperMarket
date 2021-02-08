package Supermarket;

import java.sql.SQLOutput;

public class Checkout {
    Queue waiting = new Queue();
    Customer curr;

    public void addCustomer(int ID) {
        Customer customer = new Customer(ID);
        System.out.println("New customer in queue: " + customer.ID);
        waiting.enqueue(customer);
    }

    private boolean isCurrEmpty() {
        try {
            curr.ID = curr.ID;
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void moveFromQToCurr() {
        if (waiting.head!=null) {
            curr = waiting.dequeue();
            System.out.println("Dequeueing customer " + curr.ID);
            curr.generateServiceTime();
        } else { System.out.println("Dequeueing customer " + curr.ID); curr = null; }
    }

    public boolean isCurrFinished() {
        try {
        if (curr.hasBeenServiced) { return true; } else { return false; }
        } catch(Exception e) {return true;}

    }

}
