package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;

/* compiled from: celebsItems */
public class ObjectIdInfo {
    public final String f6113a;
    public final Class<? extends ObjectIdGenerator<?>> f6114b;
    public final Class<?> f6115c;
    public final boolean f6116d;

    public ObjectIdInfo(String str, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2) {
        this(str, cls, cls2, false);
    }

    private ObjectIdInfo(String str, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2, boolean z) {
        this.f6113a = str;
        this.f6115c = cls;
        this.f6114b = cls2;
        this.f6116d = z;
    }

    public final ObjectIdInfo m11371a(boolean z) {
        return this.f6116d == z ? this : new ObjectIdInfo(this.f6113a, this.f6115c, this.f6114b, z);
    }

    public final String m11372a() {
        return this.f6113a;
    }

    public final Class<?> m11373b() {
        return this.f6115c;
    }

    public final Class<? extends ObjectIdGenerator<?>> m11374c() {
        return this.f6114b;
    }

    public final boolean m11375d() {
        return this.f6116d;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("ObjectIdInfo: propName=").append(this.f6113a).append(", scope=");
        if (this.f6115c == null) {
            str = "null";
        } else {
            str = this.f6115c.getName();
        }
        append = append.append(str).append(", generatorType=");
        if (this.f6114b == null) {
            str = "null";
        } else {
            str = this.f6114b.getName();
        }
        return append.append(str).append(", alwaysAsId=").append(this.f6116d).toString();
    }
}
