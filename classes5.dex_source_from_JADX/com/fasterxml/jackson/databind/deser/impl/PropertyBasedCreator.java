package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: city */
public final class PropertyBasedCreator {
    protected final ValueInstantiator f6036a;
    protected final HashMap<String, SettableBeanProperty> f6037b = new HashMap();
    protected final int f6038c;
    protected final Object[] f6039d;
    protected final SettableBeanProperty[] f6040e;

    private PropertyBasedCreator(ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr, Object[] objArr) {
        this.f6036a = valueInstantiator;
        int length = settableBeanPropertyArr.length;
        this.f6038c = length;
        SettableBeanProperty[] settableBeanPropertyArr2 = null;
        for (int i = 0; i < length; i++) {
            SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
            this.f6037b.put(settableBeanProperty._propName, settableBeanProperty);
            if (settableBeanProperty.mo655d() != null) {
                if (settableBeanPropertyArr2 == null) {
                    settableBeanPropertyArr2 = new SettableBeanProperty[length];
                }
                settableBeanPropertyArr2[i] = settableBeanProperty;
            }
        }
        this.f6039d = objArr;
        this.f6040e = settableBeanPropertyArr2;
    }

    public static PropertyBasedCreator m11087a(DeserializationContext deserializationContext, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr) {
        int length = settableBeanPropertyArr.length;
        SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[length];
        Object[] objArr = null;
        for (int i = 0; i < length; i++) {
            Object f;
            SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
            if (!settableBeanProperty.m10941j()) {
                settableBeanProperty = settableBeanProperty.mo650b(deserializationContext.a(settableBeanProperty.m10920a(), settableBeanProperty));
            }
            settableBeanPropertyArr2[i] = settableBeanProperty;
            JsonDeserializer l = settableBeanProperty.m10943l();
            Object a = l == null ? null : l.a();
            if (a == null && settableBeanProperty.m10920a().j()) {
                f = ClassUtil.f(settableBeanProperty.m10920a()._class);
            } else {
                f = a;
            }
            if (f != null) {
                if (objArr == null) {
                    objArr = new Object[length];
                }
                objArr[i] = f;
            }
        }
        return new PropertyBasedCreator(valueInstantiator, settableBeanPropertyArr2, objArr);
    }

    public final Collection<SettableBeanProperty> m11091a() {
        return this.f6037b.values();
    }

    public final SettableBeanProperty m11088a(String str) {
        return (SettableBeanProperty) this.f6037b.get(str);
    }

    public final PropertyValueBuffer m11089a(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectIdReader objectIdReader) {
        PropertyValueBuffer propertyValueBuffer = new PropertyValueBuffer(jsonParser, deserializationContext, this.f6038c, objectIdReader);
        if (this.f6040e != null) {
            propertyValueBuffer.m11105a(this.f6040e);
        }
        return propertyValueBuffer;
    }

    public final Object m11090a(DeserializationContext deserializationContext, PropertyValueBuffer propertyValueBuffer) {
        Object a = propertyValueBuffer.m11101a(deserializationContext, this.f6036a.mo670a(propertyValueBuffer.m11108a(this.f6039d)));
        for (PropertyValue propertyValue = propertyValueBuffer.f6052f; propertyValue != null; propertyValue = propertyValue.f6041a) {
            propertyValue.mo661a(a);
        }
        return a;
    }
}
