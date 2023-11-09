package exo3.extendsThread;

public class OneToTwentySix extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 26; ++i) {
            System.out.println(i+1);
        }
    }

    public static void main(String[] args) {
        // On crée une instance de l'objet MyThread.
        OneToTwentySix OTT = new OneToTwentySix();
        // Puis on lance le thread : t1 exécute alors la méthode run().
        OTT.start();
    }
}
