package com.thomson.practice.dp.hf.cmd;

import org.junit.Before;
import org.junit.Test;

/**
 * test case for simple remote controller.
 *
 * @author Thomson Tang
 */
public class SimpleRemoteControlTest {
    SimpleRemoteControl simpleRemoteControl;
    Light light;
    GarageDoor garageDoor;

    @Before
    public void prepare() {
        this.simpleRemoteControl = new SimpleRemoteControl();
        this.light = new RoomLight();
        this.garageDoor = new GarageDoor();
    }

    @Test
    public void testTurnOnLight() {
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
    }

    @Test
    public void testOpenGarageDoor() {
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(this.garageDoor);
        simpleRemoteControl.setCommand(garageDoorOpenCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}
