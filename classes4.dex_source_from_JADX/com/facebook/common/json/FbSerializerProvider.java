package com.facebook.common.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.FloatSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.LongSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.google.common.collect.Maps;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: video_resize_keyframe_interval_secs */
public class FbSerializerProvider extends DefaultSerializerProvider {
    private static final ConcurrentMap<Class, JsonSerializer> f243f = Maps.e();
    private static boolean f244g = false;
    private static JsonSerializer f245h = new C00272();
    private static JsonSerializer f246i = new C00283();
    private static JsonSerializer f247j = new C00294();
    private JsonSerializer mCollectionSerializer = new C00301(this);
    private final JsonLoggerStub mJsonLogger;

    /* compiled from: video_resize_keyframe_interval_secs */
    final class C00272 extends JsonSerializer<JsonSerializable> {
        C00272() {
        }

        public final void m282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            ((JsonSerializable) obj).serialize(jsonGenerator, serializerProvider);
        }
    }

    /* compiled from: video_resize_keyframe_interval_secs */
    final class C00283 extends JsonSerializer<Enum> {
        C00283() {
        }

        public final void m283a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AutoGenJsonHelper.m10228a(jsonGenerator, (Enum) obj);
        }
    }

    /* compiled from: video_resize_keyframe_interval_secs */
    final class C00294 extends JsonSerializer<Map> {
        C00294() {
        }

        public final void m284a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Map map = (Map) obj;
            jsonGenerator.f();
            for (Object next : map.keySet()) {
                if (next instanceof String) {
                    jsonGenerator.a((String) next);
                } else if (next instanceof Enum) {
                    JsonFactory b = jsonGenerator.a().b();
                    Writer stringWriter = new StringWriter();
                    JsonGenerator a = b.a(stringWriter);
                    a.a(jsonGenerator.a());
                    a.a(next);
                    a.flush();
                    JsonParser a2 = b.a(stringWriter.toString());
                    String e = a2.e();
                    if (e == null || a2.c() != null) {
                        throw new JsonGenerationException("Tried to use json as map key, but it is not a string: " + stringWriter);
                    }
                    jsonGenerator.a(e);
                } else {
                    throw new JsonGenerationException("Non-string, non-enum key (" + next.getClass() + ") found in map.");
                }
                jsonGenerator.a(map.get(next));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: video_resize_keyframe_interval_secs */
    class C00301 extends JsonSerializer<Collection> {
        final /* synthetic */ FbSerializerProvider f255a;

        C00301(FbSerializerProvider fbSerializerProvider) {
            this.f255a = fbSerializerProvider;
        }

        public final void m293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AutoGenJsonHelper.m10227a(jsonGenerator, serializerProvider, (Collection) obj);
        }
    }

    private static void m279n() {
        f243f.put(String.class, new StringSerializer());
        f243f.put(Integer.class, new IntegerSerializer());
        f243f.put(Long.class, new LongSerializer());
        f243f.put(Boolean.class, new BooleanSerializer(false));
        f243f.put(Float.class, new FloatSerializer());
        f243f.put(Double.class, new DoubleSerializer());
    }

    public FbSerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory serializerFactory, JsonLoggerStub jsonLoggerStub) {
        super(serializerProvider, serializationConfig, serializerFactory);
        this.mJsonLogger = jsonLoggerStub;
        if (!f244g) {
            m279n();
            f244g = true;
        }
    }

    public static <T> void m277a(Class<? extends T> cls, JsonSerializer<T> jsonSerializer) {
        f243f.putIfAbsent(cls, jsonSerializer);
    }

    public final DefaultSerializerProvider m281a(SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
        return new FbSerializerProvider(this, serializationConfig, serializerFactory, this.mJsonLogger);
    }

    public static JsonSerializer<Object> m276a(Class<?> cls) {
        JsonSerializer<Object> jsonSerializer = (JsonSerializer) f243f.get(cls);
        if (jsonSerializer != null) {
            return jsonSerializer;
        }
        m278b(cls);
        return (JsonSerializer) f243f.get(cls);
    }

    public final JsonSerializer<Object> m280a(Class<?> cls, boolean z, @Nullable BeanProperty beanProperty) {
        JsonSerializer<Object> jsonSerializer = (JsonSerializer) f243f.get(cls);
        if (jsonSerializer != null) {
            return jsonSerializer;
        }
        m278b(cls);
        jsonSerializer = (JsonSerializer) f243f.get(cls);
        if (jsonSerializer != null) {
            return jsonSerializer;
        }
        if (JsonSerializable.class.isAssignableFrom(cls)) {
            f243f.put(cls, f245h);
            return f245h;
        } else if (cls.isEnum()) {
            f243f.put(cls, f246i);
            return f246i;
        } else if (Collection.class.isAssignableFrom(cls)) {
            f243f.put(cls, this.mCollectionSerializer);
            return this.mCollectionSerializer;
        } else if (Map.class.isAssignableFrom(cls)) {
            f243f.put(cls, f247j);
            return f247j;
        } else {
            jsonSerializer = super.a(cls, z, beanProperty);
            if (this.mJsonLogger == null) {
                return jsonSerializer;
            }
            JsonLoggerStub jsonLoggerStub = this.mJsonLogger;
            JsonLogger$Event jsonLogger$Event = JsonLogger$Event.SERIALIZATION;
            String cls2 = cls.toString();
            JsonLogger$Event jsonLogger$Event2 = JsonLogger$Event.SERIALIZATION;
            return jsonSerializer;
        }
    }

    private static void m278b(Class<?> cls) {
        try {
            Class.forName(cls.getName().replace('$', '_') + "Serializer");
        } catch (ClassNotFoundException e) {
            try {
                Class.forName(cls.getName().concat("$Serializer"));
            } catch (ClassNotFoundException e2) {
            }
        }
    }
}
