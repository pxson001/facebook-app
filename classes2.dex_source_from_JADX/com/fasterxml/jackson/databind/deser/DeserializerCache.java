package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: start_download */
public final class DeserializerCache implements Serializable {
    private static final long serialVersionUID = 1;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new ConcurrentHashMap(64, 0.75f, 2);
    protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap(8);

    final Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }

    public final JsonDeserializer<Object> m7536a(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory, JavaType javaType) {
        JsonDeserializer<Object> a = m7528a(javaType);
        if (a != null) {
            return a;
        }
        a = m7532c(deserializationContext, deserializerFactory, javaType);
        if (a == null) {
            return m7530b(javaType);
        }
        return a;
    }

    public final KeyDeserializer m7537b(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory, JavaType javaType) {
        KeyDeserializer a = deserializerFactory.mo1091a(deserializationContext, javaType);
        if (a == null) {
            return m7533c(javaType);
        }
        if (!(a instanceof ResolvableDeserializer)) {
            return a;
        }
        ((ResolvableDeserializer) a).a(deserializationContext);
        return a;
    }

    private static JsonDeserializer<?> m7525a(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory, JavaType javaType, BeanDescription beanDescription) {
        DeserializationConfig deserializationConfig = deserializationContext._config;
        if (javaType.m6718h()) {
            return deserializerFactory.mo1085a(deserializationContext, javaType, beanDescription);
        }
        if (javaType.mo924l()) {
            if (javaType.m6716g()) {
                return deserializerFactory.mo1086a(deserializationContext, (ArrayType) javaType, beanDescription);
            }
            if (javaType.m6724n()) {
                MapLikeType mapLikeType = (MapLikeType) javaType;
                if (mapLikeType.x()) {
                    return deserializerFactory.mo1090a(deserializationContext, (MapType) mapLikeType, beanDescription);
                }
                return deserializerFactory.mo1089a(deserializationContext, mapLikeType, beanDescription);
            } else if (javaType.m6723m()) {
                Value a = beanDescription.mo942a(null);
                if (a == null || a.b != Shape.OBJECT) {
                    CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
                    if (collectionLikeType.x()) {
                        return deserializerFactory.mo1088a(deserializationContext, (CollectionType) collectionLikeType, beanDescription);
                    }
                    return deserializerFactory.mo1087a(deserializationContext, collectionLikeType, beanDescription);
                }
            }
        }
        if (JsonNode.class.isAssignableFrom(javaType._class)) {
            return deserializerFactory.mo1084a(deserializationConfig, javaType, beanDescription);
        }
        return deserializerFactory.mo1082c(deserializationContext, javaType, beanDescription);
    }

    private JsonDeserializer<Object> m7535e(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory, JavaType javaType) {
        DeserializationConfig deserializationConfig = deserializationContext._config;
        if (javaType.m6711d() || javaType.m6724n() || javaType.m6723m()) {
            javaType = deserializerFactory.mo1083a(deserializationConfig, javaType);
        }
        BeanDescription b = deserializationConfig.m7281b(javaType);
        JsonDeserializer<Object> a = m7526a(deserializationContext, b.mo949c());
        if (a != null) {
            return a;
        }
        JavaType a2 = m7524a(deserializationContext, b.mo949c(), javaType);
        if (a2 != javaType) {
            b = deserializationConfig.m7281b(a2);
            javaType = a2;
        }
        Class t = b.mo966t();
        if (t != null) {
            return deserializerFactory.mo1080a(deserializationContext, javaType, t);
        }
        Converter r = b.mo964r();
        if (r == null) {
            return m7525a(deserializationContext, deserializerFactory, javaType, b);
        }
        JavaType b2 = r.b();
        if (!b2.m6717g(javaType._class)) {
            b = deserializationConfig.m7281b(b2);
        }
        return new StdDelegatingDeserializer(r, b2, m7525a(deserializationContext, deserializerFactory, b2, b));
    }

    private JsonDeserializer<Object> m7528a(JavaType javaType) {
        if (javaType != null) {
            return (JsonDeserializer) this._cachedDeserializers.get(javaType);
        }
        throw new IllegalArgumentException("Null JavaType passed");
    }

    private static JsonDeserializer<Object> m7530b(JavaType javaType) {
        if (ClassUtil.d(javaType._class)) {
            throw new JsonMappingException("Can not find a Value deserializer for type " + javaType);
        }
        throw new JsonMappingException("Can not find a Value deserializer for abstract type " + javaType);
    }

    private JsonDeserializer<Object> m7532c(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory, JavaType javaType) {
        JsonDeserializer<Object> a;
        synchronized (this._incompleteDeserializers) {
            a = m7528a(javaType);
            if (a != null) {
            } else {
                int size = this._incompleteDeserializers.size();
                if (size > 0) {
                    a = (JsonDeserializer) this._incompleteDeserializers.get(javaType);
                    if (a != null) {
                    }
                }
                try {
                    a = m7534d(deserializationContext, deserializerFactory, javaType);
                    if (size == 0 && this._incompleteDeserializers.size() > 0) {
                        this._incompleteDeserializers.clear();
                    }
                } catch (Throwable th) {
                    if (size == 0 && this._incompleteDeserializers.size() > 0) {
                        this._incompleteDeserializers.clear();
                    }
                }
            }
        }
        return a;
    }

    private JsonDeserializer<Object> m7534d(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory, JavaType javaType) {
        try {
            JsonDeserializer<Object> e = m7535e(deserializationContext, deserializerFactory, javaType);
            if (e == null) {
                return null;
            }
            boolean z = e instanceof ResolvableDeserializer;
            boolean d = e.mo1881d();
            if (z) {
                this._incompleteDeserializers.put(javaType, e);
                ((ResolvableDeserializer) e).a(deserializationContext);
                this._incompleteDeserializers.remove(javaType);
            }
            if (!d) {
                return e;
            }
            this._cachedDeserializers.put(javaType, e);
            return e;
        } catch (Throwable e2) {
            throw new JsonMappingException(e2.getMessage(), null, e2);
        }
    }

    private JsonDeserializer<Object> m7526a(DeserializationContext deserializationContext, Annotated annotated) {
        Object o = deserializationContext.m7407f().mo1017o(annotated);
        if (o == null) {
            return null;
        }
        return m7527a(deserializationContext, annotated, deserializationContext.mo1078b(annotated, o));
    }

    private JsonDeserializer<Object> m7527a(DeserializationContext deserializationContext, Annotated annotated, JsonDeserializer<Object> jsonDeserializer) {
        Converter b = m7531b(deserializationContext, annotated);
        return b == null ? jsonDeserializer : new StdDelegatingDeserializer(b, b.b(), jsonDeserializer);
    }

    private static Converter<Object, Object> m7531b(DeserializationContext deserializationContext, Annotated annotated) {
        Object u = deserializationContext.m7407f().mo1023u(annotated);
        if (u == null) {
            return null;
        }
        return deserializationContext.m7335a(annotated, u);
    }

    private JavaType m7524a(DeserializationContext deserializationContext, Annotated annotated, JavaType javaType) {
        AnnotationIntrospector f = deserializationContext.m7407f();
        Class r = f.mo1020r(annotated);
        if (r != null) {
            try {
                JavaType a = javaType.m6700a(r);
            } catch (Throwable e) {
                throw new JsonMappingException("Failed to narrow type " + javaType + " with concrete-type annotation (value " + r.getName() + "), method '" + annotated.mo938b() + "': " + e.getMessage(), null, e);
            }
        }
        a = javaType;
        if (!a.mo924l()) {
            return a;
        }
        JavaType javaType2;
        Object p;
        Class s = f.mo1021s(annotated);
        if (s == null) {
            javaType2 = a;
        } else if (a instanceof MapLikeType) {
            try {
                javaType2 = ((MapLikeType) a).h(s);
            } catch (Throwable e2) {
                throw new JsonMappingException("Failed to narrow key type " + a + " with key-type annotation (" + s.getName() + "): " + e2.getMessage(), null, e2);
            }
        } else {
            throw new JsonMappingException("Illegal key-type annotation: type " + a + " is not a Map(-like) type");
        }
        a = javaType2.m6727q();
        if (a != null && a.mo929t() == null) {
            p = f.mo1018p(annotated);
            if (p != null) {
                KeyDeserializer c = deserializationContext.mo1079c(annotated, p);
                if (c != null) {
                    javaType2 = ((MapLikeType) javaType2).i(c);
                }
            }
        }
        Class t = f.mo1022t(annotated);
        if (t != null) {
            try {
                javaType2 = javaType2.mo921e(t);
            } catch (Throwable e3) {
                throw new JsonMappingException("Failed to narrow content type " + javaType2 + " with content-type annotation (" + t.getName() + "): " + e3.getMessage(), null, e3);
            }
        }
        if (javaType2.m6728r().mo929t() != null) {
            return javaType2;
        }
        p = f.mo1019q(annotated);
        if (p == null) {
            return javaType2;
        }
        if (!(p instanceof JsonDeserializer)) {
            p = m7529a(p, "findContentDeserializer", None.class);
            if (p != null) {
                p = deserializationContext.mo1078b(annotated, p);
                if (p == null) {
                    return javaType2.mo920d(p);
                }
                return javaType2;
            }
        }
        p = null;
        if (p == null) {
            return javaType2;
        }
        return javaType2.mo920d(p);
    }

    private static Class<?> m7529a(Object obj, String str, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            Class<?> cls2 = (Class) obj;
            if (cls2 == cls || cls2 == NoClass.class) {
                return null;
            }
            return cls2;
        }
        throw new IllegalStateException("AnnotationIntrospector." + str + "() returned value of type " + obj.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }

    private static KeyDeserializer m7533c(JavaType javaType) {
        throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + javaType);
    }
}
