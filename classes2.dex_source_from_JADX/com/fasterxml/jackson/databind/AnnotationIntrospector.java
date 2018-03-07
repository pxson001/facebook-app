package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude$Include;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;

/* compiled from: story_hidden */
public abstract class AnnotationIntrospector implements Versioned, Serializable {
    public static AnnotationIntrospector m6932a() {
        return NopAnnotationIntrospector.a;
    }

    public boolean mo979a(Annotation annotation) {
        return false;
    }

    public ObjectIdInfo mo971a(Annotated annotated) {
        return null;
    }

    public ObjectIdInfo mo972a(Annotated annotated, ObjectIdInfo objectIdInfo) {
        return objectIdInfo;
    }

    public PropertyName mo970a(AnnotatedClass annotatedClass) {
        return null;
    }

    public String[] mo985b(Annotated annotated) {
        return null;
    }

    public Boolean mo982b(AnnotatedClass annotatedClass) {
        return null;
    }

    public Boolean mo986c(AnnotatedClass annotatedClass) {
        return null;
    }

    public Object mo990d(AnnotatedClass annotatedClass) {
        return null;
    }

    public Object mo996e(AnnotatedClass annotatedClass) {
        return null;
    }

    public VisibilityChecker<?> mo973a(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    public TypeResolverBuilder<?> mo974a(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return null;
    }

    public TypeResolverBuilder<?> mo975a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public TypeResolverBuilder<?> mo980b(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public List<NamedType> mo988c(Annotated annotated) {
        return null;
    }

    public String mo1000f(AnnotatedClass annotatedClass) {
        return null;
    }

    public ReferenceProperty mo969a(AnnotatedMember annotatedMember) {
        return null;
    }

    public NameTransformer mo981b(AnnotatedMember annotatedMember) {
        return null;
    }

    public boolean mo989c(AnnotatedMember annotatedMember) {
        return false;
    }

    public Object mo991d(AnnotatedMember annotatedMember) {
        return null;
    }

    public Boolean mo995e(AnnotatedMember annotatedMember) {
        return null;
    }

    public Class<?>[] mo993d(Annotated annotated) {
        return null;
    }

    @Deprecated
    public Value mo998f(AnnotatedMember annotatedMember) {
        return null;
    }

    public Value mo994e(Annotated annotated) {
        if (annotated instanceof AnnotatedMember) {
            return mo998f((AnnotatedMember) annotated);
        }
        return null;
    }

    public Boolean mo1001g(AnnotatedMember annotatedMember) {
        return null;
    }

    public static PropertyName m6934b() {
        return null;
    }

    public Object mo999f(Annotated annotated) {
        return null;
    }

    public Object mo1002g(Annotated annotated) {
        return null;
    }

    public Object mo1005h(Annotated annotated) {
        return null;
    }

    public JsonInclude$Include mo968a(Annotated annotated, JsonInclude$Include jsonInclude$Include) {
        return jsonInclude$Include;
    }

    public Class<?> mo1007i(Annotated annotated) {
        return null;
    }

    public Class<?> mo1010j(Annotated annotated) {
        return null;
    }

    public Class<?> mo1013k(Annotated annotated) {
        return null;
    }

    public Typing mo1014l(Annotated annotated) {
        return null;
    }

    public Object mo1015m(Annotated annotated) {
        return null;
    }

    public Object mo1006h(AnnotatedMember annotatedMember) {
        return null;
    }

    public String[] mo1003g(AnnotatedClass annotatedClass) {
        return null;
    }

    public Boolean mo1004h(AnnotatedClass annotatedClass) {
        return null;
    }

    public PropertyName mo1016n(Annotated annotated) {
        String a = annotated instanceof AnnotatedField ? mo976a((AnnotatedField) annotated) : annotated instanceof AnnotatedMethod ? mo977a((AnnotatedMethod) annotated) : null;
        if (a == null) {
            return null;
        }
        if (a.length() == 0) {
            return PropertyName.a;
        }
        return new PropertyName(a);
    }

    @Deprecated
    public String mo977a(AnnotatedMethod annotatedMethod) {
        return null;
    }

    @Deprecated
    public String mo976a(AnnotatedField annotatedField) {
        return null;
    }

    public boolean mo984b(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public static String m6933a(Enum<?> enumR) {
        return enumR.name();
    }

    public Object mo1017o(Annotated annotated) {
        return null;
    }

    public Object mo1018p(Annotated annotated) {
        return null;
    }

    public Object mo1019q(Annotated annotated) {
        return null;
    }

    public Class<?> mo1020r(Annotated annotated) {
        return null;
    }

    public Class<?> mo1021s(Annotated annotated) {
        return null;
    }

    public Class<?> mo1022t(Annotated annotated) {
        return null;
    }

    public Object mo1023u(Annotated annotated) {
        return null;
    }

    public Object mo1009i(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object mo1008i(AnnotatedClass annotatedClass) {
        return null;
    }

    public Class<?> mo1011j(AnnotatedClass annotatedClass) {
        return null;
    }

    public JsonPOJOBuilder.Value mo1012k(AnnotatedClass annotatedClass) {
        return null;
    }

    public PropertyName mo1024v(Annotated annotated) {
        String b = annotated instanceof AnnotatedField ? mo983b((AnnotatedField) annotated) : annotated instanceof AnnotatedMethod ? mo987c((AnnotatedMethod) annotated) : annotated instanceof AnnotatedParameter ? mo978a((AnnotatedParameter) annotated) : null;
        if (b == null) {
            return null;
        }
        if (b.length() == 0) {
            return PropertyName.a;
        }
        return new PropertyName(b);
    }

    @Deprecated
    public String mo987c(AnnotatedMethod annotatedMethod) {
        return null;
    }

    @Deprecated
    public String mo983b(AnnotatedField annotatedField) {
        return null;
    }

    @Deprecated
    public String mo978a(AnnotatedParameter annotatedParameter) {
        return null;
    }

    public boolean mo992d(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean mo997e(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean mo1025w(Annotated annotated) {
        return false;
    }
}
