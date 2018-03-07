package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/* compiled from: channel_id */
final class AnnotatedConstructor$Serialization implements Serializable {
    private static final long serialVersionUID = 1;
    protected Class<?>[] args;
    protected Class<?> clazz;

    public AnnotatedConstructor$Serialization(Constructor<?> constructor) {
        this.clazz = constructor.getDeclaringClass();
        this.args = constructor.getParameterTypes();
    }
}
