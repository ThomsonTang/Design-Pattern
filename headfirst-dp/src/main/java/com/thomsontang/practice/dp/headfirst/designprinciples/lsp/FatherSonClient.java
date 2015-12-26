package designprinciples.lsp;

import java.util.HashMap;
import java.util.Map;

/**
 * 父类子类场景类
 *
 * @author Thomson Tang
 */
public class FatherSonClient {
    public static void invoker() {
//        Father father = new Father();
        Son f = new Son(); //父类出现的地方，子类就应该能够出现
        HashMap hashMap = new HashMap();
        f.doSomething(hashMap);
    }

    public static void main(String[] args) {
        invoker();
    }
}
