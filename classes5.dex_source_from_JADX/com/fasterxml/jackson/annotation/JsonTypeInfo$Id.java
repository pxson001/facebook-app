package com.fasterxml.jackson.annotation;

/* compiled from: color_palette */
public enum JsonTypeInfo$Id {
    NONE(null),
    CLASS("@class"),
    MINIMAL_CLASS("@c"),
    NAME("@type"),
    CUSTOM(null);
    
    private final String _defaultPropertyName;

    private JsonTypeInfo$Id(String str) {
        this._defaultPropertyName = str;
    }

    public final String getDefaultPropertyName() {
        return this._defaultPropertyName;
    }
}
