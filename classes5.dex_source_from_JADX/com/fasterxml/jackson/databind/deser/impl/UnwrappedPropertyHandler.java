package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ci_continuous */
public class UnwrappedPropertyHandler {
    protected final List<SettableBeanProperty> f6058a;

    public UnwrappedPropertyHandler() {
        this.f6058a = new ArrayList();
    }

    private UnwrappedPropertyHandler(List<SettableBeanProperty> list) {
        this.f6058a = list;
    }

    public final void m11122a(SettableBeanProperty settableBeanProperty) {
        this.f6058a.add(settableBeanProperty);
    }

    public final UnwrappedPropertyHandler m11120a(NameTransformer nameTransformer) {
        List arrayList = new ArrayList(this.f6058a.size());
        for (SettableBeanProperty settableBeanProperty : this.f6058a) {
            Object a = settableBeanProperty.mo647a(nameTransformer.mo728a(settableBeanProperty._propName));
            JsonDeserializer l = a.m10943l();
            if (l != null) {
                JsonDeserializer a2 = l.a(nameTransformer);
                if (a2 != l) {
                    a = a.mo650b(a2);
                }
            }
            arrayList.add(a);
        }
        return new UnwrappedPropertyHandler(arrayList);
    }

    public final Object m11121a(DeserializationContext deserializationContext, Object obj, TokenBuffer tokenBuffer) {
        int size = this.f6058a.size();
        for (int i = 0; i < size; i++) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) this.f6058a.get(i);
            JsonParser i2 = tokenBuffer.i();
            i2.c();
            settableBeanProperty.mo648a(i2, deserializationContext, obj);
        }
        return obj;
    }
}
