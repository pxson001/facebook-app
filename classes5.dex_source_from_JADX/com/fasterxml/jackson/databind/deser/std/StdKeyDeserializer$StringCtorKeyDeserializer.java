package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Constructor;

/* compiled from: checkbox_body */
final class StdKeyDeserializer$StringCtorKeyDeserializer extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;
    protected final Constructor<?> _ctor;

    public StdKeyDeserializer$StringCtorKeyDeserializer(Constructor<?> constructor) {
        super(constructor.getDeclaringClass());
        this._ctor = constructor;
    }

    public final Object m11302b(String str, DeserializationContext deserializationContext) {
        return this._ctor.newInstance(new Object[]{str});
    }
}
