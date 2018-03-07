package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;

/* compiled from: video_packet_loss_low */
public final class SerializerCache$TypeKey {
    protected int f256a;
    protected Class<?> f257b;
    protected JavaType f258c;
    protected boolean f259d;

    public SerializerCache$TypeKey(Class<?> cls, boolean z) {
        this.f257b = cls;
        this.f258c = null;
        this.f259d = z;
        this.f256a = m295a((Class) cls, z);
    }

    public SerializerCache$TypeKey(JavaType javaType, boolean z) {
        this.f258c = javaType;
        this.f257b = null;
        this.f259d = z;
        this.f256a = m294a(javaType, z);
    }

    private static final int m295a(Class<?> cls, boolean z) {
        int hashCode = cls.getName().hashCode();
        if (z) {
            return hashCode + 1;
        }
        return hashCode;
    }

    private static final int m294a(JavaType javaType, boolean z) {
        int hashCode = javaType.hashCode() - 1;
        if (z) {
            return hashCode - 1;
        }
        return hashCode;
    }

    public final void m297a(Class<?> cls) {
        this.f258c = null;
        this.f257b = cls;
        this.f259d = true;
        this.f256a = m295a((Class) cls, true);
    }

    public final void m299b(Class<?> cls) {
        this.f258c = null;
        this.f257b = cls;
        this.f259d = false;
        this.f256a = m295a((Class) cls, false);
    }

    public final void m296a(JavaType javaType) {
        this.f258c = javaType;
        this.f257b = null;
        this.f259d = true;
        this.f256a = m294a(javaType, true);
    }

    public final void m298b(JavaType javaType) {
        this.f258c = javaType;
        this.f257b = null;
        this.f259d = false;
        this.f256a = m294a(javaType, false);
    }

    public final int hashCode() {
        return this.f256a;
    }

    public final String toString() {
        if (this.f257b != null) {
            return "{class: " + this.f257b.getName() + ", typed? " + this.f259d + "}";
        }
        return "{type: " + this.f258c + ", typed? " + this.f259d + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        SerializerCache$TypeKey serializerCache$TypeKey = (SerializerCache$TypeKey) obj;
        if (serializerCache$TypeKey.f259d != this.f259d) {
            return false;
        }
        if (this.f257b == null) {
            return this.f258c.equals(serializerCache$TypeKey.f258c);
        }
        if (serializerCache$TypeKey.f257b == this.f257b) {
            return true;
        }
        return false;
    }
}
