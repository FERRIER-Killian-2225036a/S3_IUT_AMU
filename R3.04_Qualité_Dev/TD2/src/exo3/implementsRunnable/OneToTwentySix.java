package exo3.implementsRunnable;

public class OneToTwentySix implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 26; ++i) {
            System.out.println(i+1);
        }
    }
}
