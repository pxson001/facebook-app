package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: storyRenderContext */
public final class TypeFactory implements Serializable {
    public static final TypeFactory f4051a = new TypeFactory();
    protected static final SimpleType f4052b = new SimpleType(String.class);
    protected static final SimpleType f4053c = new SimpleType(Boolean.TYPE);
    protected static final SimpleType f4054d = new SimpleType(Integer.TYPE);
    protected static final SimpleType f4055e = new SimpleType(Long.TYPE);
    private static final JavaType[] f4056h = new JavaType[0];
    private static final long serialVersionUID = 1;
    protected final TypeModifier[] _modifiers;
    protected final TypeParser _parser;
    protected final LRUMap<ClassKey, JavaType> _typeCache;
    protected transient HierarchicType f4057f;
    protected transient HierarchicType f4058g;

    public final JavaType m7105a(TypeReference<?> typeReference) {
        return m7115b(typeReference.a, null);
    }

    private HierarchicType m7092a(HierarchicType hierarchicType, Class<?> cls) {
        Class cls2 = hierarchicType.b;
        Type[] genericInterfaces = cls2.getGenericInterfaces();
        if (genericInterfaces != null) {
            for (Type b : genericInterfaces) {
                HierarchicType b2 = m7099b(b, (Class) cls);
                if (b2 != null) {
                    b2.e = hierarchicType;
                    hierarchicType.d = b2;
                    return hierarchicType;
                }
            }
        }
        Type genericSuperclass = cls2.getGenericSuperclass();
        if (genericSuperclass != null) {
            HierarchicType b3 = m7099b(genericSuperclass, (Class) cls);
            if (b3 != null) {
                b3.e = hierarchicType;
                hierarchicType.d = b3;
                return hierarchicType;
            }
        }
        return null;
    }

    private TypeFactory() {
        this._typeCache = new LRUMap(16, 100);
        this._parser = new TypeParser(this);
        this._modifiers = null;
    }

    private TypeFactory(TypeParser typeParser, TypeModifier[] typeModifierArr) {
        this._typeCache = new LRUMap(16, 100);
        this._parser = typeParser;
        this._modifiers = typeModifierArr;
    }

    public final TypeFactory m7113a(TypeModifier typeModifier) {
        if (this._modifiers != null) {
            return new TypeFactory(this._parser, (TypeModifier[]) ArrayBuilders.m7772a(this._modifiers, (Object) typeModifier));
        }
        return new TypeFactory(this._parser, new TypeModifier[]{typeModifier});
    }

    public static TypeFactory m7095a() {
        return f4051a;
    }

    public static JavaType m7097b() {
        return m7101c();
    }

    public final JavaType m7106a(JavaType javaType, Class<?> cls) {
        if (!(javaType instanceof SimpleType) || (!cls.isArray() && !Map.class.isAssignableFrom(cls) && !Collection.class.isAssignableFrom(cls))) {
            return javaType.m6700a((Class) cls);
        }
        if (javaType._class.isAssignableFrom(cls)) {
            TypeBindings typeBindings = new TypeBindings(this, javaType._class);
            JavaType b = m7114b((Class) cls);
            Object t = javaType.mo929t();
            if (t != null) {
                b = b.mo918c(t);
            }
            t = javaType.mo930u();
            if (t != null) {
                return b.mo914a(t);
            }
            return b;
        }
        throw new IllegalArgumentException("Class " + cls.getClass().getName() + " not subtype of " + javaType);
    }

    public final JavaType m7108a(String str) {
        return this._parser.m7121a(str);
    }

    public final JavaType[] m7116b(JavaType javaType, Class<?> cls) {
        Class cls2 = javaType._class;
        if (cls2 != cls) {
            return m7096a(cls2, (Class) cls, new TypeBindings(this, javaType));
        }
        int s = javaType.mo925s();
        if (s == 0) {
            return null;
        }
        JavaType[] javaTypeArr = new JavaType[s];
        for (int i = 0; i < s; i++) {
            javaTypeArr[i] = javaType.mo913a(i);
        }
        return javaTypeArr;
    }

    private JavaType[] m7100b(Class<?> cls, Class<?> cls2) {
        return m7096a((Class) cls, (Class) cls2, new TypeBindings(this, cls));
    }

    private JavaType[] m7096a(Class<?> cls, Class<?> cls2, TypeBindings typeBindings) {
        HierarchicType c = m7103c(cls, cls2);
        if (c == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is not a subtype of " + cls2.getName());
        }
        while (c.d != null) {
            c = c.d;
            Class cls3 = c.b;
            TypeBindings typeBindings2 = new TypeBindings(this, cls3);
            if (c.c()) {
                Type[] actualTypeArguments = c.c.getActualTypeArguments();
                TypeVariable[] typeParameters = cls3.getTypeParameters();
                int length = actualTypeArguments.length;
                for (int i = 0; i < length; i++) {
                    typeBindings2.a(typeParameters[i].getName(), m7115b(actualTypeArguments[i], typeBindings));
                }
            }
            typeBindings = typeBindings2;
        }
        if (c.c()) {
            return typeBindings.b();
        }
        return null;
    }

