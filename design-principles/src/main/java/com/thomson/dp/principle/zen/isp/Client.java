package com.thomson.dp.principle.zen.isp;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class Client {
    public static void main(String[] args) {
        // 类A通过接口I依赖类B
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        // 类C通过接口I依赖类D
        C c = new C();
        c.depend1(new D());
        c.depend2(new D());
        c.depend3(new D());
    }
}
