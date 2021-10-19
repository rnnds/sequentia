package com.rnnds.sequentia;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Strings.padEnd;
import static com.google.common.base.Strings.padStart;

public class Generator {

    public <T> String generate(final T mappedObject) throws Exception {
        String result = "";
        List<Field> fields = Optional.ofNullable(mappedObject)
                .map(Object::getClass)
                .map(Class::getDeclaredFields)
                .map(Arrays::asList)
                .orElse(new ArrayList<Field>());

        for (Field field : fields) {
            Object value = BeanUtils.getProperty(mappedObject, field.getName());
            result += processValue(field, value);
        }
        return result;
    }

    private String processValue(Field field, Object value) {
        SequentialMapping annotation = field.getAnnotation(SequentialMapping.class);
        int length = annotation.length();
        char padChar = annotation.padCharacter();

        if (PadMode.LEFT.equals(annotation.pad())) {
            return padEnd(value.toString(), length, padChar);
        }
        return padStart(value.toString(), length, padChar);
    }

}
