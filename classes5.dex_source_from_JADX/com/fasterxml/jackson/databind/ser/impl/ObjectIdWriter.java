package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;

/* compiled from: can_viewer_suggest_location */
public final class ObjectIdWriter {
    public final JavaType f6166a;
    public final SerializedString f6167b;
    public final ObjectIdGenerator<?> f6168c;
    public final JsonSerializer<Object> f6169d;
    public final boolean f6170e;

    private ObjectIdWriter(JavaType javaType, SerializedString serializedString, ObjectIdGenerator<?> objectIdGenerator, JsonSerializer<?> jsonSerializer, boolean z) {
        this.f6166a = javaType;
        this.f6167b = serializedString;
        this.f6168c = objectIdGenerator;
        this.f6169d = jsonSerializer;
        this.f6170e = z;
    }

    public static ObjectIdWriter m11602a(JavaType javaType, String str, ObjectIdGenerator<?> objectIdGenerator, boolean z) {
        return new ObjectIdWriter(javaType, str == null ? null : new SerializedString(str), objectIdGenerator, null, z);
    }

    public final ObjectIdWriter m11603a(JsonSerializer<?> jsonSerializer) {
        return new ObjectIdWriter(this.f6166a, this.f6167b, this.f6168c, jsonSerializer, this.f6170e);
    }

    public final ObjectIdWriter m11604a(boolean z) {
        return z == this.f6170e ? this : new ObjectIdWriter(this.f6166a, this.f6167b, this.f6168c, this.f6169d, z);
    }
}
