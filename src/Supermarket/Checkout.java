package Supermarket;

public class Checkout {
    Queue waiting = new Queue();
    Customer curr;

    public void addCustomer(int ID) { //method to add a customer to the specific queue
        Customer customer = new Customer(ID);
        System.out.println("New customer in queue: " + customer.ID);
        waiting.enqueue(customer);
    }

    public void moveFromQToCurr() { //method to move the person in front of queue to curr (person currently being checked out)
        if (waiting.head!=null) {
            curr = waiting.dequeue();
            curr.generateServiceTime();
        } else { curr = null; }
    }

    public boolean isCurrFinished() { //checks whether or not the person being checked out is finished
        try {
        if (curr.hasBeenServiced) { return true; } else { return false; }
        } catch(Exception e) {return true;}

    }

}
