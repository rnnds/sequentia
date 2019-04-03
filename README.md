# sequentia [![Build Status](https://travis-ci.org/rnnds/sequentia.svg?branch=master)](https://travis-ci.org/rnnds/sequentia)
Sequential data to Java objects

# Description

Given raw data:
~~~~
"John    00000300000015000"
~~~~

And a mapped bean:
~~~~
//...
public class Person {

    @SequentialMapping(begin = 0, end = 8)
    private String name;

    @SequentialMapping(begin = 9, end = 15)
    private Integer age;

    @SequentialMapping(begin = 16, end = 25)
    private Long income;
//...
~~~~
`com.rnnds.sequentia.Extractor` will retrieve a populated bean:
~~~~
Person result = new Extractor().extract(Person.class, "John    00000300000015000")
result.getName(); //John
result.getAge(); //30
result.getIncome(); //15000
~~~~

:+1:
