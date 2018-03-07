package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Empty;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
/* compiled from: flush_tag=? */
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    protected static final JavaType f11501a = TypeFactory.c();
    protected final BeanProperty f11502b;
    protected final HashSet<String> f11503c;
    protected final boolean f11504d;
    protected final JavaType f11505e;
    protected final JavaType f11506f;
    protected JsonSerializer<Object> f11507g;
    protected JsonSerializer<Object> f11508h;
    protected final TypeSerializer f11509i;
    protected PropertySerializerMap f11510j;

    public final void m11999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Map map = (Map) obj;
        jsonGenerator.f();
        if (!map.isEmpty()) {
            if (serializerProvider.a(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = m11996c(map);
            }
            if (this.f11508h != null) {
                m11995a(map, jsonGenerator, serializerProvider, this.f11508h);
            } else {
                m12001a(map, jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.g();
    }

    public final void m12000a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        obj = (Map) obj;
        typeSerializer.b(obj, jsonGenerator);
        if (!obj.isEmpty()) {
            Map c;
            if (serializerProvider.a(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                c = m11996c(obj);
            }
            if (this.f11508h != null) {
                m11995a(c, jsonGenerator, serializerProvider, this.f11508h);
            } else {
                m12001a(c, jsonGenerator, serializerProvider);
            }
        }
        typeSerializer.e(obj, jsonGenerator);
    }

    public final boolean m12002a(Object obj) {
        Map map = (Map) obj;
        return map == null || map.isEmpty();
    }

    public final boolean mo854b(Object obj) {
        return ((Map) obj).size() == 1;
    }

    private MapSerializer(HashSet<String> hashSet, JavaType javaType, JavaType javaType2, boolean z, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        this.f11503c = hashSet;
        this.f11505e = javaType;
        this.f11506f = javaType2;
        this.f11504d = z;
        this.f11509i = typeSerializer;
        this.f11507g = jsonSerializer;
        this.f11508h = jsonSerializer2;
        this.f11510j = Empty.f359a;
        this.f11502b = null;
    }

    private MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, HashSet<String> hashSet) {
        super(Map.class, false);
        this.f11503c = hashSet;
        this.f11505e = mapSerializer.f11505e;
        this.f11506f = mapSerializer.f11506f;
        this.f11504d = mapSerializer.f11504d;
        this.f11509i = mapSerializer.f11509i;
        this.f11507g = jsonSerializer;
        this.f11508h = jsonSerializer2;
        this.f11510j = mapSerializer.f11510j;
        this.f11502b = beanProperty;
    }

    private MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer) {
        super(Map.class, false);
        this.f11503c = mapSerializer.f11503c;
        this.f11505e = mapSerializer.f11505e;
        this.f11506f = mapSerializer.f11506f;
        this.f11504d = mapSerializer.f11504d;
        this.f11509i = typeSerializer;
        this.f11507g = mapSerializer.f11507g;
        this.f11508h = mapSerializer.f11508h;
        this.f11510j = mapSerializer.f11510j;
        this.f11502b = mapSerializer.f11502b;
    }

    public final ContainerSerializer mo853b(TypeSerializer typeSerializer) {
        return new MapSerializer(this, typeSerializer);
    }

    private MapSerializer m11992a(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, HashSet<String> hashSet) {
        return new MapSerializer(this, beanProperty, jsonSerializer, jsonSerializer2, hashSet);
    }

    public static MapSerializer m11993a(String[] strArr, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2) {
        JavaType javaType2;
        JavaType javaType3;
        boolean z2;
        boolean z3 = false;
        HashSet a = m11994a(strArr);
        if (javaType == null) {
            javaType2 = f11501a;
            javaType3 = javaType2;
        } else {
            javaType2 = javaType.q();
            javaType3 = javaType.r();
        }
        if (z) {
            z2 = javaType3._class == Object.class ? false : z;
        } else {
            if (javaType3 != null && javaType3.k()) {
                z3 = true;
            }
            z2 = z3;
        }
        return new MapSerializer(a, javaType2, javaType3, z2, typeSerializer, jsonSerializer, jsonSerializer2);
    }

    private static HashSet<String> m11994a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet(strArr.length);
        for (Object add : strArr) {
            hashSet.add(add);
        }
        return hashSet;
    }

    public final JsonSerializer<?> m11998a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer b;
        JsonSerializer a;
        Collection collection;
        AnnotationIntrospector e;
        String[] b2;
        HashSet hashSet;
        JsonSerializer jsonSerializer = null;
        if (beanProperty != null) {
            AnnotatedMember b3 = beanProperty.mo46b();
            if (b3 != null) {
                AnnotationIntrospector e2 = serializerProvider.e();
                Object g = e2.g(b3);
                if (g != null) {
                    b = serializerProvider.b(b3, g);
                } else {
                    b = null;
                }
                Object h = e2.h(b3);
                JsonSerializer jsonSerializer2;
                if (h != null) {
                    jsonSerializer2 = b;
                    b = serializerProvider.b(b3, h);
                    jsonSerializer = jsonSerializer2;
                } else {
                    jsonSerializer2 = b;
                    b = null;
                    jsonSerializer = jsonSerializer2;
                }
                if (b == null) {
                    b = this.f11508h;
                }
                b = StdSerializer.a(serializerProvider, beanProperty, b);
                if (b != null) {
                    if ((this.f11504d && this.f11506f._class != Object.class) || ContainerSerializer.a_(serializerProvider, beanProperty)) {
                        a = serializerProvider.a(this.f11506f, beanProperty);
                    }
                    a = b;
                } else {
                    if (b instanceof ContextualSerializer) {
                        a = ((ContextualSerializer) b).a(serializerProvider, beanProperty);
                    }
                    a = b;
                }
                if (jsonSerializer != null) {
                    b = this.f11507g;
                } else {
                    b = jsonSerializer;
                }
                if (b == null) {
                    b = serializerProvider.b(this.f11505e, beanProperty);
                } else if (b instanceof ContextualSerializer) {
                    b = ((ContextualSerializer) b).a(serializerProvider, beanProperty);
                }
                collection = this.f11503c;
                e = serializerProvider.e();
                if (!(e == null || beanProperty == null)) {
                    b2 = e.b(beanProperty.mo46b());
                    if (b2 != null) {
                        hashSet = collection != null ? new HashSet() : new HashSet(collection);
                        for (Object add : b2) {
                            hashSet.add(add);
                        }
                        return m11992a(beanProperty, b, a, hashSet);
                    }
                }
                hashSet = collection;
                return m11992a(beanProperty, b, a, hashSet);
            }
        }
        b = null;
        if (b == null) {
            b = this.f11508h;
        }
        b = StdSerializer.a(serializerProvider, beanProperty, b);
        if (b != null) {
            if (b instanceof ContextualSerializer) {
                a = ((ContextualSerializer) b).a(serializerProvider, beanProperty);
            }
            a = b;
        } else {
            a = serializerProvider.a(this.f11506f, beanProperty);
        }
        if (jsonSerializer != null) {
            b = jsonSerializer;
        } else {
            b = this.f11507g;
        }
        if (b == null) {
            b = serializerProvider.b(this.f11505e, beanProperty);
        } else if (b instanceof ContextualSerializer) {
            b = ((ContextualSerializer) b).a(serializerProvider, beanProperty);
        }
        collection = this.f11503c;
        e = serializerProvider.e();
        b2 = e.b(beanProperty.mo46b());
        if (b2 != null) {
            if (collection != null) {
            }
            while (r2 < r5) {
                hashSet.add(add);
            }
            return m11992a(beanProperty, b, a, hashSet);
        }
        hashSet = collection;
        return m11992a(beanProperty, b, a, hashSet);
    }

    public final void m12001a(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f11509i != null) {
            m11997c(map, jsonGenerator, serializerProvider);
            return;
        }
        Object obj;
        JsonSerializer jsonSerializer = this.f11507g;
        HashSet hashSet = this.f11503c;
        if (serializerProvider.a(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
            obj = null;
        } else {
            obj = 1;
        }
        PropertySerializerMap propertySerializerMap = this.f11510j;
        PropertySerializerMap propertySerializerMap2 = propertySerializerMap;
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.k().a(null, jsonGenerator, serializerProvider);
            } else if ((obj == null || value != null) && (hashSet == null || !hashSet.contains(key))) {
                jsonSerializer.a(key, jsonGenerator, serializerProvider);
            }
            if (value == null) {
                serializerProvider.a(jsonGenerator);
            } else {
                JsonSerializer jsonSerializer2;
                Class cls = value.getClass();
                JsonSerializer a = propertySerializerMap2.mo48a(cls);
                JsonSerializer jsonSerializer3;
                if (a == null) {
                    if (this.f11506f.p()) {
                        a = m11990a(propertySerializerMap2, serializerProvider.a(this.f11506f, cls), serializerProvider);
                    } else {
                        a = m11991a(propertySerializerMap2, cls, serializerProvider);
                    }
                    jsonSerializer3 = a;
                    propertySerializerMap = this.f11510j;
                    jsonSerializer2 = jsonSerializer3;
                } else {
                    jsonSerializer3 = a;
                    propertySerializerMap = propertySerializerMap2;
                    jsonSerializer2 = jsonSerializer3;
                }
                try {
                    jsonSerializer2.a(value, jsonGenerator, serializerProvider);
                    propertySerializerMap2 = propertySerializerMap;
                } catch (Throwable e) {
                    StdSerializer.a(serializerProvider, e, map, key);
                    propertySerializerMap2 = propertySerializerMap;
                }
            }
        }
    }

    private void m11995a(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        JsonSerializer jsonSerializer2 = this.f11507g;
        HashSet hashSet = this.f11503c;
        TypeSerializer typeSerializer = this.f11509i;
        Object obj = !serializerProvider.a(SerializationFeature.WRITE_NULL_MAP_VALUES) ? 1 : null;
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.k().a(null, jsonGenerator, serializerProvider);
            } else if ((obj == null || value != null) && (hashSet == null || !hashSet.contains(key))) {
                jsonSerializer2.a(key, jsonGenerator, serializerProvider);
            }
            if (value == null) {
                serializerProvider.a(jsonGenerator);
            } else if (typeSerializer == null) {
                try {
                    jsonSerializer.a(value, jsonGenerator, serializerProvider);
                } catch (Throwable e) {
                    StdSerializer.a(serializerProvider, e, map, key);
                }
            } else {
                jsonSerializer.a(value, jsonGenerator, serializerProvider, typeSerializer);
            }
        }
    }

    private void m11997c(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Class cls;
        JsonSerializer jsonSerializer;
        JsonSerializer jsonSerializer2 = this.f11507g;
        HashSet hashSet = this.f11503c;
        Object obj = !serializerProvider.a(SerializationFeature.WRITE_NULL_MAP_VALUES) ? 1 : null;
        Object obj2 = null;
        JsonSerializer jsonSerializer3 = null;
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.k().a(null, jsonGenerator, serializerProvider);
            } else if ((obj == null || value != null) && (hashSet == null || !hashSet.contains(key))) {
                jsonSerializer2.a(key, jsonGenerator, serializerProvider);
            }
            if (value == null) {
                serializerProvider.a(jsonGenerator);
            } else {
                Class cls2 = value.getClass();
                if (cls2 == obj2) {
                    cls = obj2;
                    jsonSerializer = jsonSerializer3;
                } else {
                    JsonSerializer a;
                    if (this.f11506f.p()) {
                        a = serializerProvider.a(serializerProvider.a(this.f11506f, cls2), this.f11502b);
                    } else {
                        a = serializerProvider.a(cls2, this.f11502b);
                    }
                    jsonSerializer3 = a;
                    jsonSerializer = a;
                    cls = cls2;
                }
                try {
                    jsonSerializer3.a(value, jsonGenerator, serializerProvider, this.f11509i);
                    jsonSerializer3 = jsonSerializer;
                    obj2 = cls;
                } catch (Throwable e) {
                    StdSerializer.a(serializerProvider, e, map, key);
                    jsonSerializer3 = jsonSerializer;
                    obj2 = cls;
                }
            }
        }
    }

    private JsonSerializer<Object> m11991a(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
        SerializerAndMapResult a = propertySerializerMap.m603a((Class) cls, serializerProvider, this.f11502b);
        if (propertySerializerMap != a.f392b) {
            this.f11510j = a.f392b;
        }
        return a.f391a;
    }

    private JsonSerializer<Object> m11990a(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) {
        SerializerAndMapResult a = propertySerializerMap.m602a(javaType, serializerProvider, this.f11502b);
        if (propertySerializerMap != a.f392b) {
            this.f11510j = a.f392b;
        }
        return a.f391a;
    }

    private static Map<?, ?> m11996c(Map<?, ?> map) {
        return map instanceof SortedMap ? map : new TreeMap(map);
    }
}
