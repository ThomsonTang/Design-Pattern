package com.thomsontang.command.hfdp.domain;

import com.thomsontang.command.hfdp.Light;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class KitchenLight implements Light {
    @Override
    public void on() {
        System.out.println("the kitchen light is on....");
    }

    @Override
    public void off() {
        System.out.println("the kitchen light is off....");
    }
}
