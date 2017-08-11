package com.thomsontang.command.hfdp.impl;

import com.thomsontang.command.hfdp.Command;

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

    @Override
    public void undo() {
        // do nothing.
        System.out.println("do nothing...");
    }
}
