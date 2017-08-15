package com.thomson.dp.principle.zen.lsp.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 父类
 *
 * @author Thomson Tang
 */
public class Father {
    public Collection doSomething(Map map) {
        System.out.println("父类被执行.....");
        return map.values();
    }
}
