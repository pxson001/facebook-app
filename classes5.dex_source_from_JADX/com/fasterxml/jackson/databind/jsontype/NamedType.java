package com.fasterxml.jackson.databind.jsontype;

import java.io.Serializable;

/* compiled from: cdn_uri */
public final class NamedType implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _class;
    protected final int _hashCode;
    public String _name;

    public NamedType(Class<?> cls, String str) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode();
        m11376a(str);
    }

    public final Class<?> m11377a() {
        return this._class;
    }

    public final String m11378b() {
        return this._name;
    }

    private void m11376a(String str) {
        if (str == null || str.length() == 0) {
            str = null;
        }
        this._name = str;
    }

    public final boolean m11379c() {
        return this._name != null;
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
        if (this._class != ((NamedType) obj)._class) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public final String toString() {
        return "[NamedType, class " + this._class.getName() + ", name: " + (this._name == null ? "null" : "'" + this._name + "'") + "]";
    }
}
