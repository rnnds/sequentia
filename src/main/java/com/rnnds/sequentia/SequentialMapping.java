package com.rnnds.sequentia;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SequentialMapping {

    int length();

    PadMode pad() default PadMode.RIGHT;

    char padCharacter() default ' ';

}
