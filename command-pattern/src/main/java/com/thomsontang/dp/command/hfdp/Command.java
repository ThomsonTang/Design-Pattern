package com.thomsontang.dp.command.hfdp;

/**
 * Define a interface which contain an execute method that all command objects must implement.
 *
 * @author Thomson Tang
 */
public interface Command {
    void execute();
    void undo();
}
