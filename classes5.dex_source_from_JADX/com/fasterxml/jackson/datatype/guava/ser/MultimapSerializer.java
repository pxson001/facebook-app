package com.fasterxml.jackson.datatype.guava.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Map.Entry;

/* compiled from: can_see_voice_switcher */
public class MultimapSerializer extends JsonSerializer<Multimap<?, ?>> implements ContextualSerializer {
    private final MapLikeType f6323a;
    private final BeanProperty f6324b;
    private final JsonSerializer<Object> f6325c;
    private final TypeSerializer f6326d;
    private final JsonSerializer<Object> f6327e;

    public final void m12045a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Multimap multimap = (Multimap) obj;
        jsonGenerator.f();
        if (!multimap.n()) {
            m12043b(multimap, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    public final void m12046a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        Multimap multimap = (Multimap) obj;
        typeSerializer.mo707b(multimap, jsonGenerator);
        m12043b(multimap, jsonGenerator, serializerProvider);
        typeSerializer.mo711e(multimap, jsonGenerator);
    }

    public MultimapSerializer(MapLikeType mapLikeType, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        this.f6323a = mapLikeType;
        this.f6324b = null;
        this.f6325c = jsonSerializer;
        this.f6326d = typeSerializer;
        this.f6327e = jsonSerializer2;
    }

    private MultimapSerializer(MultimapSerializer multimapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer2) {
        this.f6323a = multimapSerializer.f6323a;
        this.f6324b = beanProperty;
        this.f6325c = jsonSerializer;
        this.f6326d = typeSerializer;
        this.f6327e = jsonSerializer2;
    }

    private MultimapSerializer m12042a(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer2) {
        return new MultimapSerializer(this, beanProperty, jsonSerializer, typeSerializer, jsonSerializer2);
    }

    public final JsonSerializer<?> m12044a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer jsonSerializer;
        JsonSerializer jsonSerializer2 = this.f6327e;
        if (jsonSerializer2 == null) {
            JavaType r = this.f6323a.r();
            if (r.k()) {
                jsonSerializer2 = serializerProvider.a(r, beanProperty);
            }
            jsonSerializer = jsonSerializer2;
        } else if (jsonSerializer2 instanceof ContextualSerializer) {
            jsonSerializer = ((ContextualSerializer) jsonSerializer2).a(serializerProvider, beanProperty);
        } else {
            jsonSerializer = jsonSerializer2;
        }
        jsonSerializer2 = this.f6325c;
        if (jsonSerializer2 == null) {
            jsonSerializer2 = serializerProvider.b(this.f6323a.q(), beanProperty);
        } else if (jsonSerializer2 instanceof ContextualSerializer) {
            jsonSerializer2 = ((ContextualSerializer) jsonSerializer2).a(serializerProvider, beanProperty);
        }
        TypeSerializer typeSerializer = this.f6326d;
        if (typeSerializer != null) {
            typeSerializer = typeSerializer.mo703a(beanProperty);
        }
        return m12042a(beanProperty, jsonSerializer2, typeSerializer, jsonSerializer);
    }

    private final void m12043b(Multimap<?, ?> multimap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        for (Entry entry : multimap.b().entrySet()) {
            if (this.f6325c != null) {
                this.f6325c.a(entry.getKey(), jsonGenerator, serializerProvider);
            } else {
                serializerProvider.b(serializerProvider.a(String.class), this.f6324b).a(entry.getKey(), jsonGenerator, serializerProvider);
            }
            if (this.f6327e != null) {
                jsonGenerator.d();
                for (Object a : (Collection) entry.getValue()) {
                    this.f6327e.a(a, jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            } else {
                serializerProvider.a(Lists.a((Iterable) entry.getValue()), jsonGenerator);
            }
        }
    }
}
