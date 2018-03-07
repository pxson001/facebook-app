package com.facebook.livephotos.exoplayer.extractor.ogg;

import android.util.Log;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.Arrays;

/* compiled from: page_follow_see_first_success */
final class VorbisUtil {

    /* compiled from: page_follow_see_first_success */
    public final class CodeBook {
        public final int f7305a;
        public final int f7306b;
        public final long[] f7307c;
        public final int f7308d;
        public final boolean f7309e;

        public CodeBook(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f7305a = i;
            this.f7306b = i2;
            this.f7307c = jArr;
            this.f7308d = i3;
            this.f7309e = z;
        }
    }

    /* compiled from: page_follow_see_first_success */
    public final class CommentHeader {
        public final String f7310a;
        public final String[] f7311b;
        public final int f7312c;

        public CommentHeader(String str, String[] strArr, int i) {
            this.f7310a = str;
            this.f7311b = strArr;
            this.f7312c = i;
        }
    }

    /* compiled from: page_follow_see_first_success */
    public final class Mode {
        public final boolean f7313a;
        public final int f7314b;
        public final int f7315c;
        public final int f7316d;

        public Mode(boolean z, int i, int i2, int i3) {
            this.f7313a = z;
            this.f7314b = i;
            this.f7315c = i2;
            this.f7316d = i3;
        }
    }

    /* compiled from: page_follow_see_first_success */
    public final class VorbisIdHeader {
        public final long f7317a;
        public final int f7318b;
        public final long f7319c;
        public final int f7320d;
        public final int f7321e;
        public final int f7322f;
        public final int f7323g;
        public final int f7324h;
        public final boolean f7325i;
        public final byte[] f7326j;

        public VorbisIdHeader(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.f7317a = j;
            this.f7318b = i;
            this.f7319c = j2;
            this.f7320d = i2;
            this.f7321e = i3;
            this.f7322f = i4;
            this.f7323g = i5;
            this.f7324h = i6;
            this.f7325i = z;
            this.f7326j = bArr;
        }
    }

    VorbisUtil() {
    }

    public static int m9076a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static VorbisIdHeader m9078a(ParsableByteArray parsableByteArray) {
        m9080a(1, parsableByteArray, false);
        long l = parsableByteArray.m9348l();
        int f = parsableByteArray.m9343f();
        long l2 = parsableByteArray.m9348l();
        int n = parsableByteArray.m9350n();
        int n2 = parsableByteArray.m9350n();
        int n3 = parsableByteArray.m9350n();
        int f2 = parsableByteArray.m9343f();
        return new VorbisIdHeader(l, f, l2, n, n2, n3, (int) Math.pow(2.0d, (double) (f2 & 15)), (int) Math.pow(2.0d, (double) ((f2 & 240) >> 4)), (parsableByteArray.m9343f() & 1) > 0, Arrays.copyOf(parsableByteArray.f7731a, parsableByteArray.f7733c));
    }

