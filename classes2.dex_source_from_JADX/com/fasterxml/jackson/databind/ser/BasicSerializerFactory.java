package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumMapSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlDateSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdContainerSerializers;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.EnumValues;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.TimeZone;

/* compiled from: start_cursor */
public abstract class BasicSerializerFactory extends SerializerFactory implements Serializable {
    protected static final HashMap<String, JsonSerializer<?>> f4162a = new HashMap();
    protected static final HashMap<String, Class<? extends JsonSerializer<?>>> f4163b = new HashMap();
    protected final SerializerFactoryConfig _factoryConfig;

    public abstract SerializerFactory mo1096a(SerializerFactoryConfig serializerFactoryConfig);

    protected abstract Iterable<Serializers> mo1097a();

    static {
        f4162a.put(String.class.getName(), new StringSerializer());
        ToStringSerializer toStringSerializer = ToStringSerializer.f4164a;
        f4162a.put(StringBuffer.class.getName(), toStringSerializer);
        f4162a.put(StringBuilder.class.getName(), toStringSerializer);
        f4162a.put(Character.class.getName(), toStringSerializer);
        f4162a.put(Character.TYPE.getName(), toStringSerializer);
        NumberSerializers.m7597a(f4162a);
        f4162a.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        f4162a.put(Boolean.class.getName(), new BooleanSerializer(false));
        NumberSerializer numberSerializer = new NumberSerializer();
        f4162a.put(BigInteger.class.getName(), numberSerializer);
        f4162a.put(BigDecimal.class.getName(), numberSerializer);
        f4162a.put(Calendar.class.getName(), CalendarSerializer.f4172a);
        DateSerializer dateSerializer = DateSerializer.f4175a;
        f4162a.put(Date.class.getName(), dateSerializer);
        f4162a.put(Timestamp.class.getName(), dateSerializer);
        f4163b.put(java.sql.Date.class.getName(), SqlDateSerializer.class);
        f4163b.put(Time.class.getName(), SqlTimeSerializer.class);
        for (Entry entry : StdJdkSerializers.m7622a()) {
            Object value = entry.getValue();
            if (value instanceof JsonSerializer) {
                f4162a.put(((Class) entry.getKey()).getName(), (JsonSerializer) value);
            } else if (value instanceof Class) {
                f4163b.put(((Class) entry.getKey()).getName(), (Class) value);
            } else {
                throw new IllegalStateException("Internal error: unrecognized value of type " + entry.getClass().getName());
            }
        }
        f4163b.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
    }

