package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: vault_blacklisted_sync_paths */
public abstract class PropertySerializerMap {

    /* compiled from: vault_blacklisted_sync_paths */
    public final class Empty extends PropertySerializerMap {
        public static final Empty f359a = new Empty();

        private Empty() {
        }

        public final JsonSerializer<Object> mo48a(Class<?> cls) {
            return null;
        }

        public final PropertySerializerMap mo49a(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Single(cls, jsonSerializer);
        }
    }

    /* compiled from: vault_blacklisted_sync_paths */
    public final class SerializerAndMapResult {
        public final JsonSerializer<Object> f391a;
        public final PropertySerializerMap f392b;

        public SerializerAndMapResult(JsonSerializer<Object> jsonSerializer, PropertySerializerMap propertySerializerMap) {
            this.f391a = jsonSerializer;
            this.f392b = propertySerializerMap;
        }
    }

    /* compiled from: vault_blacklisted_sync_paths */
    final class Single extends PropertySerializerMap {
        private final Class<?> f393a;
        private final JsonSerializer<Object> f394b;

        public Single(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            this.f393a = cls;
            this.f394b = jsonSerializer;
        }

        public final JsonSerializer<Object> mo48a(Class<?> cls) {
            if (cls == this.f393a) {
                return this.f394b;
            }
            return null;
        }

        public final PropertySerializerMap mo49a(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Double(this.f393a, this.f394b, cls, jsonSerializer);
        }
    }

    public abstract JsonSerializer<Object> mo48a(Class<?> cls);

    public abstract PropertySerializerMap mo49a(Class<?> cls, JsonSerializer<Object> jsonSerializer);

    public final SerializerAndMapResult m603a(Class<?> cls, SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer a = serializerProvider.a(cls, beanProperty);
        return new SerializerAndMapResult(a, mo49a(cls, a));
    }

    public final SerializerAndMapResult m602a(JavaType javaType, SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer a = serializerProvider.a(javaType, beanProperty);
        return new SerializerAndMapResult(a, mo49a(javaType._class, a));
    }

    public static PropertySerializerMap m600a() {
        return Empty.f359a;
    }
}
