package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.Serializable;

/* compiled from: city_name */
public final class ObjectIdReader implements Serializable {
    private static final long serialVersionUID = 1;
    public final JsonDeserializer<Object> deserializer;
    public final ObjectIdGenerator<?> generator;
    public final SettableBeanProperty idProperty;
    public final JavaType idType;
    public final String propertyName;

    private ObjectIdReader(JavaType javaType, String str, ObjectIdGenerator<?> objectIdGenerator, JsonDeserializer<?> jsonDeserializer, SettableBeanProperty settableBeanProperty) {
        this.idType = javaType;
        this.propertyName = str;
        this.generator = objectIdGenerator;
        this.deserializer = jsonDeserializer;
        this.idProperty = settableBeanProperty;
    }

    public static ObjectIdReader m11079a(JavaType javaType, String str, ObjectIdGenerator<?> objectIdGenerator, JsonDeserializer<?> jsonDeserializer, SettableBeanProperty settableBeanProperty) {
        return new ObjectIdReader(javaType, str, objectIdGenerator, jsonDeserializer, settableBeanProperty);
    }
}
