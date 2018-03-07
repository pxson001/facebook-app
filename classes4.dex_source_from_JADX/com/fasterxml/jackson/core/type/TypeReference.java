package com.fasterxml.jackson.core.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: topOnlineFriends */
public abstract class TypeReference<T> implements Comparable<TypeReference<T>> {
    public final Type f914a;

    protected TypeReference() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        this.f914a = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    public final Type m1240a() {
        return this.f914a;
    }

    public int compareTo(Object obj) {
        return 0;
    }
}
