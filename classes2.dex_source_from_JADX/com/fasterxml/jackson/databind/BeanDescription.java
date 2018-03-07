package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude$Include;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.Converter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: story_index */
public abstract class BeanDescription {
    public final JavaType f4041a;

    public abstract Value mo942a(Value value);

    public abstract JsonInclude$Include mo943a(JsonInclude$Include jsonInclude$Include);

    public abstract JavaType mo944a(Type type);

    public abstract AnnotatedMethod mo945a(String str, Class<?>[] clsArr);

    public abstract Object mo946a(boolean z);

    public abstract Constructor<?> mo947a(Class<?>... clsArr);

    public abstract Method mo948b(Class<?>... clsArr);

    public abstract AnnotatedClass mo949c();

    public abstract ObjectIdInfo mo950d();

    public abstract boolean mo951e();

    public abstract TypeBindings mo952f();

    public abstract Annotations mo953g();

    public abstract List<BeanPropertyDefinition> mo954h();

    public abstract Map<String, AnnotatedMember> mo955i();

    public abstract Set<String> mo956j();

    public abstract List<AnnotatedConstructor> mo957k();

    public abstract List<AnnotatedMethod> mo958l();

    public abstract AnnotatedConstructor mo959m();

    public abstract AnnotatedMember mo960n();

    public abstract AnnotatedMethod mo961o();

    public abstract AnnotatedMethod mo962p();

    public abstract Converter<Object, Object> mo963q();

    public abstract Converter<Object, Object> mo964r();

    public abstract Map<Object, AnnotatedMember> mo965s();

    public abstract Class<?> mo966t();

    public abstract JsonPOJOBuilder.Value mo967u();

    protected BeanDescription(JavaType javaType) {
        this.f4041a = javaType;
    }

    public final JavaType m6844a() {
        return this.f4041a;
    }

    public final Class<?> m6849b() {
        return this.f4041a._class;
    }
}
