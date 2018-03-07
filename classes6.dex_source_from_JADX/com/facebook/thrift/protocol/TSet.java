package com.facebook.thrift.protocol;

/* compiled from: selected_privacy */
public final class TSet {
    public final byte f5054a;
    public final int f5055b;

    public TSet() {
        this((byte) 0, 0);
    }

    public TSet(byte b, int i) {
        this.f5054a = b;
        this.f5055b = i;
    }

    public TSet(TList tList) {
        this(tList.a, tList.b);
    }
}
