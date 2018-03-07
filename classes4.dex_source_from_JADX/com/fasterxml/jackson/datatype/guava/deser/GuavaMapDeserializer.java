package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.MapType;

/* compiled from: getOtherSharedDirty */
public abstract class GuavaMapDeserializer<T> extends JsonDeserializer<T> implements ContextualDeserializer {
    protected final MapType f11105a;
    protected KeyDeserializer f11106b;
    protected JsonDeserializer<?> f11107c;
    protected final TypeDeserializer f11108d;

    public abstract GuavaMapDeserializer<T> mo830a(KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer);

    protected abstract T mo832b(JsonParser jsonParser, DeserializationContext deserializationContext);

    protected GuavaMapDeserializer(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        this.f11105a = mapType;
        this.f11106b = keyDeserializer;
        this.f11108d = typeDeserializer;
        this.f11107c = jsonDeserializer;
    }

    public final JsonDeserializer<?> mo833a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        KeyDeserializer keyDeserializer = this.f11106b;
        JsonDeserializer jsonDeserializer = this.f11107c;
        TypeDeserializer typeDeserializer = this.f11108d;
        if (keyDeserializer != null && jsonDeserializer != null && typeDeserializer == null) {
            return this;
        }
        if (keyDeserializer == null) {
            keyDeserializer = deserializationContext.b(this.f11105a.q(), beanProperty);
        }
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.a(this.f11105a.r(), beanProperty);
        }
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.a(beanProperty);
        }
        return mo830a(keyDeserializer, typeDeserializer, jsonDeserializer);
    }

    public final Object m11559a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.b(jsonParser, deserializationContext);
    }

    public T m11558a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.c();
            if (!(g == JsonToken.FIELD_NAME || g == JsonToken.END_OBJECT)) {
                throw deserializationContext.b(this.f11105a._class);
            }
        } else if (g != JsonToken.FIELD_NAME) {
            throw deserializationContext.b(this.f11105a._class);
        }
        return mo832b(jsonParser, deserializationContext);
    }
}
