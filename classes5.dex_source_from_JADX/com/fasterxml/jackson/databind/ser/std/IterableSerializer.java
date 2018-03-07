package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.util.Iterator;

@JacksonStdImpl
/* compiled from: can_viewer_promote_for_page_likes */
public class IterableSerializer extends AsArraySerializerBase<Iterable<?>> {
    public final boolean m11669a(Object obj) {
        Iterable iterable = (Iterable) obj;
        return iterable == null || !iterable.iterator().hasNext();
    }

    public final void m11671b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Class cls = null;
        Iterator it = ((Iterable) obj).iterator();
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

    public IterableSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        super(Iterable.class, javaType, z, typeSerializer, beanProperty, null);
    }

    private IterableSerializer(IterableSerializer iterableSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(iterableSerializer, beanProperty, typeSerializer, jsonSerializer);
    }

    public final ContainerSerializer<?> m11670b(TypeSerializer typeSerializer) {
        return new IterableSerializer(this.b, this.a, typeSerializer, this.e);
    }

    public final AsArraySerializerBase m11668a(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer) {
        return new IterableSerializer(this, beanProperty, typeSerializer, jsonSerializer);
    }

    public final boolean m11672b(Object obj) {
        return false;
    }
}
