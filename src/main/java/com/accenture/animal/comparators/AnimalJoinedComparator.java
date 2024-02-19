package com.accenture.animal.comparators;

import com.accenture.animal.Animal;

import java.util.Comparator;

public class AnimalJoinedComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getJoined().compareTo(o2.getJoined());
    }
}
