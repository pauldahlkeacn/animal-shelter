package com.accenture.animal;

import com.accenture.animal.Animal;

public class Cat extends Animal {

    public Cat(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println("Miau");
    }
}
