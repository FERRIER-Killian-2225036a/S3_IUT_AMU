public class MyJob implements Runnable {
    public void run() {
        // Ici se trouve la description du comportement du thread.
        System.out.println("Coucou");
    }
    public static void main(String[] args) {
        // On crée une tâche pour un thread.
        MyJob job = new MyJob();
        // On crée une instance de Thread avec la tâche job.
        Thread t1 = new Thread(job);
        // Puis on lance le thread : t1 exécute alors la méthode run()
        // de la tâche job.
        t1.start();
    }

}
