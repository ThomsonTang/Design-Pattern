package com.thomsontang.dp.proxy.hfdp.handler;

import com.thomsontang.dp.proxy.hfdp.domain.PersonBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * step one: create the InvocationHandler
 * <p/>
 * the InvocationHandler for a person who is not himself to invoke.
 *
 * @author Thomson Tang
 */
public class NotOwnerInvocationHandler implements InvocationHandler {
    private PersonBean personBean;

    public NotOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().startsWith("get")) {
                method.invoke(personBean, args);
            } else if (method.getName().equals("setInterests")) {
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
                method.invoke(personBean, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
