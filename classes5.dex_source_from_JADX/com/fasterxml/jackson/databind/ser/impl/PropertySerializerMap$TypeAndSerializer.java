package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;

/* compiled from: can_viewer_subscribe */
final class PropertySerializerMap$TypeAndSerializer {
    public final Class<?> f6176a;
    public final JsonSerializer<Object> f6177b;

    public PropertySerializerMap$TypeAndSerializer(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
        this.f6176a = cls;
        this.f6177b = jsonSerializer;
    }
}
