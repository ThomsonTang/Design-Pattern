package com.thomsontang.dp.proxy.hfdp.domain;

/**
 * the interface describe the properties of a person and the rate rank for him.
 *
 * @author Thomson Tang
 */
public interface PersonBean {
    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRanking();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRanking(int rating) throws Exception;
}
