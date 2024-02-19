package com.accenture.commands;

import com.accenture.AnimalShelter;

import java.util.Scanner;

public class SearchCommand implements Command{
    public final Scanner scanner;
    public final AnimalShelter shelter;

    public SearchCommand(Scanner scanner, AnimalShelter shelter) {
        this.scanner = scanner;
        this.shelter = shelter;
    }

    @Override
    public boolean shouldRun(String name) {
        return "search".equals(name);
    }

    @Override
    public void execute() {
        System.out.println("Search for [n]ame or for [s]pecies?");
        String searchCriteria = scanner.nextLine();
        System.out.println("Sort by: ");
        String sortBy = scanner.nextLine();
        System.out.println("Please enter the search string:");
        String searchString = scanner.nextLine();

        switch (searchCriteria) {
            case "n" -> System.out.println(shelter.searchByName(searchString, sortBy));
            case "s" -> System.out.println(shelter.searchBySpecies(searchString, sortBy));
        };
    }

    @Override
    public String getHelpText() {
        return "search: Searching the animal shelter";
    }
}
