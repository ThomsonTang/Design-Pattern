package com.thomson.practice.dp.hf.cmd;

/**
 * the empty command.
 *
 * @author Thomson Tang
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        // do nothing.
        System.out.println("do nothing...");
    }
}
