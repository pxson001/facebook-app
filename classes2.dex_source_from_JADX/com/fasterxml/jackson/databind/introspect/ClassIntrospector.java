package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

/* compiled from: story_view */
public abstract class ClassIntrospector {

    /* compiled from: story_view */
    public interface MixInResolver {
        Class<?> mo1064d(Class<?> cls);
    }

    public abstract BeanDescription mo931b(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription mo932b(SerializationConfig serializationConfig, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription mo933b(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription mo934c(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription mo935d(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver);

    protected ClassIntrospector() {
    }
}
