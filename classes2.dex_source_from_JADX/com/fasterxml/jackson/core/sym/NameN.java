package com.fasterxml.jackson.core.sym;

/* compiled from: graphql_story */
public final class NameN extends Name {
    final int[] f21919c;
    final int f21920d;

    NameN(String str, int i, int[] iArr, int i2) {
        super(str, i);
        if (i2 < 3) {
            throw new IllegalArgumentException("Qlen must >= 3");
        }
        this.f21919c = iArr;
        this.f21920d = i2;
    }

    public final boolean mo3210a(int i) {
        return false;
    }

    public final boolean mo3211a(int i, int i2) {
        return false;
    }

    public final boolean mo3212a(int[] iArr, int i) {
        if (i != this.f21920d) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != this.f21919c[i2]) {
                return false;
            }
        }
        return true;
    }
}
