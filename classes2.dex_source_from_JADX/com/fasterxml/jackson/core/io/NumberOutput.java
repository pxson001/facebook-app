package com.fasterxml.jackson.core.io;

/* compiled from: requestMessengerOnlyConfirmationCode */
public final class NumberOutput {
    static final String f7360a = "-9223372036854775808";
    static final char[] f7361b = new char[4000];
    static final char[] f7362c = new char[4000];
    static final byte[] f7363d = new byte[4000];
    static final String[] f7364e = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static final String[] f7365f = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    private static int f7366g = 1000000;
    private static int f7367h = 1000000000;
    private static long f7368i = 10000000000L;
    private static long f7369j = 1000;
    private static long f7370k = -2147483648L;
    private static long f7371l = 2147483647L;

    static {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            char c;
            char c2 = (char) (i2 + 48);
            if (i2 == 0) {
                c = '\u0000';
            } else {
                c = c2;
            }
            int i3 = 0;
            while (i3 < 10) {
                char c3;
                char c4 = (char) (i3 + 48);
                if (i2 == 0 && i3 == 0) {
                    c3 = '\u0000';
                } else {
                    c3 = c4;
                }
                int i4 = i;
                for (i = 0; i < 10; i++) {
                    char c5 = (char) (i + 48);
                    f7361b[i4] = c;
                    f7361b[i4 + 1] = c3;
                    f7361b[i4 + 2] = c5;
                    f7362c[i4] = c2;
                    f7362c[i4 + 1] = c4;
                    f7362c[i4 + 2] = c5;
                    i4 += 4;
                }
                i3++;
                i = i4;
            }
        }
        for (int i5 = 0; i5 < 4000; i5++) {
            f7363d[i5] = (byte) f7362c[i5];
        }
    }

    public static int m11997a(int i, char[] cArr, int i2) {
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return m11999a((long) i, cArr, i2);
            }
            int i3 = i2 + 1;
            cArr[i2] = '-';
            i = -i;
            i2 = i3;
        }
        if (i >= f7366g) {
            Object obj = i >= f7367h ? 1 : null;
            if (obj != null) {
                i -= f7367h;
                if (i >= f7367h) {
                    i -= f7367h;
                    i3 = i2 + 1;
                    cArr[i2] = '2';
                    i2 = i3;
                } else {
                    i3 = i2 + 1;
                    cArr[i2] = '1';
                    i2 = i3;
                }
            }
            i3 = i / 1000;
            int i4 = i - (i3 * 1000);
            int i5 = i3 / 1000;
            int i6 = i3 - (i5 * 1000);
            if (obj != null) {
                i3 = m12007c(i5, cArr, i2);
            } else {
                i3 = m12004b(i5, cArr, i2);
            }
            return m12007c(i4, cArr, m12007c(i6, cArr, i3));
        } else if (i >= 1000) {
            i3 = i / 1000;
            return m12007c(i - (i3 * 1000), cArr, m12004b(i3, cArr, i2));
        } else if (i >= 10) {
            return m12004b(i, cArr, i2);
        } else {
            i3 = i2 + 1;
            cArr[i2] = (char) (i + 48);
            return i3;
        }
    }

    public static int m11996a(int i, byte[] bArr, int i2) {
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return m11998a((long) i, bArr, i2);
            }
            int i3 = i2 + 1;
            bArr[i2] = (byte) 45;
            i = -i;
            i2 = i3;
        }
        if (i >= f7366g) {
            Object obj = i >= f7367h ? 1 : null;
            if (obj != null) {
                i -= f7367h;
                if (i >= f7367h) {
                    i -= f7367h;
                    i3 = i2 + 1;
                    bArr[i2] = (byte) 50;
                    i2 = i3;
                } else {
                    i3 = i2 + 1;
                    bArr[i2] = (byte) 49;
                    i2 = i3;
                }
            }
            i3 = i / 1000;
            int i4 = i - (i3 * 1000);
            int i5 = i3 / 1000;
            int i6 = i3 - (i5 * 1000);
            if (obj != null) {
                i3 = m12006c(i5, bArr, i2);
            } else {
                i3 = m12003b(i5, bArr, i2);
            }
            return m12006c(i4, bArr, m12006c(i6, bArr, i3));
        } else if (i >= 1000) {
            i3 = i / 1000;
            return m12006c(i - (i3 * 1000), bArr, m12003b(i3, bArr, i2));
        } else if (i >= 10) {
            return m12003b(i, bArr, i2);
        } else {
            i3 = i2 + 1;
            bArr[i2] = (byte) (i + 48);
            return i3;
        }
    }

    public static int m11999a(long j, char[] cArr, int i) {
        int length;
        if (j < 0) {
            if (j > f7370k) {
                return m11997a((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                length = f7360a.length();
                f7360a.getChars(0, length, cArr, i);
                return i + length;
            }
            length = i + 1;
            cArr[i] = '-';
            j = -j;
            i = length;
        } else if (j <= f7371l) {
            return m11997a((int) j, cArr, i);
        }
        int b = i + m12005b(j);
        length = b;
        while (j > f7371l) {
            length -= 3;
            long j2 = j / f7369j;
            m12007c((int) (j - (f7369j * j2)), cArr, length);
            j = j2;
        }
        int i2 = length;
        length = (int) j;
        while (length >= 1000) {
            int i3 = i2 - 3;
            i2 = length / 1000;
            m12007c(length - (i2 * 1000), cArr, i3);
            length = i2;
            i2 = i3;
        }
        m12004b(length, cArr, i);
        return b;
    }

    public static int m11998a(long j, byte[] bArr, int i) {
        int length;
        int i2;
        int i3;
        if (j < 0) {
            if (j > f7370k) {
                return m11996a((int) j, bArr, i);
            }
            if (j == Long.MIN_VALUE) {
                length = f7360a.length();
                i2 = 0;
                i3 = i;
                while (i2 < length) {
                    i = i3 + 1;
                    bArr[i3] = (byte) f7360a.charAt(i2);
                    i2++;
                    i3 = i;
                }
                return i3;
            }
            i2 = i + 1;
            bArr[i] = (byte) 45;
            j = -j;
            i = i2;
        } else if (j <= f7371l) {
            return m11996a((int) j, bArr, i);
        }
        i3 = i + m12005b(j);
        i2 = i3;
        while (j > f7371l) {
            i2 -= 3;
            long j2 = j / f7369j;
            m12006c((int) (j - (f7369j * j2)), bArr, i2);
            j = j2;
        }
        length = i2;
        i2 = (int) j;
        while (i2 >= 1000) {
            int i4 = length - 3;
            length = i2 / 1000;
            m12006c(i2 - (length * 1000), bArr, i4);
            i2 = length;
            length = i4;
        }
        m12003b(i2, bArr, i);
        return i3;
    }

    public static String m12001a(int i) {
        if (i < f7364e.length) {
            if (i >= 0) {
                return f7364e[i];
            }
            int i2 = (-i) - 1;
            if (i2 < f7365f.length) {
                return f7365f[i2];
            }
        }
        return Integer.toString(i);
    }

    public static String m12002a(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            return Long.toString(j);
        }
        return m12001a((int) j);
    }

    public static String m12000a(double d) {
        return Double.toString(d);
    }

    private static int m12004b(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = f7361b[i3];
        if (c != '\u0000') {
            i3 = i2 + 1;
            cArr[i2] = c;
            i2 = i3;
        }
        int i5 = i4 + 1;
        char c2 = f7361b[i4];
        if (c2 != '\u0000') {
            i3 = i2 + 1;
            cArr[i2] = c2;
            i2 = i3;
        }
        i3 = i2 + 1;
        cArr[i2] = f7361b[i5];
        return i3;
    }

    private static int m12003b(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = f7361b[i3];
        if (c != '\u0000') {
            i3 = i2 + 1;
            bArr[i2] = (byte) c;
            i2 = i3;
        }
        int i5 = i4 + 1;
        char c2 = f7361b[i4];
        if (c2 != '\u0000') {
            i3 = i2 + 1;
            bArr[i2] = (byte) c2;
            i2 = i3;
        }
        i3 = i2 + 1;
        bArr[i2] = (byte) f7361b[i5];
        return i3;
    }

    private static int m12007c(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        cArr[i2] = f7362c[i3];
        i3 = i4 + 1;
        int i6 = i5 + 1;
        cArr[i4] = f7362c[i5];
        i4 = i3 + 1;
        cArr[i3] = f7362c[i6];
        return i4;
    }

    private static int m12006c(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        bArr[i2] = f7363d[i3];
        i3 = i4 + 1;
        int i6 = i5 + 1;
        bArr[i4] = f7363d[i5];
        i4 = i3 + 1;
        bArr[i3] = f7363d[i6];
        return i4;
    }

    private static int m12005b(long j) {
        int i = 10;
        for (long j2 = f7368i; j >= j2 && i != 19; j2 = (j2 << 1) + (j2 << 3)) {
            i++;
        }
        return i;
    }
}
