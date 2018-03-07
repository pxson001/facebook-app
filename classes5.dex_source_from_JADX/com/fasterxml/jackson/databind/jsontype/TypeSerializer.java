package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;

/* compiled from: category_names */
public abstract class TypeSerializer {
    public abstract TypeSerializer mo703a(BeanProperty beanProperty);

    public abstract void mo704a(Object obj, JsonGenerator jsonGenerator);

    public abstract void mo706a(Object obj, JsonGenerator jsonGenerator, String str);

    public abstract void mo707b(Object obj, JsonGenerator jsonGenerator);

    public abstract void mo708b(Object obj, JsonGenerator jsonGenerator, String str);

    public abstract void mo709c(Object obj, JsonGenerator jsonGenerator);

    public abstract void mo710d(Object obj, JsonGenerator jsonGenerator);

    public abstract void mo711e(Object obj, JsonGenerator jsonGenerator);

    public abstract void mo712f(Object obj, JsonGenerator jsonGenerator);

    public void mo705a(Object obj, JsonGenerator jsonGenerator, Class<?> cls) {
        mo704a(obj, jsonGenerator);
    }
}
