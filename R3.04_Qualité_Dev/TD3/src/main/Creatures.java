package main;

public abstract class Creatures {
    protected String nom;
    protected int age;
    protected String sexe;
    protected int poids;
    protected int taille;
    protected String type;

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


    @Override
    public String toString() {
        return "Creatures{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", sexe='" + sexe + '\'' +
                ", poids=" + poids +
                ", taille=" + taille +
                ", type='" + type + '\'' +
                ", indicateurFaim=" + indicateurFaim +
                ", indicateurSante=" + indicateurSante +
                ", indicateurSommeil=" + indicateurSommeil +
                ", dortIl=" + dortIl +
                ", estMort=" + estMort +
                '}';
    }
}
