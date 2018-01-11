package com.rnnds.sequentia;

class ExtractionMapping {

    private final String field;
    private final Class<?> type;
    private final int begin;
    private final int end;

    public ExtractionMapping(final String field, final Class<?> type, final int begin, final int end) {
        this.field = field;
        this.type = type;
        this.begin = begin;
        this.end = end;
    }

    public String getField() {
        return field;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public Class<?> getType() {
        return type;
    }
}
