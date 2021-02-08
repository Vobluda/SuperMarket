package Supermarket;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {
        Market market = new Market();
        market.start();

        for (int minuteCounter = 0; minuteCounter < 100; minuteCounter++) {
            market.update();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
