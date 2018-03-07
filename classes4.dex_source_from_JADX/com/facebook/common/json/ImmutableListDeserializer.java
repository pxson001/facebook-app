package com.facebook.common.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: token_owner */
public class ImmutableListDeserializer<T> extends JsonDeserializer<ImmutableList<T>> {
    private final Class<T> f924a;
    private final JavaType f925b;
    private JsonDeserializer<T> f926c;

    public ImmutableListDeserializer(JsonDeserializer<T> jsonDeserializer) {
        this.f924a = null;
        this.f925b = null;
        this.f926c = jsonDeserializer;
    }

    public ImmutableListDeserializer(JavaType javaType) {
        this.f924a = null;
        this.f925b = javaType.a(0);
        this.f926c = null;
    }

    public ImmutableListDeserializer(Class<T> cls) {
        this.f924a = cls;
        this.f925b = null;
        this.f926c = null;
    }

    public Object m1264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FbObjectMapper fbObjectMapper = (FbObjectMapper) jsonParser.a();
        if (!jsonParser.h() || jsonParser.g() == JsonToken.VALUE_NULL) {
            jsonParser.f();
            return RegularImmutableList.a;
        } else if (jsonParser.g() != JsonToken.START_ARRAY) {
            throw new JsonParseException("Failed to deserialize to a list - missing start_array token", jsonParser.l());
        } else {
            if (this.f926c == null) {
                this.f926c = fbObjectMapper.a(deserializationContext, this.f924a != null ? this.f924a : this.f925b);
            }
            Builder builder = ImmutableList.builder();
            while (FbJsonChecker.a(jsonParser) != JsonToken.END_ARRAY) {
                Object a = this.f926c.a(jsonParser, deserializationContext);
                if (a != null) {
                    builder.c(a);
                }
            }
            return builder.b();
        }
    }
}
