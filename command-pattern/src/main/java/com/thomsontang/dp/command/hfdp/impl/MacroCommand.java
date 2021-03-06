package com.thomsontang.dp.command.hfdp.impl;

import com.thomsontang.dp.command.hfdp.Command;

/**
 * The macro command to execute many commands.
 *
 * @author Thomson Tang
 */
public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
