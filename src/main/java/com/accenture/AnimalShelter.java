package com.accenture;

import com.accenture.animal.Animal;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnimalShelter {
    private List<Animal> animals;

    public AnimalShelter(List<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Prompts the user to enter a name and a species and creates a new Animal object
     * which is then added to the shelter
     */
    public void addAnimal(Animal animal) {
        animal.setJoined(LocalDateTime.now());
        animals.add(animal);
    }

    /**
     * Prints all the animals in the shelter to System.out
     */
    public void showAnimals() {
        System.out.printf("There are a total of %d animal(s) in the shelter: %n", animals.size());
        System.out.println(animals);
    }

    public List<Animal> searchByName(String name, String sortBy) {
        Stream<Animal> sortedAnimalStream = animals.stream()
                .filter(a -> a.getName().equals(name));

        return sortBy(sortedAnimalStream, sortBy).toList();
    }

    public Set<Animal> sorted(String sortBy) {
        return sortBy(this.animals.stream(), sortBy).collect(Collectors.toSet());
    }

    private Stream<Animal> sortBy(Stream<Animal> stream, String sortBy)
    {
        return switch (sortBy) {
            case "name" -> stream.sorted(Comparator.comparing(Animal::getName));
            case "species" -> stream.sorted(Comparator.comparing(Animal::getSpecies));
            case "joined" -> stream.sorted(Comparator.comparing(Animal::getJoined));
            default -> stream;
        };
    }

    public List<Animal> searchBySpecies(String species, String sortBy) {
        Stream<Animal> stream = animals.stream()
                .filter(a -> a.getSpecies().equals(species));

        return sortBy(stream, sortBy).toList();

    }

    public void remove(String name) {
        animals.removeIf(animal -> animal.getName().equals(name));
    }
}
