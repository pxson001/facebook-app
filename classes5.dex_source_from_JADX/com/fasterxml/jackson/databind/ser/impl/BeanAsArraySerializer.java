package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException$Reference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: cancelLabel */
public class BeanAsArraySerializer extends BeanSerializerBase {
    protected final BeanSerializerBase f6159a;

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase, null);
        this.f6159a = beanSerializerBase;
    }

    private BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, String[] strArr) {
        super(beanSerializerBase, strArr);
        this.f6159a = beanSerializerBase;
    }

    public final JsonSerializer<Object> m11572a(NameTransformer nameTransformer) {
        return this.f6159a.a(nameTransformer);
    }

    public final boolean m11577c() {
        return false;
    }

    public final BeanSerializerBase m11573a(ObjectIdWriter objectIdWriter) {
        return this.f6159a.a(objectIdWriter);
    }

    protected final BeanSerializerBase m11574a(String[] strArr) {
        return new BeanAsArraySerializer(this, strArr);
    }

    protected final BeanSerializerBase m11578d() {
        return this;
    }

    public final void m11576a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        this.f6159a.a(obj, jsonGenerator, serializerProvider, typeSerializer);
    }

    public final void m11575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (serializerProvider.a(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && m11570b(serializerProvider)) {
            m11571d(obj, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.d();
        m11571d(obj, jsonGenerator, serializerProvider);
        jsonGenerator.e();
    }

    private boolean m11570b(SerializerProvider serializerProvider) {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.d == null || serializerProvider._serializationView == null) {
            beanPropertyWriterArr = this.c;
        } else {
            beanPropertyWriterArr = this.d;
        }
        return beanPropertyWriterArr.length == 1;
    }

    private void m11571d(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.d == null || serializerProvider.f() == null) {
            beanPropertyWriterArr = this.c;
        } else {
            beanPropertyWriterArr = this.d;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter == null) {
                    jsonGenerator.h();
                } else {
                    beanPropertyWriter.b(obj, jsonGenerator, serializerProvider);
                }
                i++;
            }
        } catch (Throwable e) {
            StdSerializer.a(serializerProvider, e, obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].c());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.a(new JsonMappingException$Reference(obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].c()));
            throw jsonMappingException;
        }
    }

    public String toString() {
        return "BeanAsArraySerializer for " + a().getName();
    }
}
