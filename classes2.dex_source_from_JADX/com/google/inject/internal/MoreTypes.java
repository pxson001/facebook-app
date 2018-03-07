package com.google.inject.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.inject.TypeLiteral;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import javax.inject.Provider;

/* compiled from: x-cache-remote */
public class MoreTypes {
    public static final Type[] f669a = new Type[0];

    private MoreTypes() {
    }

    public static boolean m1382e(Type type) {
        if (type instanceof Class) {
            return true;
        }
        if (type instanceof CompositeType) {
            return ((CompositeType) type).a();
        }
        if (type instanceof TypeVariable) {
            return false;
        }
        return ((CompositeType) m1377a(type)).a();
    }

    public static Type m1377a(Type type) {
        if (type instanceof Class) {
            GenericArrayTypeImpl genericArrayTypeImpl;
            Class cls = (Class) type;
            if (cls.isArray()) {
                genericArrayTypeImpl = new GenericArrayTypeImpl(m1377a(cls.getComponentType()));
            } else {
                genericArrayTypeImpl = cls;
            }
            return (Type) genericArrayTypeImpl;
        } else if (type instanceof CompositeType) {
            return type;
        } else {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
            } else if (type instanceof GenericArrayType) {
                return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
            } else {
                if (!(type instanceof WildcardType)) {
                    return type;
                }
                WildcardType wildcardType = (WildcardType) type;
                return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
            }
        }
    }

    public static <T> TypeLiteral<T> m1376a(TypeLiteral<T> typeLiteral) {
        if (!m1382e(typeLiteral.f667b)) {
            throw new RuntimeException("Key not fully specified " + typeLiteral);
        } else if (typeLiteral.f666a != Provider.class) {
            return typeLiteral;
        } else {
            return TypeLiteral.m1372a(new ParameterizedTypeImpl(null, Provider.class, new Type[]{((ParameterizedType) r0).getActualTypeArguments()[0]}));
        }
    }

    public static Class<?> m1379b(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            Preconditions.checkArgument(rawType instanceof Class, "Expected a Class, but <%s> is of type %s", type, type.getClass().getName());
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(m1379b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    public static boolean m1378a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (Objects.equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return true;
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return m1378a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return true;
            }
            return false;
        } else if (!(type instanceof TypeVariable)) {
            return false;
        } else {
            if (!(type2 instanceof TypeVariable)) {
                return false;
            }
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName())) {
                return true;
            }
            return false;
        }
    }

    public static String m1381c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static void m1380b(Type type, String str) {
        boolean z;
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Primitive types are not allowed in %s: %s", str, type);
    }
}
