package exo3.implementsRunnable;

public class AlphabetJob implements Runnable{
    @Override
    public void run() {
        String alphabet = "abcdefghijklmnopkrstuvwxyz";
        for (int i = 0; i < alphabet.length(); ++i) {
            System.out.println(alphabet.charAt(i));
        }
    }
}
