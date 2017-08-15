package com.thomson.dp.principle.hfdp.intro;

import com.thomson.dp.principle.hfdp.intro.impl.Quack;
import com.thomson.dp.principle.hfdp.intro.impl.FlyNoWay;

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
