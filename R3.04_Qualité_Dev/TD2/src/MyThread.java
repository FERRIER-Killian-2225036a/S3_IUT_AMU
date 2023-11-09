public class MyThread extends Thread {
    public void run() {
        // Ici se trouve la description du comportement du thread.
        System.out.println("Coucou");
    }
    public static void main(String[] args) {
        // On crée une instance de l'objet MyThread.
        MyThread t1 = new MyThread();
        // Puis on lance le thread : t1 exécute alors la méthode run().
        t1.start();
    }
}