    public final JavaType m7109a(Type type) {
        return m7115b(type, null);
    }

    public final JavaType m7110a(Type type, TypeBindings typeBindings) {
        return m7115b(type, typeBindings);
    }

    protected final JavaType m7115b(Type type, TypeBindings typeBindings) {
        JavaType b;
        if (type instanceof Class) {
            b = m7114b((Class) type);
        } else if (type instanceof ParameterizedType) {
            b = m7087a((ParameterizedType) type, typeBindings);
        } else if (type instanceof JavaType) {
            return (JavaType) type;
        } else {
            if (type instanceof GenericArrayType) {
                b = m7086a((GenericArrayType) type, typeBindings);
            } else if (type instanceof TypeVariable) {
                b = m7088a((TypeVariable) type, typeBindings);
            } else if (type instanceof WildcardType) {
                b = m7089a((WildcardType) type, typeBindings);
            } else {
                throw new IllegalArgumentException("Unrecognized Type: " + (type == null ? "[null]" : type.toString()));
            }
        }
        if (!(this._modifiers == null || r0.mo924l())) {
            TypeModifier[] typeModifierArr = this._modifiers;
            int length = typeModifierArr.length;
            int i = 0;
            while (i < length) {
                JavaType a = typeModifierArr[i].mo1158a(b, this);
                i++;
                b = a;
            }
        }
        return b;
    }

    public final CollectionType m7111a(Class<? extends Collection> cls, Class<?> cls2) {
        return CollectionType.a(cls, m7109a((Type) cls2));
    }

    public static CollectionType m7090a(Class<? extends Collection> cls, JavaType javaType) {
        return CollectionType.a(cls, javaType);
    }

    public final MapType m7112a(Class<? extends Map> cls, Class<?> cls2, Class<?> cls3) {
        return MapType.b(cls, m7109a((Type) cls2), m7109a((Type) cls3));
    }

    public static MapLikeType m7094a(Class<?> cls, JavaType javaType, JavaType javaType2) {
        return MapLikeType.a(cls, javaType, javaType2);
    }

