package com.thomson.practice.dp.hf.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * the scene for matchmaking.
 *
 * @author Thomson Tang
 */
public class MatchMakingTestDrive {
    public static void main(String[] args) {

    }

    public void drive() {

    }

    /********* Step two: write the code that creates the proxy.*********/

    /**
     * Get the owner proxy of a real person bean.
     *
     * @param person the real subject person bean.
     * @return the proxy of PersonBean
     */
    public PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy
            .newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    /**
     * Get the proxy which is not owner for a person bean.
     *
     * @param person the real subject person bean
     * @return the proxy of PersonBean
     */
    public PersonBean getNotOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy
            .newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(),
                new NotOwnerInvocationHandler(person));
    }
}
