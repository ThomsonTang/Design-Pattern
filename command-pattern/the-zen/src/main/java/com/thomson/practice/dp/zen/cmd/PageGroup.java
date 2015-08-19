package com.thomson.practice.dp.zen.cmd;

/**
 * 美工组
 *
 * @author Thomson Tang
 */
public class PageGroup extends Group {
    @Override
    public void find() {
        System.out.println("找到美工组...");
    }

    @Override
    public void add() {
        System.out.println("客户要求增加一个页面...");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一个页面...");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一个页面...");
    }

    @Override
    public void plan() {
        System.out.println("客户要求给出变更计划...");
    }
}
