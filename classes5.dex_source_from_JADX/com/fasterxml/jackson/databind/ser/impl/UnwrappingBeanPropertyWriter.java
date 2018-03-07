package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: can_viewer_remove_tag */
public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter {
    protected final NameTransformer f6186t;

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, NameTransformer nameTransformer) {
        super(beanPropertyWriter);
        this.f6186t = nameTransformer;
    }

    private UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter unwrappingBeanPropertyWriter, NameTransformer nameTransformer, SerializedString serializedString) {
        super(unwrappingBeanPropertyWriter, serializedString);
        this.f6186t = nameTransformer;
    }

    public final BeanPropertyWriter m11633a(NameTransformer nameTransformer) {
        return new UnwrappingBeanPropertyWriter(this, NameTransformer.m11786a(nameTransformer, this.f6186t), new SerializedString(nameTransformer.mo728a(this.h.a())));
    }

    public final void m11635a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object a = a(obj);
        if (a != null) {
            JsonSerializer jsonSerializer = this.k;
            if (jsonSerializer == null) {
                Class cls = a.getClass();
                PropertySerializerMap propertySerializerMap = this.m;
                jsonSerializer = propertySerializerMap.a(cls);
                if (jsonSerializer == null) {
                    jsonSerializer = m11632a(propertySerializerMap, cls, serializerProvider);
                }
            }
            if (this.o != null) {
                if (BeanPropertyWriter.a == this.o) {
                    if (jsonSerializer.a(a)) {
                        return;
                    }
                } else if (this.o.equals(a)) {
                    return;
                }
            }
            if (a == obj) {
                BeanPropertyWriter.c(jsonSerializer);
            }
            if (!jsonSerializer.c()) {
                jsonGenerator.b(this.h);
            }
            if (this.q == null) {
                jsonSerializer.a(a, jsonGenerator, serializerProvider);
            } else {
                jsonSerializer.a(a, jsonGenerator, serializerProvider, this.q);
            }
        }
    }

    public final void m11634a(JsonSerializer<Object> jsonSerializer) {
        super.a(jsonSerializer);
        if (this.k != null) {
            NameTransformer a;
            NameTransformer nameTransformer = this.f6186t;
            if (this.k.c()) {
                a = NameTransformer.m11786a(nameTransformer, ((UnwrappingBeanSerializer) this.k).f6187a);
            } else {
                a = nameTransformer;
            }
            this.k = this.k.a(a);
        }
    }

    protected final JsonSerializer<Object> m11632a(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
        JsonSerializer a;
        NameTransformer a2;
        if (this.r != null) {
            a = serializerProvider.a(serializerProvider.a(this.r, cls), this);
        } else {
            a = serializerProvider.a(cls, this);
        }
        NameTransformer nameTransformer = this.f6186t;
        if (a.c()) {
            a2 = NameTransformer.m11786a(nameTransformer, ((UnwrappingBeanSerializer) a).f6187a);
        } else {
            a2 = nameTransformer;
        }
        JsonSerializer<Object> a3 = a.a(a2);
        this.m = this.m.a(cls, a3);
        return a3;
    }
}
