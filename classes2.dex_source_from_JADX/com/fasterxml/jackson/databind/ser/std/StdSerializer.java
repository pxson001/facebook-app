package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: status_reason */
public abstract class StdSerializer<T> extends JsonSerializer<T> {
    protected final Class<T> f4137k;

    public abstract void mo1072a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    protected StdSerializer(Class<T> cls) {
        this.f4137k = cls;
    }

    protected StdSerializer(JavaType javaType) {
        this.f4137k = javaType._class;
    }

    protected StdSerializer(Class<?> cls, byte b) {
        this.f4137k = cls;
    }

    public final Class<T> mo1073a() {
        return this.f4137k;
    }

    public static void m7342a(SerializerProvider serializerProvider, Throwable th, Object obj, String str) {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj2 = (serializerProvider == null || serializerProvider.m7316a(SerializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj2 == null || !(th2 instanceof JsonMappingException)) {
                throw ((IOException) th2);
            }
        } else if (obj2 == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        throw JsonMappingException.a(th2, obj, str);
    }

    public static void m7341a(SerializerProvider serializerProvider, Throwable th, Object obj, int i) {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj2 = (serializerProvider == null || serializerProvider.m7316a(SerializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj2 == null || !(th2 instanceof JsonMappingException)) {
                throw ((IOException) th2);
            }
        } else if (obj2 == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        throw JsonMappingException.a(th2, obj, i);
    }

    protected static boolean m7343a(JsonSerializer<?> jsonSerializer) {
        return (jsonSerializer == null || jsonSerializer.getClass().getAnnotation(JacksonStdImpl.class) == null) ? false : true;
    }

    protected static JsonSerializer<?> m7340a(SerializerProvider serializerProvider, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer) {
        AnnotationIntrospector e = serializerProvider.m7322e();
        if (e == null || beanProperty == null) {
            return jsonSerializer;
        }
        Object h = e.mo1006h(beanProperty.b());
        if (h == null) {
            return jsonSerializer;
        }
        Converter a = serializerProvider.m7335a(beanProperty.b(), h);
        serializerProvider.mo1071c();
        JavaType c = a.c();
        if (jsonSerializer == null) {
            jsonSerializer = serializerProvider.m7305a(c, beanProperty);
        }
        return new StdDelegatingSerializer(a, c, jsonSerializer);
    }
}
