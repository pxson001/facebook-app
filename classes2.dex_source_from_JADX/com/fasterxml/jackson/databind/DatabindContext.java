package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.reflect.Type;

/* compiled from: status_to_update */
public abstract class DatabindContext {
    public abstract MapperConfig<?> mo1070a();

    public abstract TypeFactory mo1071c();

    public final ObjectIdGenerator<?> m7331a(Annotated annotated, ObjectIdInfo objectIdInfo) {
        ObjectIdGenerator objectIdGenerator;
        Class cls = objectIdInfo.b;
        MapperConfig a = mo1070a();
        if (a.m7267l() == null) {
            objectIdGenerator = null;
        } else {
            objectIdGenerator = null;
        }
        if (objectIdGenerator == null) {
            objectIdGenerator = (ObjectIdGenerator) ClassUtil.b(cls, a.m7263h());
        }
        return objectIdGenerator.a(objectIdInfo.c);
    }

    public final boolean m7336a(MapperFeature mapperFeature) {
        return mo1070a().m7257a(mapperFeature);
    }

    public final boolean m7337b() {
        return mo1070a().m7263h();
    }

    public final JavaType m7333a(Type type) {
        return mo1071c().m7109a(type);
    }

    public final JavaType m7332a(JavaType javaType, Class<?> cls) {
        return mo1070a().m7255a(javaType, (Class) cls);
    }

    public final Converter<Object, Object> m7335a(Annotated annotated, Object obj) {
        Converter converter = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Converter) {
            return (Converter) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == None.class || cls == NoClass.class) {
                return null;
            }
            if (Converter.class.isAssignableFrom(cls)) {
                MapperConfig a = mo1070a();
                if (a.m7267l() != null) {
                    converter = null;
                }
                if (converter == null) {
                    converter = (Converter) ClassUtil.b(cls, a.m7263h());
                }
                return converter;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }
}
