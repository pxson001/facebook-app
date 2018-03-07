package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Calendar;
import java.util.Date;

/* compiled from: float */
public class StdKeySerializers {
    protected static final JsonSerializer<Object> f11534a = new StdKeySerializer();
    protected static final JsonSerializer<Object> f11535b = new StringKeySerializer();

    /* compiled from: float */
    public class StringKeySerializer extends StdSerializer<String> {
        public final void m12022a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.a((String) obj);
        }

        public StringKeySerializer() {
            super(String.class);
        }
    }

    private StdKeySerializers() {
    }

    public static JsonSerializer<Object> m12020a(JavaType javaType) {
        if (javaType == null) {
            return f11534a;
        }
        Class cls = javaType._class;
        if (cls == String.class) {
            return f11535b;
        }
        if (cls == Object.class) {
            return f11534a;
        }
        if (Date.class.isAssignableFrom(cls)) {
            return DateKeySerializer.a;
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            return CalendarKeySerializer.a;
        }
        return f11534a;
    }
}
