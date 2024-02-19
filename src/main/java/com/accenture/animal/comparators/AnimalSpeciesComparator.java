package com.accenture.animal.comparators;

import com.accenture.animal.Animal;

import java.util.Comparator;

public class AnimalSpeciesComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getSpecies().compareTo(o2.getSpecies());
    }
}
