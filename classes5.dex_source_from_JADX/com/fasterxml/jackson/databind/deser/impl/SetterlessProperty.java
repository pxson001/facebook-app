package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.reflect.Method;

/* compiled from: ci_friends_suggestion_notif */
public final class SetterlessProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _annotated;
    protected final Method _getter;

    public SetterlessProperty(BeanPropertyDefinition beanPropertyDefinition, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedMethod annotatedMethod) {
        super(beanPropertyDefinition, javaType, typeDeserializer, annotations);
        this._annotated = annotatedMethod;
        this._getter = annotatedMethod.a;
    }

    private SetterlessProperty(SetterlessProperty setterlessProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) setterlessProperty, (JsonDeserializer) jsonDeserializer);
        this._annotated = setterlessProperty._annotated;
        this._getter = setterlessProperty._getter;
    }

    private SetterlessProperty(SetterlessProperty setterlessProperty, String str) {
        super((SettableBeanProperty) setterlessProperty, str);
        this._annotated = setterlessProperty._annotated;
        this._getter = setterlessProperty._getter;
    }

    public final SettableBeanProperty mo647a(String str) {
        return new SetterlessProperty(this, str);
    }

    public final SettableBeanProperty mo650b(JsonDeserializer jsonDeserializer) {
        return new SetterlessProperty(this, jsonDeserializer);
    }

    public final AnnotatedMember mo651b() {
        return this._annotated;
    }

    public final void mo648a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        if (jsonParser.g() != JsonToken.VALUE_NULL) {
            try {
                Object invoke = this._getter.invoke(obj, new Object[0]);
                if (invoke == null) {
                    throw new JsonMappingException("Problem deserializing 'setterless' property '" + m10936e() + "': get method returned null");
                }
                this._valueDeserializer.a(jsonParser, deserializationContext, invoke);
            } catch (Exception e) {
                SettableBeanProperty.m10919a(e);
            }
        }
    }

    public final Object mo652b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        mo648a(jsonParser, deserializationContext, obj);
        return obj;
    }

    public final void mo649a(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should never call 'set' on setterless property");
    }

    public final Object mo653b(Object obj, Object obj2) {
        mo649a(obj, obj2);
        return null;
    }
}
