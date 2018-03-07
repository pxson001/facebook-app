package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: cancelAutoFocus failed */
public abstract class FilteredBeanPropertyWriter {

    /* compiled from: cancelAutoFocus failed */
    final class MultiView extends BeanPropertyWriter {
        protected final BeanPropertyWriter f6160t;
        protected final Class<?>[] f6161u;

        protected MultiView(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
            super(beanPropertyWriter);
            this.f6160t = beanPropertyWriter;
            this.f6161u = clsArr;
        }

        public final BeanPropertyWriter m11579a(NameTransformer nameTransformer) {
            return new MultiView(this.f6160t.a(nameTransformer), this.f6161u);
        }

        public final void m11580a(JsonSerializer<Object> jsonSerializer) {
            this.f6160t.a(jsonSerializer);
        }

        public final void m11582b(JsonSerializer<Object> jsonSerializer) {
            this.f6160t.b(jsonSerializer);
        }

        public final void m11581a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Class cls = serializerProvider._serializationView;
            if (cls != null) {
                int i = 0;
                int length = this.f6161u.length;
                while (i < length && !this.f6161u[i].isAssignableFrom(cls)) {
                    i++;
                }
                if (i == length) {
                    return;
                }
            }
            this.f6160t.a(obj, jsonGenerator, serializerProvider);
        }

        public final void m11583b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Class cls = serializerProvider._serializationView;
            if (cls != null) {
                int i = 0;
                int length = this.f6161u.length;
                while (i < length && !this.f6161u[i].isAssignableFrom(cls)) {
                    i++;
                }
                if (i == length) {
                    this.f6160t.a(jsonGenerator, serializerProvider);
                    return;
                }
            }
            this.f6160t.b(obj, jsonGenerator, serializerProvider);
        }
    }

    /* compiled from: cancelAutoFocus failed */
    final class SingleView extends BeanPropertyWriter {
        protected final BeanPropertyWriter f6162t;
        protected final Class<?> f6163u;

        protected SingleView(BeanPropertyWriter beanPropertyWriter, Class<?> cls) {
            super(beanPropertyWriter);
            this.f6162t = beanPropertyWriter;
            this.f6163u = cls;
        }

        public final BeanPropertyWriter m11584a(NameTransformer nameTransformer) {
            return new SingleView(this.f6162t.a(nameTransformer), this.f6163u);
        }

        public final void m11585a(JsonSerializer<Object> jsonSerializer) {
            this.f6162t.a(jsonSerializer);
        }

        public final void m11587b(JsonSerializer<Object> jsonSerializer) {
            this.f6162t.b(jsonSerializer);
        }

        public final void m11586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Class cls = serializerProvider._serializationView;
            if (cls == null || this.f6163u.isAssignableFrom(cls)) {
                this.f6162t.a(obj, jsonGenerator, serializerProvider);
            }
        }

        public final void m11588b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Class cls = serializerProvider._serializationView;
            if (cls == null || this.f6163u.isAssignableFrom(cls)) {
                this.f6162t.b(obj, jsonGenerator, serializerProvider);
            } else {
                this.f6162t.a(jsonGenerator, serializerProvider);
            }
        }
    }

    public static BeanPropertyWriter m11589a(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        if (clsArr.length == 1) {
            return new SingleView(beanPropertyWriter, clsArr[0]);
        }
        return new MultiView(beanPropertyWriter, clsArr);
    }
}
