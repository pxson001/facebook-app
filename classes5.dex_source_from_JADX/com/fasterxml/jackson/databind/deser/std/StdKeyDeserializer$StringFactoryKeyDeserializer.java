package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Method;

/* compiled from: checkbox_body */
final class StdKeyDeserializer$StringFactoryKeyDeserializer extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;
    final Method _factoryMethod;

    public StdKeyDeserializer$StringFactoryKeyDeserializer(Method method) {
        super(method.getDeclaringClass());
        this._factoryMethod = method;
    }

    public final Object m11303b(String str, DeserializationContext deserializationContext) {
        return this._factoryMethod.invoke(null, new Object[]{str});
    }
}
