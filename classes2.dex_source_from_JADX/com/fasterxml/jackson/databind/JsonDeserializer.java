package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.util.Collection;

/* compiled from: push_connected_in_flight */
public abstract class JsonDeserializer<T> {
    public abstract T mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext);

    public T m13368a(JsonParser jsonParser, DeserializationContext deserializationContext, T t) {
        throw new UnsupportedOperationException("Can not update object of type " + t.getClass().getName() + " (by deserializer of type " + getClass().getName() + ")");
    }

    public Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.d(jsonParser, deserializationContext);
    }

    public JsonDeserializer<T> m13364a(NameTransformer nameTransformer) {
        return this;
    }

    public T mo1798a() {
        return null;
    }

    public final T m13369b() {
        return mo1798a();
    }

    public Collection<Object> m13370c() {
        return null;
    }

    public boolean mo1881d() {
        return false;
    }
}
