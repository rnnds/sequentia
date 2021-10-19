# sequentia [![Build Status](https://travis-ci.org/rnnds/sequentia.svg?branch=master)](https://travis-ci.org/rnnds/sequentia)
Sequential data to Java objects

# Description

## Extracting data

Given raw data:
~~~~
"John    00000300000015000"
~~~~

And a mapped bean:
~~~~
//...
public class Person {

    @SequentialMapping(length = 8)
    private String name;

    @SequentialMapping(length = 7, pad = LEFT, padCharacter = '0')
    private Integer age;

    @SequentialMapping(length = 10, pad = LEFT, padCharacter = '0')
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

## Generating data

Given a mapped bean:
~~~~
//...
public class Person {

    @SequentialMapping(length = 5)
    private String name = "Peter";

    @SequentialMapping(length = 5, pad = LEFT, padCharacter = '0')
    private Integer age;
//...
~~~~
`com.rnnds.sequentia.Generator` will retrieve:
~~~~
new Generator().generate(new Person()); //Peter00050
~~~~

:+1:
