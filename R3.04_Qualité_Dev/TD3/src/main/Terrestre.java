package main;

public interface Terrestre {
    String type = "Terrestre";
    default void court() {
        System.out.println("Il court");
    }
}
