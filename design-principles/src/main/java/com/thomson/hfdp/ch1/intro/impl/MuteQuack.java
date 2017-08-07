package com.thomson.hfdp.ch1.intro.impl;

import com.thomson.hfdp.ch1.intro.QuackBehavior;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 07/08/2017.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
