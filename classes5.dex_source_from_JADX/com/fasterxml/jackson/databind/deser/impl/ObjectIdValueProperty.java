package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

/* compiled from: city_hub */
public final class ObjectIdValueProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final ObjectIdReader _objectIdReader;

    public ObjectIdValueProperty(ObjectIdReader objectIdReader, boolean z) {
        super(objectIdReader.propertyName, objectIdReader.idType, null, null, null, z);
        this._objectIdReader = objectIdReader;
        this._valueDeserializer = objectIdReader.deserializer;
    }

    private ObjectIdValueProperty(ObjectIdValueProperty objectIdValueProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) objectIdValueProperty, (JsonDeserializer) jsonDeserializer);
        this._objectIdReader = objectIdValueProperty._objectIdReader;
    }

    private ObjectIdValueProperty(ObjectIdValueProperty objectIdValueProperty, String str) {
        super((SettableBeanProperty) objectIdValueProperty, str);
        this._objectIdReader = objectIdValueProperty._objectIdReader;
    }

    public final SettableBeanProperty mo647a(String str) {
        return new ObjectIdValueProperty(this, str);
    }

    public final SettableBeanProperty mo650b(JsonDeserializer jsonDeserializer) {
        return new ObjectIdValueProperty(this, jsonDeserializer);
    }

    public final AnnotatedMember mo651b() {
        return null;
    }

    public final void mo648a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        mo652b(jsonParser, deserializationContext, obj);
    }

    public final Object mo652b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Object a = this._valueDeserializer.a(jsonParser, deserializationContext);
        deserializationContext.a(a, this._objectIdReader.generator).m11109a(obj);
        SettableBeanProperty settableBeanProperty = this._objectIdReader.idProperty;
        if (settableBeanProperty != null) {
            return settableBeanProperty.mo653b(obj, a);
        }
        return obj;
    }

    public final void mo649a(Object obj, Object obj2) {
        mo653b(obj, obj2);
    }

    public final Object mo653b(Object obj, Object obj2) {
        SettableBeanProperty settableBeanProperty = this._objectIdReader.idProperty;
        if (settableBeanProperty != null) {
            return settableBeanProperty.mo653b(obj, obj2);
        }
        throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }
}
