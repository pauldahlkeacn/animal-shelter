package com.accenture;

import com.accenture.animal.Animal;
import com.accenture.commands.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class REPL {

    public static void main(String[] args) {
        new REPL().run();
    }

    /**
     * Runs the main loop. Asks for commands until the user enters "exit". In this case this
     * function will return
     */
    public void run() {
        final List<Animal> animals = new LinkedList<>();
        final AnimalShelter shelter = new AnimalShelter(animals);
        final Scanner scanner = new Scanner(System.in);

        final List<Command> commands = getCommands(shelter, scanner);

        showWelcomeMessage(commands);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            boolean matched = false;
            for (Command command : commands) {
                if (command.shouldRun(input)) {
                    command.execute();
                    matched = true;
                }
            }

            if (!matched) {
                System.out.println("Invalid command: " + input);
            }
        }
    }

    private static List<Command> getCommands(AnimalShelter shelter, Scanner scanner) {
        final AddCommand addCommand = new AddCommand(shelter, scanner);
        final ExitCommand exitCommand = new ExitCommand();
        final ShowCommand showCommand = new ShowCommand(shelter);
        final RemoveCommand removeCommand = new RemoveCommand(scanner, shelter);
        final SearchCommand searchCommand = new SearchCommand(scanner, shelter);
        final SortCommand sortCommand = new SortCommand(scanner, shelter);

        return List.of(
                addCommand,
                exitCommand,
                showCommand,
                removeCommand,
                searchCommand,
                sortCommand
        );
    }

    /**
     * Shows the initial welcome message and explains all available commands
     */
    private void showWelcomeMessage(List<Command> commands) {
        System.out.println("Welcome to the Animal Shelter Program!");
        System.out.println("The following commands are available:");
        System.out.println();
        for (Command command : commands) {
            System.out.println("[*] " + command.getHelpText());
        }
        System.out.println();
    }
}
