package com.thomson.practice.dp.hf.proxy.dynamic;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Test the Java Dynamic Proxy API.
 *
 * @author Thomson Tang
 */
public class DynamicProxyTest {
  public static final Logger logger = LoggerFactory.getLogger(DynamicProxyTest.class);

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  PersonDataMapGenerator dataMapGenerator;

  @Before
  public void prepare() {
    logger.info("prepare the data map");
    dataMapGenerator = new PersonDataMapGenerator();
    dataMapGenerator.init();
    logger.info("the data map was prepared.");
  }

  @Test
  public void testPersonOwnProxyGetMethods() {
    logger.info("start to test own proxy get methods...");
    PersonBean personBean = dataMapGenerator.getPersonFromDataMap("tim");
    PersonBean ownProxy = PersonBeanProxyFactory.getOwnProxy(personBean);
    assertEquals("tim", ownProxy.getName());
    assertEquals("male", ownProxy.getGender());
    assertEquals("basketball", ownProxy.getInterests());
    logger.debug("tim proxy, name: {}, gender: {}", ownProxy.getName(), ownProxy.getGender());
    logger.info("test success.");
  }

  @Test
  public void testPersonOwnProxySetHotOrNotRankingMethod() throws Exception {
    logger.info("start to test own proxy setHotOrNotRaking method...");
    PersonBean tim = dataMapGenerator.getPersonFromDataMap("tim");
    PersonBean ownProxy = PersonBeanProxyFactory.getOwnProxy(tim);
    thrown.expect(IllegalAccessException.class);
    ownProxy.setHotOrNotRanking(10);
    logger.debug("get the ranking: {}", ownProxy.getHotOrNotRanking());
    logger.info("test success.");
  }

  public void testPersonNonOwnProxyGetMethods() {

  }
}
