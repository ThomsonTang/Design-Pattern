package com.thomson.practice.dp.hf.cmd;

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
}
