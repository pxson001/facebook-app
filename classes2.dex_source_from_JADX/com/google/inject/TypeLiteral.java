package com.google.inject;

import com.google.common.base.Preconditions;
import com.google.inject.internal.MoreTypes;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: x-edge-hit */
public class TypeLiteral<T> {
    public final Class<? super T> f666a;
    public final Type f667b;
    final int f668c;

    protected TypeLiteral() {
        this.f667b = m1373b(getClass());
        this.f666a = MoreTypes.m1379b(this.f667b);
        this.f668c = this.f667b.hashCode();
        m1374c();
    }

    public TypeLiteral(Type type) {
        this.f667b = MoreTypes.m1377a((Type) Preconditions.checkNotNull(type, "type"));
        this.f666a = MoreTypes.m1379b(this.f667b);
        this.f668c = this.f667b.hashCode();
        m1374c();
    }

    public static Type m1373b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return MoreTypes.m1377a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> m1375a() {
        return this.f666a;
    }

    public final int hashCode() {
        return this.f668c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeLiteral) && MoreTypes.m1378a(this.f667b, ((TypeLiteral) obj).f667b);
    }

    public final String toString() {
        return MoreTypes.m1381c(this.f667b);
    }

    public static TypeLiteral<?> m1372a(Type type) {
        return new TypeLiteral(type);
    }

    private void m1374c() {
        if (this.f666a.isPrimitive()) {
            throw new IllegalArgumentException("Primitive types are not allowed: " + this.f666a.getName());
        }
    }
}
