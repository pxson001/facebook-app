package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.util.Map;

/* compiled from: lastFetchTime */
public class MapLikeType extends TypeBase {
    private static final long serialVersionUID = 416067702302823522L;
    protected final JavaType _keyType;
    protected final JavaType _valueType;

    public /* synthetic */ JavaType mo767a(Object obj) {
        return mo774e(obj);
    }

    public /* synthetic */ JavaType mo768b() {
        return mo783w();
    }

    public /* synthetic */ JavaType mo769b(Object obj) {
        return mo776f(obj);
    }

    public /* synthetic */ JavaType mo770c(Object obj) {
        return mo777g(obj);
    }

    public /* synthetic */ JavaType mo772d(Object obj) {
        return mo779h(obj);
    }

    protected MapLikeType(Class<?> cls, JavaType javaType, JavaType javaType2, Object obj, Object obj2, boolean z) {
        super(cls, javaType.hashCode() ^ javaType2.hashCode(), obj, obj2, z);
        this._keyType = javaType;
        this._valueType = javaType2;
    }

    public static MapLikeType m10027a(Class<?> cls, JavaType javaType, JavaType javaType2) {
        return new MapLikeType(cls, javaType, javaType2, null, null, false);
    }

    protected JavaType mo771d(Class<?> cls) {
        return new MapLikeType(cls, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public JavaType mo773e(Class<?> cls) {
        return cls == this._valueType._class ? this : new MapLikeType(this._class, this._keyType, this._valueType.a(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public JavaType mo775f(Class<?> cls) {
        return cls == this._valueType._class ? this : new MapLikeType(this._class, this._keyType, this._valueType.c(cls), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public JavaType mo778h(Class<?> cls) {
        return cls == this._keyType._class ? this : new MapLikeType(this._class, this._keyType.a(cls), this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public JavaType mo780i(Class<?> cls) {
        return cls == this._keyType._class ? this : new MapLikeType(this._class, this._keyType.c(cls), this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public MapLikeType mo774e(Object obj) {
        return new MapLikeType(this._class, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    public MapLikeType mo776f(Object obj) {
        return new MapLikeType(this._class, this._keyType, this._valueType.a(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public MapLikeType mo777g(Object obj) {
        return new MapLikeType(this._class, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    public MapLikeType mo779h(Object obj) {
        return new MapLikeType(this._class, this._keyType, this._valueType.c(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public MapLikeType mo783w() {
        return this._asStatic ? this : new MapLikeType(this._class, this._keyType, this._valueType.b(), this._valueHandler, this._typeHandler, true);
    }

    protected final String m10050v() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._class.getName());
        if (this._keyType != null) {
            stringBuilder.append('<');
            stringBuilder.append(this._keyType.a());
            stringBuilder.append(',');
            stringBuilder.append(this._valueType.a());
            stringBuilder.append('>');
        }
        return stringBuilder.toString();
    }

    public final boolean m10045l() {
        return true;
    }

    public final boolean m10046n() {
        return true;
    }

    public final JavaType m10047q() {
        return this._keyType;
    }

    public final JavaType m10048r() {
        return this._valueType;
    }

    public final int m10049s() {
        return 2;
    }

    public final JavaType m10028a(int i) {
        if (i == 0) {
            return this._keyType;
        }
        if (i == 1) {
            return this._valueType;
        }
        return null;
    }

    public final String m10032b(int i) {
        if (i == 0) {
            return "K";
        }
        if (i == 1) {
            return "V";
        }
        return null;
    }

    public MapLikeType mo781i(Object obj) {
        return new MapLikeType(this._class, this._keyType.c(obj), this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final boolean m10052x() {
        return Map.class.isAssignableFrom(this._class);
    }

    public String toString() {
        return "[map-like type; class " + this._class.getName() + ", " + this._keyType + " -> " + this._valueType + "]";
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
        MapLikeType mapLikeType = (MapLikeType) obj;
        if (this._class == mapLikeType._class && this._keyType.equals(mapLikeType._keyType) && this._valueType.equals(mapLikeType._valueType)) {
            return true;
        }
        return false;
    }
}
