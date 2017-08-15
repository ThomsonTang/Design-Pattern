package com.thomson.dp.principle.hfdp.intro;

import com.thomson.dp.principle.hfdp.intro.impl.Quack;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 06/08/2017.
 */
public class MallardDuck extends Duck {
    @Override
    public void display() {

    }

    public MallardDuck() {
        quackBehavior = new Quack();
    }
}
