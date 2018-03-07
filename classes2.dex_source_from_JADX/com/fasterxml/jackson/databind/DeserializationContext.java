package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: static_map_http_flow */
public abstract class DeserializationContext extends DatabindContext implements Serializable {
    private static final long serialVersionUID = -7727373309391091315L;
    protected final DeserializerCache _cache;
    public final DeserializationConfig _config;
    protected final DeserializerFactory _factory;
    protected final int _featureFlags;
    protected final InjectableValues _injectableValues;
    protected final Class<?> _view;
    public transient JsonParser f4142a;
    protected transient ArrayBuilders f4143b;
    protected transient ObjectBuffer f4144c;
    protected transient DateFormat f4145d;

    public abstract ReadableObjectId mo1077a(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public abstract JsonDeserializer<Object> mo1078b(Annotated annotated, Object obj);

    public abstract KeyDeserializer mo1079c(Annotated annotated, Object obj);

    protected DeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        if (deserializerFactory == null) {
            throw new IllegalArgumentException("Can not pass null DeserializerFactory");
        }
        this._factory = deserializerFactory;
        if (deserializerCache == null) {
            deserializerCache = new DeserializerCache();
        }
        this._cache = deserializerCache;
        this._featureFlags = 0;
        this._config = null;
        this._injectableValues = null;
        this._view = null;
    }

    protected DeserializationContext(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory) {
        this._cache = deserializationContext._cache;
        this._factory = deserializerFactory;
        this._config = deserializationContext._config;
        this._featureFlags = deserializationContext._featureFlags;
        this._view = deserializationContext._view;
        this.f4142a = deserializationContext.f4142a;
        this._injectableValues = deserializationContext._injectableValues;
    }

