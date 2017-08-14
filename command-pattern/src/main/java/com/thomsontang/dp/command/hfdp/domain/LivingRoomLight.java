package com.thomsontang.dp.command.hfdp.domain;

import com.thomsontang.dp.command.hfdp.Light;

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
