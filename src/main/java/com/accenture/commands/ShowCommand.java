package com.accenture.commands;

import com.accenture.AnimalShelter;

public class ShowCommand implements Command{

    private final AnimalShelter shelter;

    public ShowCommand(AnimalShelter shelter) {
        this.shelter = shelter;
    }

    @Override
    public boolean shouldRun(String name) {
        return name.equals("show");
    }

    @Override
    public void execute() {
        shelter.showAnimals();
    }

    @Override
    public String getHelpText() {
        return "show: Shows all animals that currently in the shelter";
    }


}
