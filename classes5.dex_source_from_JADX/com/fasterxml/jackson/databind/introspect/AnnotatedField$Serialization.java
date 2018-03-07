package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Field;

/* compiled from: channel-mask */
final class AnnotatedField$Serialization implements Serializable {
    private static final long serialVersionUID = 1;
    protected Class<?> clazz;
    protected String name;

    public AnnotatedField$Serialization(Field field) {
        this.clazz = field.getDeclaringClass();
        this.name = field.getName();
    }
}
