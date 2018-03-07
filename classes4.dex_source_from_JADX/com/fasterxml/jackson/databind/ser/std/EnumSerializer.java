package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.EnumValues;

@JacksonStdImpl
/* compiled from: validation_float */
public class EnumSerializer extends StdScalarSerializer<Enum<?>> implements ContextualSerializer {
    protected final EnumValues f387a;
    protected final Boolean f388b;

    public final void m660a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Enum enumR = (Enum) obj;
        if (m658a(serializerProvider)) {
            jsonGenerator.b(enumR.ordinal());
        } else {
            jsonGenerator.c(this.f387a.m665a(enumR));
        }
    }

    private EnumSerializer(EnumValues enumValues, Boolean bool) {
        super(Enum.class, (byte) 0);
        this.f387a = enumValues;
        this.f388b = bool;
    }

    public static EnumSerializer m656a(Class<Enum<?>> cls, SerializationConfig serializationConfig, Value value) {
        return new EnumSerializer(serializationConfig.c(SerializationFeature.WRITE_ENUMS_USING_TO_STRING) ? EnumValues.m662a((Class) cls) : EnumValues.m664b(cls, serializationConfig.a()), m657a((Class) cls, value, true));
    }

    public final JsonSerializer<?> m659a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        if (beanProperty == null) {
            return this;
        }
        Value e = serializerProvider.e().e(beanProperty.mo46b());
        if (e == null) {
            return this;
        }
        Boolean a = m657a(beanProperty.mo45a()._class, e, false);
        if (a != this.f388b) {
            return new EnumSerializer(this.f387a, a);
        }
        return this;
    }

    public final EnumValues m661d() {
        return this.f387a;
    }

    private boolean m658a(SerializerProvider serializerProvider) {
        if (this.f388b != null) {
            return this.f388b.booleanValue();
        }
        return serializerProvider.a(SerializationFeature.WRITE_ENUMS_USING_INDEX);
    }

    private static Boolean m657a(Class<?> cls, Value value, boolean z) {
        Shape shape;
        if (value == null) {
            shape = null;
        } else {
            shape = value.b;
        }
        if (shape == null || shape == Shape.ANY || shape == Shape.SCALAR) {
            return null;
        }
        if (shape == Shape.STRING) {
            return Boolean.FALSE;
        }
        if (shape.isNumeric()) {
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException("Unsupported serialization shape (" + shape + ") for Enum " + cls.getName() + ", not supported as " + (z ? "class" : "property") + " annotation");
    }
}
