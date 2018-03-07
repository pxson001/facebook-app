package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.lang.reflect.Method;

/* compiled from: child_locations */
public class EnumDeserializer extends StdScalarDeserializer<Enum<?>> {
    private static final long serialVersionUID = -5893263645879532318L;
    protected final EnumResolver<?> _resolver;

    /* compiled from: child_locations */
    public class FactoryBasedDeserializer extends StdScalarDeserializer<Object> {
        private static final long serialVersionUID = -7775129435872564122L;
        protected final Class<?> _enumClass;
        protected final Method _factory;
        protected final Class<?> _inputType;

        public FactoryBasedDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod, Class<?> cls2) {
            super(Enum.class);
            this._enumClass = cls;
            this._factory = annotatedMethod.a;
            this._inputType = cls2;
        }

        public Object m11160a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            String o;
            if (this._inputType == null) {
                o = jsonParser.o();
            } else if (this._inputType == Integer.class) {
                o = Integer.valueOf(jsonParser.E());
            } else if (this._inputType == Long.class) {
                o = Long.valueOf(jsonParser.F());
            } else {
                throw deserializationContext.b(this._enumClass);
            }
            try {
                return this._factory.invoke(this._enumClass, new Object[]{o});
            } catch (Throwable e) {
                ClassUtil.b(e);
                return null;
            }
        }
    }

    public /* synthetic */ Object m11162a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11163b(jsonParser, deserializationContext);
    }

    public EnumDeserializer(EnumResolver<?> enumResolver) {
        super(Enum.class);
        this._resolver = enumResolver;
    }

    public static JsonDeserializer<?> m11161a(DeserializationConfig deserializationConfig, Class<?> cls, AnnotatedMethod annotatedMethod) {
        Class a = annotatedMethod.a(0);
        if (a == String.class) {
            a = null;
        } else if (a == Integer.TYPE || a == Integer.class) {
            a = Integer.class;
        } else if (a == Long.TYPE || a == Long.class) {
            a = Long.class;
        } else {
            throw new IllegalArgumentException("Parameter #0 type for factory method (" + annotatedMethod + ") not suitable, must be java.lang.String or int/Integer/long/Long");
        }
        if (deserializationConfig.h()) {
            ClassUtil.a(annotatedMethod.a);
        }
        return new FactoryBasedDeserializer(cls, annotatedMethod, a);
    }

    public final boolean m11164d() {
        return true;
    }

    public Enum<?> m11163b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        Enum<?> a;
        if (g == JsonToken.VALUE_STRING || g == JsonToken.FIELD_NAME) {
            String o = jsonParser.o();
            a = this._resolver.m11783a(o);
            if (a != null) {
                return a;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && (o.length() == 0 || o.trim().length() == 0)) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return a;
            }
            throw deserializationContext.a(o, this._resolver._enumClass, "value not one of declared Enum instance names");
        } else if (g != JsonToken.VALUE_NUMBER_INT) {
            throw deserializationContext.b(this._resolver._enumClass);
        } else if (deserializationContext.a(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
            throw deserializationContext.c("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
        } else {
            int x = jsonParser.x();
            a = this._resolver.m11782a(x);
            if (a != null || deserializationContext.a(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return a;
            }
            Integer.valueOf(x);
            throw deserializationContext.b(this._resolver._enumClass, "index value outside legal index range [0.." + this._resolver.m11784b() + "]");
        }
    }
}
