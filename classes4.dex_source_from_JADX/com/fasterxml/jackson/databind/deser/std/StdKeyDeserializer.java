package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.Serializable;

/* compiled from: getOtherLabel */
public abstract class StdKeyDeserializer extends KeyDeserializer implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _keyClass;

    @JacksonStdImpl
    /* compiled from: getOtherLabel */
    final class IntKD extends StdKeyDeserializer {
        private static final long serialVersionUID = 1;

        IntKD() {
            super(Integer.class);
        }

        public final Object mo834b(String str, DeserializationContext deserializationContext) {
            return Integer.valueOf(StdKeyDeserializer.m11564a(str));
        }
    }

    protected abstract Object mo834b(String str, DeserializationContext deserializationContext);

    protected StdKeyDeserializer(Class<?> cls) {
        this._keyClass = cls;
    }

    public final Object mo835a(String str, DeserializationContext deserializationContext) {
        if (str == null) {
            return null;
        }
        try {
            Object b = mo834b(str, deserializationContext);
            if (b != null) {
                return b;
            }
            if (this._keyClass.isEnum() && deserializationContext.d().c(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            throw deserializationContext.a(this._keyClass, str, "not a valid representation");
        } catch (Exception e) {
            throw deserializationContext.a(this._keyClass, str, "not a valid representation: " + e.getMessage());
        }
    }

    protected static int m11564a(String str) {
        return Integer.parseInt(str);
    }

    protected static long m11565b(String str) {
        return Long.parseLong(str);
    }

    protected static double m11566c(String str) {
        return NumberInput.c(str);
    }
}
