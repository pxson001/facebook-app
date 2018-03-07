package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: chose_2 */
public class ArrayBlockingQueueDeserializer extends CollectionDeserializer {
    private static final long serialVersionUID = 5471961369237518580L;

    public /* synthetic */ Object mo664a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return mo668b(jsonParser, deserializationContext);
    }

    public ArrayBlockingQueueDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, ValueInstantiator valueInstantiator, JsonDeserializer<Object> jsonDeserializer2) {
        super(javaType, jsonDeserializer, typeDeserializer, valueInstantiator, jsonDeserializer2);
    }

    protected final CollectionDeserializer mo663a(JsonDeserializer jsonDeserializer, JsonDeserializer jsonDeserializer2, TypeDeserializer typeDeserializer) {
        if (jsonDeserializer == this._delegateDeserializer && jsonDeserializer2 == this._valueDeserializer && typeDeserializer == this._valueTypeDeserializer) {
            return this;
        }
        return new ArrayBlockingQueueDeserializer(this._collectionType, jsonDeserializer2, typeDeserializer, this._valueInstantiator, jsonDeserializer);
    }

    public Collection<Object> mo668b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._delegateDeserializer != null) {
            return (Collection) this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        }
        if (jsonParser.g() == JsonToken.VALUE_STRING) {
            String o = jsonParser.o();
            if (o.length() == 0) {
                return (Collection) this._valueInstantiator.mo678a(deserializationContext, o);
            }
        }
        return mo667a(jsonParser, deserializationContext, null);
    }

    public final Collection<Object> mo667a(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) {
        if (!jsonParser.m()) {
            return m11133b(jsonParser, deserializationContext, new ArrayBlockingQueue(1));
        }
        Collection arrayList = new ArrayList();
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (true) {
            JsonToken c = jsonParser.c();
            if (c == JsonToken.END_ARRAY) {
                break;
            }
            Object obj;
            if (c == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
            }
            arrayList.add(obj);
        }
        if (collection == null) {
            return new ArrayBlockingQueue(arrayList.size(), false, arrayList);
        }
        collection.addAll(arrayList);
        return collection;
    }

    public final Object mo665a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo700b(jsonParser, deserializationContext);
    }
}
