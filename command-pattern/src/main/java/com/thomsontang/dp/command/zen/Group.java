package com.thomsontang.dp.command.zen;

/**
 * 抽象类Group，表示项目开发过程中的涉及到的“小组“
 *
 * @author Thomson Tang
 */
public abstract class Group {
    /**
     * 要和某个组交流，需要先找到这个组
     */
    public abstract void find();

    /**
     * 被要求增加某些功能
     */
    public abstract void add();

    /**
     * 被要求删除某些功能
     */
    public abstract void delete();

    /**
     * 被要求修改某些功能
     */
    public abstract void change();

    /**
     * 被要求给出所有的变更计划
     */
    public abstract void plan();
}
