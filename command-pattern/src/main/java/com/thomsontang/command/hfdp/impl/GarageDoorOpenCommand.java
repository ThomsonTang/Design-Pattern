package com.thomsontang.command.hfdp.impl;

import com.thomsontang.command.hfdp.Command;
import com.thomsontang.command.hfdp.domain.GarageDoor;

/**
 * the command which open the garage door.
 *
 * @author Thomson Tang
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        this.garageDoor.up();
    }

    @Override
    public void undo() {
        this.garageDoor.down();
    }
}
