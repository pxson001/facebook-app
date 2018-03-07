package com.facebook.common.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: fetchFeedParams */
public class ArrayListDeserializer<T> extends JsonDeserializer<List<T>> {
    private final Class<T> f11783a;
    private final JavaType f11784b;
    private JsonDeserializer<T> f11785c;

    public ArrayListDeserializer(JsonDeserializer<T> jsonDeserializer) {
        this.f11783a = null;
        this.f11784b = null;
        this.f11785c = jsonDeserializer;
    }

    public ArrayListDeserializer(JavaType javaType) {
        this.f11783a = null;
        this.f11784b = javaType.a(0);
        this.f11785c = null;
    }

    public ArrayListDeserializer(Class<T> cls) {
        this.f11783a = cls;
        this.f11784b = null;
        this.f11785c = null;
    }

    public Object m12372a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FbObjectMapper fbObjectMapper = (FbObjectMapper) jsonParser.a();
        if (!jsonParser.h() || jsonParser.g() == JsonToken.VALUE_NULL) {
            jsonParser.f();
            return Lists.a();
        } else if (jsonParser.g() != JsonToken.START_ARRAY) {
            throw new JsonParseException("Failed to deserialize to a list - missing start_array token", jsonParser.l());
        } else {
            if (this.f11785c == null) {
                this.f11785c = fbObjectMapper.a(deserializationContext, this.f11783a != null ? this.f11783a : this.f11784b);
            }
            Object a = Lists.a();
            while (FbJsonChecker.a(jsonParser) != JsonToken.END_ARRAY) {
                Object a2 = this.f11785c.a(jsonParser, deserializationContext);
                if (a2 != null) {
                    a.add(a2);
                }
            }
            return a;
        }
    }
}
