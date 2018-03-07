package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: capture/takePicture failed */
public class TypeNameIdResolver extends TypeIdResolverBase {
    protected final MapperConfig<?> f6134a;
    protected final HashMap<String, String> f6135b;
    protected final HashMap<String, JavaType> f6136e;

    private TypeNameIdResolver(MapperConfig<?> mapperConfig, JavaType javaType, HashMap<String, String> hashMap, HashMap<String, JavaType> hashMap2) {
        super(javaType, mapperConfig.n());
        this.f6134a = mapperConfig;
        this.f6135b = hashMap;
        this.f6136e = hashMap2;
    }

    public static TypeNameIdResolver m11506a(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        if (z == z2) {
            throw new IllegalArgumentException();
        }
        HashMap hashMap;
        HashMap hashMap2;
        if (z) {
            hashMap = new HashMap();
        } else {
            hashMap = null;
        }
        if (z2) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = null;
        }
        if (collection != null) {
            for (NamedType namedType : collection) {
                Object obj;
                Class cls = namedType._class;
                if (namedType.m11379c()) {
                    obj = namedType._name;
                } else {
                    String a = m11507a(cls);
                }
                if (z) {
                    hashMap.put(cls.getName(), obj);
                }
                if (z2) {
                    JavaType javaType2 = (JavaType) hashMap2.get(obj);
                    if (javaType2 == null || !cls.isAssignableFrom(javaType2._class)) {
                        hashMap2.put(obj, mapperConfig.b(cls));
                    }
                }
            }
        }
        return new TypeNameIdResolver(mapperConfig, javaType, hashMap, hashMap2);
    }

    public final String mo716a(Object obj) {
        String str;
        Class cls = obj.getClass();
        String name = cls.getName();
        synchronized (this.f6135b) {
            str = (String) this.f6135b.get(name);
            if (str == null) {
                if (this.f6134a.g()) {
                    str = this.f6134a.a().f(this.f6134a.c(cls).c());
                }
                if (str == null) {
                    str = m11507a(cls);
                }
                this.f6135b.put(name, str);
            }
        }
        return str;
    }

    public final String mo717a(Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        return mo716a(obj);
    }

    public final JavaType mo715a(String str) {
        return (JavaType) this.f6136e.get(str);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append(getClass().getName());
        stringBuilder.append("; id-to-type=").append(this.f6136e);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private static String m11507a(Class<?> cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf < 0 ? name : name.substring(lastIndexOf + 1);
    }
}
