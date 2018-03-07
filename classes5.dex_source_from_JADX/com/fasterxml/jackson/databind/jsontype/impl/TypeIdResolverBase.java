package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

/* compiled from: carrier_tracking_url */
public abstract class TypeIdResolverBase implements TypeIdResolver {
    protected final TypeFactory f6122c;
    protected final JavaType f6123d;

    protected TypeIdResolverBase(JavaType javaType, TypeFactory typeFactory) {
        this.f6123d = javaType;
        this.f6122c = typeFactory;
    }

    public final String mo714a() {
        return mo717a(null, this.f6123d._class);
    }
}
