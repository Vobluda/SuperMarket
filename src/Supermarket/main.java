package Supermarket;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {
        Market market = new Market();
        market.start();

        for (int minuteCounter = 0; minuteCounter < 100; minuteCounter++) {
            System.out.println("---Minute " + minuteCounter + "---");
            market.update();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---RESULTS---");
        System.out.println("Longest time waited: " + market.maxMinsWaited);
        System.out.println("Longest queue: " + market.longestQueue);
    }
}
