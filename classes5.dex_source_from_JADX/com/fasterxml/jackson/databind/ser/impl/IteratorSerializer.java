package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.util.Iterator;

@JacksonStdImpl
/* compiled from: can_viewer_untag */
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    public final boolean m11598a(Object obj) {
        Iterator it = (Iterator) obj;
        return it == null || !it.hasNext();
    }

    public final void m11600b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Iterator it = (Iterator) obj;
        Class cls = null;
        if (it.hasNext()) {
            TypeSerializer typeSerializer = this.c;
            JsonSerializer jsonSerializer = null;
            do {
                Object next = it.next();
                if (next == null) {
                    serializerProvider.a(jsonGenerator);
                } else {
                    JsonSerializer jsonSerializer2;
                    Class cls2 = next.getClass();
                    if (cls2 == cls) {
                        jsonSerializer2 = jsonSerializer;
                    } else {
                        jsonSerializer = serializerProvider.a(cls2, this.e);
                        cls = cls2;
                        jsonSerializer2 = jsonSerializer;
                    }
                    if (typeSerializer == null) {
                        jsonSerializer2.a(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer2.a(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                }
            } while (it.hasNext());
        }
    }

    public IteratorSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        super(Iterator.class, javaType, z, typeSerializer, beanProperty, null);
    }

    private IteratorSerializer(IteratorSerializer iteratorSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(iteratorSerializer, beanProperty, typeSerializer, jsonSerializer);
    }

    public final boolean m11601b(Object obj) {
        return false;
    }

    public final ContainerSerializer<?> m11599b(TypeSerializer typeSerializer) {
        return new IteratorSerializer(this.b, this.a, typeSerializer, this.e);
    }

    public final AsArraySerializerBase m11597a(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer) {
        return new IteratorSerializer(this, beanProperty, typeSerializer, jsonSerializer);
    }
}
