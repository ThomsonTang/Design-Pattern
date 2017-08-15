package com.thomson.dp.principle.hfdp.intro.impl;

import com.thomson.dp.principle.hfdp.intro.FlyBehavior;

/**
 * 用翅膀飞行
 *
 * @author Thomson Tang
 * @version Created: 06/08/2017.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("flying with wings...");
    }
}
