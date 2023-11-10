package main;

public class Voliere extends Enclos{
    int hauteur;
    public Voliere(String nom, int superficie, int capaciteMax, int degresProprete, int hauteur) {
        super(nom, superficie, capaciteMax, degresProprete);
        this.hauteur = hauteur;
    }

    @Override
    void ajouterCreature(Creatures creatures) {
        if (creatures.type.contains("volant")){
            super.ajouterCreature(creatures);
        } else {
            System.out.println("La créature n'est pas un volant");
        }
    }

    @Override
    void nettoyer() {
        //TODO: vérification toit
        super.nettoyer();
    }
}
