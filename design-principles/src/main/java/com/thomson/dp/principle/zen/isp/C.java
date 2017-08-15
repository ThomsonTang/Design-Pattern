package com.thomson.dp.principle.zen.isp;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class C {
    public void depend1(I i) {
        i.method1();
    }

    public void depend2(I i) {
        i.method4();
    }

    public void depend3(I i) {
        i.method5();
    }
}
