package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/* compiled from: video_log_start_bitrate */
public final class ClassUtil {
    public static List<Class<?>> m307a(Class<?> cls, Class<?> cls2) {
        return m308a(cls, cls2, new ArrayList(8));
    }

    public static List<Class<?>> m308a(Class<?> cls, Class<?> cls2, List<Class<?>> list) {
        m309a(cls, cls2, list, false);
        return list;
    }

    private static void m309a(Class<?> cls, Class<?> cls2, Collection<Class<?>> collection, boolean z) {
        if (cls != cls2 && cls != null && cls != Object.class) {
            if (z) {
                if (!collection.contains(cls)) {
                    collection.add(cls);
                } else {
                    return;
                }
            }
            for (Class a : cls.getInterfaces()) {
                m309a(a, cls2, collection, true);
            }
            m309a(cls.getSuperclass(), cls2, collection, true);
        }
    }

    public static String m304a(Class<?> cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (cls.isEnum()) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static String m305a(Class<?> cls, boolean z) {
        try {
            if (cls.getEnclosingMethod() != null) {
                return "local/anonymous";
            }
            if (!(z || cls.getEnclosingClass() == null || Modifier.isStatic(cls.getModifiers()))) {
                return "non-static member class";
            }
            return null;
        } catch (SecurityException e) {
        } catch (NullPointerException e2) {
        }
    }

    public static Class<?> m313b(Class<?> cls) {
        Class<?> cls2 = null;
        try {
            if (cls.getEnclosingMethod() == null && !Modifier.isStatic(cls.getModifiers())) {
                cls2 = cls.getEnclosingClass();
            }
        } catch (SecurityException e) {
        } catch (NullPointerException e2) {
        }
        return cls2;
    }

    public static boolean m319c(Class<?> cls) {
        String name = cls.getName();
        if (name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.")) {
            return true;
        }
        return false;
    }

    public static boolean m320d(Class<?> cls) {
        return (cls.getModifiers() & 1536) == 0;
    }

    public static boolean m321e(Class<?> cls) {
        if (cls.isArray() || Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public static Class<?> m301a(String str) {
        if (str.indexOf(46) < 0) {
            if ("int".equals(str)) {
                return Integer.TYPE;
            }
            if ("long".equals(str)) {
                return Long.TYPE;
            }
            if ("float".equals(str)) {
                return Float.TYPE;
            }
            if ("double".equals(str)) {
                return Double.TYPE;
            }
            if ("boolean".equals(str)) {
                return Boolean.TYPE;
            }
            if ("byte".equals(str)) {
                return Byte.TYPE;
            }
            if ("char".equals(str)) {
                return Character.TYPE;
            }
            if ("short".equals(str)) {
                return Short.TYPE;
            }
            if ("void".equals(str)) {
                return Void.TYPE;
            }
        }
        Throwable th = null;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable th2) {
                th2 = m306a(th2);
            }
        }
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            if (th2 == null) {
                th2 = m306a(e);
            }
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            throw new ClassNotFoundException(th2.getMessage(), th2);
        }
    }

    public static Throwable m306a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private static void m318c(Throwable th) {
        m316b(th, th.getMessage());
    }

    private static void m316b(Throwable th, String str) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            throw new IllegalArgumentException(str, th);
        }
    }

    public static void m315b(Throwable th) {
        m318c(m306a(th));
    }

    public static void m310a(Throwable th, String str) {
        m316b(m306a(th), str);
    }

    public static <T> T m314b(Class<T> cls, boolean z) {
        Constructor c = m317c(cls, z);
        if (c == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
        try {
            return c.newInstance(new Object[0]);
        } catch (Throwable e) {
            m310a(e, "Failed to instantiate class " + cls.getName() + ", problem: " + e.getMessage());
            return null;
        }
    }

    private static <T> Constructor<T> m317c(Class<T> cls, boolean z) {
        try {
            Member declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (z) {
                m311a(declaredConstructor);
                return declaredConstructor;
            } else if (Modifier.isPublic(declaredConstructor.getModifiers())) {
                return declaredConstructor;
            } else {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: can not instantiate type");
            }
        } catch (NoSuchMethodException e) {
            return null;
        } catch (Throwable e2) {
            m310a(e2, "Failed to find default constructor of class " + cls.getName() + ", problem: " + e2.getMessage());
            return null;
        }
    }

    public static Object m322f(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return Integer.valueOf(0);
        }
        if (cls == Long.TYPE) {
            return Long.valueOf(0);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Byte.TYPE) {
            return Byte.valueOf((byte) 0);
        }
        if (cls == Short.TYPE) {
            return Short.valueOf((short) 0);
        }
        if (cls == Character.TYPE) {
            return Character.valueOf('\u0000');
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static Class<?> m323g(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static void m311a(Member member) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            if (!accessibleObject.isAccessible()) {
                throw new IllegalArgumentException("Can not access " + member + " (from class " + member.getDeclaringClass().getName() + "; failed to set access: " + e.getMessage());
            }
        }
    }

    public static Class<? extends Enum<?>> m303a(EnumSet<?> enumSet) {
        if (enumSet.isEmpty()) {
            return EnumTypeLocator.a.a(enumSet);
        }
        return m300a((Enum) enumSet.iterator().next());
    }

    public static Class<? extends Enum<?>> m302a(EnumMap<?, ?> enumMap) {
        if (enumMap.isEmpty()) {
            return EnumTypeLocator.a.a(enumMap);
        }
        return m300a((Enum) enumMap.keySet().iterator().next());
    }

    private static Class<? extends Enum<?>> m300a(Enum<?> enumR) {
        Class<? extends Enum<?>> cls = enumR.getClass();
        if (cls.getSuperclass() != Enum.class) {
            return cls.getSuperclass();
        }
        return cls;
    }

    public static Class<? extends Enum<?>> m324h(Class<?> cls) {
        if (cls.getSuperclass() != Enum.class) {
            return cls.getSuperclass();
        }
        return cls;
    }

    public static boolean m312a(Object obj) {
        return obj != null && m325i(obj.getClass());
    }

    private static boolean m325i(Class<?> cls) {
        return cls.getAnnotation(JacksonStdImpl.class) != null;
    }
}
