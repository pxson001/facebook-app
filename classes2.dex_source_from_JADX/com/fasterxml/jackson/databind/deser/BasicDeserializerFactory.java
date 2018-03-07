package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JacksonDeserializers;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: static-0.facebook.com */
public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    static final HashMap<String, Class<? extends Map>> f4149a;
    static final HashMap<String, Class<? extends Collection>> f4150b;
    private static final Class<?> f4151c = Object.class;
    private static final Class<?> f4152e = String.class;
    private static final Class<?> f4153f = CharSequence.class;
    private static final Class<?> f4154g = Iterable.class;
    protected final DeserializerFactoryConfig _factoryConfig;

    protected abstract DeserializerFactory mo1081a(DeserializerFactoryConfig deserializerFactoryConfig);

    static {
        HashMap hashMap = new HashMap();
        f4149a = hashMap;
        hashMap.put(Map.class.getName(), LinkedHashMap.class);
        f4149a.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        f4149a.put(SortedMap.class.getName(), TreeMap.class);
        f4149a.put("java.util.NavigableMap", TreeMap.class);
        try {
            f4149a.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
        } catch (Throwable th) {
            System.err.println("Problems with (optional) types: " + th);
        }
        hashMap = new HashMap();
        f4150b = hashMap;
        hashMap.put(Collection.class.getName(), ArrayList.class);
        f4150b.put(List.class.getName(), ArrayList.class);
        f4150b.put(Set.class.getName(), HashSet.class);
        f4150b.put(SortedSet.class.getName(), TreeSet.class);
        f4150b.put(Queue.class.getName(), LinkedList.class);
        f4150b.put("java.util.Deque", LinkedList.class);
        f4150b.put("java.util.NavigableSet", TreeSet.class);
    }

    protected BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    public final DeserializerFactory mo1092a(Deserializers deserializers) {
        return mo1081a(this._factoryConfig.m7495a(deserializers));
    }

    private KeyDeserializer m7454b(DeserializationContext deserializationContext, JavaType javaType) {
        DeserializationConfig deserializationConfig = deserializationContext._config;
        BeanDescription b = deserializationConfig.m7281b(javaType);
        JsonDeserializer a = m7437a(deserializationContext, b.mo949c());
        if (a != null) {
            return StdKeyDeserializers.m7520a(javaType, a);
        }
        Class cls = javaType._class;
        if (m7443a(cls, deserializationConfig, b) != null) {
            return StdKeyDeserializers.m7520a(javaType, a);
        }
        EnumResolver a2 = m7449a(cls, deserializationConfig, b.mo962p());
        for (AnnotatedMethod annotatedMethod : b.mo958l()) {
            if (deserializationConfig.mo1061a().mo1025w(annotatedMethod)) {
                if (annotatedMethod.l() != 1 || !annotatedMethod.o().isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsuitable method (" + annotatedMethod + ") decorated with @JsonCreator (for Enum type " + cls.getName() + ")");
                } else if (annotatedMethod.b(0) != String.class) {
                    throw new IllegalArgumentException("Parameter #0 type for factory method (" + annotatedMethod + ") not suitable, must be java.lang.String");
                } else {
                    if (deserializationConfig.m7263h()) {
                        ClassUtil.a(annotatedMethod.a);
                    }
                    return StdKeyDeserializers.m7522a(a2, annotatedMethod);
                }
            }
        }
        return StdKeyDeserializers.m7521a(a2);
    }

    public final JsonDeserializer<?> mo1085a(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        JsonDeserializer<?> a;
        DeserializationConfig deserializationConfig = deserializationContext._config;
        Class cls = javaType._class;
        JsonDeserializer<?> a2 = m7443a(cls, deserializationConfig, beanDescription);
        if (a2 == null) {
            for (AnnotatedMethod annotatedMethod : beanDescription.mo958l()) {
                if (deserializationContext.m7407f().mo1025w(annotatedMethod)) {
                    if (annotatedMethod.l() == 1 && annotatedMethod.o().isAssignableFrom(cls)) {
                        a = EnumDeserializer.a(deserializationConfig, cls, annotatedMethod);
                        if (a == null) {
                            a = new EnumDeserializer(m7449a(cls, deserializationConfig, beanDescription.mo962p()));
                        }
                    } else {
                        throw new IllegalArgumentException("Unsuitable method (" + annotatedMethod + ") decorated with @JsonCreator (for Enum type " + cls.getName() + ")");
                    }
                }
            }
            a = a2;
            if (a == null) {
                a = new EnumDeserializer(m7449a(cls, deserializationConfig, beanDescription.mo962p()));
            }
        } else {
            a = a2;
        }
        if (this._factoryConfig.m7497b()) {
            Iterator it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                a = a;
            }
        }
        return a;
    }

    public final JsonDeserializer<?> mo1086a(DeserializationContext deserializationContext, ArrayType arrayType, BeanDescription beanDescription) {
        TypeDeserializer b;
        DeserializationConfig deserializationConfig = deserializationContext._config;
        JavaType r = arrayType.m6728r();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) r.mo929t();
        TypeDeserializer typeDeserializer = (TypeDeserializer) r.mo930u();
        if (typeDeserializer == null) {
            b = mo1093b(deserializationConfig, r);
        } else {
            b = typeDeserializer;
        }
        JsonDeserializer<?> a = m7438a(arrayType, deserializationConfig, beanDescription, b, jsonDeserializer);
        if (a == null) {
            if (jsonDeserializer == null) {
                Class cls = r._class;
                if (r.m6720j()) {
                    return PrimitiveArrayDeserializers.a(cls);
                }
                if (cls == String.class) {
                    return StringArrayDeserializer.a;
                }
            }
            if (a == null) {
                a = new ObjectArrayDeserializer(arrayType, jsonDeserializer, b);
            }
        }
        if (!this._factoryConfig.m7497b()) {
            return a;
        }
        Iterator it = this._factoryConfig.m7502g().iterator();
        while (it.hasNext()) {
            it.next();
            a = a;
        }
        return a;
    }

    public final KeyDeserializer mo1091a(DeserializationContext deserializationContext, JavaType javaType) {
        DeserializationConfig deserializationConfig = deserializationContext._config;
        KeyDeserializer keyDeserializer = null;
        if (this._factoryConfig.m7496a()) {
            deserializationConfig.m7260c(javaType._class);
            for (KeyDeserializers a : this._factoryConfig.m7501f()) {
                keyDeserializer = a.mo1094a(javaType);
                if (keyDeserializer != null) {
                    break;
                }
            }
        }
        if (keyDeserializer == null) {
            if (javaType.m6718h()) {
                return m7454b(deserializationContext, javaType);
            }
            keyDeserializer = StdKeyDeserializers.m7519a(deserializationConfig, javaType);
        }
        if (keyDeserializer == null || !this._factoryConfig.m7497b()) {
            return keyDeserializer;
        }
        Iterator it = this._factoryConfig.m7502g().iterator();
        while (it.hasNext()) {
            it.next();
            keyDeserializer = keyDeserializer;
        }
        return keyDeserializer;
    }

    public final ValueInstantiator m7471a(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        DeserializationConfig deserializationConfig = deserializationContext._config;
        ValueInstantiator valueInstantiator = null;
        Annotated c = beanDescription.mo949c();
        Object i = deserializationContext.m7407f().mo1008i((AnnotatedClass) c);
        if (i != null) {
            valueInstantiator = m7446a(deserializationConfig, c, i);
        }
        if (valueInstantiator == null) {
            valueInstantiator = m7445a(deserializationConfig, beanDescription);
            if (valueInstantiator == null) {
                valueInstantiator = m7455b(deserializationContext, beanDescription);
            }
        }
        if (this._factoryConfig.m7499d()) {
            for (ValueInstantiators valueInstantiators : this._factoryConfig.m7504i()) {
                ValueInstantiator a = valueInstantiators.m7517a();
                if (a == null) {
                    throw new JsonMappingException("Broken registered ValueInstantiators (of type " + valueInstantiators.getClass().getName() + "): returned null ValueInstantiator");
                }
                valueInstantiator = a;
            }
        }
        if (valueInstantiator.o() == null) {
            return valueInstantiator;
        }
        AnnotatedParameter o = valueInstantiator.o();
        throw new IllegalArgumentException("Argument #" + o._index + " of constructor " + o._owner + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
    }

    public final JavaType mo1083a(DeserializationConfig deserializationConfig, JavaType javaType) {
        JavaType c;
        while (true) {
            c = m7458c(deserializationConfig, javaType);
            if (c == null) {
                return javaType;
            }
            Class cls = javaType._class;
            Class cls2 = c._class;
            if (cls != cls2 && cls.isAssignableFrom(cls2)) {
                javaType = c;
            }
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + c + ": latter is not a subtype of former");
    }

    private static CollectionType m7448a(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class cls = (Class) f4150b.get(javaType._class.getName());
        if (cls == null) {
            return null;
        }
        return (CollectionType) deserializationConfig.m7255a(javaType, cls);
    }

    private JavaType m7458c(DeserializationConfig deserializationConfig, JavaType javaType) {
        Class cls = javaType._class;
        if (this._factoryConfig.m7498c()) {
            Iterator it = this._factoryConfig.m7503h().iterator();
            while (it.hasNext()) {
                it.next();
                JavaType javaType2 = null;
                if (javaType2 != null && javaType2._class != cls) {
                    return javaType2;
                }
            }
        }
        return null;
    }

    public final JsonDeserializer<?> mo1084a(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Class cls = javaType._class;
        JsonDeserializer<?> b = m7453b(cls, deserializationConfig, beanDescription);
        return b != null ? b : JsonNodeDeserializer.m13332a(cls);
    }

    public final JsonDeserializer<?> m7472b(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        Class cls = javaType._class;
        String name = cls.getName();
        if (cls.isPrimitive() || name.startsWith("java.")) {
            if (cls == f4151c) {
                return UntypedObjectDeserializer.f8649a;
            }
            if (cls == f4152e || cls == f4153f) {
                return StringDeserializer.f8636a;
            }
            if (cls == f4154g) {
                return mo1088a(deserializationContext, CollectionType.a(Collection.class, javaType.mo925s() > 0 ? javaType.mo913a(0) : TypeFactory.m7101c()), beanDescription);
            }
            JsonDeserializer<?> a = NumberDeserializers.m13400a(cls, name);
            if (a != null) {
                return a;
            }
            a = DateDeserializers.a(cls, name);
            if (a == null) {
                return JdkDeserializers.a(cls, name);
            }
            return a;
        } else if (name.startsWith("com.fasterxml.")) {
            return JacksonDeserializers.a(cls);
        } else {
            return null;
        }
    }

    private static ValueInstantiator m7445a(DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        return JacksonDeserializers.a(beanDescription);
    }

    private ValueInstantiator m7455b(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        CreatorCollector creatorCollector = new CreatorCollector(beanDescription, deserializationContext.m7337b());
        AnnotationIntrospector f = deserializationContext.m7407f();
        MapperConfig mapperConfig = deserializationContext._config;
        VisibilityChecker a = f.mo973a(beanDescription.mo949c(), mapperConfig.mo1063c());
        m7457b(deserializationContext, beanDescription, a, f, creatorCollector);
        if (beanDescription.f4041a.m6713e()) {
            m7450a(deserializationContext, beanDescription, a, f, creatorCollector);
        }
        return creatorCollector.a(mapperConfig);
    }

    private static ValueInstantiator m7446a(DeserializationConfig deserializationConfig, Annotated annotated, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof ValueInstantiator) {
            return (ValueInstantiator) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == NoClass.class) {
                return null;
            }
            if (ValueInstantiator.class.isAssignableFrom(cls)) {
                if (deserializationConfig.m7267l() != null) {
                    Object obj2 = null;
                    if (obj2 != null) {
                        return obj2;
                    }
                }
                return (ValueInstantiator) ClassUtil.b(cls, deserializationConfig.m7263h());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
    }

    private void m7450a(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector) {
        AnnotatedConstructor m = beanDescription.mo959m();
        if (m != null && (!creatorCollector.a() || annotationIntrospector.mo1025w(m))) {
            creatorCollector.a(m);
        }
        String[] strArr = null;
        AnnotatedConstructor annotatedConstructor = null;
        for (BeanPropertyDefinition beanPropertyDefinition : beanDescription.mo954h()) {
            if (beanPropertyDefinition.l() != null) {
                AnnotatedParameter l = beanPropertyDefinition.l();
                AnnotatedWithParams g = l.g();
                if (g instanceof AnnotatedConstructor) {
                    AnnotatedConstructor annotatedConstructor2;
                    String[] strArr2;
                    if (annotatedConstructor == null) {
                        annotatedConstructor2 = (AnnotatedConstructor) g;
                        strArr2 = new String[annotatedConstructor2.g()];
                    } else {
                        annotatedConstructor2 = annotatedConstructor;
                        strArr2 = strArr;
                    }
                    strArr2[l.h()] = beanPropertyDefinition.a();
                    annotatedConstructor = annotatedConstructor2;
                    strArr = strArr2;
                }
            }
        }
        for (AnnotatedMember annotatedMember : beanDescription.mo957k()) {
            int g2 = annotatedMember.g();
            boolean z = annotationIntrospector.mo1025w(annotatedMember) || annotatedMember == annotatedConstructor;
            boolean a = visibilityChecker.mo1030a(annotatedMember);
            if (g2 == 1) {
                m7451a(deserializationContext, beanDescription, annotationIntrospector, creatorCollector, annotatedMember, z, a, annotatedMember == annotatedConstructor ? strArr[0] : null);
            } else if (z || a) {
                AnnotatedParameter annotatedParameter = null;
                int i = 0;
                int i2 = 0;
                CreatorProperty[] creatorPropertyArr = new CreatorProperty[g2];
                int i3 = 0;
                while (i3 < g2) {
                    AnnotatedParameter c = annotatedMember.c(i3);
                    String str = null;
                    if (annotatedMember == annotatedConstructor) {
                        str = strArr[i3];
                    }
                    if (str == null) {
                        PropertyName v = c == null ? null : annotationIntrospector.mo1024v(c);
                        str = v == null ? null : v.a();
                    }
                    Object d = annotationIntrospector.mo991d((AnnotatedMember) c);
                    if (str != null && str.length() > 0) {
                        i++;
                        creatorPropertyArr[i3] = m7444a(deserializationContext, beanDescription, str, i3, c, d);
                        c = annotatedParameter;
                    } else if (d != null) {
                        i2++;
                        creatorPropertyArr[i3] = m7444a(deserializationContext, beanDescription, str, i3, c, d);
                        c = annotatedParameter;
                    } else if (annotatedParameter != null) {
                        c = annotatedParameter;
                    }
                    i3++;
                    annotatedParameter = c;
                }
                if (z || i > 0 || i2 > 0) {
                    if (i + i2 == g2) {
                        creatorCollector.b(annotatedMember, creatorPropertyArr);
                    } else if (i == 0 && i2 + 1 == g2) {
                        creatorCollector.a(annotatedMember, creatorPropertyArr);
                    } else {
                        creatorCollector.a(annotatedParameter);
                    }
                }
            }
        }
    }

    private boolean m7451a(DeserializationContext deserializationContext, BeanDescription beanDescription, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedConstructor annotatedConstructor, boolean z, boolean z2, String str) {
        String a;
        AnnotatedParameter c = annotatedConstructor.c(0);
        if (str == null) {
            PropertyName v = c == null ? null : annotationIntrospector.mo1024v(c);
            a = v == null ? null : v.a();
        } else {
            a = str;
        }
        if (annotationIntrospector.mo991d((AnnotatedMember) c) != null || (a != null && a.length() > 0)) {
            creatorCollector.b(annotatedConstructor, new CreatorProperty[]{m7444a(deserializationContext, beanDescription, a, 0, c, r6)});
            return true;
        }
        Class a2 = annotatedConstructor.a(0);
        if (a2 == String.class) {
            if (z || z2) {
                creatorCollector.b(annotatedConstructor);
            }
            return true;
        } else if (a2 == Integer.TYPE || a2 == Integer.class) {
            if (z || z2) {
                creatorCollector.c(annotatedConstructor);
            }
            return true;
        } else if (a2 == Long.TYPE || a2 == Long.class) {
            if (z || z2) {
                creatorCollector.d(annotatedConstructor);
            }
            return true;
        } else if (a2 == Double.TYPE || a2 == Double.class) {
            if (z || z2) {
                creatorCollector.e(annotatedConstructor);
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            creatorCollector.a(annotatedConstructor, null);
            return true;
        }
    }

    private void m7457b(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector) {
        for (AnnotatedMethod annotatedMethod : beanDescription.mo958l()) {
            boolean w = annotationIntrospector.mo1025w(annotatedMethod);
            int l = annotatedMethod.l();
            if (l != 0) {
                PropertyName v;
                if (l == 1) {
                    AnnotatedMember c = annotatedMethod.c(0);
                    v = c == null ? null : annotationIntrospector.mo1024v(c);
                    String a = v == null ? null : v.a();
                    if (annotationIntrospector.mo991d(c) == null && (a == null || a.length() == 0)) {
                        m7452a((VisibilityChecker) visibilityChecker, annotationIntrospector, creatorCollector, annotatedMethod, w);
                    }
                } else if (!annotationIntrospector.mo1025w(annotatedMethod)) {
                    continue;
                }
                AnnotatedParameter annotatedParameter = null;
                CreatorProperty[] creatorPropertyArr = new CreatorProperty[l];
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i3 < l) {
                    int i4;
                    int i5;
                    AnnotatedParameter c2 = annotatedMethod.c(i3);
                    v = c2 == null ? null : annotationIntrospector.mo1024v(c2);
                    String a2 = v == null ? null : v.a();
                    Object d = annotationIntrospector.mo991d((AnnotatedMember) c2);
                    if (a2 != null && a2.length() > 0) {
                        i++;
                        creatorPropertyArr[i3] = m7444a(deserializationContext, beanDescription, a2, i3, c2, d);
                        i4 = i2;
                        i5 = i;
                        c2 = annotatedParameter;
                    } else if (d != null) {
                        i2++;
                        creatorPropertyArr[i3] = m7444a(deserializationContext, beanDescription, a2, i3, c2, d);
                        i4 = i2;
                        i5 = i;
                        c2 = annotatedParameter;
                    } else if (annotatedParameter == null) {
                        i4 = i2;
                        i5 = i;
                    } else {
                        i4 = i2;
                        i5 = i;
                        c2 = annotatedParameter;
                    }
                    i3++;
                    i2 = i4;
                    i = i5;
                    annotatedParameter = c2;
                }
                if (w || i > 0 || i2 > 0) {
                    if (i + i2 == l) {
                        creatorCollector.b(annotatedMethod, creatorPropertyArr);
                    } else if (i == 0 && i2 + 1 == l) {
                        creatorCollector.a(annotatedMethod, creatorPropertyArr);
                    } else {
                        throw new IllegalArgumentException("Argument #" + annotatedParameter.h() + " of factory method " + annotatedMethod + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                    }
                }
            } else if (w) {
                creatorCollector.a(annotatedMethod);
            }
        }
    }

    private static boolean m7452a(VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedMethod annotatedMethod, boolean z) {
        Class a = annotatedMethod.a(0);
        if (a == String.class) {
            if (!z && !visibilityChecker.mo1030a((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.b(annotatedMethod);
            return true;
        } else if (a == Integer.TYPE || a == Integer.class) {
            if (!z && !visibilityChecker.mo1030a((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.c(annotatedMethod);
            return true;
        } else if (a == Long.TYPE || a == Long.class) {
            if (!z && !visibilityChecker.mo1030a((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.d(annotatedMethod);
            return true;
        } else if (a == Double.TYPE || a == Double.class) {
            if (!z && !visibilityChecker.mo1030a((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.e(annotatedMethod);
            return true;
        } else if (a == Boolean.TYPE || a == Boolean.class) {
            if (!z && !visibilityChecker.mo1030a((AnnotatedMember) annotatedMethod)) {
                return true;
            }
            creatorCollector.f(annotatedMethod);
            return true;
        } else if (!annotationIntrospector.mo1025w(annotatedMethod)) {
            return false;
        } else {
            creatorCollector.a(annotatedMethod, null);
            return true;
        }
    }

    private CreatorProperty m7444a(DeserializationContext deserializationContext, BeanDescription beanDescription, String str, int i, AnnotatedParameter annotatedParameter, Object obj) {
        Std a;
        TypeDeserializer b;
        MapperConfig d = deserializationContext.m7405d();
        AnnotationIntrospector f = deserializationContext.m7407f();
        Boolean e = f == null ? null : f.mo995e((AnnotatedMember) annotatedParameter);
        boolean booleanValue = e == null ? false : e.booleanValue();
        JavaType a2 = d.m7269n().m7110a(annotatedParameter.f(), beanDescription.mo952f());
        Std std = new Std(str, a2, AnnotationIntrospector.m6934b(), beanDescription.mo953g(), annotatedParameter, booleanValue);
        JavaType a3 = m7460a(deserializationContext, a2, (AnnotatedMember) annotatedParameter);
        if (a3 != a2) {
            a = std.a(a3);
        } else {
            a = std;
        }
        JsonDeserializer a4 = m7437a(deserializationContext, (Annotated) annotatedParameter);
        a2 = m7436a(deserializationContext, (Annotated) annotatedParameter, a3);
        TypeDeserializer typeDeserializer = (TypeDeserializer) a2.mo930u();
        if (typeDeserializer == null) {
            b = mo1093b(d, a2);
        } else {
            b = typeDeserializer;
        }
        CreatorProperty creatorProperty = new CreatorProperty(str, a2, a.c(), b, beanDescription.mo953g(), annotatedParameter, i, obj, a.d());
        if (a4 != null) {
            return creatorProperty.a(a4);
        }
        return creatorProperty;
    }

    private JsonDeserializer<?> m7438a(ArrayType arrayType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers a : this._factoryConfig.m7500e()) {
            JsonDeserializer<?> a2 = a.mo1148a();
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public final JsonDeserializer<?> mo1088a(DeserializationContext deserializationContext, CollectionType collectionType, BeanDescription beanDescription) {
        TypeDeserializer b;
        JavaType r = collectionType.m6728r();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) r.mo929t();
        DeserializationConfig d = deserializationContext.m7405d();
        TypeDeserializer typeDeserializer = (TypeDeserializer) r.mo930u();
        if (typeDeserializer == null) {
            b = mo1093b(d, r);
        } else {
            b = typeDeserializer;
        }
        JsonDeserializer<?> a = m7440a(collectionType, d, beanDescription, b, jsonDeserializer);
        if (a == null) {
            Class c = collectionType.m6708c();
            if (jsonDeserializer == null && EnumSet.class.isAssignableFrom(c)) {
                a = new EnumSetDeserializer(r, null);
            }
        }
        if (a == null) {
            JavaType a2;
            if (collectionType.m6719i() || collectionType.m6711d()) {
                a2 = m7448a((JavaType) collectionType, d);
                if (a2 == null) {
                    throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + collectionType);
                }
                beanDescription = d.m7284c(a2);
            } else {
                a2 = collectionType;
            }
            ValueInstantiator a3 = m7471a(deserializationContext, beanDescription);
            if (!a3.h() && a2.m6708c() == ArrayBlockingQueue.class) {
                return new ArrayBlockingQueueDeserializer(a2, jsonDeserializer, b, a3, null);
            }
            if (r.m6708c() == String.class) {
                a = new StringCollectionDeserializer(a2, jsonDeserializer, a3);
            } else {
                a = new CollectionDeserializer(a2, jsonDeserializer, b, a3);
            }
        }
        if (this._factoryConfig.m7497b()) {
            Iterator it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                a = a;
            }
        }
        return a;
    }

    private JsonDeserializer<?> m7440a(CollectionType collectionType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers a : this._factoryConfig.m7500e()) {
            JsonDeserializer<?> a2 = a.mo1145a(collectionType, typeDeserializer, (JsonDeserializer) jsonDeserializer);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public final JsonDeserializer<?> mo1087a(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, BeanDescription beanDescription) {
        TypeDeserializer b;
        JavaType r = collectionLikeType.m6728r();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) r.mo929t();
        DeserializationConfig deserializationConfig = deserializationContext._config;
        TypeDeserializer typeDeserializer = (TypeDeserializer) r.mo930u();
        if (typeDeserializer == null) {
            b = mo1093b(deserializationConfig, r);
        } else {
            b = typeDeserializer;
        }
        JsonDeserializer<?> a = m7439a(collectionLikeType, deserializationConfig, beanDescription, b, jsonDeserializer);
        if (a != null && this._factoryConfig.m7497b()) {
            Iterator it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                a = a;
            }
        }
        return a;
    }

    private JsonDeserializer<?> m7439a(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers b : this._factoryConfig.m7500e()) {
            JsonDeserializer<?> b2 = b.mo1149b();
            if (b2 != null) {
                return b2;
            }
        }
        return null;
    }

    public final JsonDeserializer<?> mo1090a(DeserializationContext deserializationContext, MapType mapType, BeanDescription beanDescription) {
        TypeDeserializer b;
        DeserializationConfig d = deserializationContext.m7405d();
        JavaType q = mapType.m6727q();
        JavaType r = mapType.m6728r();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) r.mo929t();
        KeyDeserializer keyDeserializer = (KeyDeserializer) q.mo929t();
        TypeDeserializer typeDeserializer = (TypeDeserializer) r.mo930u();
        if (typeDeserializer == null) {
            b = mo1093b(d, r);
        } else {
            b = typeDeserializer;
        }
        JsonDeserializer<?> a = m7442a(mapType, d, beanDescription, keyDeserializer, b, jsonDeserializer);
        if (a == null) {
            Class c = mapType.m6708c();
            if (EnumMap.class.isAssignableFrom(c)) {
                Class c2 = q.m6708c();
                if (c2 == null || !c2.isEnum()) {
                    throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
                }
                a = new EnumMapDeserializer(mapType, null, jsonDeserializer, b);
            }
            if (a == null) {
                if (mapType.m6719i() || mapType.m6711d()) {
                    c = (Class) f4149a.get(c.getName());
                    if (c == null) {
                        throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + mapType);
                    }
                    JavaType javaType = (MapType) d.m7255a((JavaType) mapType, c);
                    beanDescription = d.m7284c(javaType);
                    q = javaType;
                } else {
                    q = mapType;
                }
                a = new MapDeserializer(q, m7471a(deserializationContext, beanDescription), keyDeserializer, jsonDeserializer, b);
                a.a(d.mo1061a().mo985b(beanDescription.mo949c()));
            }
        }
        if (this._factoryConfig.m7497b()) {
            Iterator it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                a = BeanDeserializerModifier.m7512e(a);
            }
        }
        return a;
    }

    public final JsonDeserializer<?> mo1089a(DeserializationContext deserializationContext, MapLikeType mapLikeType, BeanDescription beanDescription) {
        TypeDeserializer b;
        JavaType q = mapLikeType.m6727q();
        JavaType r = mapLikeType.m6728r();
        DeserializationConfig deserializationConfig = deserializationContext._config;
        JsonDeserializer jsonDeserializer = (JsonDeserializer) r.mo929t();
        KeyDeserializer keyDeserializer = (KeyDeserializer) q.mo929t();
        TypeDeserializer typeDeserializer = (TypeDeserializer) r.mo930u();
        if (typeDeserializer == null) {
            b = mo1093b(deserializationConfig, r);
        } else {
            b = typeDeserializer;
        }
        JsonDeserializer<?> a = m7441a(mapLikeType, deserializationConfig, beanDescription, keyDeserializer, b, jsonDeserializer);
        if (a != null && this._factoryConfig.m7497b()) {
            Iterator it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                a = a;
            }
        }
        return a;
    }

    private JsonDeserializer<?> m7442a(MapType mapType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers a : this._factoryConfig.m7500e()) {
            JsonDeserializer<?> a2 = a.mo1147a(mapType, keyDeserializer, typeDeserializer, (JsonDeserializer) jsonDeserializer);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private JsonDeserializer<?> m7441a(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        for (Deserializers a : this._factoryConfig.m7500e()) {
            JsonDeserializer<?> a2 = a.mo1146a(mapLikeType, keyDeserializer, typeDeserializer, (JsonDeserializer) jsonDeserializer);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private JsonDeserializer<?> m7443a(Class<?> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        for (Deserializers c : this._factoryConfig.m7500e()) {
            JsonDeserializer<?> c2 = c.mo1150c();
            if (c2 != null) {
                return c2;
            }
        }
        return null;
    }

    private JsonDeserializer<?> m7453b(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        for (Deserializers d : this._factoryConfig.m7500e()) {
            JsonDeserializer<?> d2 = d.mo1151d();
            if (d2 != null) {
                return d2;
            }
        }
        return null;
    }

    public final TypeDeserializer mo1093b(DeserializationConfig deserializationConfig, JavaType javaType) {
        Collection collection = null;
        AnnotatedClass c = deserializationConfig.m7260c(javaType._class).mo949c();
        AnnotationIntrospector a = deserializationConfig.mo1061a();
        TypeResolverBuilder a2 = a.mo974a((MapperConfig) deserializationConfig, c, javaType);
        if (a2 == null) {
            a2 = deserializationConfig.m7268m();
            if (a2 == null) {
                return null;
            }
        }
        collection = deserializationConfig._subtypeResolver.mo1059a(c, deserializationConfig, a);
        if (a2.a() == null && javaType.m6711d()) {
            JavaType a3 = mo1083a(deserializationConfig, javaType);
            if (!(a3 == null || a3._class == javaType._class)) {
                a2 = a2.a(a3._class);
            }
        }
        return a2.a(deserializationConfig, javaType, collection);
    }

    private TypeDeserializer m7447a(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) {
        AnnotationIntrospector a = deserializationConfig.mo1061a();
        TypeResolverBuilder a2 = a.mo975a((MapperConfig) deserializationConfig, annotatedMember, javaType);
        if (a2 == null) {
            return mo1093b(deserializationConfig, javaType);
        }
        return a2.a(deserializationConfig, javaType, deserializationConfig._subtypeResolver.mo1060a(annotatedMember, deserializationConfig, a, javaType));
    }

    private TypeDeserializer m7456b(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) {
        AnnotationIntrospector a = deserializationConfig.mo1061a();
        TypeResolverBuilder b = a.mo980b(deserializationConfig, annotatedMember, javaType);
        JavaType r = javaType.m6728r();
        if (b == null) {
            return mo1093b(deserializationConfig, r);
        }
        return b.a(deserializationConfig, r, deserializationConfig._subtypeResolver.mo1060a(annotatedMember, deserializationConfig, a, r));
    }

    protected static JsonDeserializer<Object> m7437a(DeserializationContext deserializationContext, Annotated annotated) {
        Object o = deserializationContext.m7407f().mo1017o(annotated);
        if (o == null) {
            return null;
        }
        return deserializationContext.mo1078b(annotated, o);
    }

    protected static <T extends JavaType> T m7436a(DeserializationContext deserializationContext, Annotated annotated, T t) {
        AnnotationIntrospector f = deserializationContext.m7407f();
        Class r = f.mo1020r(annotated);
        if (r != null) {
            try {
                T a = t.m6700a(r);
            } catch (Throwable e) {
                throw new JsonMappingException("Failed to narrow type " + t + " with concrete-type annotation (value " + r.getName() + "), method '" + annotated.mo938b() + "': " + e.getMessage(), null, e);
            }
        }
        a = t;
        if (!a.mo924l()) {
            return a;
        }
        T t2;
        Class s = f.mo1021s(annotated);
        if (s == null) {
            t2 = a;
        } else if (a instanceof MapLikeType) {
            try {
                t2 = ((MapLikeType) a).h(s);
            } catch (Throwable e2) {
                throw new JsonMappingException("Failed to narrow key type " + a + " with key-type annotation (" + s.getName() + "): " + e2.getMessage(), null, e2);
            }
        } else {
            throw new JsonMappingException("Illegal key-type annotation: type " + a + " is not a Map(-like) type");
        }
        JavaType q = t2.m6727q();
        if (q != null && q.mo929t() == null) {
            KeyDeserializer c = deserializationContext.mo1079c(annotated, f.mo1018p(annotated));
            if (c != null) {
                t2 = ((MapLikeType) t2).i(c);
            }
        }
        Class t3 = f.mo1022t(annotated);
        if (t3 != null) {
            try {
                t2 = t2.mo921e(t3);
            } catch (Throwable e3) {
                throw new JsonMappingException("Failed to narrow content type " + t2 + " with content-type annotation (" + t3.getName() + "): " + e3.getMessage(), null, e3);
            }
        }
        if (t2.m6728r().mo929t() != null) {
            return t2;
        }
        Object b = deserializationContext.mo1078b(annotated, f.mo1019q(annotated));
        if (b != null) {
            return t2.mo920d(b);
        }
        return t2;
    }

    protected final JavaType m7460a(DeserializationContext deserializationContext, JavaType javaType, AnnotatedMember annotatedMember) {
        Object b;
        if (javaType.mo924l()) {
            AnnotationIntrospector f = deserializationContext.m7407f();
            if (javaType.m6727q() != null) {
                KeyDeserializer c = deserializationContext.mo1079c(annotatedMember, f.mo1018p(annotatedMember));
                if (c != null) {
                    javaType = ((MapLikeType) javaType).i(c);
                }
            }
            b = deserializationContext.mo1078b((Annotated) annotatedMember, f.mo1019q(annotatedMember));
            if (b != null) {
                javaType = javaType.mo920d(b);
            }
            if (annotatedMember instanceof AnnotatedMember) {
                b = m7456b(deserializationContext._config, javaType, annotatedMember);
                if (b != null) {
                    javaType = javaType.mo916b(b);
                }
            }
        }
        if (annotatedMember instanceof AnnotatedMember) {
            b = m7447a(deserializationContext._config, javaType, annotatedMember);
        } else {
            b = mo1093b(deserializationContext._config, javaType);
        }
        if (b != null) {
            return javaType.mo914a(b);
        }
        return javaType;
    }

    private static EnumResolver<?> m7449a(Class<?> cls, DeserializationConfig deserializationConfig, AnnotatedMethod annotatedMethod) {
        if (annotatedMethod != null) {
            Method method = annotatedMethod.a;
            if (deserializationConfig.m7263h()) {
                ClassUtil.a(method);
            }
            return EnumResolver.b(cls, method);
        } else if (deserializationConfig.m7286c(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) {
            return EnumResolver.b(cls);
        } else {
            return EnumResolver.b(cls, deserializationConfig.mo1061a());
        }
    }
}
