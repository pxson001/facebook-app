package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: getPageWidthPixelsForRecyclerView() must be called after applyToRecyclerView() */
abstract class GuavaImmutableMapDeserializer<T extends ImmutableMap<Object, Object>> extends GuavaMapDeserializer<T> {
    protected abstract Builder<Object, Object> mo831e();

    GuavaImmutableMapDeserializer(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(mapType, keyDeserializer, typeDeserializer, jsonDeserializer);
    }

    protected final Object mo832b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        KeyDeserializer keyDeserializer = this.f11106b;
        JsonDeserializer jsonDeserializer = this.f11107c;
        TypeDeserializer typeDeserializer = this.f11108d;
        Builder e = mo831e();
        while (jsonParser.g() == JsonToken.FIELD_NAME) {
            Object obj;
            Object i = jsonParser.i();
            if (keyDeserializer != null) {
                i = keyDeserializer.mo835a(i, deserializationContext);
            }
            if (jsonParser.c() == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
            }
            e.b(i, obj);
            jsonParser.c();
        }
        return e.b();
    }
}
