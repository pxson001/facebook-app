package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Method;

/* compiled from: channel-count */
final class AnnotatedMethod$Serialization implements Serializable {
    private static final long serialVersionUID = 1;
    protected Class<?>[] args;
    protected Class<?> clazz;
    protected String name;

    public AnnotatedMethod$Serialization(Method method) {
        this.clazz = method.getDeclaringClass();
        this.name = method.getName();
        this.args = method.getParameterTypes();
    }
}
