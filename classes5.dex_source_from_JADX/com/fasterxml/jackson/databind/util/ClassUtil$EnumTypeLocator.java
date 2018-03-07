package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

/* compiled from: can_viewer_invite */
class ClassUtil$EnumTypeLocator {
    static final ClassUtil$EnumTypeLocator f6233a = new ClassUtil$EnumTypeLocator();
    private final Field f6234b = m11772a(EnumSet.class, "elementType", Class.class);
    private final Field f6235c = m11772a(EnumMap.class, "elementType", Class.class);

    private ClassUtil$EnumTypeLocator() {
    }

    public final Class<? extends Enum<?>> m11774a(EnumSet<?> enumSet) {
        if (this.f6234b != null) {
            return (Class) m11771a(enumSet, this.f6234b);
        }
        throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
    }

    public final Class<? extends Enum<?>> m11773a(EnumMap<?, ?> enumMap) {
        if (this.f6235c != null) {
            return (Class) m11771a(enumMap, this.f6235c);
        }
        throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
    }

    private static Object m11771a(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static Field m11772a(Class<?> cls, String str, Class<?> cls2) {
        int i;
        int length;
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if (str.equals(field.getName()) && field.getType() == cls2) {
                break;
            }
        }
        Field field2 = null;
        if (field2 == null) {
            length = declaredFields.length;
            i = 0;
            Field field3 = field2;
            while (i < length) {
                field2 = declaredFields[i];
                if (field2.getType() != cls2) {
                    field2 = field3;
                } else if (field3 != null) {
                    return null;
                }
                i++;
                field3 = field2;
            }
            field2 = field3;
        }
        if (field2 == null) {
            return field2;
        }
        try {
            field2.setAccessible(true);
            return field2;
        } catch (Throwable th) {
            return field2;
        }
    }
}
