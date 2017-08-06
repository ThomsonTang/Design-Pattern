package com.thomson.hfdp.ch1.intro;

/**
 * 鸭子类
 *
 * @author Thomson Tang
 * @version Created: 06/08/2017.
 */
public class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }
}
