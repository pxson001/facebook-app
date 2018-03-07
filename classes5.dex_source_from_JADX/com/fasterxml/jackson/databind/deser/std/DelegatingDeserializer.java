package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;

/* compiled from: child_search */
public abstract class DelegatingDeserializer extends StdDeserializer<Object> implements ContextualDeserializer, ResolvableDeserializer {
    private static final long serialVersionUID = 1;
    protected final JsonDeserializer<?> _delegatee;

    public Object m11159a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return this._delegatee.a(jsonParser, deserializationContext);
    }
}
