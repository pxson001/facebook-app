package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$EnumKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _factory;
    protected final EnumResolver<?> _resolver;

    protected StdKeyDeserializer$EnumKD(EnumResolver<?> enumResolver, AnnotatedMethod annotatedMethod) {
        super(enumResolver._enumClass);
        this._resolver = enumResolver;
        this._factory = annotatedMethod;
    }

    public final Object m11297b(String str, DeserializationContext deserializationContext) {
        Object a;
        if (this._factory != null) {
            try {
                a = this._factory.a(str);
            } catch (Throwable e) {
                ClassUtil.b(e);
            }
            return a;
        }
        a = this._resolver.m11783a(str);
        if (a == null && !deserializationContext.d().c(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
            throw deserializationContext.a(this._keyClass, str, "not one of values for Enum class");
        }
        return a;
    }
}
