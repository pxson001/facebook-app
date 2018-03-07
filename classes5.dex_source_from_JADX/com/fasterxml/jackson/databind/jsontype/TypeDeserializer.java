package com.fasterxml.jackson.databind.jsontype;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.annotation.JsonTypeInfo$As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: ccu_background_ping */
public abstract class TypeDeserializer {

    /* compiled from: ccu_background_ping */
    /* synthetic */ class C05541 {
        static final /* synthetic */ int[] f6117a = new int[JsonToken.values().length];

        static {
            try {
                f6117a[JsonToken.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6117a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6117a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6117a[JsonToken.VALUE_TRUE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6117a[JsonToken.VALUE_FALSE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public abstract JsonTypeInfo$As mo697a();

    public abstract TypeDeserializer mo698a(BeanProperty beanProperty);

    public abstract Object mo699a(JsonParser jsonParser, DeserializationContext deserializationContext);

    public abstract Object mo700b(JsonParser jsonParser, DeserializationContext deserializationContext);

    public abstract String mo694b();

    public abstract TypeIdResolver mo695c();

    public abstract Object mo701c(JsonParser jsonParser, DeserializationContext deserializationContext);

    public abstract Class<?> mo696d();

    public abstract Object mo702d(JsonParser jsonParser, DeserializationContext deserializationContext);

    private static Object m11381a(JsonParser jsonParser, Class<?> cls) {
        JsonToken g = jsonParser.g();
        if (g == null) {
            return null;
        }
        switch (C05541.f6117a[g.ordinal()]) {
            case 1:
                if (cls.isAssignableFrom(String.class)) {
                    return jsonParser.o();
                }
                return null;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (cls.isAssignableFrom(Integer.class)) {
                    return Integer.valueOf(jsonParser.x());
                }
                return null;
            case 3:
                if (cls.isAssignableFrom(Double.class)) {
                    return Double.valueOf(jsonParser.B());
                }
                return null;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.TRUE;
                }
                return null;
            case 5:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }

    public static Object m11380a(JsonParser jsonParser, DeserializationContext deserializationContext, JavaType javaType) {
        return m11381a(jsonParser, javaType._class);
    }
}
