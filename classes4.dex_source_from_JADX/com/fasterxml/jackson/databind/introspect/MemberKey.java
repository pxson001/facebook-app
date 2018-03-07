package com.fasterxml.jackson.databind.introspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: video_data_height */
public final class MemberKey {
    static final Class<?>[] f300a = new Class[0];
    final String f301b;
    final Class<?>[] f302c;

    public MemberKey(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public MemberKey(Constructor<?> constructor) {
        this("", constructor.getParameterTypes());
    }

    public MemberKey(String str, Class<?>[] clsArr) {
        this.f301b = str;
        if (clsArr == null) {
            clsArr = f300a;
        }
        this.f302c = clsArr;
    }

    public final String toString() {
        return this.f301b + "(" + this.f302c.length + "-args)";
    }

    public final int hashCode() {
        return this.f301b.hashCode() + this.f302c.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        MemberKey memberKey = (MemberKey) obj;
        if (!this.f301b.equals(memberKey.f301b)) {
            return false;
        }
        Class[] clsArr = memberKey.f302c;
        int length = this.f302c.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Class cls = clsArr[i];
            Class cls2 = this.f302c[i];
            if (cls != cls2 && !cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                return false;
            }
        }
        return true;
    }
}
