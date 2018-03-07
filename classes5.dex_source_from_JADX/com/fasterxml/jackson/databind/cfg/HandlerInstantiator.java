package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.util.Converter;

/* compiled from: clientTimeMs */
public abstract class HandlerInstantiator {
    public abstract JsonDeserializer<?> m10816a();

    public abstract KeyDeserializer m10817b();

    public abstract JsonSerializer<?> m10818c();

    public abstract TypeResolverBuilder<?> m10819d();

    public abstract TypeIdResolver m10820e();

    public static ValueInstantiator m10812f() {
        return null;
    }

    public static ObjectIdGenerator<?> m10813g() {
        return null;
    }

    public static PropertyNamingStrategy m10814h() {
        return null;
    }

    public static Converter<?, ?> m10815i() {
        return null;
    }
}
