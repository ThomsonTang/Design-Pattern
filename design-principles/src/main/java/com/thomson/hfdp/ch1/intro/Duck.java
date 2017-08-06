package com.thomson.hfdp.ch1.intro;

/**
 * 鸭子类
 *
 * @author Thomson Tang
 * @version Created: 06/08/2017.
 */
public abstract class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public abstract void display();

    public Duck() {
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("All ducks float...");
    }
}
