package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pulsar/ */
public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {
    private static final long serialVersionUID = 1;

    protected abstract T mo1800a(String str, DeserializationContext deserializationContext);

    protected FromStringDeserializer(Class<?> cls) {
        super(cls);
    }

    public final T mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String I = jsonParser.mo1753I();
        if (I != null) {
            if (I.length() == 0) {
                return null;
            }
            I = I.trim();
            if (I.length() == 0) {
                return null;
            }
            try {
                T a = mo1800a(I, deserializationContext);
                if (a != null) {
                    return a;
                }
            } catch (IllegalArgumentException e) {
            }
            throw deserializationContext.m7387a(I, this._valueClass, "not a valid textual representation");
        } else if (jsonParser.mo1794g() == JsonToken.VALUE_EMBEDDED_OBJECT) {
            Object D = jsonParser.mo1776D();
            if (D == null) {
                return null;
            }
            if (this._valueClass.isAssignableFrom(D.getClass())) {
                return D;
            }
            return m13427a(D, deserializationContext);
        } else {
            throw deserializationContext.m7397b(this._valueClass);
        }
    }

    protected T m13427a(Object obj, DeserializationContext deserializationContext) {
        throw deserializationContext.m7402c("Don't know how to convert embedded Object of type " + obj.getClass().getName() + " into " + this._valueClass.getName());
    }
}
