package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

/* compiled from: ci_friends_suggestion */
public final class TypeWrappedDeserializer extends JsonDeserializer<Object> {
    final TypeDeserializer f6056a;
    final JsonDeserializer<Object> f6057b;

    public TypeWrappedDeserializer(TypeDeserializer typeDeserializer, JsonDeserializer<Object> jsonDeserializer) {
        this.f6056a = typeDeserializer;
        this.f6057b = jsonDeserializer;
    }

    public final Object m11117a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return this.f6057b.a(jsonParser, deserializationContext, this.f6056a);
    }

    public final Object m11118a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    public final Object m11119a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return this.f6057b.a(jsonParser, deserializationContext, obj);
    }
}
