package com.facebook.livephotos.exoplayer.extractor.mp3;

import android.util.Pair;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.GaplessInfo;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.nio.charset.Charset;

/* compiled from: page_recommendation_error */
final class Id3Util {
    private static final int f7083a = Util.m9368c("ID3");
    private static final Charset[] f7084b = new Charset[]{Charset.forName("ISO-8859-1"), Charset.forName("UTF-16LE"), Charset.forName("UTF-16BE"), Charset.forName("UTF-8")};

    public static GaplessInfo m8951a(DefaultExtractorInput defaultExtractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        GaplessInfo gaplessInfo = null;
        int i = 0;
        while (true) {
            defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 10);
            parsableByteArray.m9337b(0);
            if (parsableByteArray.m9346j() == f7083a) {
                int f = parsableByteArray.m9343f();
                int f2 = parsableByteArray.m9343f();
                int f3 = parsableByteArray.m9343f();
                int r = parsableByteArray.m9354r();
                if (gaplessInfo == null) {
                    Object obj;
                    if (f2 == 255 || f < 2 || f > 4 || r > 3145728 || ((f == 2 && !((f3 & 63) == 0 && (f3 & 64) == 0)) || ((f == 3 && (f3 & 31) != 0) || (f == 4 && (f3 & 15) != 0)))) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        byte[] bArr = new byte[r];
                        defaultExtractorInput.m8846c(bArr, 0, r);
                        gaplessInfo = m8952a(new ParsableByteArray(bArr), f, f3);
                        i += r + 10;
                    }
                }
                defaultExtractorInput.m8845c(r);
                i += r + 10;
            } else {
                defaultExtractorInput.m8838a();
                defaultExtractorInput.m8845c(i);
                return gaplessInfo;
            }
        }
    }

    private static GaplessInfo m8952a(ParsableByteArray parsableByteArray, int i, int i2) {
        m8955b(parsableByteArray, i, i2);
        parsableByteArray.m9337b(0);
        int r;
        if (i != 3 || (i2 & 64) == 0) {
            if (i == 4 && (i2 & 64) != 0) {
                if (parsableByteArray.m9336b() < 4) {
                    return null;
                }
                r = parsableByteArray.m9354r();
                if (r < 6 || r > parsableByteArray.m9336b() + 4) {
                    return null;
                }
                parsableByteArray.m9337b(r);
            }
        } else if (parsableByteArray.m9336b() < 4) {
            return null;
        } else {
            r = parsableByteArray.m9355s();
            if (r > parsableByteArray.m9336b()) {
                return null;
            }
            if (r >= 6) {
                parsableByteArray.m9339c(2);
                int s = parsableByteArray.m9355s();
                parsableByteArray.m9337b(4);
                parsableByteArray.m9332a(parsableByteArray.f7733c - s);
                if (parsableByteArray.m9336b() < r) {
                    return null;
                }
            }
            parsableByteArray.m9339c(r);
        }
        while (true) {
            Pair a = m8950a(i, parsableByteArray);
            if (a == null) {
                return null;
            }
            if (((String) a.first).length() > 3) {
                GaplessInfo a2 = GaplessInfo.m8898a(((String) a.first).substring(3), (String) a.second);
                if (a2 != null) {
                    return a2;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.String, java.lang.String> m8950a(int r9, com.facebook.livephotos.exoplayer.util.ParsableByteArray r10) {
        /*
        r8 = 2;
        r3 = 1;
        r4 = 0;
        r7 = 4;
        r1 = 0;
    L_0x0005:
        if (r9 != r8) goto L_0x003f;
    L_0x0007:
        r0 = r10.m9336b();
        r2 = 6;
        if (r0 >= r2) goto L_0x0010;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = 3;
        r2 = "US-ASCII";
        r2 = java.nio.charset.Charset.forName(r2);
        r2 = r10.m9330a(r0, r2);
        r0 = "\u0000\u0000\u0000";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x0025;
    L_0x0023:
        r0 = r1;
        goto L_0x000f;
    L_0x0025:
        r0 = r10.m9346j();
        if (r0 == 0) goto L_0x0031;
    L_0x002b:
        r5 = r10.m9336b();
        if (r0 <= r5) goto L_0x0033;
    L_0x0031:
        r0 = r1;
        goto L_0x000f;
    L_0x0033:
        r5 = "COM";
        r2 = r2.equals(r5);
        if (r2 != 0) goto L_0x0090;
    L_0x003b:
        r10.m9339c(r0);
        goto L_0x0005;
    L_0x003f:
        r0 = r10.m9336b();
        r2 = 10;
        if (r0 >= r2) goto L_0x0049;
    L_0x0047:
        r0 = r1;
        goto L_0x000f;
    L_0x0049:
        r0 = "US-ASCII";
        r0 = java.nio.charset.Charset.forName(r0);
        r5 = r10.m9330a(r7, r0);
        r0 = "\u0000\u0000\u0000\u0000";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x005b:
        r0 = r1;
        goto L_0x000f;
    L_0x005d:
        if (r9 != r7) goto L_0x006f;
    L_0x005f:
        r0 = r10.m9354r();
    L_0x0063:
        if (r0 == 0) goto L_0x006d;
    L_0x0065:
        r2 = r10.m9336b();
        r2 = r2 + -2;
        if (r0 <= r2) goto L_0x0074;
    L_0x006d:
        r0 = r1;
        goto L_0x000f;
    L_0x006f:
        r0 = r10.m9355s();
        goto L_0x0063;
    L_0x0074:
        r2 = r10.m9344g();
        if (r9 != r7) goto L_0x007e;
    L_0x007a:
        r6 = r2 & 12;
        if (r6 != 0) goto L_0x0085;
    L_0x007e:
        r6 = 3;
        if (r9 != r6) goto L_0x009e;
    L_0x0081:
        r2 = r2 & 192;
        if (r2 == 0) goto L_0x009e;
    L_0x0085:
        r2 = r3;
    L_0x0086:
        if (r2 != 0) goto L_0x003b;
    L_0x0088:
        r2 = "COMM";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x003b;
    L_0x0090:
        r2 = r10.m9343f();
        if (r2 < 0) goto L_0x009b;
    L_0x0096:
        r5 = f7084b;
        r5 = r5.length;
        if (r2 < r5) goto L_0x00a0;
    L_0x009b:
        r0 = r1;
        goto L_0x000f;
    L_0x009e:
        r2 = r4;
        goto L_0x0086;
    L_0x00a0:
        r5 = f7084b;
        r2 = r5[r2];
        r0 = r0 + -1;
        r0 = r10.m9330a(r0, r2);
        r2 = "\u0000";
        r0 = r0.split(r2);
        r2 = r0.length;
        if (r2 != r8) goto L_0x00bd;
    L_0x00b3:
        r1 = r0[r4];
        r0 = r0[r3];
        r0 = android.util.Pair.create(r1, r0);
        goto L_0x000f;
    L_0x00bd:
        r0 = r1;
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.extractor.mp3.Id3Util.a(int, com.facebook.livephotos.exoplayer.util.ParsableByteArray):android.util.Pair<java.lang.String, java.lang.String>");
    }

    private static boolean m8955b(ParsableByteArray parsableByteArray, int i, int i2) {
        if (i != 4) {
            if ((i2 & 128) != 0) {
                Object obj = parsableByteArray.f7731a;
                int length = obj.length;
                int i3 = false;
                while (i3 + 1 < length) {
                    if ((obj[i3] & 255) == 255 && obj[i3 + 1] == (byte) 0) {
                        System.arraycopy(obj, i3 + 2, obj, i3 + 1, (length - i3) - 2);
                        length--;
                    }
                    i3++;
                }
                parsableByteArray.m9332a(length);
            }
        } else if (m8953a(parsableByteArray, false)) {
            m8954b(parsableByteArray, false);
        } else if (!m8953a(parsableByteArray, true)) {
            return false;
        } else {
            m8954b(parsableByteArray, true);
        }
        return true;
    }

    private static boolean m8953a(ParsableByteArray parsableByteArray, boolean z) {
        parsableByteArray.m9337b(0);
        while (parsableByteArray.m9336b() >= 10) {
            if (parsableByteArray.m9349m() == 0) {
                return true;
            }
            long k = parsableByteArray.m9347k();
            if (!z) {
                if ((8421504 & k) != 0) {
                    return false;
                }
                k = (((k >> 24) & 127) << 21) | (((k & 127) | (((k >> 8) & 127) << 7)) | (((k >> 16) & 127) << 14));
            }
            if (k > ((long) (parsableByteArray.m9336b() - 2))) {
                return false;
            }
            if ((parsableByteArray.m9344g() & 1) != 0 && parsableByteArray.m9336b() < 4) {
                return false;
            }
            parsableByteArray.m9339c((int) k);
        }
        return true;
    }

    private static void m8954b(ParsableByteArray parsableByteArray, boolean z) {
        parsableByteArray.m9337b(0);
        Object obj = parsableByteArray.f7731a;
        while (parsableByteArray.m9336b() >= 10 && parsableByteArray.m9349m() != 0) {
            int i;
            int i2;
            int s = z ? parsableByteArray.m9355s() : parsableByteArray.m9354r();
            int g = parsableByteArray.m9344g();
            if ((g & 1) != 0) {
                i = parsableByteArray.f7732b;
                System.arraycopy(obj, i + 4, obj, i, parsableByteArray.m9336b() - 4);
                i = s - 4;
                i2 = g & -2;
                parsableByteArray.m9332a(parsableByteArray.f7733c - 4);
            } else {
                i2 = g;
                i = s;
            }
            if ((i2 & 2) != 0) {
                s = parsableByteArray.f7732b + 1;
                int i3 = 0;
                int i4 = s;
                while (i3 + 1 < i) {
                    if ((obj[s - 1] & 255) == 255 && obj[s] == (byte) 0) {
                        s++;
                        i--;
                    }
                    int i5 = i4 + 1;
                    int i6 = s + 1;
                    obj[i4] = obj[s];
                    i3++;
                    i4 = i5;
                    s = i6;
                }
                parsableByteArray.m9332a(parsableByteArray.f7733c - (s - i4));
                System.arraycopy(obj, s, obj, i4, parsableByteArray.m9336b() - s);
                s = i2 & -3;
            } else {
                s = i2;
            }
            if (s != g || z) {
                i2 = parsableByteArray.f7732b - 6;
                obj[i2] = (byte) ((i >> 21) & 127);
                obj[i2 + 1] = (byte) ((i >> 14) & 127);
                obj[i2 + 2] = (byte) ((i >> 7) & 127);
                obj[i2 + 3] = (byte) (i & 127);
                obj[i2 + 4] = (byte) (s >> 8);
                obj[i2 + 5] = (byte) (s & 255);
            }
            parsableByteArray.m9339c(i);
        }
    }

    private Id3Util() {
    }
}
