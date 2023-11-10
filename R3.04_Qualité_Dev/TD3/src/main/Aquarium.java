package main;

public class Aquarium extends Enclos {
    int profondeur;
    int saliniteEau;
    public Aquarium(String nom, int superficie, int capaciteMax, int degresProprete, int profondeur, int saliniteEau) {
        super(nom, superficie, capaciteMax, degresProprete);
        this.profondeur = profondeur;
        this.saliniteEau = saliniteEau;
    }

    @Override
    void ajouterCreature(Creatures creatures) {
        if (creatures.type.contains("aquatique")){
            super.ajouterCreature(creatures);
        } else {
            System.out.println("La créature n'est pas aquatique");
        }
    }

    @Override
    void nettoyer() {
        //TODO: vérification deux attribut
        super.nettoyer();
    }
}
