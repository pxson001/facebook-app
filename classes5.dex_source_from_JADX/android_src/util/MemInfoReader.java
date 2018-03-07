package android_src.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: treehouse_group_info */
public class MemInfoReader {
    byte[] f1651a = new byte[1024];
    public long f1652b;
    private long f1653c;
    private long f1654d;

    private static boolean m2232a(byte[] bArr, int i, String str) {
        int length = str.length();
        if (i + length >= bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i + i2] != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    private static long m2231a(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != (byte) 10) {
            if (bArr[i] < (byte) 48 || bArr[i] > (byte) 57) {
                i++;
            } else {
                int i2 = i + 1;
                while (i2 < bArr.length && bArr[i2] >= (byte) 48 && bArr[i2] <= (byte) 57) {
                    i2++;
                }
                return ((long) Integer.parseInt(new String(bArr, 0, i, i2 - i))) * 1024;
            }
        }
        return 0;
    }

    public final void m2233a() {
        int i = 0;
        try {
            this.f1652b = 0;
            this.f1653c = 0;
            this.f1654d = 0;
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            int read = fileInputStream.read(this.f1651a);
            fileInputStream.close();
            int length = this.f1651a.length;
            int i2 = 0;
            while (i < read && i2 < 3) {
                if (m2232a(this.f1651a, i, "MemTotal")) {
                    i += 8;
                    this.f1652b = m2231a(this.f1651a, i);
                    i2++;
                } else if (m2232a(this.f1651a, i, "MemFree")) {
                    i += 7;
                    this.f1653c = m2231a(this.f1651a, i);
                    i2++;
                } else if (m2232a(this.f1651a, i, "Cached")) {
                    i += 6;
                    this.f1654d = m2231a(this.f1651a, i);
                    i2++;
                }
                while (i < length && this.f1651a[i] != (byte) 10) {
                    i++;
                }
                i++;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }
}
