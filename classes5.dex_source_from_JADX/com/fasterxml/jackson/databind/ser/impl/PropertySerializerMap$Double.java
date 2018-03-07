package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;

/* compiled from: can_viewer_subscribe */
final class PropertySerializerMap$Double extends PropertySerializerMap {
    private final Class<?> f6171a;
    private final Class<?> f6172b;
    private final JsonSerializer<Object> f6173c;
    private final JsonSerializer<Object> f6174d;

    public PropertySerializerMap$Double(Class<?> cls, JsonSerializer<Object> jsonSerializer, Class<?> cls2, JsonSerializer<Object> jsonSerializer2) {
        this.f6171a = cls;
        this.f6173c = jsonSerializer;
        this.f6172b = cls2;
        this.f6174d = jsonSerializer2;
    }

    public final JsonSerializer<Object> m11610a(Class<?> cls) {
        if (cls == this.f6171a) {
            return this.f6173c;
        }
        if (cls == this.f6172b) {
            return this.f6174d;
        }
        return null;
    }

    public final PropertySerializerMap m11611a(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
        return new PropertySerializerMap$Multi(new PropertySerializerMap$TypeAndSerializer[]{new PropertySerializerMap$TypeAndSerializer(this.f6171a, this.f6173c), new PropertySerializerMap$TypeAndSerializer(this.f6172b, this.f6174d)});
    }
}
