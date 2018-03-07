package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.HashMap;

/* compiled from: can_viewer_post */
public class StdArraySerializers {
    protected static final HashMap<String, JsonSerializer<?>> f6216a;

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class BooleanArraySerializer extends ArraySerializerBase<boolean[]> {
        private static final JavaType f6209a = TypeFactory.a(Boolean.class);

        public final boolean m11693a(Object obj) {
            boolean[] zArr = (boolean[]) obj;
            return zArr == null || zArr.length == 0;
        }

        public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            for (boolean a : (boolean[]) obj) {
                jsonGenerator.a(a);
            }
        }

        public final boolean m11696b(Object obj) {
            return ((boolean[]) obj).length == 1;
        }

        public BooleanArraySerializer() {
            super(boolean[].class, null);
        }

        public final ContainerSerializer<?> m11694b(TypeSerializer typeSerializer) {
            return this;
        }

        static {
            TypeFactory typeFactory = TypeFactory.a;
        }
    }

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class ByteArraySerializer extends StdSerializer<byte[]> {
        public final void m11697a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            byte[] bArr = (byte[]) obj;
            jsonGenerator.a(serializerProvider._config.r(), bArr, 0, bArr.length);
        }

        public final void m11698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            byte[] bArr = (byte[]) obj;
            typeSerializer.mo704a(bArr, jsonGenerator);
            jsonGenerator.a(serializerProvider._config.r(), bArr, 0, bArr.length);
            typeSerializer.mo710d(bArr, jsonGenerator);
        }

        public final boolean m11699a(Object obj) {
            byte[] bArr = (byte[]) obj;
            return bArr == null || bArr.length == 0;
        }

        public ByteArraySerializer() {
            super(byte[].class);
        }
    }

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class CharArraySerializer extends StdSerializer<char[]> {
        public final void m11701a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            char[] cArr = (char[]) obj;
            if (serializerProvider.a(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                jsonGenerator.d();
                m11700a(jsonGenerator, cArr);
                jsonGenerator.e();
                return;
            }
            jsonGenerator.a(cArr, 0, cArr.length);
        }

        public final void m11702a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            char[] cArr = (char[]) obj;
            if (serializerProvider.a(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                typeSerializer.mo709c(cArr, jsonGenerator);
                m11700a(jsonGenerator, cArr);
                typeSerializer.mo712f(cArr, jsonGenerator);
                return;
            }
            typeSerializer.mo704a(cArr, jsonGenerator);
            jsonGenerator.a(cArr, 0, cArr.length);
            typeSerializer.mo710d(cArr, jsonGenerator);
        }

        public final boolean m11703a(Object obj) {
            char[] cArr = (char[]) obj;
            return cArr == null || cArr.length == 0;
        }

        public CharArraySerializer() {
            super(char[].class);
        }

        private static void m11700a(JsonGenerator jsonGenerator, char[] cArr) {
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                jsonGenerator.a(cArr, i, 1);
            }
        }
    }

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class DoubleArraySerializer extends ArraySerializerBase<double[]> {
        private static final JavaType f6210a = TypeFactory.a(Double.TYPE);

        static {
            TypeFactory typeFactory = TypeFactory.a;
        }

        public final boolean m11704a(Object obj) {
            double[] dArr = (double[]) obj;
            return dArr == null || dArr.length == 0;
        }

        public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            for (double a : (double[]) obj) {
                jsonGenerator.a(a);
            }
        }

        public final boolean m11707b(Object obj) {
            return ((double[]) obj).length == 1;
        }

        public DoubleArraySerializer() {
            super(double[].class, null);
        }

        public final ContainerSerializer<?> m11705b(TypeSerializer typeSerializer) {
            return this;
        }
    }

    /* compiled from: can_viewer_post */
    public abstract class TypedPrimitiveArraySerializer<T> extends ArraySerializerBase<T> {
        protected final TypeSerializer f6211a;

        protected TypedPrimitiveArraySerializer(Class<T> cls) {
            super(cls);
            this.f6211a = null;
        }

        protected TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> typedPrimitiveArraySerializer, BeanProperty beanProperty, TypeSerializer typeSerializer) {
            super((ArraySerializerBase) typedPrimitiveArraySerializer, beanProperty);
            this.f6211a = typeSerializer;
        }
    }

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class FloatArraySerializer extends TypedPrimitiveArraySerializer<float[]> {
        private static final JavaType f6212b = TypeFactory.a(Float.TYPE);

        static {
            TypeFactory typeFactory = TypeFactory.a;
        }

        public final boolean m11708a(Object obj) {
            float[] fArr = (float[]) obj;
            return fArr == null || fArr.length == 0;
        }

        public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            float[] fArr = (float[]) obj;
            int i = 0;
            int length;
            if (this.f6211a != null) {
                length = fArr.length;
                while (i < length) {
                    this.f6211a.mo705a(null, jsonGenerator, Float.TYPE);
                    jsonGenerator.a(fArr[i]);
                    this.f6211a.mo710d(null, jsonGenerator);
                    i++;
                }
                return;
            }
            length = fArr.length;
            while (i < length) {
                jsonGenerator.a(fArr[i]);
                i++;
            }
        }

        public final boolean m11711b(Object obj) {
            return ((float[]) obj).length == 1;
        }

        public FloatArraySerializer() {
            super(float[].class);
        }

        private FloatArraySerializer(FloatArraySerializer floatArraySerializer, BeanProperty beanProperty, TypeSerializer typeSerializer) {
            super(floatArraySerializer, beanProperty, typeSerializer);
        }

        public final ContainerSerializer<?> m11709b(TypeSerializer typeSerializer) {
            return new FloatArraySerializer(this, this.f6178c, typeSerializer);
        }
    }

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class IntArraySerializer extends ArraySerializerBase<int[]> {
        private static final JavaType f6213a = TypeFactory.a(Integer.TYPE);

        static {
            TypeFactory typeFactory = TypeFactory.a;
        }

        public final boolean m11712a(Object obj) {
            int[] iArr = (int[]) obj;
            return iArr == null || iArr.length == 0;
        }

        public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            for (int b : (int[]) obj) {
                jsonGenerator.b(b);
            }
        }

        public final boolean m11715b(Object obj) {
            return ((int[]) obj).length == 1;
        }

        public IntArraySerializer() {
            super(int[].class, null);
        }

        public final ContainerSerializer<?> m11713b(TypeSerializer typeSerializer) {
            return this;
        }
    }

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class LongArraySerializer extends TypedPrimitiveArraySerializer<long[]> {
        private static final JavaType f6214b = TypeFactory.a(Long.TYPE);

        static {
            TypeFactory typeFactory = TypeFactory.a;
        }

        public final boolean m11716a(Object obj) {
            long[] jArr = (long[]) obj;
            return jArr == null || jArr.length == 0;
        }

        public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            long[] jArr = (long[]) obj;
            int i = 0;
            int length;
            if (this.f6211a != null) {
                length = jArr.length;
                while (i < length) {
                    this.f6211a.mo705a(null, jsonGenerator, Long.TYPE);
                    jsonGenerator.a(jArr[i]);
                    this.f6211a.mo710d(null, jsonGenerator);
                    i++;
                }
                return;
            }
            length = jArr.length;
            while (i < length) {
                jsonGenerator.a(jArr[i]);
                i++;
            }
        }

        public final boolean m11719b(Object obj) {
            return ((long[]) obj).length == 1;
        }

        public LongArraySerializer() {
            super(long[].class);
        }

        private LongArraySerializer(LongArraySerializer longArraySerializer, BeanProperty beanProperty, TypeSerializer typeSerializer) {
            super(longArraySerializer, beanProperty, typeSerializer);
        }

        public final ContainerSerializer<?> m11717b(TypeSerializer typeSerializer) {
            return new LongArraySerializer(this, this.f6178c, typeSerializer);
        }
    }

    @JacksonStdImpl
    /* compiled from: can_viewer_post */
    public final class ShortArraySerializer extends TypedPrimitiveArraySerializer<short[]> {
        private static final JavaType f6215b = TypeFactory.a(Short.TYPE);

        static {
            TypeFactory typeFactory = TypeFactory.a;
        }

        public final boolean m11720a(Object obj) {
            short[] sArr = (short[]) obj;
            return sArr == null || sArr.length == 0;
        }

        public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            short[] sArr = (short[]) obj;
            int i = 0;
            int length;
            if (this.f6211a != null) {
                length = sArr.length;
                while (i < length) {
                    this.f6211a.mo705a(null, jsonGenerator, Short.TYPE);
                    jsonGenerator.a(sArr[i]);
                    this.f6211a.mo710d(null, jsonGenerator);
                    i++;
                }
                return;
            }
            length = sArr.length;
            while (i < length) {
                jsonGenerator.b(sArr[i]);
                i++;
            }
        }

        public final boolean m11723b(Object obj) {
            return ((short[]) obj).length == 1;
        }

        public ShortArraySerializer() {
            super(short[].class);
        }

        private ShortArraySerializer(ShortArraySerializer shortArraySerializer, BeanProperty beanProperty, TypeSerializer typeSerializer) {
            super(shortArraySerializer, beanProperty, typeSerializer);
        }

        public final ContainerSerializer<?> m11721b(TypeSerializer typeSerializer) {
            return new ShortArraySerializer(this, this.f6178c, typeSerializer);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f6216a = hashMap;
        hashMap.put(boolean[].class.getName(), new BooleanArraySerializer());
        f6216a.put(byte[].class.getName(), new ByteArraySerializer());
        f6216a.put(char[].class.getName(), new CharArraySerializer());
        f6216a.put(short[].class.getName(), new ShortArraySerializer());
        f6216a.put(int[].class.getName(), new IntArraySerializer());
        f6216a.put(long[].class.getName(), new LongArraySerializer());
        f6216a.put(float[].class.getName(), new FloatArraySerializer());
        f6216a.put(double[].class.getName(), new DoubleArraySerializer());
    }

    protected StdArraySerializers() {
    }

    public static JsonSerializer<?> m11724a(Class<?> cls) {
        return (JsonSerializer) f6216a.get(cls.getName());
    }
}
