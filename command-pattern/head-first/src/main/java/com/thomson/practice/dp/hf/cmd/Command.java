package com.thomson.practice.dp.hf.cmd;

/**
 * Define a interface which contain an execute method that all command objects must implement.
 *
 * @author Thomson Tang
 */
public interface Command {
    void execute();
    void undo();
}
