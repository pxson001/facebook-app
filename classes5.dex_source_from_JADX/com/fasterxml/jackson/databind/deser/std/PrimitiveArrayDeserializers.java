package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder;

/* compiled from: checkboxes */
public abstract class PrimitiveArrayDeserializers<T> extends StdDeserializer<T> {

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class BooleanDeser extends PrimitiveArrayDeserializers<boolean[]> {
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11263b(jsonParser, deserializationContext);
        }

        public BooleanDeser() {
            super(boolean[].class);
        }

        public final boolean[] m11263b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (!jsonParser.m()) {
                return m11261d(jsonParser, deserializationContext);
            }
            PrimitiveArrayBuilder a = deserializationContext.m().a();
            Object obj = (boolean[]) a.m11760a();
            int i = 0;
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                int i2;
                boolean k = k(jsonParser, deserializationContext);
                if (i >= obj.length) {
                    i2 = 0;
                    obj = (boolean[]) a.m11762a(obj, i);
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                obj[i2] = k;
            }
            return (boolean[]) a.m11763b(obj, i);
        }

        private final boolean[] m11261d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new boolean[]{k(jsonParser, deserializationContext)};
            }
            throw deserializationContext.b(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class ByteDeser extends PrimitiveArrayDeserializers<byte[]> {
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11265a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11266b(jsonParser, deserializationContext);
        }

        public ByteDeser() {
            super(byte[].class);
        }

        public final byte[] m11266b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken g = jsonParser.g();
            if (g == JsonToken.VALUE_STRING) {
                return jsonParser.a(deserializationContext.h());
            }
            if (g == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object D = jsonParser.D();
                if (D == null) {
                    return null;
                }
                if (D instanceof byte[]) {
                    return (byte[]) D;
                }
            }
            if (!jsonParser.m()) {
                return m11264d(jsonParser, deserializationContext);
            }
            PrimitiveArrayBuilder b = deserializationContext.m().b();
            Object obj = (byte[]) b.m11760a();
            int i = 0;
            while (true) {
                JsonToken c = jsonParser.c();
                if (c == JsonToken.END_ARRAY) {
                    return (byte[]) b.m11763b(obj, i);
                }
                byte v;
                int i2;
                if (c == JsonToken.VALUE_NUMBER_INT || c == JsonToken.VALUE_NUMBER_FLOAT) {
                    v = jsonParser.v();
                } else if (c != JsonToken.VALUE_NULL) {
                    throw deserializationContext.b(this._valueClass.getComponentType());
                } else {
                    v = (byte) 0;
                }
                if (i >= obj.length) {
                    i2 = 0;
                    obj = (byte[]) b.m11762a(obj, i);
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                obj[i2] = v;
            }
        }

        private final byte[] m11264d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                byte v;
                JsonToken g = jsonParser.g();
                if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
                    v = jsonParser.v();
                } else if (g != JsonToken.VALUE_NULL) {
                    throw deserializationContext.b(this._valueClass.getComponentType());
                } else {
                    v = (byte) 0;
                }
                return new byte[]{v};
            }
            throw deserializationContext.b(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class CharDeser extends PrimitiveArrayDeserializers<char[]> {
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11267a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11268b(jsonParser, deserializationContext);
        }

        public CharDeser() {
            super(char[].class);
        }

        public final char[] m11268b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken g = jsonParser.g();
            Object obj;
            if (g == JsonToken.VALUE_STRING) {
                Object p = jsonParser.p();
                int r = jsonParser.r();
                int q = jsonParser.q();
                obj = new char[q];
                System.arraycopy(p, r, obj, 0, q);
                return obj;
            } else if (jsonParser.m()) {
                StringBuilder stringBuilder = new StringBuilder(64);
                while (true) {
                    JsonToken c = jsonParser.c();
                    if (c == JsonToken.END_ARRAY) {
                        return stringBuilder.toString().toCharArray();
                    }
                    if (c != JsonToken.VALUE_STRING) {
                        throw deserializationContext.b(Character.TYPE);
                    }
                    String o = jsonParser.o();
                    if (o.length() != 1) {
                        throw JsonMappingException.a(jsonParser, "Can not convert a JSON String of length " + o.length() + " into a char element of char array");
                    }
                    stringBuilder.append(o.charAt(0));
                }
            } else {
                if (g == JsonToken.VALUE_EMBEDDED_OBJECT) {
                    obj = jsonParser.D();
                    if (obj == null) {
                        return null;
                    }
                    if (obj instanceof char[]) {
                        return (char[]) obj;
                    }
                    if (obj instanceof String) {
                        return ((String) obj).toCharArray();
                    }
                    if (obj instanceof byte[]) {
                        return Base64Variants.b.a((byte[]) obj, false).toCharArray();
                    }
                }
                throw deserializationContext.b(this._valueClass);
            }
        }
    }

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class DoubleDeser extends PrimitiveArrayDeserializers<double[]> {
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11270a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11271b(jsonParser, deserializationContext);
        }

        public DoubleDeser() {
            super(double[].class);
        }

        public final double[] m11271b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (!jsonParser.m()) {
                return m11269d(jsonParser, deserializationContext);
            }
            PrimitiveArrayBuilder g = deserializationContext.m().g();
            Object obj = (double[]) g.m11760a();
            int i = 0;
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                int i2;
                double w = w(jsonParser, deserializationContext);
                if (i >= obj.length) {
                    i2 = 0;
                    obj = (double[]) g.m11762a(obj, i);
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                obj[i2] = w;
            }
            return (double[]) g.m11763b(obj, i);
        }

        private final double[] m11269d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new double[]{w(jsonParser, deserializationContext)};
            }
            throw deserializationContext.b(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class FloatDeser extends PrimitiveArrayDeserializers<float[]> {
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11273a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11274b(jsonParser, deserializationContext);
        }

        public FloatDeser() {
            super(float[].class);
        }

        public final float[] m11274b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (!jsonParser.m()) {
                return m11272d(jsonParser, deserializationContext);
            }
            PrimitiveArrayBuilder f = deserializationContext.m().f();
            Object obj = (float[]) f.m11760a();
            int i = 0;
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                int i2;
                float u = u(jsonParser, deserializationContext);
                if (i >= obj.length) {
                    i2 = 0;
                    obj = (float[]) f.m11762a(obj, i);
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                obj[i2] = u;
            }
            return (float[]) f.m11763b(obj, i);
        }

        private final float[] m11272d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new float[]{u(jsonParser, deserializationContext)};
            }
            throw deserializationContext.b(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class IntDeser extends PrimitiveArrayDeserializers<int[]> {
        public static final IntDeser f6097a = new IntDeser();
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11276a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11277b(jsonParser, deserializationContext);
        }

        public IntDeser() {
            super(int[].class);
        }

        public final int[] m11277b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (!jsonParser.m()) {
                return m11275d(jsonParser, deserializationContext);
            }
            PrimitiveArrayBuilder d = deserializationContext.m().d();
            Object obj = (int[]) d.m11760a();
            int i = 0;
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                int i2;
                int p = p(jsonParser, deserializationContext);
                if (i >= obj.length) {
                    i2 = 0;
                    obj = (int[]) d.m11762a(obj, i);
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                obj[i2] = p;
            }
            return (int[]) d.m11763b(obj, i);
        }

        private final int[] m11275d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new int[]{p(jsonParser, deserializationContext)};
            }
            throw deserializationContext.b(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class LongDeser extends PrimitiveArrayDeserializers<long[]> {
        public static final LongDeser f6098a = new LongDeser();
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11279a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11280b(jsonParser, deserializationContext);
        }

        public LongDeser() {
            super(long[].class);
        }

        public final long[] m11280b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (!jsonParser.m()) {
                return m11278d(jsonParser, deserializationContext);
            }
            PrimitiveArrayBuilder e = deserializationContext.m().e();
            Object obj = (long[]) e.m11760a();
            int i = 0;
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                int i2;
                long s = s(jsonParser, deserializationContext);
                if (i >= obj.length) {
                    i2 = 0;
                    obj = (long[]) e.m11762a(obj, i);
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                obj[i2] = s;
            }
            return (long[]) e.m11763b(obj, i);
        }

        private final long[] m11278d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new long[]{s(jsonParser, deserializationContext)};
            }
            throw deserializationContext.b(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* compiled from: checkboxes */
    final class ShortDeser extends PrimitiveArrayDeserializers<short[]> {
        private static final long serialVersionUID = 1;

        public final /* synthetic */ Object m11282a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11283b(jsonParser, deserializationContext);
        }

        public ShortDeser() {
            super(short[].class);
        }

        public final short[] m11283b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (!jsonParser.m()) {
                return m11281d(jsonParser, deserializationContext);
            }
            PrimitiveArrayBuilder c = deserializationContext.m().c();
            Object obj = (short[]) c.m11760a();
            int i = 0;
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                int i2;
                short o = o(jsonParser, deserializationContext);
                if (i >= obj.length) {
                    i2 = 0;
                    obj = (short[]) c.m11762a(obj, i);
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                obj[i2] = o;
            }
            return (short[]) c.m11763b(obj, i);
        }

        private final short[] m11281d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
                return null;
            }
            if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new short[]{o(jsonParser, deserializationContext)};
            }
            throw deserializationContext.b(this._valueClass);
        }
    }

    protected PrimitiveArrayDeserializers(Class<T> cls) {
        super(cls);
    }

    public static JsonDeserializer<?> m11259a(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return IntDeser.f6097a;
        }
        if (cls == Long.TYPE) {
            return LongDeser.f6098a;
        }
        if (cls == Byte.TYPE) {
            return new ByteDeser();
        }
        if (cls == Short.TYPE) {
            return new ShortDeser();
        }
        if (cls == Float.TYPE) {
            return new FloatDeser();
        }
        if (cls == Double.TYPE) {
            return new DoubleDeser();
        }
        if (cls == Boolean.TYPE) {
            return new BooleanDeser();
        }
        if (cls == Character.TYPE) {
            return new CharDeser();
        }
        throw new IllegalStateException();
    }

    public final Object m11260a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo700b(jsonParser, deserializationContext);
    }
}
