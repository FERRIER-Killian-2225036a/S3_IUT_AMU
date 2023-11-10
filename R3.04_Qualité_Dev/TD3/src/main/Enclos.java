package main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Enclos {
    String nom;
    int superficie;
    int capaciteMax;
    int nombreCreaturesPresentes;
    ArrayList<Creatures> creaturesPresentes = new ArrayList<>();
    int degresProprete; // 0 = « mauvais », 1 = « correct » et 2 = « bon »

    public Enclos(String nom, int superficie, int capaciteMax, int degresProprete) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.degresProprete = degresProprete;
    }

    protected String getProprete() {
        if (degresProprete==0){
            return "mauvais";
        } else if (degresProprete==1) {
            return "correct";
        } else {
            return "bon";
        }
    }

    @Override
    public String toString() {
        StringBuilder toStringCreaturePresentes = new StringBuilder();
        for (Creatures crea: creaturesPresentes) {
            toStringCreaturePresentes.append(crea.toString());
        }
        return "Enclos{" +
                "nom='" + nom + '\'' +
                ", superficie=" + superficie +
                ", capaciteMax=" + capaciteMax +
                ", nombreCreaturesPresentes=" + nombreCreaturesPresentes +
                ", creaturesPresentes=" + toStringCreaturePresentes +
                ", propreté=" + getProprete() +
                '}';
    }

    void ajouterCreature(Creatures creatures) {
        if (creaturesPresentes.size()<capaciteMax){
            if (!creaturesPresentes.isEmpty()) {
                if (creaturesPresentes.get(0).type == creatures.type) {
                    creaturesPresentes.add(creatures);
                } else {
                    System.out.println("Cet enclos ne contient pas la même espèce");
                }
            } else {
                creaturesPresentes.add(creatures);
            }
        } else {
            System.out.println("Cap");
        }

    }
    void nourrirCreatures() {
        for (Creatures crea: creaturesPresentes) {
            crea.manger();
        }
    }
    void nettoyer() {
        if (this.degresProprete == 0 && creaturesPresentes.isEmpty()) {
            degresProprete = 2;
        }
    }
}
