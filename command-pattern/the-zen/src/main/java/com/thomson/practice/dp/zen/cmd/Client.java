package com.thomson.practice.dp.zen.cmd;

/**
 * 客户类, 需求变化的场景类
 *
 * @author Thomson Tang
 */
public class Client {
    public static void main(String[] args) {
        // 客户首先找到需求组，开始谈需求
        System.out.println("--------客户要求增加一项新功能...");

        Group group = new RequirementGroup();
        group.find();
        group.add();
        group.plan();

        System.out.println("--------客户要求删除一个新页面...");
        Group group1 = new PageGroup();
        group1.find();
        group1.delete();
        group1.plan();
    }
}
