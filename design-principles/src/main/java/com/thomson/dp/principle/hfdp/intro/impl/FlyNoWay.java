package com.thomson.dp.principle.hfdp.intro.impl;

import com.thomson.dp.principle.hfdp.intro.FlyBehavior;

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
