package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.EnumSet;

/* compiled from: checkpoint */
public class EnumSetDeserializer extends StdDeserializer<EnumSet<?>> implements ContextualDeserializer {
    private static final long serialVersionUID = 3479455075597887177L;
    protected final Class<Enum> _enumClass;
    protected JsonDeserializer<Enum<?>> _enumDeserializer;
    protected final JavaType _enumType;

    public /* synthetic */ Object m11175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11177b(jsonParser, deserializationContext);
    }

    public EnumSetDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
        super(EnumSet.class);
        this._enumType = javaType;
        this._enumClass = javaType._class;
        this._enumDeserializer = jsonDeserializer;
    }

    private EnumSetDeserializer m11172b(JsonDeserializer<?> jsonDeserializer) {
        return this._enumDeserializer == jsonDeserializer ? this : new EnumSetDeserializer(this._enumType, jsonDeserializer);
    }

    public final boolean m11178d() {
        return true;
    }

    public final JsonDeserializer<?> m11174a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer jsonDeserializer = this._enumDeserializer;
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.a(this._enumType, beanProperty);
        } else if (jsonDeserializer instanceof ContextualDeserializer) {
            jsonDeserializer = ((ContextualDeserializer) jsonDeserializer).a(deserializationContext, beanProperty);
        }
        return m11172b(jsonDeserializer);
    }

    public EnumSet<?> m11177b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.m()) {
            EnumSet<?> e = m11173e();
            while (true) {
                JsonToken c = jsonParser.c();
                if (c == JsonToken.END_ARRAY) {
                    return e;
                }
                if (c == JsonToken.VALUE_NULL) {
                    throw deserializationContext.b(this._enumClass);
                }
                Enum enumR = (Enum) this._enumDeserializer.a(jsonParser, deserializationContext);
                if (enumR != null) {
                    e.add(enumR);
                }
            }
        } else {
            throw deserializationContext.b(EnumSet.class);
        }
    }

    public final Object m11176a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo700b(jsonParser, deserializationContext);
    }

    private EnumSet m11173e() {
        return EnumSet.noneOf(this._enumClass);
    }
}
