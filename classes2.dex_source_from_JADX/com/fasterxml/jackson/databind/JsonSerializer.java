package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: status_code */
public abstract class JsonSerializer<T> {
    public abstract void mo1072a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    public JsonSerializer<T> m7346a(NameTransformer nameTransformer) {
        return this;
    }

    public void mo1074a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        Class a = mo1073a();
        if (a == null) {
            a = t.getClass();
        }
        throw new UnsupportedOperationException("Type id handling not implemented for type " + a.getName());
    }

    public Class<T> mo1073a() {
        return null;
    }

    public boolean mo1102a(T t) {
        return t == null;
    }

    public boolean m7351b() {
        return false;
    }

    public boolean m7352c() {
        return false;
    }
}
