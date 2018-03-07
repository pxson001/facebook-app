package com.fasterxml.jackson.databind.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: getSmsInviteContacts */
public class HierarchicType {
    protected final Type f11099a;
    public final Class<?> f11100b;
    public final ParameterizedType f11101c;
    public HierarchicType f11102d;
    public HierarchicType f11103e;

    public HierarchicType(Type type) {
        this.f11099a = type;
        if (type instanceof Class) {
            this.f11100b = (Class) type;
            this.f11101c = null;
        } else if (type instanceof ParameterizedType) {
            this.f11101c = (ParameterizedType) type;
            this.f11100b = (Class) this.f11101c.getRawType();
        } else {
            throw new IllegalArgumentException("Type " + type.getClass().getName() + " can not be used to construct HierarchicType");
        }
    }

    private HierarchicType(Type type, Class<?> cls, ParameterizedType parameterizedType, HierarchicType hierarchicType, HierarchicType hierarchicType2) {
        this.f11099a = type;
        this.f11100b = cls;
        this.f11101c = parameterizedType;
        this.f11102d = hierarchicType;
        this.f11103e = hierarchicType2;
    }

    public final HierarchicType m11539a() {
        HierarchicType a = this.f11102d == null ? null : this.f11102d.m11539a();
        HierarchicType hierarchicType = new HierarchicType(this.f11099a, this.f11100b, this.f11101c, a, null);
        if (a != null) {
            a.f11103e = hierarchicType;
        }
        return hierarchicType;
    }

    public final void m11540a(HierarchicType hierarchicType) {
        this.f11102d = hierarchicType;
    }

    public final HierarchicType m11541b() {
        return this.f11102d;
    }

    public final void m11542b(HierarchicType hierarchicType) {
        this.f11103e = hierarchicType;
    }

    public final boolean m11543c() {
        return this.f11101c != null;
    }

    public final ParameterizedType m11544d() {
        return this.f11101c;
    }

    public final Class<?> m11545e() {
        return this.f11100b;
    }

    public String toString() {
        if (this.f11101c != null) {
            return this.f11101c.toString();
        }
        return this.f11100b.getName();
    }
}
