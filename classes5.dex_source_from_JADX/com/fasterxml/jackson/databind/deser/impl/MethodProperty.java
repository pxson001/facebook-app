package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.reflect.Method;

/* compiled from: claim_count */
public final class MethodProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _annotated;
    protected final transient Method f6035c;

    public MethodProperty(BeanPropertyDefinition beanPropertyDefinition, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedMethod annotatedMethod) {
        super(beanPropertyDefinition, javaType, typeDeserializer, annotations);
        this._annotated = annotatedMethod;
        this.f6035c = annotatedMethod.a;
    }

    private MethodProperty(MethodProperty methodProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) methodProperty, (JsonDeserializer) jsonDeserializer);
        this._annotated = methodProperty._annotated;
        this.f6035c = methodProperty.f6035c;
    }

    private MethodProperty(MethodProperty methodProperty, String str) {
        super((SettableBeanProperty) methodProperty, str);
        this._annotated = methodProperty._annotated;
        this.f6035c = methodProperty.f6035c;
    }

    private MethodProperty(MethodProperty methodProperty, Method method) {
        super(methodProperty);
        this._annotated = methodProperty._annotated;
        this.f6035c = method;
    }

    public final SettableBeanProperty mo647a(String str) {
        return new MethodProperty(this, str);
    }

    public final SettableBeanProperty mo650b(JsonDeserializer jsonDeserializer) {
        return new MethodProperty(this, jsonDeserializer);
    }

    public final AnnotatedMember mo651b() {
        return this._annotated;
    }

    public final void mo648a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        mo649a(obj, m10922a(jsonParser, deserializationContext));
    }

    public final Object mo652b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return mo653b(obj, m10922a(jsonParser, deserializationContext));
    }

    public final void mo649a(Object obj, Object obj2) {
        try {
            this.f6035c.invoke(obj, new Object[]{obj2});
        } catch (Exception e) {
            m10925a(e, obj2);
        }
    }

    public final Object mo653b(Object obj, Object obj2) {
        try {
            Object invoke = this.f6035c.invoke(obj, new Object[]{obj2});
            return invoke == null ? obj : invoke;
        } catch (Exception e) {
            m10925a(e, obj2);
            return null;
        }
    }

    final Object readResolve() {
        return new MethodProperty(this, this._annotated.a);
    }
}
