package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Converter;

/* compiled from: checkbox_question_prompt */
public class StdDelegatingDeserializer<T> extends StdDeserializer<T> implements ContextualDeserializer, ResolvableDeserializer {
    private static final long serialVersionUID = 1;
    protected final Converter<Object, T> _converter;
    protected final JsonDeserializer<Object> _delegateDeserializer;
    protected final JavaType _delegateType;

    public StdDelegatingDeserializer(Converter<Object, T> converter, JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
        super(javaType);
        this._converter = converter;
        this._delegateType = javaType;
        this._delegateDeserializer = jsonDeserializer;
    }

    private StdDelegatingDeserializer<T> m11284a(Converter<Object, T> converter, JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
        if (getClass() == StdDelegatingDeserializer.class) {
            return new StdDelegatingDeserializer(converter, javaType, jsonDeserializer);
        }
        throw new IllegalStateException("Sub-class " + getClass().getName() + " must override 'withDelegate'");
    }

    public final void m11289a(DeserializationContext deserializationContext) {
        if (this._delegateDeserializer != null && (this._delegateDeserializer instanceof ResolvableDeserializer)) {
            ((ResolvableDeserializer) this._delegateDeserializer).a(deserializationContext);
        }
    }

    public final JsonDeserializer<?> m11286a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        if (this._delegateDeserializer == null) {
            JavaType b = this._converter.b();
            return m11284a(this._converter, b, deserializationContext.a(b, beanProperty));
        } else if (!(this._delegateDeserializer instanceof ContextualDeserializer)) {
            return this;
        } else {
            JsonDeserializer a = ((ContextualDeserializer) this._delegateDeserializer).a(deserializationContext, beanProperty);
            if (a != this._delegateDeserializer) {
                return m11284a(this._converter, this._delegateType, a);
            }
            return this;
        }
    }

    public T m11287a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object a = this._delegateDeserializer.a(jsonParser, deserializationContext);
        if (a == null) {
            return null;
        }
        return m11285a(a);
    }

    public final Object m11288a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        Object a = this._delegateDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
        if (a == null) {
            return null;
        }
        return m11285a(a);
    }

    private T m11285a(Object obj) {
        return this._converter.a();
    }
}
