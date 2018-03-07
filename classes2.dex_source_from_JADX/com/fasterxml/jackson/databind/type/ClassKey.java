package com.fasterxml.jackson.databind.type;

import java.io.Serializable;

/* compiled from: profile/%s/friends/%s?source_ref=%s */
public final class ClassKey implements Serializable, Comparable<ClassKey> {
    private static final long serialVersionUID = 1;
    private Class<?> _class;
    private String _className;
    private int _hashCode;

    public final int compareTo(Object obj) {
        return this._className.compareTo(((ClassKey) obj)._className);
    }

    public ClassKey() {
        this._class = null;
        this._className = null;
        this._hashCode = 0;
    }

    public ClassKey(Class<?> cls) {
        this._class = cls;
        this._className = cls.getName();
        this._hashCode = this._className.hashCode();
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
        if (((ClassKey) obj)._class != this._class) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public final String toString() {
        return this._className;
    }
}
