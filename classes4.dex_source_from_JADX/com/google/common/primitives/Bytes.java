package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckReturnValue;

@GwtCompatible
@CheckReturnValue
/* compiled from: seen = ? */
public final class Bytes {
    private Bytes() {
    }

    public static int m3147a(byte[] bArr, byte[] bArr2) {
        Preconditions.checkNotNull(bArr, "array");
        Preconditions.checkNotNull(bArr2, "target");
        if (bArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (bArr.length - bArr2.length) + 1) {
            int i2 = 0;
            while (i2 < bArr2.length) {
                if (bArr[i + i2] == bArr2[i2]) {
                    i2++;
                } else {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }
}
