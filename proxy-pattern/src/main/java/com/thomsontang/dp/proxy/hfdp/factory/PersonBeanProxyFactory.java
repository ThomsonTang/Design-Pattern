package com.thomsontang.dp.proxy.hfdp.factory;

import com.thomsontang.dp.proxy.hfdp.domain.PersonBean;
import com.thomsontang.dp.proxy.hfdp.handler.NotOwnerInvocationHandler;
import com.thomsontang.dp.proxy.hfdp.handler.OwnerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * The factory to get the person bean proxy.
 * <p/>
 * Step two: write the code to create the Proxy.
 *
 * @author Thomson Tang
 */
public class PersonBeanProxyFactory {

  /**
   * get the own proxy of a person
   *
   * @param personBean the real subject person
   * @return the proxy person
   */
  public static PersonBean getOwnProxy(PersonBean personBean) {
    return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
        personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
  }

  /**
   * get the not own proxy of a person
   *
   * @param personBean the real subject person
   * @return the proxy person
   */
  public static PersonBean getNotOwnProxy(PersonBean personBean) {
    return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
        personBean.getClass().getInterfaces(), new NotOwnerInvocationHandler(personBean));
  }
}
