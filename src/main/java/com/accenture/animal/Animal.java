package com.accenture.animal;

import com.accenture.animal.comparators.AnimalJoinedComparator;
import com.accenture.animal.comparators.AnimalNameComparator;
import com.accenture.animal.comparators.AnimalSpeciesComparator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Animal implements Comparable<Animal> {

    private String name;
    private String species;
    private LocalDateTime joined;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public Animal(String name, String species, LocalDateTime joined) {
        this.name = name;
        this.species = species;
        this.joined = joined;
    }

    /**
     * Get the name of the animal
     *
     * @return name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the animal
     *
     * @param name new animal name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the species of the animal
     *
     * @return name of the animal
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets the species of the animal
     *
     * @param species new animal name
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    public LocalDateTime getJoined() {
        return joined;
    }

    public void setJoined(LocalDateTime joined) {
        this.joined = joined;
    }

    /**
     * Makes the sound of the animal
     */
    public void makeSound() {
        System.out.println("No sound");
    }

    @Override
    public String toString() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", joined=" + joined.format(dateTimeFormatter) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(species, animal.species) &&
                Objects.equals(joined, animal.joined);
    }

    @Override
    public int hashCode() {
        return 7 * name.hashCode() +
                9 * species.hashCode() +
                11 * joined.hashCode();
    }

    @Override
    public int compareTo(Animal o) {
        int nameCompare = this.name.compareTo(o.name);
        if (nameCompare != 0) return nameCompare;
        int speciesCompare = this.species.compareTo(o.species);
        if (speciesCompare != 0) return speciesCompare;
        return this.joined.compareTo(o.joined);
    }
}
