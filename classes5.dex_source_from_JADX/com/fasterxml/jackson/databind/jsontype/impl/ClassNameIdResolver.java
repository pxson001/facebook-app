package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.EnumMap;
import java.util.EnumSet;

/* compiled from: carrier_id */
public class ClassNameIdResolver extends TypeIdResolverBase {
    public ClassNameIdResolver(JavaType javaType, TypeFactory typeFactory) {
        super(javaType, typeFactory);
    }

    public String mo716a(Object obj) {
        return m11488b(obj, obj.getClass());
    }

    public final String mo717a(Object obj, Class<?> cls) {
        return m11488b(obj, cls);
    }

    public JavaType mo715a(String str) {
        if (str.indexOf(60) > 0) {
            return this.f6122c.a(str);
        }
        try {
            return this.f6122c.a(this.f6123d, ClassUtil.a(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): no such class found");
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): " + e2.getMessage(), e2);
        }
    }

    private String m11488b(Object obj, Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (name.startsWith("java.util")) {
            if (obj instanceof EnumSet) {
                return TypeFactory.a.a(EnumSet.class, ClassUtil.a((EnumSet) obj)).a();
            } else if (obj instanceof EnumMap) {
                return TypeFactory.a.a(EnumMap.class, ClassUtil.a((EnumMap) obj), Object.class).a();
            } else {
                String substring = name.substring(9);
                if ((substring.startsWith(".Arrays$") || substring.startsWith(".Collections$")) && name.indexOf("List") >= 0) {
                    return "java.util.ArrayList";
                }
                return name;
            }
        } else if (name.indexOf(36) < 0 || ClassUtil.b(cls) == null || ClassUtil.b(this.f6123d._class) != null) {
            return name;
        } else {
            return this.f6123d._class.getName();
        }
    }
}
