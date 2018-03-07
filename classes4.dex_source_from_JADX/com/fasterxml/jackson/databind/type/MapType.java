package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

/* compiled from: lastFullUpdateSize */
public final class MapType extends MapLikeType {
    private static final long serialVersionUID = -811146779148281500L;

    public final /* synthetic */ JavaType mo767a(Object obj) {
        return m10006j(obj);
    }

    public final /* synthetic */ JavaType mo768b() {
        return m10010y();
    }

    public final /* synthetic */ JavaType mo769b(Object obj) {
        return m10007k(obj);
    }

    public final /* synthetic */ JavaType mo770c(Object obj) {
        return m10008l(obj);
    }

    public final /* synthetic */ JavaType mo772d(Object obj) {
        return m10009m(obj);
    }

    public final /* synthetic */ MapLikeType mo774e(Object obj) {
        return m10006j(obj);
    }

    public final /* synthetic */ MapLikeType mo776f(Object obj) {
        return m10007k(obj);
    }

    public final /* synthetic */ MapLikeType mo777g(Object obj) {
        return m10008l(obj);
    }

    public final /* synthetic */ MapLikeType mo779h(Object obj) {
        return m10009m(obj);
    }

    public final /* synthetic */ MapLikeType mo783w() {
        return m10010y();
    }

    private MapType(Class<?> cls, JavaType javaType, JavaType javaType2, Object obj, Object obj2, boolean z) {
        super(cls, javaType, javaType2, obj, obj2, z);
    }

    public static MapType m10005b(Class<?> cls, JavaType javaType, JavaType javaType2) {
        return new MapType(cls, javaType, javaType2, null, null, false);
    }

    protected final JavaType mo771d(Class<?> cls) {
        return new MapType(cls, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType mo773e(Class<?> cls) {
        return cls == this._valueType._class ? this : new MapType(this._class, this._keyType, this._valueType.a(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType mo775f(Class<?> cls) {
        return cls == this._valueType._class ? this : new MapType(this._class, this._keyType, this._valueType.c(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType mo778h(Class<?> cls) {
        return cls == this._keyType._class ? this : new MapType(this._class, this._keyType.a(cls), this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType mo780i(Class<?> cls) {
        return cls == this._keyType._class ? this : new MapType(this._class, this._keyType.c(cls), this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    private MapType m10006j(Object obj) {
        return new MapType(this._class, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    private MapType m10007k(Object obj) {
        return new MapType(this._class, this._keyType, this._valueType.a(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    private MapType m10008l(Object obj) {
        return new MapType(this._class, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    private MapType m10009m(Object obj) {
        return new MapType(this._class, this._keyType, this._valueType.c(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    private MapType m10010y() {
        return this._asStatic ? this : new MapType(this._class, this._keyType.b(), this._valueType.b(), this._valueHandler, this._typeHandler, true);
    }

    public final MapLikeType mo781i(Object obj) {
        return new MapType(this._class, this._keyType.c(obj), this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final String toString() {
        return "[map type; class " + this._class.getName() + ", " + this._keyType + " -> " + this._valueType + "]";
    }
}
