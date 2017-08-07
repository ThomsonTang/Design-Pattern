package com.thomson.hfdp.ch1.intro;

import com.thomson.hfdp.ch1.intro.impl.FlyNoWay;
import com.thomson.hfdp.ch1.intro.impl.Quack;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 07/08/2017.
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck.");
    }
}
