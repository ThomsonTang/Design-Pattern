package com.thomson.practice.dp.zen.cmd;

/**
 * 需求组
 *
 * @author Thomson Tang
 */
public class RequirementGroup extends Group {

    @Override
    public void find() {
        System.out.println("客户找到需求组..."); // 客户要求需求组过去和他们谈需求
    }

    @Override
    public void add() {
        System.out.println("客户要求增加一项需求...");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一项需求...");
    }

    @Override
    public void change() {
        System.out.println("客户要求更改一项需求...");
    }

    @Override
    public void plan() {
        System.out.println("客户要求需求变更计划...");
    }
}
