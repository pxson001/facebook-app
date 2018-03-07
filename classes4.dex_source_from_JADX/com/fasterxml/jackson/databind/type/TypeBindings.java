package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: vault_local_image_status_api exception */
public class TypeBindings {
    public static final JavaType f341a = new SimpleType(Object.class);
    private static final JavaType[] f342g = new JavaType[0];
    protected final TypeFactory f343b;
    protected final JavaType f344c;
    protected final Class<?> f345d;
    protected Map<String, JavaType> f346e;
    protected HashSet<String> f347f;
    private final TypeBindings f348h;

    public TypeBindings(TypeFactory typeFactory, Class<?> cls) {
        this(typeFactory, null, cls, null);
    }

    public TypeBindings(TypeFactory typeFactory, JavaType javaType) {
        this(typeFactory, null, javaType._class, javaType);
    }

    public final TypeBindings m586a() {
        return new TypeBindings(this.f343b, this, this.f345d, this.f344c);
    }

    private TypeBindings(TypeFactory typeFactory, TypeBindings typeBindings, Class<?> cls, JavaType javaType) {
        this.f343b = typeFactory;
        this.f348h = typeBindings;
        this.f345d = cls;
        this.f344c = javaType;
    }

    public final JavaType m585a(Type type) {
        return this.f343b.b(type, this);
    }

    public final JavaType m584a(String str) {
        if (this.f346e == null) {
            m583c();
        }
        JavaType javaType = (JavaType) this.f346e.get(str);
        if (javaType != null) {
            return javaType;
        }
        if (this.f347f != null && this.f347f.contains(str)) {
            return f341a;
        }
        if (this.f348h != null) {
            return this.f348h.m584a(str);
        }
        if (this.f345d != null && this.f345d.getEnclosingClass() != null && !Modifier.isStatic(this.f345d.getModifiers())) {
            return f341a;
        }
        String name;
        if (this.f345d != null) {
            name = this.f345d.getName();
        } else if (this.f344c != null) {
            name = this.f344c.toString();
        } else {
            name = "UNKNOWN";
        }
        throw new IllegalArgumentException("Type variable '" + str + "' can not be resolved (with context of class " + name + ")");
    }

    public final void m587a(String str, JavaType javaType) {
        if (this.f346e == null || this.f346e.size() == 0) {
            this.f346e = new LinkedHashMap();
        }
        this.f346e.put(str, javaType);
    }

    public final JavaType[] m589b() {
        if (this.f346e == null) {
            m583c();
        }
        if (this.f346e.size() == 0) {
            return f342g;
        }
        return (JavaType[]) this.f346e.values().toArray(new JavaType[this.f346e.size()]);
    }

    private void m583c() {
        m582b(this.f345d);
        if (this.f344c != null) {
            int s = this.f344c.s();
            if (s > 0) {
                for (int i = 0; i < s; i++) {
                    m587a(this.f344c.b(i), this.f344c.a(i));
                }
            }
        }
        if (this.f346e == null) {
            this.f346e = Collections.emptyMap();
        }
    }

    public final void m588b(String str) {
        if (this.f347f == null) {
            this.f347f = new HashSet();
        }
        this.f347f.add(str);
    }

    private void m582b(Type type) {
        int i = 0;
        if (type != null) {
            Class cls;
            int i2;
            TypeVariable[] typeParameters;
            String name;
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                    cls = (Class) parameterizedType.getRawType();
                    typeParameters = cls.getTypeParameters();
                    if (typeParameters.length != actualTypeArguments.length) {
                        throw new IllegalArgumentException("Strange parametrized type (in class " + cls.getName() + "): number of type arguments != number of type parameters (" + actualTypeArguments.length + " vs " + typeParameters.length + ")");
                    }
                    int length = actualTypeArguments.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        name = typeParameters[i3].getName();
                        if (this.f346e == null) {
                            this.f346e = new LinkedHashMap();
                        } else if (this.f346e.containsKey(name)) {
                        }
                        m588b(name);
                        this.f346e.put(name, this.f343b.b(actualTypeArguments[i3], this));
                    }
                }
                cls = (Class) parameterizedType.getRawType();
            } else if (type instanceof Class) {
                Class cls2 = (Class) type;
                cls = cls2.getDeclaringClass();
                if (!(cls == null || cls.isAssignableFrom(cls2))) {
                    m582b(cls2.getDeclaringClass());
                }
                typeParameters = cls2.getTypeParameters();
                if (typeParameters != null && typeParameters.length > 0) {
                    JavaType[] javaTypeArr = null;
                    if (this.f344c != null && cls2.isAssignableFrom(this.f344c._class)) {
                        javaTypeArr = this.f343b.b(this.f344c, cls2);
                    }
                    for (i2 = 0; i2 < typeParameters.length; i2++) {
                        TypeVariable typeVariable = typeParameters[i2];
                        name = typeVariable.getName();
                        Type type2 = typeVariable.getBounds()[0];
                        if (type2 != null) {
                            if (this.f346e == null) {
                                this.f346e = new LinkedHashMap();
                            } else if (this.f346e.containsKey(name)) {
                            }
                            m588b(name);
                            if (javaTypeArr != null) {
                                this.f346e.put(name, javaTypeArr[i2]);
                            } else {
                                this.f346e.put(name, this.f343b.b(type2, this));
                            }
                        }
                    }
                }
                cls = cls2;
            } else {
                return;
            }
            m582b(cls.getGenericSuperclass());
            Type[] genericInterfaces = cls.getGenericInterfaces();
            i2 = genericInterfaces.length;
            while (i < i2) {
                m582b(genericInterfaces[i]);
                i++;
            }
        }
    }

    public String toString() {
        if (this.f346e == null) {
            m583c();
        }
        StringBuilder stringBuilder = new StringBuilder("[TypeBindings for ");
        if (this.f344c != null) {
            stringBuilder.append(this.f344c.toString());
        } else {
            stringBuilder.append(this.f345d.getName());
        }
        stringBuilder.append(": ").append(this.f346e).append("]");
        return stringBuilder.toString();
    }
}
