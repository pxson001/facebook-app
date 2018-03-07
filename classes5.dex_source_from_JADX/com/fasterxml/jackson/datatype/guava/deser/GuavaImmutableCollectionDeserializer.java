package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection.Builder;

/* compiled from: can_viewer_claim_adminship */
abstract class GuavaImmutableCollectionDeserializer<T extends ImmutableCollection<Object>> extends GuavaCollectionDeserializer<T> {
    protected abstract Builder<Object> mo733e();

    GuavaImmutableCollectionDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    protected final Object mo730b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._typeDeserializerForValue;
        Builder e = mo733e();
        while (true) {
            JsonToken c = jsonParser.c();
            if (c == JsonToken.END_ARRAY) {
                return e.a();
            }
            Object obj;
            if (c == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
            }
            e.b(obj);
        }
    }
}
