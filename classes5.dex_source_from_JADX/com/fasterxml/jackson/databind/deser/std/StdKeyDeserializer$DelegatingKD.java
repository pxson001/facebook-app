package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import java.io.Serializable;

/* compiled from: checkbox_body */
final class StdKeyDeserializer$DelegatingKD extends KeyDeserializer implements Serializable {
    private static final long serialVersionUID = 1;
    protected final JsonDeserializer<?> _delegate;
    protected final Class<?> _keyClass;

    protected StdKeyDeserializer$DelegatingKD(Class<?> cls, JsonDeserializer<?> jsonDeserializer) {
        this._keyClass = cls;
        this._delegate = jsonDeserializer;
    }

    public final Object m11295a(String str, DeserializationContext deserializationContext) {
        if (str == null) {
            return null;
        }
        try {
            Object a = this._delegate.a(deserializationContext.g(), deserializationContext);
            if (a != null) {
                return a;
            }
            throw deserializationContext.a(this._keyClass, str, "not a valid representation");
        } catch (Exception e) {
            throw deserializationContext.a(this._keyClass, str, "not a valid representation: " + e.getMessage());
        }
    }
}
