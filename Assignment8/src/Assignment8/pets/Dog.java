// Dog.java
package Assignment8.pets;

import Assignment8.Animal;

public class Dog extends Animal {
    public Dog() {
        super("Dog");
    }

    public Dog(String species) {
        super(species);
    }

    void makeSound() {
        System.out.println("Woof!");
    }
}
