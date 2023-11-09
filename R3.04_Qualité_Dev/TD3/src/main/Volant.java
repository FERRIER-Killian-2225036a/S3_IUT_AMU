package main;

public interface Volant {
    String type = "Volant";
    default void vole() {
        System.out.println("Il vole");
    }
}
