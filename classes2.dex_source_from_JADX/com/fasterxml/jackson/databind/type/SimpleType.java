package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.databind.JavaType;

/* compiled from: streaming_fetch_rerun_count_by_cc */
public final class SimpleType extends TypeBase {
    private static final long serialVersionUID = -800374828948534376L;
    protected final String[] _typeNames;
    protected final JavaType[] _typeParameters;

    protected SimpleType(Class<?> cls) {
        this(cls, null, null, null, null, false);
    }

    protected SimpleType(Class<?> cls, String[] strArr, JavaType[] javaTypeArr, Object obj, Object obj2, boolean z) {
        super(cls, 0, obj, obj2, z);
        if (strArr == null || strArr.length == 0) {
            this._typeNames = null;
            this._typeParameters = null;
            return;
        }
        this._typeNames = strArr;
        this._typeParameters = javaTypeArr;
    }

    public static SimpleType m6679h(Class<?> cls) {
        return new SimpleType(cls, null, null, null, null, false);
    }

    protected final JavaType mo919d(Class<?> cls) {
        return new SimpleType(cls, this._typeNames, this._typeParameters, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public final JavaType mo921e(Class<?> cls) {
        throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
    }

    public final JavaType mo923f(Class<?> cls) {
        throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
    }

    public final JavaType mo914a(Object obj) {
        return new SimpleType(this._class, this._typeNames, this._typeParameters, this._valueHandler, obj, this._asStatic);
    }

    public final JavaType mo916b(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
    }

    public final JavaType mo918c(Object obj) {
        if (obj == this._valueHandler) {
            return this;
        }
        return new SimpleType(this._class, this._typeNames, this._typeParameters, obj, this._typeHandler, this._asStatic);
    }

    public final JavaType mo920d(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenValueHandler()");
    }

    public final JavaType mo915b() {
        return this._asStatic ? this : new SimpleType(this._class, this._typeNames, this._typeParameters, this._valueHandler, this._typeHandler, this._asStatic);
    }

    protected final String mo927v() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._class.getName());
        if (this._typeParameters != null && this._typeParameters.length > 0) {
            stringBuilder.append('<');
            Object obj = 1;
            for (ResolvedType resolvedType : this._typeParameters) {
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(',');
                }
                stringBuilder.append(resolvedType.mo928a());
            }
            stringBuilder.append('>');
        }
        return stringBuilder.toString();
    }

    public final boolean mo924l() {
        return false;
    }

    public final int mo925s() {
        return this._typeParameters == null ? 0 : this._typeParameters.length;
    }

    public final JavaType mo913a(int i) {
        if (i < 0 || this._typeParameters == null || i >= this._typeParameters.length) {
            return null;
        }
        return this._typeParameters[i];
    }

    public final String mo917b(int i) {
        if (i < 0 || this._typeNames == null || i >= this._typeNames.length) {
            return null;
        }
        return this._typeNames[i];
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("[simple type, class ").append(mo927v()).append(']');
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        SimpleType simpleType = (SimpleType) obj;
        if (simpleType._class != this._class) {
            return false;
        }
        JavaType[] javaTypeArr = this._typeParameters;
        JavaType[] javaTypeArr2 = simpleType._typeParameters;
        if (javaTypeArr == null) {
            if (javaTypeArr2 == null || javaTypeArr2.length == 0) {
                return true;
            }
            return false;
        } else if (javaTypeArr2 == null) {
            return false;
        } else {
            if (javaTypeArr.length != javaTypeArr2.length) {
                return false;
            }
            int length = javaTypeArr.length;
            for (int i = 0; i < length; i++) {
                if (!javaTypeArr[i].equals(javaTypeArr2[i])) {
                    return false;
                }
            }
            return true;
        }
    }
}
