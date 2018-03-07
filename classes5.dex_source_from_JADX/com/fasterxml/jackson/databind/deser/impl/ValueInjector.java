package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;

/* compiled from: ci_bkg */
public class ValueInjector extends Std {
    protected final Object f6059g;

    public ValueInjector(String str, JavaType javaType, Annotations annotations, AnnotatedMember annotatedMember, Object obj) {
        super(str, javaType, null, annotations, annotatedMember, false);
        this.f6059g = obj;
    }

    private Object m11123b(DeserializationContext deserializationContext, Object obj) {
        return deserializationContext.a(this.f6059g, this, obj);
    }

    public final void m11124a(DeserializationContext deserializationContext, Object obj) {
        this.e.a(obj, m11123b(deserializationContext, obj));
    }
}
