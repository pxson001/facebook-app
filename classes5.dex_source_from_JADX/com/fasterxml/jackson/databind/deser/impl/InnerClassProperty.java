package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Constructor;

/* compiled from: claim_time */
public final class InnerClassProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final Constructor<?> _creator;
    protected final SettableBeanProperty _delegate;

    public InnerClassProperty(SettableBeanProperty settableBeanProperty, Constructor<?> constructor) {
        super(settableBeanProperty);
        this._delegate = settableBeanProperty;
        this._creator = constructor;
    }

    private InnerClassProperty(InnerClassProperty innerClassProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) innerClassProperty, (JsonDeserializer) jsonDeserializer);
        this._delegate = innerClassProperty._delegate.mo650b((JsonDeserializer) jsonDeserializer);
        this._creator = innerClassProperty._creator;
    }

    private InnerClassProperty(InnerClassProperty innerClassProperty, String str) {
        super((SettableBeanProperty) innerClassProperty, str);
        this._delegate = innerClassProperty._delegate.mo647a(str);
        this._creator = innerClassProperty._creator;
    }

    public final SettableBeanProperty mo647a(String str) {
        return new InnerClassProperty(this, str);
    }

    public final SettableBeanProperty mo650b(JsonDeserializer jsonDeserializer) {
        return new InnerClassProperty(this, jsonDeserializer);
    }

    public final AnnotatedMember mo651b() {
        return this._delegate.mo651b();
    }

    public final void mo648a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Object obj2 = null;
        if (jsonParser.g() == JsonToken.VALUE_NULL) {
            if (this._nullProvider != null) {
                obj2 = this._nullProvider.m11078a(deserializationContext);
            }
        } else if (this._valueTypeDeserializer != null) {
            obj2 = this._valueDeserializer.a(jsonParser, deserializationContext, this._valueTypeDeserializer);
        } else {
            try {
                obj2 = this._creator.newInstance(new Object[]{obj});
            } catch (Throwable e) {
                ClassUtil.a(e, "Failed to instantiate class " + this._creator.getDeclaringClass().getName() + ", problem: " + e.getMessage());
            }
            this._valueDeserializer.a(jsonParser, deserializationContext, obj2);
        }
        mo649a(obj, obj2);
    }

    public final Object mo652b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return mo653b(obj, m10922a(jsonParser, deserializationContext));
    }

    public final void mo649a(Object obj, Object obj2) {
        this._delegate.mo649a(obj, obj2);
    }

    public final Object mo653b(Object obj, Object obj2) {
        return this._delegate.mo653b(obj, obj2);
    }
}
