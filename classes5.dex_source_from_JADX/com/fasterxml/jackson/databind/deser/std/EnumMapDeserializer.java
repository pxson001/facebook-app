package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.EnumMap;

/* compiled from: chevron_color */
public class EnumMapDeserializer extends StdDeserializer<EnumMap<?, ?>> implements ContextualDeserializer {
    private static final long serialVersionUID = 1518773374647478964L;
    protected final Class<?> _enumClass;
    protected JsonDeserializer<Enum<?>> _keyDeserializer;
    protected final JavaType _mapType;
    protected JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;

    public /* synthetic */ Object m11168a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11170b(jsonParser, deserializationContext);
    }

    public EnumMapDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, TypeDeserializer typeDeserializer) {
        super(EnumMap.class);
        this._mapType = javaType;
        this._enumClass = javaType.q()._class;
        this._keyDeserializer = jsonDeserializer;
        this._valueDeserializer = jsonDeserializer2;
        this._valueTypeDeserializer = typeDeserializer;
    }

    private EnumMapDeserializer m11165a(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, TypeDeserializer typeDeserializer) {
        return (jsonDeserializer == this._keyDeserializer && jsonDeserializer2 == this._valueDeserializer && typeDeserializer == this._valueTypeDeserializer) ? this : new EnumMapDeserializer(this._mapType, jsonDeserializer, jsonDeserializer2, this._valueTypeDeserializer);
    }

    public final JsonDeserializer<?> m11167a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer a;
        JsonDeserializer jsonDeserializer = this._keyDeserializer;
        if (jsonDeserializer == null) {
            a = deserializationContext.a(this._mapType.q(), beanProperty);
        } else {
            a = jsonDeserializer;
        }
        jsonDeserializer = this._valueDeserializer;
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.a(this._mapType.r(), beanProperty);
        } else if (jsonDeserializer instanceof ContextualDeserializer) {
            jsonDeserializer = ((ContextualDeserializer) jsonDeserializer).a(deserializationContext, beanProperty);
        }
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.mo698a(beanProperty);
        }
        return m11165a(a, jsonDeserializer, typeDeserializer);
    }

    public final boolean m11171d() {
        return true;
    }

    public EnumMap<?, ?> m11170b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            throw deserializationContext.b(EnumMap.class);
        }
        EnumMap<?, ?> e = m11166e();
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            Enum enumR = (Enum) this._keyDeserializer.a(jsonParser, deserializationContext);
            if (enumR != null) {
                Object obj;
                if (jsonParser.c() == JsonToken.VALUE_NULL) {
                    obj = null;
                } else if (typeDeserializer == null) {
                    obj = jsonDeserializer.a(jsonParser, deserializationContext);
                } else {
                    obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
                }
                e.put(enumR, obj);
            } else if (deserializationContext.a(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                jsonParser.c();
                jsonParser.f();
            } else {
                String o;
                try {
                    if (jsonParser.h()) {
                        o = jsonParser.o();
                        throw deserializationContext.a(o, this._enumClass, "value not one of declared Enum instance names");
                    }
                } catch (Exception e2) {
                }
                o = null;
                throw deserializationContext.a(o, this._enumClass, "value not one of declared Enum instance names");
            }
        }
        return e;
    }

    public final Object m11169a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo699a(jsonParser, deserializationContext);
    }

    private EnumMap<?, ?> m11166e() {
        return new EnumMap(this._enumClass);
    }
}