    protected DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
        this._cache = deserializationContext._cache;
        this._factory = deserializationContext._factory;
        this._config = deserializationConfig;
        this._featureFlags = deserializationConfig._deserFeatures;
        this._view = deserializationConfig._view;
        this.f4142a = jsonParser;
        this._injectableValues = injectableValues;
    }

    public final /* synthetic */ MapperConfig mo1070a() {
        return this._config;
    }

    public final DeserializationConfig m7405d() {
        return this._config;
    }

    public final Class<?> m7406e() {
        return this._view;
    }

    public final AnnotationIntrospector m7407f() {
        return this._config.mo1061a();
    }

    public final TypeFactory mo1071c() {
        return this._config.m7269n();
    }

    public final boolean m7395a(DeserializationFeature deserializationFeature) {
        return (this._featureFlags & deserializationFeature.getMask()) != 0;
    }

    public final JsonMappingException m7402c(String str) {
        return JsonMappingException.a(this.f4142a, str);
    }

    public final JsonParser m7408g() {
        return this.f4142a;
    }

    public final Object m7390a(Object obj, BeanProperty beanProperty, Object obj2) {
        if (this._injectableValues != null) {
            return this._injectableValues.a();
        }
        throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + obj + "]");
    }

    public final Base64Variant m7409h() {
        return this._config.m7273r();
    }

    public final JsonNodeFactory m7410i() {
        return this._config._nodeFactory;
    }

    public final Locale m7411j() {
        return this._config.m7271p();
    }

    public final TimeZone m7412k() {
        return this._config.m7272q();
    }

    public final JsonDeserializer<Object> m7381a(JavaType javaType, BeanProperty beanProperty) {
        JsonDeserializer<Object> a = this._cache.m7536a(this, this._factory, javaType);
        if (a == null || !(a instanceof ContextualDeserializer)) {
            return a;
        }
        return ((ContextualDeserializer) a).a(this, beanProperty);
    }

    public final JsonDeserializer<Object> m7380a(JavaType javaType) {
        JsonDeserializer<Object> a = this._cache.m7536a(this, this._factory, javaType);
        if (a == null) {
            return null;
        }
        if (a instanceof ContextualDeserializer) {
            a = ((ContextualDeserializer) a).a(this, null);
        }
        TypeDeserializer b = this._factory.mo1093b(this._config, javaType);
        if (b != null) {
            return new TypeWrappedDeserializer(b.a(null), a);
        }
        return a;
    }

    public final KeyDeserializer m7399b(JavaType javaType, BeanProperty beanProperty) {
        KeyDeserializer b = this._cache.m7537b(this, this._factory, javaType);
        if (b instanceof ContextualKeyDeserializer) {
            return ((ContextualKeyDeserializer) b).a();
        }
        return b;
    }

    public final JavaType m7379a(Class<?> cls) {
        return this._config.m7258b(cls);
    }

    public static Class<?> m7374a(String str) {
        return ClassUtil.a(str);
    }

    public final ObjectBuffer m7413l() {
        ObjectBuffer objectBuffer = this.f4144c;
        if (objectBuffer == null) {
            return new ObjectBuffer();
        }
        this.f4144c = null;
        return objectBuffer;
    }

    public final void m7392a(ObjectBuffer objectBuffer) {
        if (this.f4144c == null || objectBuffer.b() >= this.f4144c.b()) {
            this.f4144c = objectBuffer;
        }
    }

    public final ArrayBuilders m7414m() {
        if (this.f4143b == null) {
            this.f4143b = new ArrayBuilders();
        }
        return this.f4143b;
    }

    public final Date m7400b(String str) {
        try {
            return m7377n().parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse Date value '" + str + "': " + e.getMessage());
        }
    }

    public final Calendar m7391a(Date date) {
        Calendar instance = Calendar.getInstance(m7412k());
        instance.setTime(date);
        return instance;
    }

    public final boolean m7394a(JsonParser jsonParser, JsonDeserializer<?> jsonDeserializer, Object obj, String str) {
        LinkedNode linkedNode = this._config._problemHandlers;
        if (linkedNode != null) {
            while (linkedNode != null) {
                if (null != null) {
                    return true;
                }
                linkedNode = linkedNode.a;
            }
        }
        return false;
    }

    public final void m7393a(Object obj, String str, JsonDeserializer<?> jsonDeserializer) {
        if (m7395a(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw UnrecognizedPropertyException.a(this.f4142a, obj, str, jsonDeserializer == null ? null : jsonDeserializer.m13370c());
        }
    }

    public final JsonMappingException m7397b(Class<?> cls) {
        return m7383a((Class) cls, this.f4142a.mo1794g());
    }

    public final JsonMappingException m7383a(Class<?> cls, JsonToken jsonToken) {
        return JsonMappingException.a(this.f4142a, "Can not deserialize instance of " + m7375d((Class) cls) + " out of " + jsonToken + " token");
    }

    public final JsonMappingException m7386a(Class<?> cls, Throwable th) {
        return JsonMappingException.a(this.f4142a, "Can not construct instance of " + cls.getName() + ", problem: " + th.getMessage(), th);
    }

    public final JsonMappingException m7384a(Class<?> cls, String str) {
        return JsonMappingException.a(this.f4142a, "Can not construct instance of " + cls.getName() + ", problem: " + str);
    }

    public final JsonMappingException m7387a(String str, Class<?> cls, String str2) {
        return InvalidFormatException.a(this.f4142a, "Can not construct instance of " + cls.getName() + " from String value '" + m7378o() + "': " + str2, str, cls);
    }

    public final JsonMappingException m7398b(Class<?> cls, String str) {
        return InvalidFormatException.a(this.f4142a, "Can not construct instance of " + cls.getName() + " from number value (" + m7378o() + "): " + str, null, cls);
    }

    public final JsonMappingException m7385a(Class<?> cls, String str, String str2) {
        return InvalidFormatException.a(this.f4142a, "Can not construct Map key of type " + cls.getName() + " from String \"" + m7376d(str) + "\": " + str2, str, cls);
    }

    public static JsonMappingException m7373a(JsonParser jsonParser, JsonToken jsonToken, String str) {
        return JsonMappingException.a(jsonParser, "Unexpected token (" + jsonParser.mo1794g() + "), expected " + jsonToken + ": " + str);
    }

    public final JsonMappingException m7382a(JavaType javaType, String str) {
        return JsonMappingException.a(this.f4142a, "Could not resolve type id '" + str + "' into a subtype of " + javaType);
    }

    public final JsonMappingException m7401c(Class<?> cls) {
        return JsonMappingException.a(this.f4142a, "Unexpected end-of-input when trying to deserialize a " + cls.getName());
    }

    private DateFormat m7377n() {
        if (this.f4145d != null) {
            return this.f4145d;
        }
        DateFormat dateFormat = (DateFormat) this._config.m7270o().clone();
        this.f4145d = dateFormat;
        return dateFormat;
    }

    private String m7375d(Class<?> cls) {
        if (cls.isArray()) {
            return m7375d(cls.getComponentType()) + "[]";
        }
        return cls.getName();
    }

    private String m7378o() {
        try {
            return m7376d(this.f4142a.mo1769o());
        } catch (Exception e) {
            return "[N/A]";
        }
    }

    private static String m7376d(String str) {
        if (str.length() > 500) {
            return str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
        }
        return str;
    }
}
