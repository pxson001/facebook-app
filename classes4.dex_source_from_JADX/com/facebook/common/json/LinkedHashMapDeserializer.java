package com.facebook.common.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;

/* compiled from: lastFailureExceptionJson */
public class LinkedHashMapDeserializer<K, V> extends JsonDeserializer<LinkedHashMap<K, V>> {
    private final Class f9603a;
    private JsonDeserializer<K> f9604b;
    private boolean f9605c = false;
    private final JavaType f9606d;
    private JsonDeserializer<V> f9607e;

    public LinkedHashMapDeserializer(JavaType javaType) {
        boolean z = false;
        this.f9603a = javaType.a(0)._class;
        if (this.f9603a == String.class || Enum.class.isAssignableFrom(this.f9603a)) {
            z = true;
        }
        Preconditions.checkArgument(z, "Map keys must be a String or an enum.");
        this.f9606d = javaType.a(1);
    }

    public Object m10053a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FbObjectMapper fbObjectMapper = (FbObjectMapper) jsonParser.a();
        LinkedHashMap d = Maps.d();
        if (!jsonParser.h() || jsonParser.g() == JsonToken.VALUE_NULL) {
            jsonParser.f();
            return d;
        } else if (jsonParser.g() != JsonToken.START_OBJECT) {
            throw new JsonParseException("Failed to deserialize to a map - missing start_object token", jsonParser.l());
        } else {
            if (!this.f9605c) {
                if (this.f9603a != String.class) {
                    this.f9604b = fbObjectMapper.a(deserializationContext, this.f9603a);
                }
                this.f9605c = true;
            }
            if (this.f9607e == null) {
                this.f9607e = fbObjectMapper.b(deserializationContext, this.f9606d);
            }
            while (FbJsonChecker.a(jsonParser) != JsonToken.END_OBJECT) {
                if (jsonParser.g() == JsonToken.FIELD_NAME) {
                    Object a;
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        a = this.f9607e.a();
                    } else {
                        a = this.f9607e.a(jsonParser, deserializationContext);
                        if (a != null) {
                        }
                    }
                    if (this.f9604b != null) {
                        JsonParser a2 = fbObjectMapper.b().a("\"" + i + "\"");
                        a2.c();
                        d.put(this.f9604b.a(a2, deserializationContext), a);
                    } else {
                        d.put(i, a);
                    }
                }
            }
            return d;
        }
    }
}
