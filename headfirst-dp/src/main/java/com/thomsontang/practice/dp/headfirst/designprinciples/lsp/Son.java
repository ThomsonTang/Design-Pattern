package designprinciples.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 子类
 *
 * @author Thomson Tang
 */
public class Son extends Father {

    public Collection doSomething(HashMap map) {
        System.out.println("子类被执行.....");
        return map.values();
    }
}
