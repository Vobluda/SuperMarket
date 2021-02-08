package Supermarket;

public class Checkout {
    Queue waiting = new Queue();
    Customer curr;

    public void addCustomer(int ID) {
        Customer customer = new Customer(ID);
        waiting.enqueue(customer);
        if (isCurrEmpty() == true) {
            this.moveFromQToCurr();
        }
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
        curr = waiting.dequeue();
        curr.generateServiceTime();
    }

    public boolean isCurrFinished() {
        if (curr.hasBeenServiced) { return true; } else { return false; }
    }

}
