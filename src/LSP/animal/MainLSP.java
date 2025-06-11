package LSP.animal;
// src/lsp/MainLSP.java

import LSP.animal.*;

public class MainLSP {
    public static void main(String[] args) {
        Animal dog  = new Dog();
        Animal fish = new Fish();

        // Todos los animales hacen sonido:
        dog.makeSound();   // Dog barks.
        fish.makeSound();  // Fish makes blub-blub sound.

        // Solo los que son Walkable caminan:
        if (dog instanceof Walkable) {
            ((Walkable) dog).walk();  // Dog is walking.
        }
        // No intentamos hacer fish.walk() → ningún error en tiempo de ejecución
    }
}
