package com.accenture.commands;

import com.accenture.AnimalShelter;
import com.accenture.animal.Animal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddCommand implements Command {

    private final AnimalShelter shelter;
    private final Scanner scanner;
    private final String DATETIMEFORMAT = "dd.MM.yyyy HH:mm";

    public AddCommand(AnimalShelter shelter, Scanner scanner) {
        this.shelter = shelter;
        this.scanner = scanner;
    }

    @Override
    public boolean shouldRun(String name) {
        return name.equals("add");
    }

    @Override
    public void execute() {
        System.out.println("Please enter the name of the animal: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the species of the animal: ");
        String species = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIMEFORMAT);
        LocalDateTime joined = LocalDateTime.now();
        boolean success = false;
        do
        {
            System.out.printf("When did %s enter the shelter (%s)?%n", name, DATETIMEFORMAT);
            String stringTime = scanner.nextLine();
            if (stringTime.isEmpty()) {
                joined = LocalDateTime.now();
                break;
            }
            try {
                joined = LocalDateTime.parse(stringTime, formatter);
                success = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date time, please try again");
            }
        } while (!success);

        Animal animal = new Animal(name, species);
        animal.setJoined(joined);
        shelter.addAnimal(animal);
    }

    @Override
    public String getHelpText() {
        return "add: adds an animal to the shelter";
    }
}
