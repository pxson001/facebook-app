package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

/* compiled from: disk_cache_visit */
public final class CollectionType extends CollectionLikeType {
    private static final long serialVersionUID = -7834910259750909424L;

    public final /* synthetic */ JavaType mo972a(Object obj) {
        return m14500i(obj);
    }

    public final /* synthetic */ JavaType mo973b() {
        return m14504y();
    }

    public final /* synthetic */ JavaType mo974b(Object obj) {
        return m14501j(obj);
    }

    public final /* synthetic */ JavaType mo975c(Object obj) {
        return m14502k(obj);
    }

    public final /* synthetic */ JavaType mo977d(Object obj) {
        return m14503l(obj);
    }

    public final /* synthetic */ CollectionLikeType mo979e(Object obj) {
        return m14500i(obj);
    }

    public final /* synthetic */ CollectionLikeType mo981f(Object obj) {
        return m14501j(obj);
    }

    public final /* synthetic */ CollectionLikeType mo982g(Object obj) {
        return m14502k(obj);
    }

    public final /* synthetic */ CollectionLikeType mo983h(Object obj) {
        return m14503l(obj);
    }

    public final /* synthetic */ CollectionLikeType mo985w() {
        return m14504y();
    }

    private CollectionType(Class<?> cls, JavaType javaType, Object obj, Object obj2, boolean z) {
        super(cls, javaType, obj, obj2, z);
    }

    protected final JavaType mo976d(Class<?> cls) {
        return new CollectionType(cls, this._elementType, null, null, this._asStatic);
    }

    public final JavaType mo978e(Class<?> cls) {
        return cls == this._elementType._class ? this : new CollectionType(this._class, this._elementType.a(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType mo980f(Class<?> cls) {
        return cls == this._elementType._class ? this : new CollectionType(this._class, this._elementType.c(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public static CollectionType m14499a(Class<?> cls, JavaType javaType) {
        return new CollectionType(cls, javaType, null, null, false);
    }

    private CollectionType m14500i(Object obj) {
        return new CollectionType(this._class, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    private CollectionType m14501j(Object obj) {
        return new CollectionType(this._class, this._elementType.a(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    private CollectionType m14502k(Object obj) {
        return new CollectionType(this._class, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    private CollectionType m14503l(Object obj) {
        return new CollectionType(this._class, this._elementType.c(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    private CollectionType m14504y() {
        return this._asStatic ? this : new CollectionType(this._class, this._elementType.b(), this._valueHandler, this._typeHandler, true);
    }

    public final String toString() {
        return "[collection type; class " + this._class.getName() + ", contains " + this._elementType + "]";
    }
}
