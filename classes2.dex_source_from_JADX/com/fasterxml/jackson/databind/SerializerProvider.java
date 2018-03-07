package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: step */
public abstract class SerializerProvider extends DatabindContext {
    protected static final JavaType f4133a = TypeFactory.m7084a(Object.class);
    public static final JsonSerializer<Object> f4134b = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    public static final JsonSerializer<Object> f4135c = new UnknownSerializer();
    public final SerializationConfig _config;
    protected DateFormat _dateFormat;
    protected JsonSerializer<Object> _keySerializer;
    protected final ReadOnlyClassToSerializerMap _knownSerializers;
    public JsonSerializer<Object> _nullKeySerializer;
    public JsonSerializer<Object> _nullValueSerializer;
    protected final RootNameLookup _rootNames;
    public final Class<?> _serializationView;
    protected final SerializerCache _serializerCache;
    protected final SerializerFactory _serializerFactory;
    public JsonSerializer<Object> _unknownTypeSerializer;

    public abstract WritableObjectId mo1068a(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public abstract JsonSerializer<Object> mo1069b(Annotated annotated, Object obj);

    static {
        TypeFactory typeFactory = TypeFactory.f4051a;
    }

    public SerializerProvider() {
        this._unknownTypeSerializer = f4135c;
        this._nullValueSerializer = NullSerializer.f4138a;
        this._nullKeySerializer = f4134b;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new SerializerCache();
        this._knownSerializers = null;
        this._rootNames = new RootNameLookup();
        this._serializationView = null;
    }

    protected SerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
        this._unknownTypeSerializer = f4135c;
        this._nullValueSerializer = NullSerializer.f4138a;
        this._nullKeySerializer = f4134b;
        if (serializationConfig == null) {
            throw new NullPointerException();
        }
        this._serializerFactory = serializerFactory;
        this._config = serializationConfig;
        this._serializerCache = serializerProvider._serializerCache;
        this._unknownTypeSerializer = serializerProvider._unknownTypeSerializer;
        this._keySerializer = serializerProvider._keySerializer;
        this._nullValueSerializer = serializerProvider._nullValueSerializer;
        this._nullKeySerializer = serializerProvider._nullKeySerializer;
        this._rootNames = serializerProvider._rootNames;
        this._knownSerializers = this._serializerCache.m7359a();
        this._serializationView = serializationConfig._view;
    }

    public final /* synthetic */ MapperConfig mo1070a() {
        return this._config;
    }

    public final SerializationConfig m7321d() {
        return this._config;
    }

    public final AnnotationIntrospector m7322e() {
        return this._config.mo1061a();
    }

    public final TypeFactory mo1071c() {
        return this._config.m7269n();
    }

    public final Class<?> m7323f() {
        return this._serializationView;
    }

    public final boolean m7316a(SerializationFeature serializationFeature) {
        return this._config.m7246c(serializationFeature);
    }

    public final FilterProvider m7324g() {
        return this._config._filterProvider;
    }

    public final Locale m7325h() {
        return this._config.m7271p();
    }

    public final TimeZone m7326i() {
        return this._config.m7272q();
    }

    public final JsonSerializer<Object> m7308a(Class<?> cls, BeanProperty beanProperty) {
        JsonSerializer b = this._knownSerializers.b(cls);
        if (b == null) {
            b = this._serializerCache.m7358a((Class) cls);
            if (b == null) {
                b = this._serializerCache.m7357a(this._config.m7258b(cls));
                if (b == null) {
                    b = m7299a((Class) cls);
                    if (b == null) {
                        return this._unknownTypeSerializer;
                    }
                }
            }
        }
        return m7302b(b, beanProperty);
    }

    public final JsonSerializer<Object> m7305a(JavaType javaType, BeanProperty beanProperty) {
        JsonSerializer b = this._knownSerializers.b(javaType);
        if (b == null) {
            b = this._serializerCache.m7357a(javaType);
            if (b == null) {
                b = m7297a(javaType);
                if (b == null) {
                    return this._unknownTypeSerializer;
                }
            }
        }
        return m7302b(b, beanProperty);
    }

    public JsonSerializer<Object> m7309a(Class<?> cls, boolean z, BeanProperty beanProperty) {
        JsonSerializer<Object> a = this._knownSerializers.a(cls);
        if (a == null) {
            a = this._serializerCache.m7365b((Class) cls);
            if (a == null) {
                JsonSerializer<Object> a2 = m7308a((Class) cls, beanProperty);
                TypeSerializer a3 = this._serializerFactory.mo1099a(this._config, this._config.m7258b(cls));
                if (a3 != null) {
                    a = new TypeWrappedSerializer(a3.a(beanProperty), a2);
                } else {
                    a = a2;
                }
                if (z) {
                    this._serializerCache.m7362a((Class) cls, r0);
                }
            }
        }
        return a;
    }

