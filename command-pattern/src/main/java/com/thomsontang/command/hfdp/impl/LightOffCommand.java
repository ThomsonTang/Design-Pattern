package com.thomsontang.command.hfdp.impl;

import com.thomsontang.command.hfdp.Command;
import com.thomsontang.command.hfdp.Light;

/**
 * the command to turn off the light
 *
 * @author Thomson Tang
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
