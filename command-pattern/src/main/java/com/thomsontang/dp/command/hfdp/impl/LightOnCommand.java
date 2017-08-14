package com.thomsontang.dp.command.hfdp.impl;

import com.thomsontang.dp.command.hfdp.Command;
import com.thomsontang.dp.command.hfdp.Light;

/**
 * The command to turn on the light.
 *
 * @author Thomson Tang
 */
public class LightOnCommand implements Command {
    Light light;

    /**
     * The constructor is passed the specific light that this command is going to control.
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
