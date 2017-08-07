package com.thomson.hfdp.ch1.intro.impl;

import com.thomson.hfdp.ch1.intro.FlyBehavior;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 07/08/2017.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("flying with a rocket...");
    }
}
