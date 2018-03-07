package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.util.Collection;

/* compiled from: store_conversion */
public abstract class SubtypeResolver {
    public abstract Collection<NamedType> mo1059a(AnnotatedClass annotatedClass, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector);

    public abstract Collection<NamedType> mo1060a(AnnotatedMember annotatedMember, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, JavaType javaType);
}
