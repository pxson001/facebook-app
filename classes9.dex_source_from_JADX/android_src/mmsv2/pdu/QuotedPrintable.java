package android_src.mmsv2.pdu;

import java.io.ByteArrayOutputStream;

/* compiled from: service_center */
public class QuotedPrintable {
    private static byte f3883a = (byte) 61;

    public static final byte[] m3724a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == f3883a) {
                try {
                    if ('\r' == ((char) bArr[i + 1]) && '\n' == ((char) bArr[i + 2])) {
                        i += 2;
                    } else {
                        i++;
                        int digit = Character.digit((char) bArr[i], 16);
                        i++;
                        int digit2 = Character.digit((char) bArr[i], 16);
                        if (digit == -1 || digit2 == -1) {
                            return null;
                        }
                        byteArrayOutputStream.write((char) ((digit << 4) + digit2));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return null;
                }
            }
            byteArrayOutputStream.write(b);
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
