package com.thomson.dp.principle.zen.lsp;

import com.thomson.dp.principle.zen.lsp.domain.AUG;
import com.thomson.dp.principle.zen.lsp.domain.Snipper;

/**
 * 狙击枪业务场景类
 * 可以体现里氏替换原则中"子类可以有自己的特定方法"的含义。
 *
 * @author Thomson Tang
 */
public class SnipperClient {
    public static void main(String[] args) {
        //生成三毛狙击手
        Snipper sanMao = new Snipper();
        //杀敌
        sanMao.killEnemy(new AUG()); //这里系统直接调用了子类，一个狙击手是很依赖枪支的
    }
}
