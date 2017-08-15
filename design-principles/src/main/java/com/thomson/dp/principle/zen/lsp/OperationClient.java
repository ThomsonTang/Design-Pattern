package com.thomson.dp.principle.zen.lsp;

import com.thomson.dp.principle.zen.lsp.domain.Operation;
import com.thomson.dp.principle.zen.lsp.domain.SubOperation;

/**
 * 里氏替换原则
 * 子类复写父类方法后导致的异常问题
 *
 * @author Thomson Tang
 */
public class OperationClient {
    public static void main(String[] args) {
        Operation operation = new Operation();
        System.out.println("60+40=" + operation.m1(60, 40));

        SubOperation subOperation = new SubOperation();
        System.out.println("60+40=" + subOperation.m1(60, 40));
        System.out.println("60-40+100=" + subOperation.m2(60, 40));
    }
}
