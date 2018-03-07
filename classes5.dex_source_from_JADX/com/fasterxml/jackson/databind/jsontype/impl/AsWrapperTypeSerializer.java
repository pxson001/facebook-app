package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: categories */
public class AsWrapperTypeSerializer extends TypeSerializerBase {
    public AsWrapperTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    public final TypeSerializer mo703a(BeanProperty beanProperty) {
        return this.f6119c == beanProperty ? this : new AsWrapperTypeSerializer(this.f6118b, beanProperty);
    }

    public final void mo707b(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        jsonGenerator.g(m11427a(obj));
    }

    public final void mo709c(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        jsonGenerator.f(m11427a(obj));
    }

    public final void mo704a(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        jsonGenerator.a(m11427a(obj));
    }

    public final void mo705a(Object obj, JsonGenerator jsonGenerator, Class<?> cls) {
        jsonGenerator.f();
        jsonGenerator.a(m11428a(obj, cls));
    }

    public final void mo711e(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.g();
        jsonGenerator.g();
    }

    public final void mo712f(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.e();
        jsonGenerator.g();
    }

    public final void mo710d(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.g();
    }

    public final void mo706a(Object obj, JsonGenerator jsonGenerator, String str) {
        jsonGenerator.f();
        jsonGenerator.g(str);
    }

    public final void mo708b(Object obj, JsonGenerator jsonGenerator, String str) {
        mo711e(obj, jsonGenerator);
    }
}
