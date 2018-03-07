package com.fasterxml.jackson.core;

import java.io.Serializable;

/* compiled from: topFriends */
public class JsonLocation implements Serializable {
    public static final JsonLocation f915a = new JsonLocation("N/A", -1, -1, -1, -1);
    private static final long serialVersionUID = 1;
    final int _columnNr;
    final int _lineNr;
    public final long _totalBytes;
    public final long _totalChars;
    final transient Object f916b;

    public JsonLocation(Object obj, long j, int i, int i2) {
        this(obj, -1, j, i, i2);
    }

    public JsonLocation(Object obj, long j, long j2, int i, int i2) {
        this.f916b = obj;
        this._totalBytes = j;
        this._totalChars = j2;
        this._lineNr = i;
        this._columnNr = i2;
    }

    public final long m1253a() {
        return this._totalChars;
    }

    private long m1252b() {
        return this._totalBytes;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(80);
        stringBuilder.append("[Source: ");
        if (this.f916b == null) {
            stringBuilder.append("UNKNOWN");
        } else {
            stringBuilder.append(this.f916b.toString());
        }
        stringBuilder.append("; line: ");
        stringBuilder.append(this._lineNr);
        stringBuilder.append(", column: ");
        stringBuilder.append(this._columnNr);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public int hashCode() {
        return ((((this.f916b == null ? 1 : this.f916b.hashCode()) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        if (this.f916b == null) {
            if (jsonLocation.f916b != null) {
                return false;
            }
        } else if (!this.f916b.equals(jsonLocation.f916b)) {
            return false;
        }
        if (this._lineNr == jsonLocation._lineNr && this._columnNr == jsonLocation._columnNr && this._totalChars == jsonLocation._totalChars && this._totalBytes == jsonLocation._totalBytes) {
            return true;
        }
        return false;
    }
}
