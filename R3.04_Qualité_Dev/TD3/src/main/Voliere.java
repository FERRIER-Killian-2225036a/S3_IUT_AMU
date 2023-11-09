package main;

public class Voliere extends Enclos{
    int hauteur;
    public Voliere(String nom, int superficie, int capaciteMax, int degresProprete, int hauteur) {
        super(nom, superficie, capaciteMax, degresProprete);
        this.hauteur = hauteur;
    }

    @Override
    void ajouterCreature(Creatures creatures) {
        if (creatures.type == "volant"){
            super.ajouterCreature(creatures);
        }
    }
}
