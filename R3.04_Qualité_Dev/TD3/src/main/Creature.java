package main;

import java.util.ArrayList;

public abstract class Creature {
    protected String nom;
    protected int age;
    protected int sexe; // 0 = male; 1 = femelle
    protected int poids; // En kg
    protected int taille; // En cm
    protected ArrayList<?> type = getTypeName(); // Nom de l'interface
    protected int dureeDeVie = 50; // En années
    protected int indicateurFaim = 0; // De 0 a 100
    protected int indicateurSante = 100; // De 100 a 0
    protected int indicateurSommeil = 0; // De 0 a 100
    protected boolean dortIl = false;
    protected boolean estMorte = false;

    public static class InstanceManager {
        private static final ArrayList<Creature> instances = new ArrayList<>();

        private static void addInstance(Creature instance) {
            instances.add(instance);
        }

        public static ArrayList<Creature> getAllInstances() {
            return instances;
        }
    }

    public Creature(String nom, int age, int sexe, int poids, int taille) {
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        InstanceManager.addInstance(this);
    }

    protected void manger() {
        if (!estMorte){
            if (!dortIl) {
                System.out.println("Miam miam");
            } else {
                System.out.println("La créature dort");
            }
        } else {
            System.out.println("La créature est morte");
        }

    }
    protected void emetUnSon() {
        System.out.println("La créature émet un son");
    }
    protected void etreSoigne() {
        if (!estMorte) {
            this.indicateurSante = 100;
        } else {
            System.out.println("La créature est morte");
        }

    }
    protected void sendormirOuSeReveiller() {
        if (estMorte){
            System.out.println("La créature est morte");
        } else {
            dortIl = !dortIl;
        }

    }
    protected void vieillir(int annee) {
        if (this.age<dureeDeVie) {
            this.age += annee;
        } else {
            this.meurt();
        }
    }
    protected void meurt() {
        if (!estMorte) {
            this.estMorte = true;
            if (Enclos.getListCreatureDansEnclos().contains(this)) {
                System.out.println("Vous devez enlever le cadavre de "+nom+" de son enclos");
            }
        } else {
            System.out.println("La créature est déjà morte");
        }

    }

    public String getSex() {
        if (this.sexe==0){
            return "Male";
        } else if (this.sexe==1) {
            return "Femelle";
        } else {
            return "Non défini";
        }
    }

    public String getNom() {
        return nom;
    }

    // Méthode pour obtenir le nom de l'interface
    private ArrayList<?> getTypeName() {
        Class<?>[] interfaces = this.getClass().getInterfaces();
        ArrayList<String> interfaceNames = new ArrayList<>();
        // Gestion du cas où la classe n'implémente aucune interface
        if (interfaces.length > 0) {
            for (Class<?> interfaceElem : interfaces) {
                interfaceNames.add(interfaceElem.getSimpleName());
            }
        } else {
            interfaceNames.add("Non spécifé");
        }
        return interfaceNames; // Prend le nom de la première interface (Volant dans ce cas)
    }

    @Override
    public String toString() {
        return "Creature{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", sexe='" + getSex() + '\'' +
                ", poids=" + poids +
                ", taille=" + taille +
                ", type='" + getTypeName() + '\'' +
                ", indicateurFaim=" + indicateurFaim +
                ", indicateurSante=" + indicateurSante +
                ", indicateurSommeil=" + indicateurSommeil +
                ", dortIl=" + dortIl +
                ", estMorte=" + estMorte +
                '}';
    }
}
