package com.thomsontang.dp.proxy.hfdp;

import com.google.common.collect.ImmutableMap;

import com.thomsontang.dp.proxy.hfdp.domain.PersonBean;
import com.thomsontang.dp.proxy.hfdp.domain.PersonBeanImpl;

import java.util.Map;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class PersonDataMapGenerator {
    private Map<String, PersonBean> dataMap;

    public void init() {
        PersonBean tim = new PersonBeanImpl.Builder("tim", "male").interests("basketball").build();
        PersonBean mason = new PersonBeanImpl.Builder("mason", "male").interests("football").build();
        dataMap = ImmutableMap.of("tim", tim, "mason", mason);
    }

    public PersonBean getPersonFromDataMap(String name) {
        if (null != dataMap && dataMap.containsKey(name)) {
            return dataMap.get(name);
        }
        return null;
    }
}
