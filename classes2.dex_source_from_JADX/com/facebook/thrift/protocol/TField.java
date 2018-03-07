package com.facebook.thrift.protocol;

/* compiled from: fm.last.android.playbackcomplete */
public class TField {
    public final String f23577a;
    public final byte f23578b;
    public final short f23579c;

    public TField() {
        this("", (byte) 0, (short) 0);
    }

    public TField(String str, byte b, short s) {
        this.f23577a = str;
        this.f23578b = b;
        this.f23579c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f23577a + "' type:" + this.f23578b + " field-id:" + this.f23579c + ">";
    }
}
