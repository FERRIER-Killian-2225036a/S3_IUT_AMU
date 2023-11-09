package exo3.implementsRunnable;

import exo3.extendsThread.AlphabetJob;
import exo3.extendsThread.OneToTwentySix;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        OneToTwentySix OTT = new OneToTwentySix();
        AlphabetJob AJ = new AlphabetJob();
        Thread t1 = new Thread(OTT);
        Thread t2 = new Thread(AJ);

        t1.start();
        t2.start();
    }


}
