package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.util.Converter;

/* compiled from: can_viewer_poke */
public class StdDelegatingSerializer extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer {
    protected final Converter<Object, ?> f6217a;
    protected final JavaType f6218b;
    protected final JsonSerializer<Object> f6219c;

    public StdDelegatingSerializer(Converter<Object, ?> converter, JavaType javaType, JsonSerializer<?> jsonSerializer) {
        super(javaType);
        this.f6217a = converter;
        this.f6218b = javaType;
        this.f6219c = jsonSerializer;
    }

    private StdDelegatingSerializer m11725a(Converter<Object, ?> converter, JavaType javaType, JsonSerializer<?> jsonSerializer) {
        if (getClass() == StdDelegatingSerializer.class) {
            return new StdDelegatingSerializer(converter, javaType, jsonSerializer);
        }
        throw new IllegalStateException("Sub-class " + getClass().getName() + " must override 'withDelegate'");
    }

    public final void m11728a(SerializerProvider serializerProvider) {
        if (this.f6219c != null && (this.f6219c instanceof ResolvableSerializer)) {
            ((ResolvableSerializer) this.f6219c).a(serializerProvider);
        }
    }

    public final JsonSerializer<?> m11727a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        if (this.f6219c == null) {
            JavaType javaType = this.f6218b;
            if (javaType == null) {
                Converter converter = this.f6217a;
                serializerProvider.c();
                javaType = converter.c();
            }
            return m11725a(this.f6217a, javaType, serializerProvider.a(javaType, beanProperty));
        } else if (!(this.f6219c instanceof ContextualSerializer)) {
            return this;
        } else {
            JsonSerializer a = ((ContextualSerializer) this.f6219c).a(serializerProvider, beanProperty);
            if (a == this.f6219c) {
                return this;
            }
            return m11725a(this.f6217a, this.f6218b, a);
        }
    }

    public final void m11729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object b = m11726b(obj);
        if (b == null) {
            serializerProvider.a(jsonGenerator);
        } else {
            this.f6219c.a(b, jsonGenerator, serializerProvider);
        }
    }

    public final void m11730a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        this.f6219c.a(m11726b(obj), jsonGenerator, serializerProvider, typeSerializer);
    }

    public final boolean m11731a(Object obj) {
        return this.f6219c.a(m11726b(obj));
    }

    private Object m11726b(Object obj) {
        return this.f6217a.a();
    }
}
