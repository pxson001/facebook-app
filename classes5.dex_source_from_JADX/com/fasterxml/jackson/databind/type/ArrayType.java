package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Array;

/* compiled from: can_viewer_make_profile_picture */
public final class ArrayType extends TypeBase {
    private static final long serialVersionUID = 9040058063449087477L;
    protected final JavaType _componentType;
    protected final Object _emptyArray;

    private ArrayType(JavaType javaType, Object obj, Object obj2, Object obj3, boolean z) {
        super(obj.getClass(), javaType.hashCode(), obj2, obj3, z);
        this._componentType = javaType;
        this._emptyArray = obj;
    }

    public static ArrayType m11737a(JavaType javaType) {
        return new ArrayType(javaType, Array.newInstance(javaType._class, 0), null, null, false);
    }

    public final JavaType m11739a(Object obj) {
        if (obj == this._typeHandler) {
            return this;
        }
        return new ArrayType(this._componentType, this._emptyArray, this._valueHandler, obj, this._asStatic);
    }

    public final JavaType m11741b(Object obj) {
        return obj == this._componentType.u() ? this : new ArrayType(this._componentType.a(obj), this._emptyArray, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType m11743c(Object obj) {
        if (obj == this._valueHandler) {
            return this;
        }
        return new ArrayType(this._componentType, this._emptyArray, obj, this._typeHandler, this._asStatic);
    }

    public final JavaType m11745d(Object obj) {
        return obj == this._componentType.t() ? this : new ArrayType(this._componentType.c(obj), this._emptyArray, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType m11740b() {
        return this._asStatic ? this : new ArrayType(this._componentType.b(), this._emptyArray, this._valueHandler, this._typeHandler, true);
    }

    protected final String m11755v() {
        return this._class.getName();
    }

    protected final JavaType m11744d(Class<?> cls) {
        if (cls.isArray()) {
            return m11737a(TypeFactory.a.a(cls.getComponentType()));
        }
        throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + cls.getName());
    }

    public final JavaType m11747e(Class<?> cls) {
        return cls == this._componentType._class ? this : m11737a(this._componentType.a(cls));
    }

    public final JavaType m11749f(Class<?> cls) {
        return cls == this._componentType._class ? this : m11737a(this._componentType.c(cls));
    }

    public final boolean m11750g() {
        return true;
    }

    public final boolean m11746d() {
        return false;
    }

    public final boolean m11748e() {
        return true;
    }

    public final boolean m11752p() {
        return this._componentType.p();
    }

    public final String m11742b(int i) {
        if (i == 0) {
            return "E";
        }
        return null;
    }

    public final boolean m11751l() {
        return true;
    }

    public final JavaType m11753r() {
        return this._componentType;
    }

    public final int m11754s() {
        return 1;
    }

    public final JavaType m11738a(int i) {
        return i == 0 ? this._componentType : null;
    }

    public final String toString() {
        return "[array type, component type: " + this._componentType + "]";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this._componentType.equals(((ArrayType) obj)._componentType);
    }
}