    public final JsonSerializer<Object> m7306a(JavaType javaType, boolean z, BeanProperty beanProperty) {
        JsonSerializer<Object> a = this._knownSerializers.a(javaType);
        if (a == null) {
            a = this._serializerCache.m7364b(javaType);
            if (a == null) {
                JsonSerializer<Object> a2 = m7305a(javaType, beanProperty);
                TypeSerializer a3 = this._serializerFactory.mo1099a(this._config, javaType);
                if (a3 != null) {
                    a = new TypeWrappedSerializer(a3.a(beanProperty), a2);
                } else {
                    a = a2;
                }
                if (z) {
                    this._serializerCache.m7360a(javaType, r0);
                }
            }
        }
        return a;
    }

    public final JsonSerializer<Object> m7317b(JavaType javaType, BeanProperty beanProperty) {
        return m7298a(this._serializerFactory.mo1098a(this._config, javaType, this._keySerializer), beanProperty);
    }

    private JsonSerializer<Object> m7303n() {
        return this._nullKeySerializer;
    }

    public final JsonSerializer<Object> m7328k() {
        return this._nullKeySerializer;
    }

    public final void m7313a(JsonGenerator jsonGenerator) {
        this._nullValueSerializer.mo1072a(null, jsonGenerator, this);
    }

    public final JsonSerializer<Object> m7327j() {
        return this._nullValueSerializer;
    }

    public final JsonSerializer<Object> m7329l() {
        return this._nullValueSerializer;
    }

    public final JsonSerializer<Object> m7330m() {
        return this._unknownTypeSerializer;
    }

    public final void m7314a(Object obj, JsonGenerator jsonGenerator) {
        if (obj == null) {
            this._nullValueSerializer.mo1072a(null, jsonGenerator, this);
        } else {
            m7309a(obj.getClass(), true, null).mo1072a(obj, jsonGenerator, this);
        }
    }

    public final void m7315a(Date date, JsonGenerator jsonGenerator) {
        if (m7316a(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.mo1111a(date.getTime());
        } else {
            jsonGenerator.mo1123b(m7304o().format(date));
        }
    }

    public final void m7312a(long j, JsonGenerator jsonGenerator) {
        if (m7316a(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.mo1115a(String.valueOf(j));
        } else {
            jsonGenerator.mo1115a(m7304o().format(new Date(j)));
        }
    }

    public final void m7319b(Date date, JsonGenerator jsonGenerator) {
        if (m7316a(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.mo1115a(String.valueOf(date.getTime()));
        } else {
            jsonGenerator.mo1115a(m7304o().format(date));
        }
    }

    protected static void m7300a(Object obj, JavaType javaType) {
        if (!javaType.m6720j() || !ClassUtil.g(javaType._class).isAssignableFrom(obj.getClass())) {
            throw new JsonMappingException("Incompatible types: declared root type (" + javaType + ") vs " + obj.getClass().getName());
        }
    }

    private JsonSerializer<Object> m7299a(Class<?> cls) {
        try {
            JsonSerializer b = m7301b(this._config.m7258b(cls));
            if (b != null) {
                this._serializerCache.m7363a((Class) cls, b, this);
            }
            return b;
        } catch (Throwable e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }

    private JsonSerializer<Object> m7297a(JavaType javaType) {
        try {
            JsonSerializer b = m7301b(javaType);
            if (b != null) {
                this._serializerCache.m7361a(javaType, b, this);
            }
            return b;
        } catch (Throwable e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }

    private JsonSerializer<Object> m7301b(JavaType javaType) {
        return this._serializerFactory.mo1095a(this, javaType);
    }

    private JsonSerializer<Object> m7298a(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) {
        if (jsonSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializer).a(this);
        }
        return m7302b((JsonSerializer) jsonSerializer, beanProperty);
    }

    protected final JsonSerializer<Object> m7307a(JsonSerializer<?> jsonSerializer) {
        if (jsonSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializer).a(this);
        }
        return jsonSerializer;
    }

    private JsonSerializer<Object> m7302b(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) {
        if (jsonSerializer instanceof ContextualSerializer) {
            return ((ContextualSerializer) jsonSerializer).mo1105a(this, beanProperty);
        }
        return jsonSerializer;
    }

    private DateFormat m7304o() {
        if (this._dateFormat != null) {
            return this._dateFormat;
        }
        DateFormat dateFormat = (DateFormat) this._config.m7270o().clone();
        this._dateFormat = dateFormat;
        return dateFormat;
    }
}
