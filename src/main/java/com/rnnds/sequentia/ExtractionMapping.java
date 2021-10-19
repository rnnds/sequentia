package com.rnnds.sequentia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ExtractionMapping {

    private final String field;
    private final Class<?> type;
    private final int length;

}
