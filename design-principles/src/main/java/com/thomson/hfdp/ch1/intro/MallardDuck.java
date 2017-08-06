package com.thomson.hfdp.ch1.intro;

import com.thomson.hfdp.ch1.intro.impl.Quack;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 06/08/2017.
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
    }
}
