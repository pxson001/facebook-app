package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: validation_bool */
public final class EnumValues {
    private final Class<Enum<?>> f389a;
    private final EnumMap<?, SerializedString> f390b;

    private EnumValues(Class<Enum<?>> cls, Map<Enum<?>, SerializedString> map) {
        this.f389a = cls;
        this.f390b = new EnumMap(map);
    }

    public static EnumValues m663a(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        return m664b(cls, annotationIntrospector);
    }

    public static EnumValues m664b(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) ClassUtil.m324h(cls).getEnumConstants();
        if (enumArr != null) {
            Map hashMap = new HashMap();
            for (Enum enumR : enumArr) {
                hashMap.put(enumR, new SerializedString(AnnotationIntrospector.a(enumR)));
            }
            return new EnumValues(cls, hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    public static EnumValues m662a(Class<Enum<?>> cls) {
        Enum[] enumArr = (Enum[]) ClassUtil.m324h(cls).getEnumConstants();
        if (enumArr != null) {
            Map hashMap = new HashMap();
            for (Enum enumR : enumArr) {
                hashMap.put(enumR, new SerializedString(enumR.toString()));
            }
            return new EnumValues(cls, hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    public final SerializedString m665a(Enum<?> enumR) {
        return (SerializedString) this.f390b.get(enumR);
    }
}
