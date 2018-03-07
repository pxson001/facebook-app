package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: category_discover_tag */
public class AsArrayTypeSerializer extends TypeSerializerBase {
    public /* synthetic */ TypeSerializer mo703a(BeanProperty beanProperty) {
        return mo713b(beanProperty);
    }

    public AsArrayTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    public AsArrayTypeSerializer mo713b(BeanProperty beanProperty) {
        return this.f6119c == beanProperty ? this : new AsArrayTypeSerializer(this.f6118b, beanProperty);
    }

    public void mo707b(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.d();
        jsonGenerator.b(m11427a(obj));
        jsonGenerator.f();
    }

    public final void mo709c(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.d();
        jsonGenerator.b(m11427a(obj));
        jsonGenerator.d();
    }

    public final void mo704a(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.d();
        jsonGenerator.b(m11427a(obj));
    }

    public final void mo705a(Object obj, JsonGenerator jsonGenerator, Class<?> cls) {
        jsonGenerator.d();
        jsonGenerator.b(m11428a(obj, cls));
    }

    public void mo711e(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.g();
        jsonGenerator.e();
    }

    public final void mo712f(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.e();
        jsonGenerator.e();
    }

    public final void mo710d(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.e();
    }

    public void mo706a(Object obj, JsonGenerator jsonGenerator, String str) {
        jsonGenerator.d();
        jsonGenerator.b(str);
        jsonGenerator.f();
    }

    public void mo708b(Object obj, JsonGenerator jsonGenerator, String str) {
        mo711e(obj, jsonGenerator);
    }
}
