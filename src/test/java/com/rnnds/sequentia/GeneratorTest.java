package com.rnnds.sequentia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeneratorTest {

    private static final Person JOHN = new Person("John", 30, 15000L);
    private static final Person MARY = new Person("Mary", 10, 0L);
    private final Generator generator = new Generator();

    @Test
    public void shouldReturnEmptyStringWithoutExpectedAnnotation() throws Exception {
        String result = generator.generate(new Object());
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldGenerateCorrectSequence() throws Exception {
        String result = generator.generate(JOHN);
        assertEquals("John    00000300000015000", result);
    }

}
