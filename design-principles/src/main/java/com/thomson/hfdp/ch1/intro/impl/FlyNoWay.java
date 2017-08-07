package com.thomson.hfdp.ch1.intro.impl;

import com.thomson.hfdp.ch1.intro.FlyBehavior;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 07/08/2017.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
