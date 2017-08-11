package com.thomsontang.command.hfdp.impl;

import com.thomsontang.command.hfdp.Command;
import com.thomsontang.command.hfdp.domain.GarageDoor;

/**
 * the command for downing the garage door.
 *
 * @author Thomson Tang
 */
public class GarageDoorDownCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
