package com.thomson.practice.dp.hf.cmd;

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
}
