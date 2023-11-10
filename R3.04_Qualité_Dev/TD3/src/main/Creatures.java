package main;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Creatures {
    protected String nom;
    protected int age;
    protected int sexe; // 0 = male; 1 = femelle
    protected int poids;
    protected int taille;
    protected ArrayList<?> type = getTypeName();

    protected int indicateurFaim = 0;
    protected int indicateurSante = 100;
    protected int indicateurSommeil = 0;
    protected boolean dortIl = false;
    protected boolean estMort = false;


    void manger() {
        if (!estMort){
            if (!dortIl) {
                System.out.println("Miam miam");
            } else {
                System.out.println("La créature dort");
            }
        } else {
            System.out.println("La créature est morte");
        }

    }
    void emetUnSon() {
        System.out.println("La créature émet un son");
    }
    void etreSoigne() {
        if (!estMort) {
            this.indicateurSante = 100;
        } else {
            System.out.println("La créature est morte");
        }

    }
    void sendormirOuSeReveiller() {
        if (estMort){
            System.out.println("La créature est morte");
        } else {
            dortIl = !dortIl;
        }

    }
    void vieillir() {
        //TODO: (et mourir s’il a atteint la dernière catégorie d’âge et qu’il doit encore vieillir, ou s’il devient trop malade)
    }
    void meurt() {
        if (!estMort) {
            this.estMort = true;
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
        if (interfaces.length > 0) {
            for (Class<?> interfaceElem : interfaces) {
                interfaceNames.add(interfaceElem.getSimpleName());
            }
            return interfaceNames; // Prend le nom de la première interface (Volant dans ce cas)
        } else {
            interfaceNames.add("Non spécifé");
            return interfaceNames; // Gestion du cas où la classe n'implémente aucune interface
        }
    }

    @Override
    public String toString() {
        return "Creatures{" +
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
                ", estMort=" + estMort +
                '}';
    }
}