    public static CommentHeader m9082b(ParsableByteArray parsableByteArray) {
        int i = 0;
        m9080a(3, parsableByteArray, false);
        String d = parsableByteArray.m9341d((int) parsableByteArray.m9348l());
        int length = d.length() + 11;
        long l = parsableByteArray.m9348l();
        String[] strArr = new String[((int) l)];
        length += 4;
        while (((long) i) < l) {
            length += 4;
            strArr[i] = parsableByteArray.m9341d((int) parsableByteArray.m9348l());
            length += strArr[i].length();
            i++;
        }
        if ((parsableByteArray.m9343f() & 1) != 0) {
            return new CommentHeader(d, strArr, length + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static boolean m9080a(int i, ParsableByteArray parsableByteArray, boolean z) {
        if (parsableByteArray.m9343f() != i) {
            if (z) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i));
        } else if (parsableByteArray.m9343f() == 118 && parsableByteArray.m9343f() == 111 && parsableByteArray.m9343f() == 114 && parsableByteArray.m9343f() == 98 && parsableByteArray.m9343f() == 105 && parsableByteArray.m9343f() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }

    public static Mode[] m9081a(ParsableByteArray parsableByteArray, int i) {
        int i2;
        int i3 = 0;
        m9080a(5, parsableByteArray, false);
        int f = parsableByteArray.m9343f() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.f7731a);
        vorbisBitArray.m9075b(parsableByteArray.f7732b * 8);
        for (i2 = 0; i2 < f; i2++) {
            m9085d(vorbisBitArray);
        }
        i2 = vorbisBitArray.m9072a(6) + 1;
        while (i3 < i2) {
            if (vorbisBitArray.m9072a(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
            i3++;
        }
        m9084c(vorbisBitArray);
        m9083b(vorbisBitArray);
        m9079a(i, vorbisBitArray);
        int a = vorbisBitArray.m9072a(6) + 1;
        Mode[] modeArr = new Mode[a];
        for (int i4 = 0; i4 < a; i4++) {
            modeArr[i4] = new Mode(vorbisBitArray.m9073a(), vorbisBitArray.m9072a(16), vorbisBitArray.m9072a(16), vorbisBitArray.m9072a(8));
        }
        Mode[] modeArr2 = modeArr;
        if (vorbisBitArray.m9073a()) {
            return modeArr2;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    private static void m9079a(int i, VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m9072a(6) + 1;
        for (int i2 = 0; i2 < a; i2++) {
            int a2 = vorbisBitArray.m9072a(16);
            switch (a2) {
                case 0:
                    int i3;
                    if (vorbisBitArray.m9073a()) {
                        a2 = vorbisBitArray.m9072a(4) + 1;
                    } else {
                        a2 = 1;
                    }
                    if (vorbisBitArray.m9073a()) {
                        int a3 = vorbisBitArray.m9072a(8) + 1;
                        for (i3 = 0; i3 < a3; i3++) {
                            vorbisBitArray.m9075b(m9076a(i - 1));
                            vorbisBitArray.m9075b(m9076a(i - 1));
                        }
                    }
                    if (vorbisBitArray.m9072a(2) == 0) {
                        if (a2 > 1) {
                            for (i3 = 0; i3 < i; i3++) {
                                vorbisBitArray.m9075b(4);
                            }
                        }
                        for (i3 = 0; i3 < a2; i3++) {
                            vorbisBitArray.m9075b(8);
                            vorbisBitArray.m9075b(8);
                            vorbisBitArray.m9075b(8);
                        }
                        break;
                    }
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                default:
                    Log.e("VorbisUtil", "mapping type other than 0 not supported: " + a2);
                    break;
            }
        }
    }

    private static void m9083b(VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m9072a(6) + 1;
        for (int i = 0; i < a; i++) {
            if (vorbisBitArray.m9072a(16) > 2) {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
            int i2;
            vorbisBitArray.m9075b(24);
            vorbisBitArray.m9075b(24);
            vorbisBitArray.m9075b(24);
            int a2 = vorbisBitArray.m9072a(6) + 1;
            vorbisBitArray.m9075b(8);
            int[] iArr = new int[a2];
            for (i2 = 0; i2 < a2; i2++) {
                int a3;
                int a4 = vorbisBitArray.m9072a(3);
                if (vorbisBitArray.m9073a()) {
                    a3 = vorbisBitArray.m9072a(5);
                } else {
                    a3 = 0;
                }
                iArr[i2] = (a3 * 8) + a4;
            }
            for (i2 = 0; i2 < a2; i2++) {
                for (a3 = 0; a3 < 8; a3++) {
                    if ((iArr[i2] & (1 << a3)) != 0) {
                        vorbisBitArray.m9075b(8);
                    }
                }
            }
        }
    }

    private static void m9084c(VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m9072a(6) + 1;
        for (int i = 0; i < a; i++) {
            int a2 = vorbisBitArray.m9072a(16);
            int a3;
            switch (a2) {
                case 0:
                    vorbisBitArray.m9075b(8);
                    vorbisBitArray.m9075b(16);
                    vorbisBitArray.m9075b(16);
                    vorbisBitArray.m9075b(6);
                    vorbisBitArray.m9075b(8);
                    a3 = vorbisBitArray.m9072a(4) + 1;
                    for (a2 = 0; a2 < a3; a2++) {
                        vorbisBitArray.m9075b(8);
                    }
                    break;
                case 1:
                    int a4;
                    int a5 = vorbisBitArray.m9072a(5);
                    a2 = -1;
                    int[] iArr = new int[a5];
                    for (a3 = 0; a3 < a5; a3++) {
                        iArr[a3] = vorbisBitArray.m9072a(4);
                        if (iArr[a3] > a2) {
                            a2 = iArr[a3];
                        }
                    }
                    int[] iArr2 = new int[(a2 + 1)];
                    for (a2 = 0; a2 < iArr2.length; a2++) {
                        iArr2[a2] = vorbisBitArray.m9072a(3) + 1;
                        a4 = vorbisBitArray.m9072a(2);
                        if (a4 > 0) {
                            vorbisBitArray.m9075b(8);
                        }
                        for (a3 = 0; a3 < (1 << a4); a3++) {
                            vorbisBitArray.m9075b(8);
                        }
                    }
                    vorbisBitArray.m9075b(2);
                    int a6 = vorbisBitArray.m9072a(4);
                    a2 = 0;
                    a4 = 0;
                    for (a3 = 0; a3 < a5; a3++) {
                        a4 += iArr2[iArr[a3]];
                        while (a2 < a4) {
                            vorbisBitArray.m9075b(a6);
                            a2++;
                        }
                    }
                    break;
                default:
                    throw new ParserException("floor type greater than 1 not decodable: " + a2);
            }
        }
    }

    private static CodeBook m9085d(VorbisBitArray vorbisBitArray) {
        int i = 0;
        if (vorbisBitArray.m9072a(24) != 5653314) {
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.m9074b());
        }
        int i2;
        int a = vorbisBitArray.m9072a(16);
        int a2 = vorbisBitArray.m9072a(24);
        long[] jArr = new long[a2];
        boolean a3 = vorbisBitArray.m9073a();
        if (a3) {
            int a4 = vorbisBitArray.m9072a(5) + 1;
            i2 = 0;
            while (i2 < a2) {
                int a5 = vorbisBitArray.m9072a(m9076a(a2 - i2));
                int i3 = i2;
                for (i2 = 0; i2 < a5 && i3 < a2; i2++) {
                    jArr[i3] = (long) a4;
                    i3++;
                }
                a4++;
                i2 = i3;
            }
        } else {
            boolean a6 = vorbisBitArray.m9073a();
            while (i < a2) {
                if (!a6 || vorbisBitArray.m9073a()) {
                    jArr[i] = (long) (vorbisBitArray.m9072a(5) + 1);
                } else {
                    jArr[i] = 0;
                }
                i++;
            }
        }
        i = vorbisBitArray.m9072a(4);
        if (i > 2) {
            throw new ParserException("lookup type greater than 2 not decodable: " + i);
        }
        if (i == 1 || i == 2) {
            long j;
            vorbisBitArray.m9075b(32);
            vorbisBitArray.m9075b(32);
            i2 = vorbisBitArray.m9072a(4) + 1;
            vorbisBitArray.m9075b(1);
            if (i != 1) {
                j = (long) (a2 * a);
            } else if (a != 0) {
                j = m9077a((long) a2, (long) a);
            } else {
                j = 0;
            }
            vorbisBitArray.m9075b((int) (j * ((long) i2)));
        }
        return new CodeBook(a, a2, jArr, i, a3);
    }

    private static long m9077a(long j, long j2) {
        return (long) Math.floor(Math.pow((double) j, 1.0d / ((double) j2)));
    }
}
