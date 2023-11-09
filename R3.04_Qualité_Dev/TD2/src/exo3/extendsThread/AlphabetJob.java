package exo3.extendsThread;

public class AlphabetJob extends Thread{
    @Override
    public void run() {
        String alphabet = "abcdefghijklmnopkrstuvwxyz";
        for (int i = 0; i < alphabet.length(); ++i) {
            System.out.println(alphabet.charAt(i));
        }
    }

    public static void main(String[] args) {
        // On crée une instance de l'objet MyThread.
        AlphabetJob AJ = new AlphabetJob();
        OneToTwentySix OTT = new OneToTwentySix();
        // Puis on lance le thread : t1 exécute alors la méthode run().
        AJ.start();
        OTT.start();
    }
}
