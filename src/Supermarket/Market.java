package Supermarket;
import java.util.Random;

public class Market {
    Checkout checkout = new Checkout();
    int IDCounter = 0;
    int maxMinsWaited = 0;
    int longestQueue = 0;

    public void update() {

        checkout.curr.incrementTimeWaited();
        checkout.waiting.incrementTime();
        checkout.curr.hasBeenServiced();

        if (checkout.isCurrFinished() == true) {
            if (checkout.curr.minutesWaited < maxMinsWaited) { maxMinsWaited = checkout.curr.minutesWaited; }
            System.out.println("Customer " + checkout.curr.ID + " has been checked out with a wait time of " + checkout.curr.minutesWaited);
            checkout.moveFromQToCurr();
        }

        Random rand = new Random();
        if (rand.nextInt(5) == 1) {
            checkout.addCustomer(IDCounter);
            IDCounter ++;
        }

        if ((checkout.waiting.getLen() + 1) < longestQueue) {
            longestQueue = (checkout.waiting.getLen() + 1);
        }
    }

    public void start() {
        IDCounter = 1;
        checkout.addCustomer(1);
        IDCounter ++ ;
        checkout.moveFromQToCurr();
    }
}
