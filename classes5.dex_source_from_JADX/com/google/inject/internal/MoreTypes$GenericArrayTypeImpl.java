package com.google.inject.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: bugReport_bs */
public class MoreTypes$GenericArrayTypeImpl implements MoreTypes$CompositeType, Serializable, GenericArrayType {
    private final Type componentType;

    public MoreTypes$GenericArrayTypeImpl(Type type) {
        this.componentType = MoreTypes.a(type);
    }

    public Type getGenericComponentType() {
        return this.componentType;
    }

    public final boolean mo1019a() {
        return MoreTypes.e(this.componentType);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && MoreTypes.a(this, (GenericArrayType) obj);
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        return MoreTypes.c(this.componentType) + "[]";
    }
}
