package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.Multiset;

/* compiled from: can_viewer_claim */
abstract class GuavaMultisetDeserializer<T extends Multiset<Object>> extends GuavaCollectionDeserializer<T> {
    protected abstract T mo732e();

    GuavaMultisetDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    protected final Object mo730b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._typeDeserializerForValue;
        Multiset e = mo732e();
        while (true) {
            JsonToken c = jsonParser.c();
            if (c == JsonToken.END_ARRAY) {
                return e;
            }
            Object obj;
            if (c == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
            }
            e.add(obj);
        }
    }
}
