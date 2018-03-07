package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: vault.upload_completed */
public class BeanSerializer extends BeanSerializerBase {
    public BeanSerializer(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType, beanSerializerBuilder, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    private BeanSerializer(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter) {
        super(beanSerializerBase, objectIdWriter);
    }

    private BeanSerializer(BeanSerializerBase beanSerializerBase, String[] strArr) {
        super(beanSerializerBase, strArr);
    }

    public static BeanSerializer m611a(JavaType javaType) {
        return new BeanSerializer(javaType, null, BeanSerializerBase.f361b, null);
    }

    public final JsonSerializer<Object> m612a(NameTransformer nameTransformer) {
        return new UnwrappingBeanSerializer(this, nameTransformer);
    }

    public final BeanSerializerBase mo50a(ObjectIdWriter objectIdWriter) {
        return new BeanSerializer((BeanSerializerBase) this, objectIdWriter);
    }

    protected final BeanSerializerBase mo51a(String[] strArr) {
        return new BeanSerializer((BeanSerializerBase) this, strArr);
    }

    protected final BeanSerializerBase mo52d() {
        if (this.f367h == null && this.f364e == null && this.f365f == null) {
            return new BeanAsArraySerializer(this);
        }
        return this;
    }

    public final void m615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f367h != null) {
            m627a(obj, jsonGenerator, serializerProvider, true);
            return;
        }
        jsonGenerator.f();
        if (this.f365f != null) {
            m630c(obj, jsonGenerator, serializerProvider);
        } else {
            m628b(obj, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    public String toString() {
        return "BeanSerializer for " + a().getName();
    }
}
