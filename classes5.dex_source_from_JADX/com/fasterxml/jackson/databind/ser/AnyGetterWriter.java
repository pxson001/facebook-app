package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;

/* compiled from: canonical */
public class AnyGetterWriter {
    protected final BeanProperty f6156a;
    protected final AnnotatedMember f6157b;
    protected MapSerializer f6158c;

    public AnyGetterWriter(BeanProperty beanProperty, AnnotatedMember annotatedMember, MapSerializer mapSerializer) {
        this.f6157b = annotatedMember;
        this.f6156a = beanProperty;
        this.f6158c = mapSerializer;
    }

    public final void m11568a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object b = this.f6157b.b(obj);
        if (b != null) {
            if (b instanceof Map) {
                this.f6158c.a((Map) b, jsonGenerator, serializerProvider);
                return;
            }
            throw new JsonMappingException("Value returned by 'any-getter' (" + this.f6157b.b() + "()) not java.util.Map but " + b.getClass().getName());
        }
    }

    public final void m11567a(SerializerProvider serializerProvider) {
        this.f6158c = (MapSerializer) this.f6158c.a(serializerProvider, this.f6156a);
    }
}
