package com.fasterxml.jackson.core.sym;

/* compiled from: lastDeliveredReceiptTimestampMs */
public final class Name3 extends Name {
    final int f9608c;
    final int f9609d;
    final int f9610e;

    Name3(String str, int i, int i2, int i3, int i4) {
        super(str, i);
        this.f9608c = i2;
        this.f9609d = i3;
        this.f9610e = i4;
    }

    public final boolean m10054a(int i) {
        return false;
    }

    public final boolean m10055a(int i, int i2) {
        return false;
    }

    public final boolean m10056a(int[] iArr, int i) {
        return i == 3 && iArr[0] == this.f9608c && iArr[1] == this.f9609d && iArr[2] == this.f9610e;
    }
}
