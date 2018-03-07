package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.type.SimpleType;
import java.io.Serializable;

/* compiled from: storygallerysurvey */
public class BasicClassIntrospector extends ClassIntrospector implements Serializable {
    protected static final BasicBeanDescription f4011a = BasicBeanDescription.m6810a(null, SimpleType.m6679h(String.class), AnnotatedClass.m6768b(String.class, null, null));
    protected static final BasicBeanDescription f4012b = BasicBeanDescription.m6810a(null, SimpleType.m6679h(Boolean.TYPE), AnnotatedClass.m6768b(Boolean.TYPE, null, null));
    protected static final BasicBeanDescription f4013c = BasicBeanDescription.m6810a(null, SimpleType.m6679h(Integer.TYPE), AnnotatedClass.m6768b(Integer.TYPE, null, null));
    protected static final BasicBeanDescription f4014d = BasicBeanDescription.m6810a(null, SimpleType.m6679h(Long.TYPE), AnnotatedClass.m6768b(Long.TYPE, null, null));
    public static final BasicClassIntrospector f4015e = new BasicClassIntrospector();
    private static final long serialVersionUID = 1;

    public /* synthetic */ BeanDescription mo932b(SerializationConfig serializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        return mo1058a(serializationConfig, javaType, mixInResolver);
    }

    public /* synthetic */ BeanDescription mo935d(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        return mo1057a(deserializationConfig, javaType, mixInResolver);
    }

    public BasicBeanDescription mo1058a(SerializationConfig serializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription a = m6733a(javaType);
        if (a != null) {
            return a;
        }
        return BasicBeanDescription.m6814b(m6736a((MapperConfig) serializationConfig, javaType, mixInResolver, true, "set"));
    }

    public BasicBeanDescription mo1057a(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription a = m6733a(javaType);
        if (a != null) {
            return a;
        }
        return BasicBeanDescription.m6811a(m6736a((MapperConfig) deserializationConfig, javaType, mixInResolver, false, "set"));
    }

    public final BeanDescription mo934c(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        return BasicBeanDescription.m6811a(m6735a(deserializationConfig, javaType, mixInResolver, false));
    }

    public final BeanDescription mo931b(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        BeanDescription a = m6733a(javaType);
        if (a != null) {
            return a;
        }
        return BasicBeanDescription.m6811a(m6736a((MapperConfig) deserializationConfig, javaType, mixInResolver, false, "set"));
    }

    public final BeanDescription mo933b(MapperConfig mapperConfig, JavaType javaType, MixInResolver mixInResolver) {
        return BasicBeanDescription.m6810a(mapperConfig, javaType, AnnotatedClass.m6750a(javaType._class, mapperConfig.m7262g() ? mapperConfig.mo1061a() : null, mixInResolver));
    }

    public static BasicBeanDescription m6734a(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver) {
        boolean g = mapperConfig.m7262g();
        AnnotationIntrospector a = mapperConfig.mo1061a();
        Class cls = javaType._class;
        if (!g) {
            a = null;
        }
        return BasicBeanDescription.m6810a(mapperConfig, javaType, AnnotatedClass.m6768b(cls, a, mixInResolver));
    }

    private POJOPropertiesCollector m6736a(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver, boolean z, String str) {
        return m6737a((MapperConfig) mapperConfig, AnnotatedClass.m6750a(javaType._class, mapperConfig.m7262g() ? mapperConfig.mo1061a() : null, mixInResolver), javaType, z, str).k();
    }

    private POJOPropertiesCollector m6735a(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver, boolean z) {
        AnnotationIntrospector a;
        Value value = null;
        if (mapperConfig.m7262g()) {
            a = mapperConfig.mo1061a();
        } else {
            a = null;
        }
        AnnotatedClass a2 = AnnotatedClass.m6750a(javaType._class, a, mixInResolver);
        if (a != null) {
            value = a.mo1012k(a2);
        }
        return m6737a((MapperConfig) mapperConfig, a2, javaType, z, value == null ? "with" : value.b).k();
    }

    private static POJOPropertiesCollector m6737a(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType, boolean z, String str) {
        return new POJOPropertiesCollector(mapperConfig, z, javaType, annotatedClass, str);
    }

    protected static BasicBeanDescription m6733a(JavaType javaType) {
        Class cls = javaType._class;
        if (cls == String.class) {
            return f4011a;
        }
        if (cls == Boolean.TYPE) {
            return f4012b;
        }
        if (cls == Integer.TYPE) {
            return f4013c;
        }
        if (cls == Long.TYPE) {
            return f4014d;
        }
        return null;
    }
}
