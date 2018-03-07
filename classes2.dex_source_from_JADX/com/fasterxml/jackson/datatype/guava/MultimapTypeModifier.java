package com.fasterxml.jackson.datatype.guava;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeModifier;
import com.google.common.collect.Multimap;
import java.lang.reflect.Type;

/* compiled from: sq */
public class MultimapTypeModifier extends TypeModifier {
    public final JavaType mo1158a(JavaType javaType, TypeFactory typeFactory) {
        if (!Multimap.class.isAssignableFrom(javaType._class)) {
            return javaType;
        }
        JavaType a = javaType.mo913a(0);
        JavaType a2 = javaType.mo913a(1);
        if (a == null) {
            a = typeFactory.m7109a((Type) Object.class);
        }
        if (a2 == null) {
            a2 = typeFactory.m7109a((Type) Object.class);
        }
        return MapLikeType.a(javaType._class, a, a2);
    }
}
