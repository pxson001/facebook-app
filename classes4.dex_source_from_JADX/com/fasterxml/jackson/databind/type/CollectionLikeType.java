package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.util.Collection;

/* compiled from: disk_cache */
public class CollectionLikeType extends TypeBase {
    private static final long serialVersionUID = 4611641304150899138L;
    protected final JavaType _elementType;

    public /* synthetic */ JavaType mo972a(Object obj) {
        return mo979e(obj);
    }

    public /* synthetic */ JavaType mo973b() {
        return mo985w();
    }

    public /* synthetic */ JavaType mo974b(Object obj) {
        return mo981f(obj);
    }

    public /* synthetic */ JavaType mo975c(Object obj) {
        return mo982g(obj);
    }

    public /* synthetic */ JavaType mo977d(Object obj) {
        return mo983h(obj);
    }

    protected CollectionLikeType(Class<?> cls, JavaType javaType, Object obj, Object obj2, boolean z) {
        super(cls, javaType.hashCode(), obj, obj2, z);
        this._elementType = javaType;
    }

    protected JavaType mo976d(Class<?> cls) {
        return new CollectionLikeType(cls, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public JavaType mo978e(Class<?> cls) {
        return cls == this._elementType._class ? this : new CollectionLikeType(this._class, this._elementType.a(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public JavaType mo980f(Class<?> cls) {
        return cls == this._elementType._class ? this : new CollectionLikeType(this._class, this._elementType.c(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public CollectionLikeType mo979e(Object obj) {
        return new CollectionLikeType(this._class, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    public CollectionLikeType mo981f(Object obj) {
        return new CollectionLikeType(this._class, this._elementType.a(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public CollectionLikeType mo982g(Object obj) {
        return new CollectionLikeType(this._class, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    public CollectionLikeType mo983h(Object obj) {
        return new CollectionLikeType(this._class, this._elementType.c(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public CollectionLikeType mo985w() {
        return this._asStatic ? this : new CollectionLikeType(this._class, this._elementType.b(), this._valueHandler, this._typeHandler, true);
    }

    public final boolean m14532l() {
        return true;
    }

    public final boolean m14533m() {
        return true;
    }

    public final JavaType m14534r() {
        return this._elementType;
    }

    public final int m14535s() {
        return 1;
    }

    public final JavaType m14518a(int i) {
        return i == 0 ? this._elementType : null;
    }

    public final String m14522b(int i) {
        if (i == 0) {
            return "E";
        }
        return null;
    }

    protected final String m14536v() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._class.getName());
        if (this._elementType != null) {
            stringBuilder.append('<');
            stringBuilder.append(this._elementType.a());
            stringBuilder.append('>');
        }
        return stringBuilder.toString();
    }

    public final boolean m14538x() {
        return Collection.class.isAssignableFrom(this._class);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        CollectionLikeType collectionLikeType = (CollectionLikeType) obj;
        if (this._class == collectionLikeType._class && this._elementType.equals(collectionLikeType._elementType)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "[collection-like type; class " + this._class.getName() + ", contains " + this._elementType + "]";
    }
}
