package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: category_icon */
public abstract class TypeSerializerBase extends TypeSerializer {
    protected final TypeIdResolver f6118b;
    protected final BeanProperty f6119c;

    protected TypeSerializerBase(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        this.f6118b = typeIdResolver;
        this.f6119c = beanProperty;
    }

    protected final String m11427a(Object obj) {
        return this.f6118b.mo716a(obj);
    }

    protected final String m11428a(Object obj, Class<?> cls) {
        return this.f6118b.mo717a(obj, cls);
    }
}
