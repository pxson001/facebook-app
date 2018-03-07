package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Empty;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;

/* compiled from: disable_refresh */
public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    protected final boolean f13793a;
    protected final JavaType f13794b;
    protected final TypeSerializer f13795c;
    protected final JsonSerializer<Object> f13796d;
    protected final BeanProperty f13797e;
    protected PropertySerializerMap f13798f;

    public abstract AsArraySerializerBase<T> mo986a(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer);

    protected abstract void mo987b(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        boolean z2 = false;
        super(cls, false);
        this.f13794b = javaType;
        if (z || (javaType != null && javaType.k())) {
            z2 = true;
        }
        this.f13793a = z2;
        this.f13795c = typeSerializer;
        this.f13797e = beanProperty;
        this.f13796d = jsonSerializer;
        this.f13798f = Empty.f359a;
    }

    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super((ContainerSerializer) asArraySerializerBase);
        this.f13794b = asArraySerializerBase.f13794b;
        this.f13793a = asArraySerializerBase.f13793a;
        this.f13795c = typeSerializer;
        this.f13797e = beanProperty;
        this.f13796d = jsonSerializer;
        this.f13798f = asArraySerializerBase.f13798f;
    }

    public final JsonSerializer<?> m14553a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        TypeSerializer a;
        TypeSerializer typeSerializer = this.f13795c;
        if (typeSerializer != null) {
            a = typeSerializer.a(beanProperty);
        } else {
            a = typeSerializer;
        }
        JsonSerializer jsonSerializer = null;
        if (beanProperty != null) {
            AnnotatedMember b = beanProperty.mo46b();
            if (b != null) {
                Object h = serializerProvider.e().h(b);
                if (h != null) {
                    jsonSerializer = serializerProvider.b(b, h);
                }
            }
        }
        if (jsonSerializer == null) {
            jsonSerializer = this.f13796d;
        }
        jsonSerializer = StdSerializer.a(serializerProvider, beanProperty, jsonSerializer);
        if (jsonSerializer == null) {
            if (jsonSerializer == null && this.f13794b != null && (this.f13793a || ContainerSerializer.a_(serializerProvider, beanProperty))) {
                jsonSerializer = serializerProvider.a(this.f13794b, beanProperty);
            }
        } else if (jsonSerializer instanceof ContextualSerializer) {
            jsonSerializer = ((ContextualSerializer) jsonSerializer).a(serializerProvider, beanProperty);
        }
        if (jsonSerializer == this.f13796d && beanProperty == this.f13797e && this.f13795c == a) {
            return this;
        }
        return mo986a(beanProperty, a, jsonSerializer);
    }

    public final void m14557a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (serializerProvider.a(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && mo854b((Object) t)) {
            mo987b(t, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.d();
        mo987b(t, jsonGenerator, serializerProvider);
        jsonGenerator.e();
    }

    public final void m14558a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.c(t, jsonGenerator);
        mo987b(t, jsonGenerator, serializerProvider);
        typeSerializer.f(t, jsonGenerator);
    }

    protected final JsonSerializer<Object> m14555a(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
        SerializerAndMapResult a = propertySerializerMap.m603a((Class) cls, serializerProvider, this.f13797e);
        if (propertySerializerMap != a.f392b) {
            this.f13798f = a.f392b;
        }
        return a.f391a;
    }

    protected final JsonSerializer<Object> m14554a(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) {
        SerializerAndMapResult a = propertySerializerMap.m602a(javaType, serializerProvider, this.f13797e);
        if (propertySerializerMap != a.f392b) {
            this.f13798f = a.f392b;
        }
        return a.f391a;
    }
}
