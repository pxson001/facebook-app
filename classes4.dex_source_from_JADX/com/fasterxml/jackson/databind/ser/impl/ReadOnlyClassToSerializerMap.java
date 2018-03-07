package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache$TypeKey;
import java.util.HashMap;

/* compiled from: video_resize_frame_rate */
public final class ReadOnlyClassToSerializerMap {
    protected final JsonSerializerMap f248a;
    protected SerializerCache$TypeKey f249b = null;

    private ReadOnlyClassToSerializerMap(JsonSerializerMap jsonSerializerMap) {
        this.f248a = jsonSerializerMap;
    }

    public final ReadOnlyClassToSerializerMap m288a() {
        return new ReadOnlyClassToSerializerMap(this.f248a);
    }

    public static ReadOnlyClassToSerializerMap m285a(HashMap<SerializerCache$TypeKey, JsonSerializer<Object>> hashMap) {
        return new ReadOnlyClassToSerializerMap(new JsonSerializerMap(hashMap));
    }

    public final JsonSerializer<Object> m286a(JavaType javaType) {
        if (this.f249b == null) {
            this.f249b = new SerializerCache$TypeKey(javaType, true);
        } else {
            this.f249b.m296a(javaType);
        }
        return this.f248a.m292a(this.f249b);
    }

    public final JsonSerializer<Object> m287a(Class<?> cls) {
        if (this.f249b == null) {
            this.f249b = new SerializerCache$TypeKey((Class) cls, true);
        } else {
            this.f249b.m297a((Class) cls);
        }
        return this.f248a.m292a(this.f249b);
    }

    public final JsonSerializer<Object> m289b(JavaType javaType) {
        if (this.f249b == null) {
            this.f249b = new SerializerCache$TypeKey(javaType, false);
        } else {
            this.f249b.m298b(javaType);
        }
        return this.f248a.m292a(this.f249b);
    }

    public final JsonSerializer<Object> m290b(Class<?> cls) {
        if (this.f249b == null) {
            this.f249b = new SerializerCache$TypeKey((Class) cls, false);
        } else {
            this.f249b.m299b((Class) cls);
        }
        return this.f248a.m292a(this.f249b);
    }
}
