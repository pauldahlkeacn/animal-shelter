package com.accenture.commands;

import com.accenture.AnimalShelter;

import java.util.Scanner;

public class SortCommand implements Command{

    private final Scanner scanner;
    private final AnimalShelter shelter;

    public SortCommand(Scanner scanner, AnimalShelter shelter) {
        this.scanner = scanner;
        this.shelter = shelter;
    }

    @Override
    public boolean shouldRun(String name) {
        return "sort".equals(name);
    }

    @Override
    public void execute() {
        System.out.println("Sort by: name, species or joined?");
        String sortInput = scanner.nextLine();
        System.out.println(shelter.sorted(sortInput));
    }

    @Override
    public String getHelpText() {
        return "sort: Prints all animals sorted by the specified field";
    }
}
