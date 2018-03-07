package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;

/* compiled from: can_viewer_subscribe */
final class PropertySerializerMap$Multi extends PropertySerializerMap {
    private final PropertySerializerMap$TypeAndSerializer[] f6175a;

    public PropertySerializerMap$Multi(PropertySerializerMap$TypeAndSerializer[] propertySerializerMap$TypeAndSerializerArr) {
        this.f6175a = propertySerializerMap$TypeAndSerializerArr;
    }

    public final JsonSerializer<Object> m11612a(Class<?> cls) {
        for (PropertySerializerMap$TypeAndSerializer propertySerializerMap$TypeAndSerializer : this.f6175a) {
            if (propertySerializerMap$TypeAndSerializer.f6176a == cls) {
                return propertySerializerMap$TypeAndSerializer.f6177b;
            }
        }
        return null;
    }

    public final PropertySerializerMap m11613a(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
        int length = this.f6175a.length;
        if (length == 8) {
            return this;
        }
        Object obj = new PropertySerializerMap$TypeAndSerializer[(length + 1)];
        System.arraycopy(this.f6175a, 0, obj, 0, length);
        obj[length] = new PropertySerializerMap$TypeAndSerializer(cls, jsonSerializer);
        this(obj);
        return this;
    }
}
