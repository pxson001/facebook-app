package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

/* compiled from: purgeUnexpectedResources */
public class NumberDeserializers {
    private static final HashSet<String> f8637a = new HashSet();

    @JacksonStdImpl
    /* compiled from: purgeUnexpectedResources */
    public final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {
        public static final IntegerDeserializer f8638a = new IntegerDeserializer(Integer.class, Integer.valueOf(0));
        public static final IntegerDeserializer f8639b = new IntegerDeserializer(Integer.TYPE, null);
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13405b(jsonParser, deserializationContext);
        }

        private IntegerDeserializer(Class<Integer> cls, Integer num) {
            super(cls, num);
        }

        public final Integer m13405b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13357q(jsonParser, deserializationContext);
        }

        public final Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return m13357q(jsonParser, deserializationContext);
        }
    }

    /* compiled from: purgeUnexpectedResources */
    public abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
        private static final long serialVersionUID = 1;
        protected final T _nullValue;

        protected PrimitiveOrWrapperDeserializer(Class<T> cls, T t) {
            super(cls);
            this._nullValue = t;
        }

        public final T mo1798a() {
            return this._nullValue;
        }
    }

    @JacksonStdImpl
    /* compiled from: purgeUnexpectedResources */
    public final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {
        public static final LongDeserializer f8640a = new LongDeserializer(Long.class, Long.valueOf(0));
        public static final LongDeserializer f8641b = new LongDeserializer(Long.TYPE, null);
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13410b(jsonParser, deserializationContext);
        }

        private LongDeserializer(Class<Long> cls, Long l) {
            super(cls, l);
        }

        public final Long m13410b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13358r(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* compiled from: purgeUnexpectedResources */
    public final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {
        public static final BooleanDeserializer f8642a = new BooleanDeserializer(Boolean.class, Boolean.FALSE);
        public static final BooleanDeserializer f8643b = new BooleanDeserializer(Boolean.TYPE, null);
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13415b(jsonParser, deserializationContext);
        }

        private BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
            super(cls, bool);
        }

        public final Boolean m13415b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13352l(jsonParser, deserializationContext);
        }

        public final Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return m13352l(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* compiled from: purgeUnexpectedResources */
    public final class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {
        public static final FloatDeserializer f8644a = new FloatDeserializer(Float.class, Float.valueOf(0.0f));
        public static final FloatDeserializer f8645b = new FloatDeserializer(Float.TYPE, null);
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13419b(jsonParser, deserializationContext);
        }

        private FloatDeserializer(Class<Float> cls, Float f) {
            super(cls, f);
        }

        public final Float m13419b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13360t(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* compiled from: purgeUnexpectedResources */
    public final class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {
        public static final DoubleDeserializer f8646a = new DoubleDeserializer(Double.class, Double.valueOf(0.0d));
        public static final DoubleDeserializer f8647b = new DoubleDeserializer(Double.TYPE, null);
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13424b(jsonParser, deserializationContext);
        }

        private DoubleDeserializer(Class<Double> cls, Double d) {
            super(cls, d);
        }

        public final Double m13424b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m13362v(jsonParser, deserializationContext);
        }

        public final Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return m13362v(jsonParser, deserializationContext);
        }
    }

    static {
        int i = 0;
        Class[] clsArr = new Class[]{Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        while (i < 11) {
            f8637a.add(clsArr[i].getName());
            i++;
        }
    }

    public static JsonDeserializer<?> m13400a(Class<?> cls, String str) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return IntegerDeserializer.f8638a;
            }
            if (cls == Boolean.TYPE) {
                return BooleanDeserializer.f8642a;
            }
            if (cls == Long.TYPE) {
                return LongDeserializer.f8640a;
            }
            if (cls == Double.TYPE) {
                return DoubleDeserializer.f8646a;
            }
            if (cls == Character.TYPE) {
                return CharacterDeserializer.a;
            }
            if (cls == Byte.TYPE) {
                return ByteDeserializer.a;
            }
            if (cls == Short.TYPE) {
                return ShortDeserializer.a;
            }
            if (cls == Float.TYPE) {
                return FloatDeserializer.f8644a;
            }
        } else if (!f8637a.contains(str)) {
            return null;
        } else {
            if (cls == Integer.class) {
                return IntegerDeserializer.f8639b;
            }
            if (cls == Boolean.class) {
                return BooleanDeserializer.f8643b;
            }
            if (cls == Long.class) {
                return LongDeserializer.f8641b;
            }
            if (cls == Double.class) {
                return DoubleDeserializer.f8647b;
            }
            if (cls == Character.class) {
                return CharacterDeserializer.b;
            }
            if (cls == Byte.class) {
                return ByteDeserializer.b;
            }
            if (cls == Short.class) {
                return ShortDeserializer.b;
            }
            if (cls == Float.class) {
                return FloatDeserializer.f8645b;
            }
            if (cls == Number.class) {
                return NumberDeserializer.a;
            }
            if (cls == BigDecimal.class) {
                return BigDecimalDeserializer.a;
            }
            if (cls == BigInteger.class) {
                return BigIntegerDeserializer.a;
            }
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + cls.getName());
    }
}
