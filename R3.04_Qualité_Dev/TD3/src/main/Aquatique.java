package main;

public interface Aquatique {
    String type = "Aquatique";
    default void nage() {
        System.out.println("Il nage");
    }
}