    protected BasicSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        if (serializerFactoryConfig == null) {
            serializerFactoryConfig = new SerializerFactoryConfig();
        }
        this._factoryConfig = serializerFactoryConfig;
    }

    public final SerializerFactory mo1101a(Serializers serializers) {
        return mo1096a(this._factoryConfig.m7720a(serializers));
    }

    public final SerializerFactory mo1100a(BeanSerializerModifier beanSerializerModifier) {
        return mo1096a(this._factoryConfig.m7719a(beanSerializerModifier));
    }

    protected final JsonSerializer<?> m7574a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription, boolean z) {
        Class cls = javaType._class;
        if (Iterator.class.isAssignableFrom(cls)) {
            return m7560a(serializationConfig, javaType, beanDescription);
        }
        if (Iterable.class.isAssignableFrom(cls)) {
            return m7568b(serializationConfig, javaType, beanDescription);
        }
        if (CharSequence.class.isAssignableFrom(cls)) {
            return ToStringSerializer.f4164a;
        }
        return null;
    }

    public final JsonSerializer<Object> mo1098a(SerializationConfig serializationConfig, JavaType javaType, JsonSerializer<Object> jsonSerializer) {
        BeanDescription c = serializationConfig.m7260c(javaType._class);
        JsonSerializer<Object> jsonSerializer2 = null;
        if (this._factoryConfig.m7721a()) {
            for (Serializers a : this._factoryConfig.m7724d()) {
                jsonSerializer2 = a.mo1152a(serializationConfig, javaType, c);
                if (jsonSerializer2 != null) {
                    break;
                }
            }
        }
        if (jsonSerializer2 != null) {
            jsonSerializer = jsonSerializer2;
        } else if (jsonSerializer == null) {
            jsonSerializer = StdKeySerializers.a(javaType);
        }
        if (this._factoryConfig.m7722b()) {
            Iterator it = this._factoryConfig.m7725e().iterator();
            while (it.hasNext()) {
                it.next();
                jsonSerializer = jsonSerializer;
            }
        }
        return jsonSerializer;
    }

    protected final JsonSerializer<?> m7576a(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription) {
        if (JsonSerializable.class.isAssignableFrom(javaType._class)) {
            return SerializableSerializer.a;
        }
        Annotated p = beanDescription.mo962p();
        if (p == null) {
            return null;
        }
        Method method = p.a;
        if (serializerProvider.m7337b()) {
            ClassUtil.a(method);
        }
        return new JsonValueSerializer(method, m7578a(serializerProvider, p));
    }

    protected final JsonSerializer<?> m7577a(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z) {
        Class cls = javaType._class;
        if (InetAddress.class.isAssignableFrom(cls)) {
            return InetAddressSerializer.a;
        }
        if (TimeZone.class.isAssignableFrom(cls)) {
            return TimeZoneSerializer.a;
        }
        if (Charset.class.isAssignableFrom(cls)) {
            return ToStringSerializer.f4164a;
        }
        JsonSerializer<?> b = m7569b(serializerProvider, javaType, beanDescription);
        if (b != null) {
            return b;
        }
        if (Number.class.isAssignableFrom(cls)) {
            return NumberSerializer.f4171a;
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return m7571c(serializerProvider._config, javaType, beanDescription);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            return CalendarSerializer.f4172a;
        }
        if (Date.class.isAssignableFrom(cls)) {
            return DateSerializer.f4175a;
        }
        return null;
    }

    public final TypeSerializer mo1099a(SerializationConfig serializationConfig, JavaType javaType) {
        Collection collection;
        AnnotatedClass c = serializationConfig.m7260c(javaType._class).mo949c();
        AnnotationIntrospector a = serializationConfig.mo1061a();
        TypeResolverBuilder a2 = a.mo974a((MapperConfig) serializationConfig, c, javaType);
        if (a2 == null) {
            a2 = serializationConfig.m7268m();
            collection = null;
        } else {
            collection = serializationConfig._subtypeResolver.mo1059a(c, serializationConfig, a);
        }
        if (a2 == null) {
            return null;
        }
        return a2.a(serializationConfig, javaType, collection);
    }

    protected static JsonSerializer<?> m7559a(JavaType javaType) {
        String name = javaType.m6708c().getName();
        JsonSerializer<?> jsonSerializer = (JsonSerializer) f4162a.get(name);
        if (jsonSerializer != null) {
            return jsonSerializer;
        }
        Class cls = (Class) f4163b.get(name);
        if (cls == null) {
            return jsonSerializer;
        }
        try {
            return (JsonSerializer) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalStateException("Failed to instantiate standard serializer (of type " + cls.getName() + "): " + e.getMessage(), e);
        }
    }

    private static JsonSerializer<?> m7569b(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription) {
        return OptionalHandlerFactory.a.a(serializerProvider._config, javaType, beanDescription);
    }

    protected final JsonSerializer<Object> m7578a(SerializerProvider serializerProvider, Annotated annotated) {
        Object f = serializerProvider.m7322e().mo999f(annotated);
        if (f == null) {
            return null;
        }
        return m7564a(serializerProvider, annotated, serializerProvider.mo1069b(annotated, f));
    }

    private JsonSerializer<?> m7564a(SerializerProvider serializerProvider, Annotated annotated, JsonSerializer<?> jsonSerializer) {
        Converter b = m7570b(serializerProvider, annotated);
        if (b == null) {
            return jsonSerializer;
        }
        serializerProvider.mo1071c();
        return new StdDelegatingSerializer(b, b.c(), jsonSerializer);
    }

    private static Converter<Object, Object> m7570b(SerializerProvider serializerProvider, Annotated annotated) {
        Object m = serializerProvider.m7322e().mo1015m(annotated);
        if (m == null) {
            return null;
        }
        return serializerProvider.m7335a(annotated, m);
    }

    protected final JsonSerializer<?> m7584b(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z) {
        boolean z2;
        SerializationConfig d = serializerProvider.m7321d();
        if (!(z || !javaType.m6725o() || (javaType.mo924l() && javaType.m6728r().m6708c() == Object.class))) {
            z = true;
        }
        TypeSerializer a = mo1099a(d, javaType.m6728r());
        if (a != null) {
            z2 = false;
        } else {
            z2 = z;
        }
        JsonSerializer d2 = m7573d(serializerProvider, beanDescription.mo949c());
        JsonSerializer<?> a2;
        Iterator it;
        if (javaType.m6724n()) {
            MapLikeType mapLikeType = (MapLikeType) javaType;
            JsonSerializer c = m7572c(serializerProvider, beanDescription.mo949c());
            if (mapLikeType.x()) {
                return m7563a(d, (MapType) mapLikeType, beanDescription, z2, c, a, d2);
            }
            for (Serializers a3 : mo1097a()) {
                a2 = a3.mo1153a(d, (MapLikeType) javaType, beanDescription, c, a, d2);
                if (a2 != null) {
                    if (!this._factoryConfig.m7722b()) {
                        return a2;
                    }
                    it = this._factoryConfig.m7725e().iterator();
                    while (it.hasNext()) {
                        it.next();
                        a2 = BeanSerializerModifier.m7739f(a2);
                    }
                    return a2;
                }
            }
            return null;
        } else if (javaType.m6723m()) {
            CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
            if (collectionLikeType.x()) {
                return m7562a(d, (CollectionType) collectionLikeType, beanDescription, z2, a, d2);
            }
            for (Serializers c2 : mo1097a()) {
                a2 = c2.mo1156c();
                if (a2 != null) {
                    if (!this._factoryConfig.m7722b()) {
                        return a2;
                    }
                    it = this._factoryConfig.m7725e().iterator();
                    while (it.hasNext()) {
                        it.next();
                        a2 = BeanSerializerModifier.m7737d(a2);
                    }
                    return a2;
                }
            }
            return null;
        } else if (!javaType.m6716g()) {
            return null;
        } else {
            return m7561a(d, (ArrayType) javaType, beanDescription, z2, a, d2);
        }
    }

    private JsonSerializer<?> m7562a(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        JavaType javaType = null;
        JsonSerializer<?> jsonSerializer2 = null;
        for (Serializers b : mo1097a()) {
            jsonSerializer2 = b.mo1155b();
            if (jsonSerializer2 != null) {
                break;
            }
        }
        if (jsonSerializer2 == null) {
            Value a = beanDescription.mo942a(null);
            if (a != null && a.b == Shape.OBJECT) {
                return null;
            }
            Class cls = collectionType._class;
            if (EnumSet.class.isAssignableFrom(cls)) {
                JavaType r = collectionType.m6728r();
                if (r.m6718h()) {
                    javaType = r;
                }
                jsonSerializer2 = StdContainerSerializers.a(javaType);
            } else {
                Class cls2 = collectionType.m6728r()._class;
                if (m7566a(cls)) {
                    if (cls2 != String.class) {
                        jsonSerializer2 = StdContainerSerializers.a(collectionType.m6728r(), z, typeSerializer, jsonSerializer);
                    } else if (jsonSerializer == null || ClassUtil.a(jsonSerializer)) {
                        jsonSerializer2 = IndexedStringListSerializer.a;
                    }
                } else if (cls2 == String.class && (jsonSerializer == null || ClassUtil.a(jsonSerializer))) {
                    jsonSerializer2 = StringCollectionSerializer.a;
                }
                if (jsonSerializer2 == null) {
                    jsonSerializer2 = StdContainerSerializers.b(collectionType.m6728r(), z, typeSerializer, jsonSerializer);
                }
            }
        }
        if (this._factoryConfig.m7722b()) {
            Iterator it = this._factoryConfig.m7725e().iterator();
            while (it.hasNext()) {
                it.next();
                jsonSerializer2 = jsonSerializer2;
            }
        }
        return jsonSerializer2;
    }

    private static boolean m7566a(Class<?> cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    private JsonSerializer<?> m7563a(SerializationConfig serializationConfig, MapType mapType, BeanDescription beanDescription, boolean z, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        JsonSerializer<?> jsonSerializer3 = null;
        for (Serializers d : mo1097a()) {
            jsonSerializer3 = d.mo1157d();
            if (jsonSerializer3 != null) {
                break;
            }
        }
        if (jsonSerializer3 == null) {
            if (EnumMap.class.isAssignableFrom(mapType._class)) {
                EnumValues b;
                JavaType q = mapType.m6727q();
                if (q.m6718h()) {
                    b = EnumValues.b(q._class, serializationConfig.mo1061a());
                } else {
                    b = null;
                }
                jsonSerializer3 = new EnumMapSerializer(mapType.m6728r(), z, b, typeSerializer, jsonSerializer2);
            } else {
                jsonSerializer3 = MapSerializer.a(serializationConfig.mo1061a().mo985b(beanDescription.mo949c()), mapType, z, typeSerializer, jsonSerializer, jsonSerializer2);
            }
        }
        if (this._factoryConfig.m7722b()) {
            Iterator it = this._factoryConfig.m7725e().iterator();
            while (it.hasNext()) {
                it.next();
                jsonSerializer3 = jsonSerializer3;
            }
        }
        return jsonSerializer3;
    }

    private JsonSerializer<?> m7561a(SerializationConfig serializationConfig, ArrayType arrayType, BeanDescription beanDescription, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        Iterator it;
        JsonSerializer<?> jsonSerializer2 = null;
        for (Serializers a : mo1097a()) {
            jsonSerializer2 = a.mo1154a();
            if (jsonSerializer2 != null) {
                break;
            }
        }
        if (jsonSerializer2 == null) {
            Class cls = arrayType._class;
            if (jsonSerializer == null || ClassUtil.a(jsonSerializer)) {
                if (String[].class == cls) {
                    jsonSerializer2 = StringArraySerializer.a;
                } else {
                    jsonSerializer2 = StdArraySerializers.a(cls);
                }
            }
            if (jsonSerializer2 == null) {
                jsonSerializer2 = new ObjectArraySerializer(arrayType.m6728r(), z, typeSerializer, jsonSerializer);
            }
        }
        if (this._factoryConfig.m7722b()) {
            it = this._factoryConfig.m7725e().iterator();
            while (it.hasNext()) {
                it.next();
                jsonSerializer2 = jsonSerializer2;
            }
        }
        return jsonSerializer2;
    }

    private JsonSerializer<?> m7560a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        JavaType a = javaType.mo913a(0);
        if (a == null) {
            a = TypeFactory.m7101c();
        }
        TypeSerializer a2 = mo1099a(serializationConfig, a);
        return StdContainerSerializers.a(a, m7565a(serializationConfig, beanDescription, a2), a2);
    }

    private JsonSerializer<?> m7568b(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        JavaType a = javaType.mo913a(0);
        if (a == null) {
            a = TypeFactory.m7101c();
        }
        TypeSerializer a2 = mo1099a(serializationConfig, a);
        return StdContainerSerializers.b(a, m7565a(serializationConfig, beanDescription, a2), a2);
    }

    private JsonSerializer<?> m7571c(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        JsonSerializer<?> jsonSerializer = null;
        Value a = beanDescription.mo942a(null);
        if (a == null || a.b != Shape.OBJECT) {
            jsonSerializer = EnumSerializer.a(javaType._class, serializationConfig, a);
            if (this._factoryConfig.m7722b()) {
                Iterator it = this._factoryConfig.m7725e().iterator();
                while (it.hasNext()) {
                    it.next();
                    jsonSerializer = jsonSerializer;
                }
            }
        } else {
            ((BasicBeanDescription) beanDescription).m6821a("declaringClass");
        }
        return jsonSerializer;
    }

    protected static <T extends JavaType> T m7558a(SerializationConfig serializationConfig, Annotated annotated, T t) {
        JavaType c;
        Class i = serializationConfig.mo1061a().mo1007i(annotated);
        if (i != null) {
            try {
                c = t.m6706c(i);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Failed to widen type " + t + " with concrete-type annotation (value " + i.getName() + "), method '" + annotated.mo938b() + "': " + e.getMessage());
            }
        }
        return m7567b(serializationConfig, annotated, c);
    }

    protected static <T extends JavaType> T m7567b(SerializationConfig serializationConfig, Annotated annotated, T t) {
        AnnotationIntrospector a = serializationConfig.mo1061a();
        if (t.mo924l()) {
            Class j = a.mo1010j(annotated);
            if (j != null) {
                if (t instanceof MapType) {
                    try {
                        t = ((MapType) t).i(j);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Failed to narrow key type " + t + " with key-type annotation (" + j.getName() + "): " + e.getMessage());
                    }
                }
                throw new IllegalArgumentException("Illegal key-type annotation: type " + t + " is not a Map type");
            }
            Class k = a.mo1013k(annotated);
            if (k != null) {
                try {
                    t = t.mo923f(k);
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("Failed to narrow content type " + t + " with content-type annotation (" + k.getName() + "): " + e2.getMessage());
                }
            }
        }
        return t;
    }

    private static JsonSerializer<Object> m7572c(SerializerProvider serializerProvider, Annotated annotated) {
        Object g = serializerProvider.m7322e().mo1002g(annotated);
        if (g != null) {
            return serializerProvider.mo1069b(annotated, g);
        }
        return null;
    }

    private static JsonSerializer<Object> m7573d(SerializerProvider serializerProvider, Annotated annotated) {
        Object h = serializerProvider.m7322e().mo1005h(annotated);
        if (h != null) {
            return serializerProvider.mo1069b(annotated, h);
        }
        return null;
    }

    protected static boolean m7565a(SerializationConfig serializationConfig, BeanDescription beanDescription, TypeSerializer typeSerializer) {
        if (typeSerializer != null) {
            return false;
        }
        Typing l = serializationConfig.mo1061a().mo1014l(beanDescription.mo949c());
        if (l == null) {
            return serializationConfig.m7257a(MapperFeature.USE_STATIC_TYPING);
        }
        if (l == Typing.STATIC) {
            return true;
        }
        return false;
    }
}
