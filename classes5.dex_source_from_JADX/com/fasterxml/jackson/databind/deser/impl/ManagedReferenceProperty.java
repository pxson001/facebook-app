package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;
import java.util.Collection;
import java.util.Map;

/* compiled from: claim_status */
public final class ManagedReferenceProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final SettableBeanProperty _backProperty;
    protected final boolean _isContainer;
    protected final SettableBeanProperty _managedProperty;
    protected final String _referenceName;

    private ManagedReferenceProperty(ManagedReferenceProperty managedReferenceProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) managedReferenceProperty, (JsonDeserializer) jsonDeserializer);
        this._referenceName = managedReferenceProperty._referenceName;
        this._isContainer = managedReferenceProperty._isContainer;
        this._managedProperty = managedReferenceProperty._managedProperty;
        this._backProperty = managedReferenceProperty._backProperty;
    }

    private ManagedReferenceProperty(ManagedReferenceProperty managedReferenceProperty, String str) {
        super((SettableBeanProperty) managedReferenceProperty, str);
        this._referenceName = managedReferenceProperty._referenceName;
        this._isContainer = managedReferenceProperty._isContainer;
        this._managedProperty = managedReferenceProperty._managedProperty;
        this._backProperty = managedReferenceProperty._backProperty;
    }

    public final SettableBeanProperty mo647a(String str) {
        return new ManagedReferenceProperty(this, str);
    }

    public final SettableBeanProperty mo650b(JsonDeserializer jsonDeserializer) {
        return new ManagedReferenceProperty(this, jsonDeserializer);
    }

    public final AnnotatedMember mo651b() {
        return this._managedProperty.mo651b();
    }

    public final void mo648a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        mo649a(obj, this._managedProperty.m10922a(jsonParser, deserializationContext));
    }

    public final Object mo652b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return mo653b(obj, m10922a(jsonParser, deserializationContext));
    }

    public final void mo649a(Object obj, Object obj2) {
        mo653b(obj, obj2);
    }

    public final Object mo653b(Object obj, Object obj2) {
        Object b = this._managedProperty.mo653b(obj, obj2);
        if (obj2 != null) {
            if (!this._isContainer) {
                this._backProperty.mo649a(obj2, obj);
            } else if (obj2 instanceof Object[]) {
                for (Object obj3 : (Object[]) obj2) {
                    if (obj3 != null) {
                        this._backProperty.mo649a(obj3, obj);
                    }
                }
            } else if (obj2 instanceof Collection) {
                for (Object next : (Collection) obj2) {
                    if (next != null) {
                        this._backProperty.mo649a(next, obj);
                    }
                }
            } else if (obj2 instanceof Map) {
                for (Object next2 : ((Map) obj2).values()) {
                    if (next2 != null) {
                        this._backProperty.mo649a(next2, obj);
                    }
                }
            } else {
                throw new IllegalStateException("Unsupported container type (" + obj2.getClass().getName() + ") when resolving reference '" + this._referenceName + "'");
            }
        }
        return b;
    }

    public ManagedReferenceProperty(SettableBeanProperty settableBeanProperty, String str, SettableBeanProperty settableBeanProperty2, Annotations annotations, boolean z) {
        super(settableBeanProperty._propName, settableBeanProperty.m10920a(), settableBeanProperty._wrapperName, settableBeanProperty._valueTypeDeserializer, annotations, settableBeanProperty._isRequired);
        this._referenceName = str;
        this._managedProperty = settableBeanProperty;
        this._backProperty = settableBeanProperty2;
        this._isContainer = z;
    }
}
