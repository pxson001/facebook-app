package android_src.mmsv2.pdu;

/* compiled from: setPayload failed */
public class Base64 {
    public static byte[] f3815a = new byte[255];

    static {
        int i;
        for (i = 0; i < 255; i++) {
            f3815a[i] = (byte) -1;
        }
        for (i = 90; i >= 65; i--) {
            f3815a[i] = (byte) (i - 65);
        }
        for (i = 122; i >= 97; i--) {
            f3815a[i] = (byte) ((i - 97) + 26);
        }
        for (i = 57; i >= 48; i--) {
            f3815a[i] = (byte) ((i - 48) + 52);
        }
        f3815a[43] = (byte) 62;
        f3815a[47] = (byte) 63;
    }

    public static byte[] m3596a(byte[] bArr) {
        int i = 0;
        byte[] b = m3597b(bArr);
        if (b.length == 0) {
            return new byte[0];
        }
        int length = b.length / 4;
        int length2 = b.length;
        while (b[length2 - 1] == (byte) 61) {
            length2--;
            if (length2 == 0) {
                return new byte[0];
            }
        }
        byte[] bArr2 = new byte[(length2 - length)];
        int i2 = 0;
        while (i < length) {
            int i3 = i * 4;
            byte b2 = b[i3 + 2];
            byte b3 = b[i3 + 3];
            byte b4 = f3815a[b[i3]];
            byte b5 = f3815a[b[i3 + 1]];
            if (b2 != (byte) 61 && b3 != (byte) 61) {
                b2 = f3815a[b2];
                b3 = f3815a[b3];
                bArr2[i2] = (byte) ((b4 << 2) | (b5 >> 4));
                bArr2[i2 + 1] = (byte) (((b5 & 15) << 4) | ((b2 >> 2) & 15));
                bArr2[i2 + 2] = (byte) ((b2 << 6) | b3);
            } else if (b2 == (byte) 61) {
                bArr2[i2] = (byte) ((b5 >> 4) | (b4 << 2));
            } else if (b3 == (byte) 61) {
                b2 = f3815a[b2];
                bArr2[i2] = (byte) ((b4 << 2) | (b5 >> 4));
                bArr2[i2 + 1] = (byte) (((b5 & 15) << 4) | ((b2 >> 2) & 15));
            }
            i2 += 3;
            i++;
        }
        return bArr2;
    }

    private static byte[] m3597b(byte[] bArr) {
        Object obj = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            Object obj2 = 1;
            if (b != (byte) 61 && f3815a[b] == (byte) -1) {
                obj2 = null;
            }
            if (obj2 != null) {
                int i3 = i + 1;
                obj[i] = bArr[i2];
                i = i3;
            }
        }
        Object obj3 = new byte[i];
        System.arraycopy(obj, 0, obj3, 0, i);
        return obj3;
    }
}
