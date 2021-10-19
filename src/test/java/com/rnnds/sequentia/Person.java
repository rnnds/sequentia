package com.rnnds.sequentia;

import com.google.common.base.Objects;

import static com.google.common.base.Objects.equal;
import static com.rnnds.sequentia.PadMode.LEFT;
import static com.rnnds.sequentia.PadMode.RIGHT;

public class Person {

    @SequentialMapping(length = 8)
    private String name;

    @SequentialMapping(length = 7, pad = LEFT, padCharacter = '0')
    private Integer age;

    @SequentialMapping(length = 10, pad = LEFT, padCharacter = '0')
    private Long income;

    public Person() {
    }

    public Person(final String name, final int age, final Long income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(final Long income) {
        this.income = income;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.age, this.income);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else {
            if (obj instanceof Person) {
                Person that = (Person) obj;
                return equal(this.name, that.name) && equal(this.age, that.age) && equal(this.income, that.income);
            }
            return false;
        }
    }

}
