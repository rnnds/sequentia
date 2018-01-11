package com.rnnds.sequentia;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class ExtractorTest {

    private static final Person JOHN = new Person("John", 30, 15000L);
    private static final Person MARY = new Person("Mary", 10, 0L);
    private final Extractor extractor = new Extractor();

    @Test
    public void shouldExtractFromPath() throws Exception {
        Path path = Paths.get("src/test/resources/person-test.txt");
        List<Person> result = extractor.extract(Person.class, path);
        assertArrayEquals(new Person[] { JOHN, MARY }, result.toArray());
    }

    @Test
    public void shouldExtractFromString() throws Exception {
        Person result = extractor.extract(Person.class, "John    00000300000015000");
        assertEquals(JOHN, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNoClassWithPath() throws Exception {
        extractor.extract(null, Paths.get(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNoClassWithString() throws Exception {
        extractor.extract(null, "");
    }

}
