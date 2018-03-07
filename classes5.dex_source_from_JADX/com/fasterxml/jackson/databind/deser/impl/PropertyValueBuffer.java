package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;

/* compiled from: ci_softmatch_pymk */
public final class PropertyValueBuffer {
    protected final JsonParser f6047a;
    protected final DeserializationContext f6048b;
    protected final Object[] f6049c;
    protected final ObjectIdReader f6050d;
    private int f6051e;
    public PropertyValue f6052f;
    private Object f6053g;

    public PropertyValueBuffer(JsonParser jsonParser, DeserializationContext deserializationContext, int i, ObjectIdReader objectIdReader) {
        this.f6047a = jsonParser;
        this.f6048b = deserializationContext;
        this.f6051e = i;
        this.f6050d = objectIdReader;
        this.f6049c = new Object[i];
    }

    public final void m11105a(SettableBeanProperty[] settableBeanPropertyArr) {
        int length = settableBeanPropertyArr.length;
        for (int i = 0; i < length; i++) {
            SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
            if (settableBeanProperty != null) {
                this.f6049c[i] = this.f6048b.a(settableBeanProperty.mo655d(), settableBeanProperty, null);
            }
        }
    }

    protected final Object[] m11108a(Object[] objArr) {
        if (objArr != null) {
            int length = this.f6049c.length;
            for (int i = 0; i < length; i++) {
                if (this.f6049c[i] == null) {
                    Object obj = objArr[i];
                    if (obj != null) {
                        this.f6049c[i] = obj;
                    }
                }
            }
        }
        return this.f6049c;
    }

    public final boolean m11107a(String str) {
        if (this.f6050d == null || !str.equals(this.f6050d.propertyName)) {
            return false;
        }
        this.f6053g = this.f6050d.deserializer.a(this.f6047a, this.f6048b);
        return true;
    }

    public final Object m11101a(DeserializationContext deserializationContext, Object obj) {
        if (this.f6050d == null || this.f6053g == null) {
            return obj;
        }
        deserializationContext.a(this.f6053g, this.f6050d.generator).m11109a(obj);
        SettableBeanProperty settableBeanProperty = this.f6050d.idProperty;
        if (settableBeanProperty != null) {
            return settableBeanProperty.mo653b(obj, this.f6053g);
        }
        return obj;
    }

    protected final PropertyValue m11100a() {
        return this.f6052f;
    }

    public final boolean m11106a(int i, Object obj) {
        this.f6049c[i] = obj;
        int i2 = this.f6051e - 1;
        this.f6051e = i2;
        return i2 <= 0;
    }

    public final void m11103a(SettableBeanProperty settableBeanProperty, Object obj) {
        this.f6052f = new Regular(this.f6052f, obj, settableBeanProperty);
    }

    public final void m11102a(SettableAnyProperty settableAnyProperty, String str, Object obj) {
        this.f6052f = new Any(this.f6052f, obj, settableAnyProperty, str);
    }

    public final void m11104a(Object obj, Object obj2) {
        this.f6052f = new Map(this.f6052f, obj2, obj);
    }
}
