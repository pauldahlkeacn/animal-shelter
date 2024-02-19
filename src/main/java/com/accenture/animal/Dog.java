package com.accenture.animal;

import com.accenture.animal.Animal;

public class Dog extends Animal {

    public Dog(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println("Wuff");
    }
}
