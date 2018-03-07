package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: category_discover_category */
public class AsExternalTypeSerializer extends TypeSerializerBase {
    protected final String f6120a;

    public AsExternalTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this.f6120a = str;
    }

    public final TypeSerializer mo703a(BeanProperty beanProperty) {
        return this.f6119c == beanProperty ? this : new AsExternalTypeSerializer(this.f6118b, beanProperty, this.f6120a);
    }

    public final void mo704a(Object obj, JsonGenerator jsonGenerator) {
    }

    public final void mo705a(Object obj, JsonGenerator jsonGenerator, Class<?> cls) {
    }

    public final void mo711e(Object obj, JsonGenerator jsonGenerator) {
        m11445b(jsonGenerator, m11427a(obj));
    }

    public final void mo712f(Object obj, JsonGenerator jsonGenerator) {
        m11446c(jsonGenerator, m11427a(obj));
    }

    public final void mo710d(Object obj, JsonGenerator jsonGenerator) {
        m11443a(jsonGenerator, m11427a(obj));
    }

    public final void mo708b(Object obj, JsonGenerator jsonGenerator, String str) {
        m11445b(jsonGenerator, str);
    }

    private static void m11442a(JsonGenerator jsonGenerator) {
        jsonGenerator.f();
    }

    public final void mo706a(Object obj, JsonGenerator jsonGenerator, String str) {
        jsonGenerator.f();
    }

    public final void mo707b(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
    }

    private static void m11444b(JsonGenerator jsonGenerator) {
        jsonGenerator.d();
    }

    public final void mo709c(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.d();
    }

    private void m11443a(JsonGenerator jsonGenerator, String str) {
        jsonGenerator.a(this.f6120a, str);
    }

    private void m11445b(JsonGenerator jsonGenerator, String str) {
        jsonGenerator.g();
        jsonGenerator.a(this.f6120a, str);
    }

    private void m11446c(JsonGenerator jsonGenerator, String str) {
        jsonGenerator.e();
        jsonGenerator.a(this.f6120a, str);
    }
}
