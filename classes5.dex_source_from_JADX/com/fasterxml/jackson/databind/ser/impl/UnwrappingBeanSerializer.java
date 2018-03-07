package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: can_viewer_remove_self */
public class UnwrappingBeanSerializer extends BeanSerializerBase {
    protected final NameTransformer f6187a;

    public UnwrappingBeanSerializer(BeanSerializerBase beanSerializerBase, NameTransformer nameTransformer) {
        super(beanSerializerBase, nameTransformer);
        this.f6187a = nameTransformer;
    }

    private UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, ObjectIdWriter objectIdWriter) {
        super(unwrappingBeanSerializer, objectIdWriter);
        this.f6187a = unwrappingBeanSerializer.f6187a;
    }

    private UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, String[] strArr) {
        super(unwrappingBeanSerializer, strArr);
        this.f6187a = unwrappingBeanSerializer.f6187a;
    }

    public final JsonSerializer<Object> m11636a(NameTransformer nameTransformer) {
        return new UnwrappingBeanSerializer((BeanSerializerBase) this, nameTransformer);
    }

    public final boolean m11640c() {
        return true;
    }

    public final BeanSerializerBase m11637a(ObjectIdWriter objectIdWriter) {
        return new UnwrappingBeanSerializer(this, objectIdWriter);
    }

    protected final BeanSerializerBase m11638a(String[] strArr) {
        return new UnwrappingBeanSerializer(this, strArr);
    }

    protected final BeanSerializerBase m11641d() {
        return this;
    }

    public final void m11639a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.h != null) {
            a(obj, jsonGenerator, serializerProvider, false);
        } else if (this.f != null) {
            c(obj, jsonGenerator, serializerProvider);
        } else {
            b(obj, jsonGenerator, serializerProvider);
        }
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + a().getName();
    }
}
