package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

/* compiled from: circles */
public class PropertyBasedObjectIdGenerator extends PropertyGenerator {
    private static final long serialVersionUID = 1;

    public PropertyBasedObjectIdGenerator(Class<?> cls) {
        super(cls);
    }

    public final Object mo660b(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final ObjectIdGenerator<Object> mo658a(Class<?> cls) {
        if (cls == this._scope) {
            return this;
        }
        this(cls);
        return this;
    }

    public final ObjectIdGenerator<Object> mo659b() {
        return this;
    }

    public final IdKey mo657a(Object obj) {
        return new IdKey(getClass(), this._scope, obj);
    }
}
