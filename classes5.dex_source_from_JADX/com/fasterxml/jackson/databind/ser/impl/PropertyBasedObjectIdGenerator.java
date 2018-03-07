package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

/* compiled from: circles */
public class PropertyBasedObjectIdGenerator extends PropertyGenerator {
    private static final long serialVersionUID = 1;
    protected final BeanPropertyWriter _property;

    private PropertyBasedObjectIdGenerator(Class<?> cls, BeanPropertyWriter beanPropertyWriter) {
        super(cls);
        this._property = beanPropertyWriter;
    }

    public final boolean mo635a(ObjectIdGenerator<?> objectIdGenerator) {
        if (objectIdGenerator.getClass() != getClass()) {
            return false;
        }
        PropertyBasedObjectIdGenerator propertyBasedObjectIdGenerator = (PropertyBasedObjectIdGenerator) objectIdGenerator;
        if (propertyBasedObjectIdGenerator.mo634a() == this._scope && propertyBasedObjectIdGenerator._property == this._property) {
            return true;
        }
        return false;
    }

    public PropertyBasedObjectIdGenerator(ObjectIdInfo objectIdInfo, BeanPropertyWriter beanPropertyWriter) {
        this(objectIdInfo.f6115c, beanPropertyWriter);
    }

    public final Object mo660b(Object obj) {
        try {
            return this._property.a(obj);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e2) {
            throw new IllegalStateException("Problem accessing property '" + this._property.c() + "': " + e2.getMessage(), e2);
        }
    }

    public final ObjectIdGenerator<Object> mo658a(Class<?> cls) {
        return cls == this._scope ? this : new PropertyBasedObjectIdGenerator((Class) cls, this._property);
    }

    public final ObjectIdGenerator<Object> mo659b() {
        return this;
    }

    public final IdKey mo657a(Object obj) {
        return new IdKey(getClass(), this._scope, obj);
    }
}
