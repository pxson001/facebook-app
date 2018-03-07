package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: story_fbid */
public class SerializedString implements SerializableString, Serializable {
    protected char[] _quotedChars;
    protected byte[] _quotedUTF8Ref;
    protected byte[] _unquotedUTF8Ref;
    protected final String _value;
    protected transient String f4045a;

    public SerializedString(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this._value = str;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f4045a = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeUTF(this._value);
    }

    protected Object readResolve() {
        return new SerializedString(this.f4045a);
    }

    public final String mo1050a() {
        return this._value;
    }

    public final int mo1051b() {
        return this._value.length();
    }

    public final char[] mo1052c() {
        char[] cArr = this._quotedChars;
        if (cArr != null) {
            return cArr;
        }
        cArr = JsonStringEncoder.a().a(this._value);
        this._quotedChars = cArr;
        return cArr;
    }

    public final byte[] mo1053d() {
        byte[] bArr = this._unquotedUTF8Ref;
        if (bArr != null) {
            return bArr;
        }
        bArr = JsonStringEncoder.a().c(this._value);
        this._unquotedUTF8Ref = bArr;
        return bArr;
    }

    public final byte[] mo1054e() {
        byte[] bArr = this._quotedUTF8Ref;
        if (bArr != null) {
            return bArr;
        }
        bArr = JsonStringEncoder.a().b(this._value);
        this._quotedUTF8Ref = bArr;
        return bArr;
    }

    public final int mo1049a(byte[] bArr, int i) {
        Object obj = this._quotedUTF8Ref;
        if (obj == null) {
            obj = JsonStringEncoder.a().b(this._value);
            this._quotedUTF8Ref = obj;
        }
        int length = obj.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(obj, 0, bArr, i, length);
        return length;
    }

    public final String toString() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this._value.equals(((SerializedString) obj)._value);
    }
}
