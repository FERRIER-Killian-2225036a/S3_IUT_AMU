package exo4;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SleepThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            final Random RANDOM = new Random();
            int min = 0;
            int max = 2000;
            try {
                TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(min, max));
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
