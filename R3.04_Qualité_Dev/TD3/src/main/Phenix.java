package main;

public class Phenix extends Ovipare implements Volant{
    public Phenix(String nom, int age, int sexe, int poids, int taille) {
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
    }

    @Override
    void meurt() {
        System.out.println("La créature renée de ses cendres");
        this.indicateurSante = 100;
    }
}
