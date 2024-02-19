package com.accenture.commands;

public interface Command {
     boolean shouldRun(String name);
     void execute();
     String getHelpText();

}
