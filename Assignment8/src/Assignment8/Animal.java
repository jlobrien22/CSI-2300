// Animal.java
package Assignment8;

public abstract class Animal {
    protected String species;

    Animal(String species) {
        this.species = species;
    }

    Animal() {
        this.species = "Unknown";
    }

    abstract void makeSound();
}
