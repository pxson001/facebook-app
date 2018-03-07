package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import java.util.HashMap;

/* compiled from: status_bar_height */
public final class SerializerCache {
    private HashMap<TypeKey, JsonSerializer<Object>> f4139a = new HashMap(64);
    private ReadOnlyClassToSerializerMap f4140b = null;

    public final ReadOnlyClassToSerializerMap m7359a() {
        ReadOnlyClassToSerializerMap readOnlyClassToSerializerMap;
        synchronized (this) {
            readOnlyClassToSerializerMap = this.f4140b;
            if (readOnlyClassToSerializerMap == null) {
                readOnlyClassToSerializerMap = ReadOnlyClassToSerializerMap.a(this.f4139a);
                this.f4140b = readOnlyClassToSerializerMap;
            }
        }
        return readOnlyClassToSerializerMap.a();
    }

    public final JsonSerializer<Object> m7358a(Class<?> cls) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = (JsonSerializer) this.f4139a.get(new TypeKey(cls, false));
        }
        return jsonSerializer;
    }

    public final JsonSerializer<Object> m7357a(JavaType javaType) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = (JsonSerializer) this.f4139a.get(new TypeKey(javaType, false));
        }
        return jsonSerializer;
    }

    public final JsonSerializer<Object> m7364b(JavaType javaType) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = (JsonSerializer) this.f4139a.get(new TypeKey(javaType, true));
        }
        return jsonSerializer;
    }

    public final JsonSerializer<Object> m7365b(Class<?> cls) {
        JsonSerializer<Object> jsonSerializer;
        synchronized (this) {
            jsonSerializer = (JsonSerializer) this.f4139a.get(new TypeKey(cls, true));
        }
        return jsonSerializer;
    }

    public final void m7360a(JavaType javaType, JsonSerializer<Object> jsonSerializer) {
        synchronized (this) {
            if (this.f4139a.put(new TypeKey(javaType, true), jsonSerializer) == null) {
                this.f4140b = null;
            }
        }
    }

    public final void m7362a(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
        synchronized (this) {
            if (this.f4139a.put(new TypeKey(cls, true), jsonSerializer) == null) {
                this.f4140b = null;
            }
        }
    }

    public final void m7363a(Class<?> cls, JsonSerializer<Object> jsonSerializer, SerializerProvider serializerProvider) {
        synchronized (this) {
            if (this.f4139a.put(new TypeKey(cls, false), jsonSerializer) == null) {
                this.f4140b = null;
            }
            if (jsonSerializer instanceof ResolvableSerializer) {
                ((ResolvableSerializer) jsonSerializer).a(serializerProvider);
            }
        }
    }

    public final void m7361a(JavaType javaType, JsonSerializer<Object> jsonSerializer, SerializerProvider serializerProvider) {
        synchronized (this) {
            if (this.f4139a.put(new TypeKey(javaType, false), jsonSerializer) == null) {
                this.f4140b = null;
            }
            if (jsonSerializer instanceof ResolvableSerializer) {
                ((ResolvableSerializer) jsonSerializer).a(serializerProvider);
            }
        }
    }
}
