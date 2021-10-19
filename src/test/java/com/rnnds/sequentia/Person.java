package com.rnnds.sequentia;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.rnnds.sequentia.PadMode.LEFT;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {

    @SequentialMapping(length = 8)
    private String name;

    @SequentialMapping(length = 7, pad = LEFT, padCharacter = '0')
    private Integer age;

    @SequentialMapping(length = 10, pad = LEFT, padCharacter = '0')
    private Long income;

}
