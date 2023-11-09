package exo4;

public class TestTimeThread extends Thread{
    @Override
    public void run() {
        SleepThread s1 = new SleepThread();
        SleepThread s2 = new SleepThread();
        SleepThread s3 = new SleepThread();

        s1.start();
        s2.start();
        s3.start();
    }

    public static void main(String[] args) {
        TestTimeThread TTT = new TestTimeThread();

        TTT.start();
    }
}
