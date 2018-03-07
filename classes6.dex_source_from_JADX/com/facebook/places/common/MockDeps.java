package com.facebook.places.common;

import android.util.Pair;
import java.lang.reflect.Field;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: frame_pack */
public abstract class MockDeps {
    private static Map<Pair<Class, String>, Object> f14674a;

    private static synchronized <T> T m22223a(Class<T> cls) {
        T t;
        synchronized (MockDeps.class) {
            if (f14674a == null) {
                t = null;
            } else {
                t = f14674a.get(m22227b(cls));
            }
        }
        return t;
    }

    private static synchronized <T> T m22225a(Class<T> cls, String str) {
        T t;
        synchronized (MockDeps.class) {
            if (f14674a == null) {
                t = null;
            } else {
                t = f14674a.get(m22229c(cls, str));
            }
        }
        return t;
    }

    private static synchronized <T> T m22228b(Class<T> cls, String str) {
        T t;
        synchronized (MockDeps.class) {
            if (f14674a == null) {
                t = null;
            } else {
                t = m22225a((Class) cls, str);
                T a = m22223a((Class) cls);
                if (t == null) {
                    t = a;
                }
            }
        }
        return t;
    }

    public static synchronized <T> T m22224a(Class<T> cls, T t) {
        synchronized (MockDeps.class) {
            if (m22223a((Class) cls) != null) {
                t = m22223a((Class) cls);
            }
        }
        return t;
    }

    public static <CLASS> void m22226a(CLASS classR) {
        if (f14674a != null) {
            try {
                synchronized (MockDeps.class) {
                    for (Field field : classR.getClass().getDeclaredFields()) {
                        if (m22228b(field.getType(), field.getName()) != null && field.isAnnotationPresent(Inject.class)) {
                            field.setAccessible(true);
                            field.set(classR, m22228b(field.getType(), field.getName()));
                        }
                    }
                }
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Pair<Class, String> m22227b(Class cls) {
        return Pair.create(cls, null);
    }

    private static Pair<Class, String> m22229c(Class cls, String str) {
        return Pair.create(cls, str);
    }
}
