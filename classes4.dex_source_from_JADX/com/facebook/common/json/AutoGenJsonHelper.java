package com.facebook.common.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Collection;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: is_sponsored */
public final class AutoGenJsonHelper {
    private AutoGenJsonHelper() {
    }

    public static void m10225a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, String str, @Nullable Object obj) {
        if (obj != null) {
            jsonGenerator.a(str);
            m10223a(jsonGenerator, serializerProvider, obj);
        }
    }

    public static void m10226a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, String str, Collection<?> collection) {
        if (collection != null) {
            jsonGenerator.a(str);
            m10227a(jsonGenerator, serializerProvider, (Collection) collection);
        }
    }

    public static void m10224a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, String str, @Nullable JsonSerializable jsonSerializable) {
        if (jsonSerializable != null) {
            jsonGenerator.a(str);
            jsonSerializable.serialize(jsonGenerator, serializerProvider);
        }
    }

    public static void m10234a(JsonGenerator jsonGenerator, String str, String str2) {
        if (str2 != null) {
            jsonGenerator.a(str);
            jsonGenerator.b(str2);
        }
    }

    public static void m10232a(JsonGenerator jsonGenerator, String str, Integer num) {
        if (num != null) {
            jsonGenerator.a(str);
            jsonGenerator.b(num.intValue());
        }
    }

    public static void m10233a(JsonGenerator jsonGenerator, String str, Long l) {
        if (l != null) {
            jsonGenerator.a(str);
            jsonGenerator.a(l.longValue());
        }
    }

    public static void m10230a(JsonGenerator jsonGenerator, String str, Double d) {
        if (d != null) {
            jsonGenerator.a(str);
            jsonGenerator.a(d.doubleValue());
        }
    }

    public static void m10231a(JsonGenerator jsonGenerator, String str, Float f) {
        if (f != null) {
            jsonGenerator.a(str);
            jsonGenerator.a(f.floatValue());
        }
    }

    public static void m10229a(JsonGenerator jsonGenerator, String str, Boolean bool) {
        if (bool != null) {
            jsonGenerator.a(str);
            jsonGenerator.a(bool.booleanValue());
        }
    }

    public static void m10227a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Collection<?> collection) {
        if (collection != null) {
            jsonGenerator.d();
            for (Object a : collection) {
                m10223a(jsonGenerator, serializerProvider, a);
            }
            jsonGenerator.e();
        }
    }

    private static void m10223a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) {
        if (obj != null) {
            Class cls = obj.getClass();
            if (JsonSerializable.class.isAssignableFrom(cls)) {
                ((JsonSerializable) obj).serialize(jsonGenerator, serializerProvider);
            } else if (cls.isEnum()) {
                m10228a(jsonGenerator, (Enum) obj);
            } else if (Collection.class.isAssignableFrom(cls)) {
                m10227a(jsonGenerator, serializerProvider, (Collection) obj);
            } else {
                jsonGenerator.a(obj);
            }
        }
    }

    public static void m10228a(JsonGenerator jsonGenerator, Enum<?> enumR) {
        jsonGenerator.b(enumR.name());
    }

    public static void m10235a(SerializationConfig serializationConfig) {
        if (!Include.NON_NULL.equals(serializationConfig.b())) {
            throw new IllegalArgumentException(String.format(Locale.US, "Currently, we only support serialization inclusion %s. You are using %s.", new Object[]{Include.NON_NULL, serializationConfig.b()}));
        }
    }
}
