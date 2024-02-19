package com.accenture.commands;

public class ExitCommand implements Command {
    @Override
    public boolean shouldRun(String name) {
        return name.equals("exit");
    }

    @Override
    public void execute() {
        System.out.println("Goodbye.");
        System.exit(0);
    }

    @Override
    public String getHelpText() {
        return "exit: exits the application";
    }


}
