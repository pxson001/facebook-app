package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;

/* compiled from: TRENDING_DEMOGRAPHICS_LIVE */
public final class GifFormatChecker {
    private static final byte[] f13556a = new byte[]{(byte) 0, (byte) 33, (byte) -7, (byte) 4};
    private static final byte[] f13557b = new byte[]{(byte) 0, (byte) 44};
    private static final byte[] f13558c = new byte[]{(byte) 0, (byte) 33};

    private GifFormatChecker() {
    }

    public static boolean m22834a(InputStream inputStream) {
        byte[] bArr = new byte[10];
        try {
            inputStream.read(bArr, 0, 10);
            int i = 0;
            int i2 = 0;
            while (inputStream.read(bArr, i2, 1) > 0) {
                if (m22835a(bArr, i2 + 1, f13556a) && (m22835a(bArr, i2 + 9, f13557b) || m22835a(bArr, i2 + 9, f13558c))) {
                    i++;
                    if (i > 1) {
                        return true;
                    }
                }
                i2 = (i2 + 1) % 10;
            }
            return false;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @VisibleForTesting
    private static boolean m22835a(byte[] bArr, int i, byte[] bArr2) {
        Preconditions.a(bArr);
        Preconditions.a(bArr2);
        Preconditions.a(i >= 0);
        if (bArr2.length > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[(i2 + i) % bArr.length] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
