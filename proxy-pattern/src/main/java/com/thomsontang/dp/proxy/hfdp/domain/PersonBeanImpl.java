package com.thomsontang.dp.proxy.hfdp.domain;

/**
 * the implementation of PersonBean.
 *
 * @author Thomson Tang
 */
public class PersonBeanImpl implements PersonBean {
    private final String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount;


    public static class Builder {
        private String name;
        private String gender;

        private String interests;
        private int rating = 0;
        private int ratingCount = 0;

        public Builder() {
        }

        public Builder(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public Builder name(String val) {
            this.name = val;
            return this;
        }

        public Builder gender(String val) {
            this.gender = val;
            return this;
        }

        public Builder interests(String val) {
            interests = val;
            return this;
        }

        public Builder rating(int val) {
            this.rating = val;
            return this;
        }

        public PersonBeanImpl build() {
            return new PersonBeanImpl(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private PersonBeanImpl(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.interests = builder.interests;
        this.rating = builder.rating;
        this.ratingCount = builder.ratingCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public String getInterests() {
        return this.interests;
    }

    @Override
    public int getHotOrNotRanking() {
        if (ratingCount == 0)
            return 0;
        return (rating / ratingCount);
    }

    @Override
    public void setName(String name) {
        builder().name = name;
    }

    @Override
    public void setGender(String gender) {
        builder().gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRanking(int rating) {
        this.rating += rating;
        this.ratingCount++;
    }
}
