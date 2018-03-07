package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.reflect.Field;

/* compiled from: class */
public final class FieldProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedField _annotated;
    protected final transient Field f6034c;

    public FieldProperty(BeanPropertyDefinition beanPropertyDefinition, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedField annotatedField) {
        super(beanPropertyDefinition, javaType, typeDeserializer, annotations);
        this._annotated = annotatedField;
        this.f6034c = annotatedField.a;
    }

    private FieldProperty(FieldProperty fieldProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) fieldProperty, (JsonDeserializer) jsonDeserializer);
        this._annotated = fieldProperty._annotated;
        this.f6034c = fieldProperty.f6034c;
    }

    private FieldProperty(FieldProperty fieldProperty, String str) {
        super((SettableBeanProperty) fieldProperty, str);
        this._annotated = fieldProperty._annotated;
        this.f6034c = fieldProperty.f6034c;
    }

    private FieldProperty(FieldProperty fieldProperty, Field field) {
        super(fieldProperty);
        this._annotated = fieldProperty._annotated;
        if (field == null) {
            throw new IllegalArgumentException("No Field passed for property '" + fieldProperty._propName + "' (class " + fieldProperty.m10939h().getName() + ")");
        }
        this.f6034c = field;
    }

    public final SettableBeanProperty mo647a(String str) {
        return new FieldProperty(this, str);
    }

    public final SettableBeanProperty mo650b(JsonDeserializer jsonDeserializer) {
        return new FieldProperty(this, jsonDeserializer);
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
            this.f6034c.set(obj, obj2);
        } catch (Exception e) {
            m10925a(e, obj2);
        }
    }

    public final Object mo653b(Object obj, Object obj2) {
        try {
            this.f6034c.set(obj, obj2);
        } catch (Exception e) {
            m10925a(e, obj2);
        }
        return obj;
    }

    final Object readResolve() {
        return new FieldProperty(this, this._annotated.a);
    }
}
