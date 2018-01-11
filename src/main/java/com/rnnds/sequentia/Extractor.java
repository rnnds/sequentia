package com.rnnds.sequentia;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;
import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.beanutils.ConvertUtils.convert;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Extractor {

    public <T> List<T> extract(final Class<T> clazz, final Path path) throws Exception {
        List<ExtractionMapping> mappings = retrieveMappings(clazz);
        return build(clazz, mappings, lines(path));
    }

    public <T> T extract(final Class<T> clazz, final String value) throws Exception {
        List<ExtractionMapping> mappings = retrieveMappings(clazz);
        return build(clazz, mappings, value);
    }

    private List<ExtractionMapping> retrieveMappings(final Class<?> clazz) {
        checkArgument(clazz != null);
        return Stream.of(clazz.getDeclaredFields())
                .map((field) -> toMapping(field))
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private ExtractionMapping toMapping(final Field field) {
        SequentialMapping annotation = field.getAnnotation(SequentialMapping.class);
        if (annotation != null) {
            return new ExtractionMapping(field.getName(), field.getType(), annotation.begin(), annotation.end());
        }
        return null;
    }

    private <T> List<T> build(final Class<T> clazz, final List<ExtractionMapping> mappings, final Stream<String> lines)
            throws Exception {
        List<T> extracted = newArrayList();
        for (String line : lines.collect(toList())) {
            extracted.add(build(clazz, mappings, line));
        }
        return extracted;
    }

    private <T> T build(final Class<T> clazz, final List<ExtractionMapping> mappings, final String line)
            throws Exception {
        T current = clazz.newInstance();
        for (ExtractionMapping mapping : mappings) {
            Field field = clazz.getDeclaredField(mapping.getField());
            field.setAccessible(true);
            String value = line.substring(mapping.getBegin(), mapping.getEnd()).trim();
            field.set(current, convert(value, mapping.getType()));
        }
        return current;
    }

}
