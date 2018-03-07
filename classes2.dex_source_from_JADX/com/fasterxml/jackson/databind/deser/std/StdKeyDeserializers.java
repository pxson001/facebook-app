package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.BoolKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.ByteKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.CalendarKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.CharKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.DateKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.DelegatingKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.DoubleKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.EnumKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.FloatKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.IntKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.LocaleKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.LongKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.ShortKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringCtorKeyDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringFactoryKeyDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringKD;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.UuidKD;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* compiled from: start_for_result */
public class StdKeyDeserializers implements KeyDeserializers, Serializable {
    private static final long serialVersionUID = 923268084968181479L;

    public static KeyDeserializer m7521a(EnumResolver<?> enumResolver) {
        return new EnumKD(enumResolver, null);
    }

    public static KeyDeserializer m7522a(EnumResolver<?> enumResolver, AnnotatedMethod annotatedMethod) {
        return new EnumKD(enumResolver, annotatedMethod);
    }

    public static KeyDeserializer m7520a(JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
        return new DelegatingKD(javaType._class, jsonDeserializer);
    }

    public static KeyDeserializer m7519a(DeserializationConfig deserializationConfig, JavaType javaType) {
        BeanDescription b = deserializationConfig.m7281b(javaType);
        Object a = b.mo947a(String.class);
        if (a != null) {
            if (deserializationConfig.m7263h()) {
                ClassUtil.a(a);
            }
            return new StringCtorKeyDeserializer(a);
        }
        a = b.mo948b(String.class);
        if (a == null) {
            return null;
        }
        if (deserializationConfig.m7263h()) {
            ClassUtil.a(a);
        }
        return new StringFactoryKeyDeserializer(a);
    }

    public final KeyDeserializer mo1094a(JavaType javaType) {
        Class cls = javaType._class;
        if (cls == String.class || cls == Object.class) {
            return StringKD.a(cls);
        }
        if (cls == UUID.class) {
            return new UuidKD();
        }
        if (cls.isPrimitive()) {
            cls = ClassUtil.g(cls);
        }
        if (cls == Integer.class) {
            return new IntKD();
        }
        if (cls == Long.class) {
            return new LongKD();
        }
        if (cls == Date.class) {
            return new DateKD();
        }
        if (cls == Calendar.class) {
            return new CalendarKD();
        }
        if (cls == Boolean.class) {
            return new BoolKD();
        }
        if (cls == Byte.class) {
            return new ByteKD();
        }
        if (cls == Character.class) {
            return new CharKD();
        }
        if (cls == Short.class) {
            return new ShortKD();
        }
        if (cls == Float.class) {
            return new FloatKD();
        }
        if (cls == Double.class) {
            return new DoubleKD();
        }
        if (cls == Locale.class) {
            return new LocaleKD();
        }
        return null;
    }
}
