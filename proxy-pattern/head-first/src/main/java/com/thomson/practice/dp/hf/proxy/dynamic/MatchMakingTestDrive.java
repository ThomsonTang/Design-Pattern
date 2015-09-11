package com.thomson.practice.dp.hf.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class MatchMakingTestDrive {
    public static void main(String[] args) {

    }

    public void drive() {

    }

    public PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }

    public PersonBean getNotOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy
            .newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new NotOwnerInvocationHandler(person));
    }
}
