package com.thomson.practice.dp.hf.cmd;

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
}
