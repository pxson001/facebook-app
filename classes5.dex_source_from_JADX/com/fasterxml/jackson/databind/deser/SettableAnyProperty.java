package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.io.IOException;
import java.lang.reflect.Method;

/* compiled from: clear_feed_cache */
public final class SettableAnyProperty {
    public final BeanProperty f6005a;
    protected final Method f6006b;
    public final JavaType f6007c;
    protected JsonDeserializer<Object> f6008d;

    private SettableAnyProperty(BeanProperty beanProperty, Method method, JavaType javaType, JsonDeserializer<Object> jsonDeserializer) {
        this.f6005a = beanProperty;
        this.f6007c = javaType;
        this.f6006b = method;
        this.f6008d = jsonDeserializer;
    }

    public final SettableAnyProperty m10960a(JsonDeserializer<Object> jsonDeserializer) {
        return new SettableAnyProperty(this.f6005a, this.f6006b, this.f6007c, (JsonDeserializer) jsonDeserializer);
    }

    public final BeanProperty m10959a() {
        return this.f6005a;
    }

    public final boolean m10964b() {
        return this.f6008d != null;
    }

    public final JavaType m10965c() {
        return this.f6007c;
    }

    public SettableAnyProperty(BeanProperty beanProperty, AnnotatedMethod annotatedMethod, JavaType javaType, JsonDeserializer<Object> jsonDeserializer) {
        this(beanProperty, annotatedMethod.a, javaType, (JsonDeserializer) jsonDeserializer);
    }

    public final void m10962a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) {
        m10963a(obj, str, m10961a(jsonParser, deserializationContext));
    }

    public final Object m10961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() == JsonToken.VALUE_NULL) {
            return null;
        }
        return this.f6008d.a(jsonParser, deserializationContext);
    }

    public final void m10963a(Object obj, String str, Object obj2) {
        try {
            this.f6006b.invoke(obj, new Object[]{str, obj2});
        } catch (Exception e) {
            m10957a(e, str, obj2);
        }
    }

    private void m10957a(Exception exception, String str, Object obj) {
        if (exception instanceof IllegalArgumentException) {
            String name = obj == null ? "[NULL]" : obj.getClass().getName();
            StringBuilder append = new StringBuilder("Problem deserializing \"any\" property '").append(str);
            append.append("' of class " + m10958d() + " (expected type: ").append(this.f6007c);
            append.append("; actual type: ").append(name).append(")");
            name = exception.getMessage();
            if (name != null) {
                append.append(", problem: ").append(name);
            } else {
                append.append(" (no error message provided)");
            }
            throw new JsonMappingException(append.toString(), null, exception);
        } else if (exception instanceof IOException) {
            throw ((IOException) exception);
        } else if (exception instanceof RuntimeException) {
            throw ((RuntimeException) exception);
        } else {
            while (exception.getCause() != null) {
                exception = exception.getCause();
            }
            throw new JsonMappingException(exception.getMessage(), null, exception);
        }
    }

    private String m10958d() {
        return this.f6006b.getDeclaringClass().getName();
    }

    public final String toString() {
        return "[any property on class " + m10958d() + "]";
    }
}
