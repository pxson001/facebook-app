package com.facebook.common.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;

/* compiled from: slides */
public class ImmutableMapDeserializer<K, V> extends JsonDeserializer<ImmutableMap<K, V>> {
    private final Class f2679a;
    private JsonDeserializer<K> f2680b;
    private boolean f2681c = false;
    private final JavaType f2682d;
    private JsonDeserializer<V> f2683e;

    public ImmutableMapDeserializer(JavaType javaType) {
        boolean z = false;
        this.f2679a = javaType.a(0)._class;
        if (this.f2679a == String.class || Enum.class.isAssignableFrom(this.f2679a)) {
            z = true;
        }
        Preconditions.checkArgument(z, "Map keys must be a String or an enum.");
        this.f2682d = javaType.a(1);
    }

    public Object m3780a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FbObjectMapper fbObjectMapper = (FbObjectMapper) jsonParser.a();
        if (!jsonParser.h() || jsonParser.g() == JsonToken.VALUE_NULL) {
            jsonParser.f();
            return RegularImmutableBiMap.a;
        } else if (jsonParser.g() != JsonToken.START_OBJECT) {
            throw new JsonParseException("Failed to deserialize to a map - missing start_object token", jsonParser.l());
        } else {
            if (!this.f2681c) {
                if (this.f2679a != String.class) {
                    this.f2680b = fbObjectMapper.a(deserializationContext, this.f2679a);
                }
                this.f2681c = true;
            }
            if (this.f2683e == null) {
                this.f2683e = fbObjectMapper.b(deserializationContext, this.f2682d);
            }
            Builder builder = ImmutableMap.builder();
            while (FbJsonChecker.a(jsonParser) != JsonToken.END_OBJECT) {
                if (jsonParser.g() == JsonToken.FIELD_NAME) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    Object a = this.f2683e.a(jsonParser, deserializationContext);
                    if (a != null) {
                        if (this.f2680b != null) {
                            JsonParser a2 = fbObjectMapper.b().a("\"" + i + "\"");
                            a2.c();
                            builder.b(this.f2680b.a(a2, deserializationContext), a);
                        } else {
                            builder.b(i, a);
                        }
                    }
                }
            }
            return builder.b();
        }
    }
}
