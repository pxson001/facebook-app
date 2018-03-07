package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@JacksonStdImpl
/* compiled from: can_viewer_promote_cta */
public class JsonValueSerializer extends StdSerializer<Object> implements ContextualSerializer {
    protected final Method f6198a;
    protected final JsonSerializer<Object> f6199b;
    protected final BeanProperty f6200c;
    protected final boolean f6201d;

    public JsonValueSerializer(Method method, JsonSerializer<Object> jsonSerializer) {
        super(Object.class);
        this.f6198a = method;
        this.f6199b = jsonSerializer;
        this.f6200c = null;
        this.f6201d = true;
    }

    private JsonValueSerializer(JsonValueSerializer jsonValueSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, boolean z) {
        super(m11674a(jsonValueSerializer.a()));
        this.f6198a = jsonValueSerializer.f6198a;
        this.f6199b = jsonSerializer;
        this.f6200c = beanProperty;
        this.f6201d = z;
    }

    private static final Class<Object> m11674a(Class<?> cls) {
        return cls == null ? Object.class : cls;
    }

    private JsonValueSerializer m11673a(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, boolean z) {
        return (this.f6200c == beanProperty && this.f6199b == jsonSerializer && z == this.f6201d) ? this : new JsonValueSerializer(this, beanProperty, jsonSerializer, z);
    }

    public final JsonSerializer<?> m11676a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer jsonSerializer = this.f6199b;
        if (jsonSerializer == null) {
            if (!serializerProvider.a(MapperFeature.USE_STATIC_TYPING) && !Modifier.isFinal(this.f6198a.getReturnType().getModifiers())) {
                return this;
            }
            JavaType a = serializerProvider.a(this.f6198a.getGenericReturnType());
            JsonSerializer a2 = serializerProvider.a(a, false, this.f6200c);
            return m11673a(beanProperty, a2, m11675a(a._class, a2));
        } else if (jsonSerializer instanceof ContextualSerializer) {
            return m11673a(beanProperty, ((ContextualSerializer) jsonSerializer).a(serializerProvider, beanProperty), this.f6201d);
        } else {
            return this;
        }
    }

    public final void m11677a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        try {
            Object invoke = this.f6198a.invoke(obj, new Object[0]);
            if (invoke == null) {
                serializerProvider.a(jsonGenerator);
                return;
            }
            JsonSerializer jsonSerializer = this.f6199b;
            if (jsonSerializer == null) {
                jsonSerializer = serializerProvider.a(invoke.getClass(), true, this.f6200c);
            }
            jsonSerializer.a(invoke, jsonGenerator, serializerProvider);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            Throwable e3 = e2;
            while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                e3 = e3.getCause();
            }
            if (e3 instanceof Error) {
                throw ((Error) e3);
            }
            throw JsonMappingException.a(e3, obj, this.f6198a.getName() + "()");
        }
    }

    public final void m11678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        try {
            Object invoke = this.f6198a.invoke(obj, new Object[0]);
            if (invoke == null) {
                serializerProvider.a(jsonGenerator);
                return;
            }
            JsonSerializer jsonSerializer = this.f6199b;
            if (jsonSerializer == null) {
                jsonSerializer = serializerProvider.a(invoke.getClass(), this.f6200c);
            } else if (this.f6201d) {
                typeSerializer.mo704a(obj, jsonGenerator);
                jsonSerializer.a(invoke, jsonGenerator, serializerProvider);
                typeSerializer.mo710d(obj, jsonGenerator);
                return;
            }
            jsonSerializer.a(invoke, jsonGenerator, serializerProvider, typeSerializer);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            Throwable e3 = e2;
            while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                e3 = e3.getCause();
            }
            if (e3 instanceof Error) {
                throw ((Error) e3);
            }
            throw JsonMappingException.a(e3, obj, this.f6198a.getName() + "()");
        }
    }

    private boolean m11675a(Class<?> cls, JsonSerializer<?> jsonSerializer) {
        if (cls.isPrimitive()) {
            if (!(cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE)) {
                return false;
            }
        } else if (!(cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class)) {
            return false;
        }
        return StdSerializer.a(jsonSerializer);
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this.f6198a.getDeclaringClass() + "#" + this.f6198a.getName() + ")";
    }
}
