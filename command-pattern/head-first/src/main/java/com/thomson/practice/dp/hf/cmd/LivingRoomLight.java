package com.thomson.practice.dp.hf.cmd;

/**
 * the light in room.
 *
 * @author Thomson Tang
 */
public class LivingRoomLight implements Light {
    @Override
    public void on() {
        System.out.println("the room light is on...");
    }

    @Override
    public void off() {
        System.out.println("the room light is off...");
    }
}
