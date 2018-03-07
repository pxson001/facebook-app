package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;

/* compiled from: can_viewer_share */
public abstract class ArraySerializerBase<T> extends ContainerSerializer<T> {
    protected final BeanProperty f6178c;

    protected abstract void mo726b(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    protected ArraySerializerBase(Class<T> cls) {
        super(cls);
        this.f6178c = null;
    }

    protected ArraySerializerBase(Class<T> cls, BeanProperty beanProperty) {
        super(cls);
        this.f6178c = beanProperty;
    }

    protected ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, BeanProperty beanProperty) {
        super(arraySerializerBase.k, false);
        this.f6178c = beanProperty;
    }

    public final void m11614a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (serializerProvider.a(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && b(t)) {
            mo726b(t, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.d();
        mo726b(t, jsonGenerator, serializerProvider);
        jsonGenerator.e();
    }

    public final void m11615a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.mo709c(t, jsonGenerator);
        mo726b(t, jsonGenerator, serializerProvider);
        typeSerializer.mo712f(t, jsonGenerator);
    }
}
