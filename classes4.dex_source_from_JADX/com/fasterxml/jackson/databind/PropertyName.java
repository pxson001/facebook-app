package com.fasterxml.jackson.databind;

import java.io.Serializable;

/* compiled from: video_bitrate */
public class PropertyName implements Serializable {
    public static final PropertyName f303a = new PropertyName("", null);
    public static final PropertyName f304b = new PropertyName(new String("#disabled"), null);
    private static final long serialVersionUID = 7930806520033045126L;
    protected final String _namespace;
    public final String _simpleName;

    public PropertyName(String str) {
        this(str, null);
    }

    private PropertyName(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this._simpleName = str;
        this._namespace = str2;
    }

    protected Object readResolve() {
        if (this._simpleName == null || "".equals(this._simpleName)) {
            return f303a;
        }
        if (this._simpleName.equals("#disabled")) {
            return f304b;
        }
        return this;
    }

    public final String m496a() {
        return this._simpleName;
    }

    public final boolean m497b() {
        return this._simpleName.length() > 0;
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
        PropertyName propertyName = (PropertyName) obj;
        if (this._simpleName == null) {
            if (propertyName._simpleName != null) {
                return false;
            }
        } else if (!this._simpleName.equals(propertyName._simpleName)) {
            return false;
        }
        if (this._namespace != null) {
            return this._namespace.equals(propertyName._namespace);
        }
        if (propertyName._namespace != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this._namespace == null) {
            return this._simpleName.hashCode();
        }
        return this._namespace.hashCode() ^ this._simpleName.hashCode();
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        return "{" + this._namespace + "}" + this._simpleName;
    }
}
