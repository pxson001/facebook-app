package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: can_viewer_get_notification */
public class EnumResolver<T extends Enum<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<T> _enumClass;
    protected final T[] _enums;
    protected final HashMap<String, T> _enumsById;

    private EnumResolver(Class<T> cls, T[] tArr, HashMap<String, T> hashMap) {
        this._enumClass = cls;
        this._enums = tArr;
        this._enumsById = hashMap;
    }

    public static <ET extends Enum<ET>> EnumResolver<ET> m11779b(Class<ET> cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("No enum constants for class " + cls.getName());
        }
        HashMap hashMap = new HashMap();
        for (Enum enumR : enumArr) {
            hashMap.put(AnnotationIntrospector.a(enumR), enumR);
        }
        return new EnumResolver(cls, enumArr, hashMap);
    }

    public static <ET extends Enum<ET>> EnumResolver<ET> m11778b(Class<ET> cls) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int length = enumArr.length;
        while (true) {
            length--;
            if (length < 0) {
                return new EnumResolver(cls, enumArr, hashMap);
            }
            Enum enumR = enumArr[length];
            hashMap.put(enumR.toString(), enumR);
        }
    }

    public static <ET extends Enum<ET>> EnumResolver<ET> m11780b(Class<ET> cls, Method method) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int length = enumArr.length;
        while (true) {
            length--;
            if (length < 0) {
                return new EnumResolver(cls, enumArr, hashMap);
            }
            Object obj = enumArr[length];
            try {
                Object invoke = method.invoke(obj, new Object[0]);
                if (invoke != null) {
                    hashMap.put(invoke.toString(), obj);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + obj + ": " + e.getMessage());
            }
        }
    }

    public static EnumResolver<?> m11776a(Class<?> cls, AnnotationIntrospector annotationIntrospector) {
        return m11779b((Class) cls, annotationIntrospector);
    }

    public static EnumResolver<?> m11775a(Class<?> cls) {
        return m11778b(cls);
    }

    public static EnumResolver<?> m11777a(Class<?> cls, Method method) {
        return m11780b((Class) cls, method);
    }

    public final T m11783a(String str) {
        return (Enum) this._enumsById.get(str);
    }

    public final T m11782a(int i) {
        if (i < 0 || i >= this._enums.length) {
            return null;
        }
        return this._enums[i];
    }

    public final Class<T> m11781a() {
        return this._enumClass;
    }

    public final int m11784b() {
        return this._enums.length - 1;
    }
}
