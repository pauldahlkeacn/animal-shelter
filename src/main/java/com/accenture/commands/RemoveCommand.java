package com.accenture.commands;

import com.accenture.AnimalShelter;

import java.util.Scanner;

public class RemoveCommand implements Command{

    private final Scanner scanner;
    private final AnimalShelter shelter;

    public RemoveCommand(Scanner scanner, AnimalShelter shelter) {
        this.scanner = scanner;
        this.shelter = shelter;
    }

    @Override
    public boolean shouldRun(String name) {
        return name.equals("remove");
    }

    @Override
    public void execute() {
        System.out.println("Please enter the name of the animal which should be removed from the shelter:");
        String name = scanner.nextLine();
        shelter.remove(name);
    }

    @Override
    public String getHelpText() {
        return "remove: removes the animal given a name";
    }
}