    private static JavaType m7085a(Class<?> cls, JavaType[] javaTypeArr) {
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters.length != javaTypeArr.length) {
            throw new IllegalArgumentException("Parameter type mismatch for " + cls.getName() + ": expected " + typeParameters.length + " parameters, was given " + javaTypeArr.length);
        }
        String[] strArr = new String[typeParameters.length];
        int length = typeParameters.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = typeParameters[i].getName();
        }
        return new SimpleType(cls, strArr, javaTypeArr, null, null, false);
    }

    public static JavaType m7084a(Class<?> cls) {
        return new SimpleType(cls);
    }

    protected final JavaType m7114b(Class<?> cls) {
        if (cls == String.class) {
            return f4052b;
        }
        if (cls == Boolean.TYPE) {
            return f4053c;
        }
        if (cls == Integer.TYPE) {
            return f4054d;
        }
        if (cls == Long.TYPE) {
            return f4055e;
        }
        ClassKey classKey = new ClassKey(cls);
        synchronized (this._typeCache) {
            JavaType javaType = (JavaType) this._typeCache.get(classKey);
        }
        if (javaType != null) {
            return javaType;
        }
        if (cls.isArray()) {
            javaType = ArrayType.a(m7115b(cls.getComponentType(), null));
        } else if (cls.isEnum()) {
            javaType = new SimpleType(cls);
        } else if (Map.class.isAssignableFrom(cls)) {
            javaType = m7102c(cls);
        } else if (Collection.class.isAssignableFrom(cls)) {
            javaType = m7104d(cls);
        } else {
            javaType = new SimpleType(cls);
        }
        synchronized (this._typeCache) {
            this._typeCache.put(classKey, javaType);
        }
        return javaType;
    }

    protected final JavaType m7107a(Class<?> cls, List<JavaType> list) {
        if (cls.isArray()) {
            return ArrayType.a(m7115b(cls.getComponentType(), null));
        }
        if (cls.isEnum()) {
            return new SimpleType(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (list.size() <= 0) {
                return m7102c(cls);
            }
            return MapType.b(cls, (JavaType) list.get(0), list.size() >= 2 ? (JavaType) list.get(1) : m7101c());
        } else if (Collection.class.isAssignableFrom(cls)) {
            if (list.size() > 0) {
                return CollectionType.a(cls, (JavaType) list.get(0));
            }
            return m7104d(cls);
        } else if (list.size() == 0) {
            return new SimpleType(cls);
        } else {
            return m7085a((Class) cls, (JavaType[]) list.toArray(new JavaType[list.size()]));
        }
    }

    private JavaType m7087a(ParameterizedType parameterizedType, TypeBindings typeBindings) {
        JavaType[] javaTypeArr;
        Class cls = (Class) parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
        if (length == 0) {
            javaTypeArr = f4056h;
        } else {
            javaTypeArr = new JavaType[length];
            for (int i = 0; i < length; i++) {
                javaTypeArr[i] = m7115b(actualTypeArguments[i], typeBindings);
            }
        }
        if (Map.class.isAssignableFrom(cls)) {
            javaTypeArr = m7116b(m7085a(cls, javaTypeArr), Map.class);
            if (javaTypeArr.length == 2) {
                return MapType.b(cls, javaTypeArr[0], javaTypeArr[1]);
            }
            throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + cls.getName() + " (found " + javaTypeArr.length + ")");
        } else if (Collection.class.isAssignableFrom(cls)) {
            javaTypeArr = m7116b(m7085a(cls, javaTypeArr), Collection.class);
            if (javaTypeArr.length == 1) {
                return CollectionType.a(cls, javaTypeArr[0]);
            }
            throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + cls.getName() + " (found " + javaTypeArr.length + ")");
        } else if (length == 0) {
            return new SimpleType(cls);
        } else {
            return m7085a(cls, javaTypeArr);
        }
    }

    private JavaType m7086a(GenericArrayType genericArrayType, TypeBindings typeBindings) {
        return ArrayType.a(m7115b(genericArrayType.getGenericComponentType(), typeBindings));
    }

    private JavaType m7088a(TypeVariable<?> typeVariable, TypeBindings typeBindings) {
        if (typeBindings == null) {
            return m7101c();
        }
        String name = typeVariable.getName();
        JavaType a = typeBindings.a(name);
        if (a != null) {
            return a;
        }
        Type[] bounds = typeVariable.getBounds();
        typeBindings.b(name);
        return m7115b(bounds[0], typeBindings);
    }

    private JavaType m7089a(WildcardType wildcardType, TypeBindings typeBindings) {
        return m7115b(wildcardType.getUpperBounds()[0], typeBindings);
    }

    private JavaType m7102c(Class<?> cls) {
        JavaType[] b = m7100b((Class) cls, Map.class);
        if (b == null) {
            return MapType.b(cls, m7101c(), m7101c());
        }
        if (b.length == 2) {
            return MapType.b(cls, b[0], b[1]);
        }
        throw new IllegalArgumentException("Strange Map type " + cls.getName() + ": can not determine type parameters");
    }

    private JavaType m7104d(Class<?> cls) {
        JavaType[] b = m7100b((Class) cls, Collection.class);
        if (b == null) {
            return CollectionType.a(cls, m7101c());
        }
        if (b.length == 1) {
            return CollectionType.a(cls, b[0]);
        }
        throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": can not determine type parameters");
    }

    public static JavaType m7101c() {
        return new SimpleType(Object.class);
    }

    private HierarchicType m7103c(Class<?> cls, Class<?> cls2) {
        if (cls2.isInterface()) {
            return m7099b((Type) cls, (Class) cls2);
        }
        return m7093a((Type) cls, (Class) cls2);
    }

    private HierarchicType m7093a(Type type, Class<?> cls) {
        HierarchicType hierarchicType = new HierarchicType(type);
        Class<?> cls2 = hierarchicType.b;
        if (cls2 == cls) {
            return hierarchicType;
        }
        Type genericSuperclass = cls2.getGenericSuperclass();
        if (genericSuperclass != null) {
            HierarchicType a = m7093a(genericSuperclass, (Class) cls);
            if (a != null) {
                a.e = hierarchicType;
                hierarchicType.d = a;
                return hierarchicType;
            }
        }
        return null;
    }

    private HierarchicType m7099b(Type type, Class<?> cls) {
        HierarchicType hierarchicType = new HierarchicType(type);
        Class<?> cls2 = hierarchicType.b;
        if (cls2 == cls) {
            return new HierarchicType(type);
        }
        if (cls2 == HashMap.class && cls == Map.class) {
            return m7091a(hierarchicType);
        }
        if (cls2 == ArrayList.class && cls == List.class) {
            return m7098b(hierarchicType);
        }
        return m7092a(hierarchicType, (Class) cls);
    }

    private synchronized HierarchicType m7091a(HierarchicType hierarchicType) {
        HierarchicType a;
        if (this.f4057f == null) {
            a = hierarchicType.a();
            m7092a(a, Map.class);
            this.f4057f = a.b();
        }
        a = this.f4057f.a();
        hierarchicType.a(a);
        a.b(hierarchicType);
        return hierarchicType;
    }

    private synchronized HierarchicType m7098b(HierarchicType hierarchicType) {
        HierarchicType a;
        if (this.f4058g == null) {
            a = hierarchicType.a();
            m7092a(a, List.class);
            this.f4058g = a.b();
        }
        a = this.f4058g.a();
        hierarchicType.a(a);
        a.b(hierarchicType);
        return hierarchicType;
    }
}
