package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.JsonDeserializer;

/* compiled from: ci */
public abstract class ContainerDeserializerBase<T> extends StdDeserializer<T> {
    public abstract JsonDeserializer<Object> mo662e();

    protected ContainerDeserializerBase(Class<?> cls) {
        super(cls);
    }
}
