package org.whispersystems.libsignal.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;

/* compiled from: actionButtonText */
public class ByteUtil {
    public static byte[] m22406a(byte[]... bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] write : bArr) {
                byteArrayOutputStream.write(write);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[][] m22407a(byte[] bArr, int i, int i2) {
        byte[][] bArr2 = new byte[2][];
        bArr2[0] = new byte[i];
        System.arraycopy(bArr, 0, bArr2[0], 0, i);
        bArr2[1] = new byte[i2];
        System.arraycopy(bArr, i, bArr2[1], 0, i2);
        return bArr2;
    }

    public static byte[][] m22408a(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null || i < 0 || i2 < 0 || i3 < 0 || bArr.length < (i + i2) + i3) {
            String str;
            StringBuilder stringBuilder = new StringBuilder("Input too small: ");
            if (bArr == null) {
                str = null;
            } else {
                int length = bArr.length;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i4 = 0; i4 < length; i4++) {
                    byte b = bArr[0 + i4];
                    stringBuffer.append("(byte)0x");
                    stringBuffer.append(Hex.f21478a[(b >> 4) & 15]);
                    stringBuffer.append(Hex.f21478a[b & 15]);
                    stringBuffer.append(", ");
                }
                str = stringBuffer.toString();
            }
            throw new ParseException(stringBuilder.append(str).toString(), 0);
        }
        r0 = new byte[3][];
        System.arraycopy(bArr, 0, r0[0], 0, i);
        r0[1] = new byte[i2];
        System.arraycopy(bArr, i, r0[1], 0, i2);
        r0[2] = new byte[i3];
        System.arraycopy(bArr, i + i2, r0[2], 0, i3);
        return r0;
    }

    public static byte[] m22405a(byte[] bArr, int i) {
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        return obj;
    }

    public static byte m22403a(int i, int i2) {
        return (byte) (((i << 4) | i2) & 255);
    }

    public static int m22404a(byte b) {
        return (b & 255) >> 4;
    }

    public static int m22409b(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) i2;
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i] = (byte) (i2 >> 24);
        return 4;
    }
}
