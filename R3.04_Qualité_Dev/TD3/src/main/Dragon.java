package main;

public class Dragon extends Ovipare implements Terrestre, Aquatique, Volant{
    public Dragon(String nom, int age, String sexe, int poids, int taille) {
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
    }


}
