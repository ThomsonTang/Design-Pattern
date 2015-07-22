package com.thomsontang.practice.dp.headfirst.proxypattern.protectionproxy;

/**
 * 描述人的属性相关的接口.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/1/13
 */
public interface PersonBean {
    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);
}
