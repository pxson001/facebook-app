package com.facebook.common.json;

import android.annotation.SuppressLint;
import com.facebook.common.json.JsonLogger.Event;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude$Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: string array */
public class FbObjectMapper extends ObjectMapper {
    private static FbObjectMapper f4003f = null;
    private final JsonLoggerStub mJsonLogger;

    /* compiled from: string array */
    final class C02231 extends BasicClassIntrospector {
        C02231() {
        }

        public final /* synthetic */ BeanDescription mo932b(SerializationConfig serializationConfig, JavaType javaType, MixInResolver mixInResolver) {
            return mo1058a(serializationConfig, javaType, mixInResolver);
        }

        public final /* synthetic */ BeanDescription mo935d(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
            return mo1057a(deserializationConfig, javaType, mixInResolver);
        }

        public final BasicBeanDescription mo1057a(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
            BasicBeanDescription a = BasicClassIntrospector.m6733a(javaType);
            if (a != null) {
                return a;
            }
            JsonDeserialize jsonDeserialize = (JsonDeserialize) javaType._class.getAnnotation(JsonDeserialize.class);
            if (jsonDeserialize == null || jsonDeserialize.using() == null) {
                return super.mo1057a(deserializationConfig, javaType, mixInResolver);
            }
            return BasicClassIntrospector.m6734a((MapperConfig) deserializationConfig, javaType, mixInResolver);
        }

        public final BasicBeanDescription mo1058a(SerializationConfig serializationConfig, JavaType javaType, MixInResolver mixInResolver) {
            BasicBeanDescription a = BasicClassIntrospector.m6733a(javaType);
            if (a != null) {
                return a;
            }
            JsonSerialize jsonSerialize = (JsonSerialize) javaType._class.getAnnotation(JsonSerialize.class);
            if (jsonSerialize == null || jsonSerialize.using() == null) {
                return super.mo1058a(serializationConfig, javaType, mixInResolver);
            }
            return BasicClassIntrospector.m6734a((MapperConfig) serializationConfig, javaType, mixInResolver);
        }
    }

    static {
        ClassIntrospector c02231 = new C02231();
        BaseSettings baseSettings = new BaseSettings(c02231, ObjectMapper.f4005b, ObjectMapper.f4006c, null, TypeFactory.m7095a(), null, StdDateFormat.f4065f, null, Locale.getDefault(), TimeZone.getTimeZone("GMT"), Base64Variants.m7130a());
        try {
            Field declaredField = ObjectMapper.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            declaredField.set(null, c02231);
            Field declaredField2 = ObjectMapper.class.getDeclaredField("e");
            declaredField2.setAccessible(true);
            declaredField2.set(null, baseSettings);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
    }

    public static synchronized FbObjectMapper m6612i() {
        FbObjectMapper fbObjectMapper;
        synchronized (FbObjectMapper.class) {
            if (f4003f == null) {
                f4003f = new FbObjectMapper(new JsonFactory(), new JsonLoggerStub());
            }
            fbObjectMapper = f4003f;
        }
        return fbObjectMapper;
    }

    @Inject
    @SuppressLint({"BadMethodUse-<init>"})
    @VisibleForTesting
    public FbObjectMapper(@Nullable JsonFactory jsonFactory, @Nullable JsonLoggerStub jsonLoggerStub) {
        super(jsonFactory);
        this.mJsonLogger = jsonLoggerStub;
        m6641a(new FbGuavaModule());
        m6639a(PropertyAccessor.ALL, Visibility.NONE);
        m6640a(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        m6638a(JsonInclude$Include.NON_NULL);
    }

    public FbObjectMapper(@Nullable JsonFactory jsonFactory) {
        this(jsonFactory, null);
    }

    protected final DefaultSerializerProvider mo902a(SerializationConfig serializationConfig) {
        return new FbSerializerProvider(this._serializerProvider, serializationConfig, this._serializerFactory, this.mJsonLogger);
    }

    public final <T> JsonDeserializer<T> m6615a(DeserializationContext deserializationContext, Type type) {
        if (type instanceof Class) {
            return m6614a(deserializationContext, (Class) type);
        }
        return m6618b(deserializationContext, this._typeFactory.m7109a(type));
    }

    public final <T> JsonDeserializer<T> m6614a(DeserializationContext deserializationContext, Class<T> cls) {
        JsonDeserializer<T> a = GlobalAutoGenDeserializerCache.m11717a((Class) cls);
        if (a == null) {
            a = super.mo901a(deserializationContext, this._typeFactory.m7109a((Type) cls));
            if (this.mJsonLogger != null) {
                JsonLoggerStub jsonLoggerStub = this.mJsonLogger;
                Event event = Event.DESERIALIZATION;
                String cls2 = cls.toString();
                Event event2 = Event.SERIALIZATION;
            }
        }
        return a;
    }

    public final <T> JsonDeserializer<T> m6618b(DeserializationContext deserializationContext, JavaType javaType) {
        JsonDeserializer<T> jsonDeserializer = null;
        if (!javaType.m6726p()) {
            jsonDeserializer = GlobalAutoGenDeserializerCache.m11717a(javaType._class);
        }
        if (jsonDeserializer == null) {
            jsonDeserializer = m6610a(javaType);
        }
        if (jsonDeserializer == null) {
            jsonDeserializer = super.mo901a(deserializationContext, javaType);
            if (this.mJsonLogger != null) {
                JsonLoggerStub jsonLoggerStub = this.mJsonLogger;
                Event event = Event.DESERIALIZATION;
                String javaType2 = javaType.toString();
                Event event2 = Event.SERIALIZATION;
            }
        }
        return jsonDeserializer;
    }

    protected final JsonDeserializer<Object> mo901a(DeserializationContext deserializationContext, JavaType javaType) {
        return m6618b(deserializationContext, javaType);
    }

    private <T> JsonDeserializer<T> m6610a(JavaType javaType) {
        Class cls = javaType._class;
        if (cls == List.class || cls == ArrayList.class) {
            return new ArrayListDeserializer(javaType);
        }
        if (cls == ImmutableList.class) {
            return new ImmutableListDeserializer(javaType);
        }
        if ((cls == Map.class || cls == LinkedHashMap.class) && m6611a(javaType.mo913a(0)._class)) {
            return new LinkedHashMapDeserializer(javaType);
        }
        if (cls == ImmutableMap.class && m6611a(javaType.mo913a(0)._class)) {
            return new ImmutableMapDeserializer(javaType);
        }
        return null;
    }

    private static boolean m6611a(Class cls) {
        return cls == String.class || Enum.class.isAssignableFrom(cls);
    }

    protected final Object mo904b(JsonParser jsonParser, JavaType javaType) {
        if (jsonParser.mo1761a() == null) {
            jsonParser.mo1763a((ObjectCodec) this);
        }
        return super.mo904b(jsonParser, javaType);
    }

    protected final Object mo903a(DeserializationConfig deserializationConfig, JsonParser jsonParser, JavaType javaType) {
        if (jsonParser.mo1761a() == null) {
            jsonParser.mo1763a((ObjectCodec) this);
        }
        return super.mo903a(deserializationConfig, jsonParser, javaType);
    }
}
