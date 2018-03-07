package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/* compiled from: carrierAndSimMccMnc */
public class FailingDeserializer extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final String _message;

    public FailingDeserializer(String str) {
        super(Object.class);
        this._message = str;
    }

    public Object m11492a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        throw deserializationContext.c(this._message);
    }
}
