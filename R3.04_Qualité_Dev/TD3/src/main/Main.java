package main;

public class Main {
    public static void main(String[] args) {
        Phenix phenix = new Phenix("Un phénix", 18, 0, 36, 14);
        // System.out.println(phenix);
        Dragon dragon = new Dragon("Un dragon", 113, 0, 400, 233);
        // System.out.println(dragon);
        Enclos enclosDefaut = new Enclos("Enclos défaut", 20, 5, 2);
        System.out.println(enclosDefaut);
    }
}
