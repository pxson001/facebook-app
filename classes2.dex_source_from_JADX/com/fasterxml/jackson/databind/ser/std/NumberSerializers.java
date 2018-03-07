package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/* compiled from: start an array */
public class NumberSerializers {

    @JacksonStdImpl
    /* compiled from: start an array */
    public final class IntegerSerializer extends NonTypedScalarSerializerBase<Integer> {
        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1121b(((Integer) obj).intValue());
        }

        public IntegerSerializer() {
            super(Integer.class);
        }
    }

    @JacksonStdImpl
    /* compiled from: start an array */
    public final class LongSerializer extends StdScalarSerializer<Long> {
        static final LongSerializer f4165a = new LongSerializer();

        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1111a(((Long) obj).longValue());
        }

        public LongSerializer() {
            super(Long.class);
        }
    }

    @JacksonStdImpl
    /* compiled from: start an array */
    public final class IntLikeSerializer extends StdScalarSerializer<Number> {
        static final IntLikeSerializer f4166a = new IntLikeSerializer();

        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1121b(((Number) obj).intValue());
        }

        public IntLikeSerializer() {
            super(Number.class);
        }
    }

    @JacksonStdImpl
    /* compiled from: start an array */
    public final class ShortSerializer extends StdScalarSerializer<Short> {
        static final ShortSerializer f4167a = new ShortSerializer();

        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1118a(((Short) obj).shortValue());
        }

        public ShortSerializer() {
            super(Short.class);
        }
    }

    @JacksonStdImpl
    /* compiled from: start an array */
    public final class FloatSerializer extends StdScalarSerializer<Float> {
        static final FloatSerializer f4168a = new FloatSerializer();

        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1110a(((Float) obj).floatValue());
        }

        public FloatSerializer() {
            super(Float.class);
        }
    }

    @JacksonStdImpl
    /* compiled from: start an array */
    public final class DoubleSerializer extends NonTypedScalarSerializerBase<Double> {
        static final DoubleSerializer f4169a = new DoubleSerializer();

        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.mo1109a(((Double) obj).doubleValue());
        }

        public DoubleSerializer() {
            super(Double.class);
        }
    }

    @JacksonStdImpl
    /* compiled from: start an array */
    public final class NumberSerializer extends StdScalarSerializer<Number> {
        public static final NumberSerializer f4171a = new NumberSerializer();

        public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Number number = (Number) obj;
            if (number instanceof BigDecimal) {
                if (!serializerProvider.m7316a(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN) || (jsonGenerator instanceof TokenBuffer)) {
                    jsonGenerator.mo1116a((BigDecimal) number);
                } else {
                    jsonGenerator.mo1133e(((BigDecimal) number).toPlainString());
                }
            } else if (number instanceof BigInteger) {
                jsonGenerator.mo1117a((BigInteger) number);
            } else if (number instanceof Integer) {
                jsonGenerator.mo1121b(number.intValue());
            } else if (number instanceof Long) {
                jsonGenerator.mo1111a(number.longValue());
            } else if (number instanceof Double) {
                jsonGenerator.mo1109a(number.doubleValue());
            } else if (number instanceof Float) {
                jsonGenerator.mo1110a(number.floatValue());
            } else if ((number instanceof Byte) || (number instanceof Short)) {
                jsonGenerator.mo1121b(number.intValue());
            } else {
                jsonGenerator.mo1133e(number.toString());
            }
        }

        public NumberSerializer() {
            super(Number.class);
        }
    }

    protected NumberSerializers() {
    }

    public static void m7597a(Map<String, JsonSerializer<?>> map) {
        IntegerSerializer integerSerializer = new IntegerSerializer();
        map.put(Integer.class.getName(), integerSerializer);
        map.put(Integer.TYPE.getName(), integerSerializer);
        map.put(Long.class.getName(), LongSerializer.f4165a);
        map.put(Long.TYPE.getName(), LongSerializer.f4165a);
        map.put(Byte.class.getName(), IntLikeSerializer.f4166a);
        map.put(Byte.TYPE.getName(), IntLikeSerializer.f4166a);
        map.put(Short.class.getName(), ShortSerializer.f4167a);
        map.put(Short.TYPE.getName(), ShortSerializer.f4167a);
        map.put(Float.class.getName(), FloatSerializer.f4168a);
        map.put(Float.TYPE.getName(), FloatSerializer.f4168a);
        map.put(Double.class.getName(), DoubleSerializer.f4169a);
        map.put(Double.TYPE.getName(), DoubleSerializer.f4169a);
    }
}
