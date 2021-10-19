package com.rnnds.sequentia;

class ExtractionMapping {

    private final String field;
    private final Class<?> type;
    private final int length;

    public ExtractionMapping(final String field, final Class<?> type, final int length) {
        this.field = field;
        this.type = type;
        this.length = length;
    }

    public String getField() {
        return field;
    }

    public int getLength() {
        return length;
    }

    public Class<?> getType() {
        return type;
    }
}
