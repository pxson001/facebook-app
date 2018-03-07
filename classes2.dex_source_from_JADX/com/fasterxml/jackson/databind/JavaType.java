package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.type.ResolvedType;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/* compiled from: str == null */
public abstract class JavaType extends ResolvedType implements Serializable, Type {
    private static final long serialVersionUID = 6774285981275451126L;
    protected final boolean _asStatic;
    public final Class<?> _class;
    protected final int _hashCode;
    protected final Object _typeHandler;
    protected final Object _valueHandler;

    public abstract JavaType mo914a(Object obj);

    public abstract JavaType mo915b();

    public abstract JavaType mo916b(Object obj);

    public abstract JavaType mo918c(Object obj);

    protected abstract JavaType mo919d(Class<?> cls);

    public abstract JavaType mo920d(Object obj);

    public abstract JavaType mo921e(Class<?> cls);

    public abstract boolean equals(Object obj);

    public abstract JavaType mo923f(Class<?> cls);

    public abstract boolean mo924l();

    public abstract String toString();

    protected JavaType(Class<?> cls, int i, Object obj, Object obj2, boolean z) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode() + i;
        this._valueHandler = obj;
        this._typeHandler = obj2;
        this._asStatic = z;
    }

    public final JavaType m6700a(Class<?> cls) {
        if (cls == this._class) {
            return this;
        }
        m6698i(cls);
        JavaType d = mo919d((Class) cls);
        if (this._valueHandler != d.mo929t()) {
            d = d.mo918c(this._valueHandler);
        }
        if (this._typeHandler != d.mo930u()) {
            d = d.mo914a(this._typeHandler);
        }
        return d;
    }

    public final JavaType m6703b(Class<?> cls) {
        if (cls == this._class) {
            return this;
        }
        JavaType d = mo919d((Class) cls);
        if (this._valueHandler != d.mo929t()) {
            d = d.mo918c(this._valueHandler);
        }
        if (this._typeHandler != d.mo930u()) {
            d = d.mo914a(this._typeHandler);
        }
        return d;
    }

    public final JavaType m6706c(Class<?> cls) {
        if (cls == this._class) {
            return this;
        }
        m6698i(this._class);
        return m6697h(cls);
    }

    private JavaType m6697h(Class<?> cls) {
        return mo919d((Class) cls);
    }

    public final Class<?> m6708c() {
        return this._class;
    }

    public final boolean m6717g(Class<?> cls) {
        return this._class == cls;
    }

    public boolean m6711d() {
        return Modifier.isAbstract(this._class.getModifiers());
    }

    public boolean m6713e() {
        if ((this._class.getModifiers() & 1536) == 0 || this._class.isPrimitive()) {
            return true;
        }
        return false;
    }

    public final boolean m6715f() {
        return Throwable.class.isAssignableFrom(this._class);
    }

    public boolean m6716g() {
        return false;
    }

    public final boolean m6718h() {
        return this._class.isEnum();
    }

    public final boolean m6719i() {
        return this._class.isInterface();
    }

    public final boolean m6720j() {
        return this._class.isPrimitive();
    }

    public final boolean m6721k() {
        return Modifier.isFinal(this._class.getModifiers());
    }

    public boolean m6723m() {
        return false;
    }

    public boolean m6724n() {
        return false;
    }

    public final boolean m6725o() {
        return this._asStatic;
    }

    public boolean m6726p() {
        return mo925s() > 0;
    }

    public JavaType m6727q() {
        return null;
    }

    public JavaType m6728r() {
        return null;
    }

    public int mo925s() {
        return 0;
    }

    public JavaType mo913a(int i) {
        return null;
    }

    public String mo917b(int i) {
        return null;
    }

    public <T> T mo929t() {
        return this._valueHandler;
    }

    public <T> T mo930u() {
        return this._typeHandler;
    }

    private void m6698i(Class<?> cls) {
        if (!this._class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is not assignable to " + this._class.getName());
        }
    }

    public final int hashCode() {
        return this._hashCode;
    }
}
