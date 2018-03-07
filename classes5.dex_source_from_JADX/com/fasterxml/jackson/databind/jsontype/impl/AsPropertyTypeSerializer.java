package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: categoryID */
public class AsPropertyTypeSerializer extends AsArrayTypeSerializer {
    protected final String f6121a;

    public final /* synthetic */ TypeSerializer mo703a(BeanProperty beanProperty) {
        return m11463c(beanProperty);
    }

    public final /* synthetic */ AsArrayTypeSerializer mo713b(BeanProperty beanProperty) {
        return m11463c(beanProperty);
    }

    public AsPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this.f6121a = str;
    }

    private AsPropertyTypeSerializer m11463c(BeanProperty beanProperty) {
        return this.f6119c == beanProperty ? this : new AsPropertyTypeSerializer(this.f6118b, beanProperty, this.f6121a);
    }

    public final void mo707b(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        jsonGenerator.a(this.f6121a, m11427a(obj));
    }

    public final void mo711e(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.g();
    }

    public final void mo706a(Object obj, JsonGenerator jsonGenerator, String str) {
        jsonGenerator.f();
        jsonGenerator.a(this.f6121a, str);
    }

    public final void mo708b(Object obj, JsonGenerator jsonGenerator, String str) {
        jsonGenerator.g();
    }
}
