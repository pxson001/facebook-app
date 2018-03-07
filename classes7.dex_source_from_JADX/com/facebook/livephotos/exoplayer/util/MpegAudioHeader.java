package com.facebook.livephotos.exoplayer.util;

/* compiled from: option_display */
public final class MpegAudioHeader {
    private static final String[] f7696h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] f7697i = new int[]{44100, 48000, 32000};
    private static final int[] f7698j = new int[]{32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448};
    private static final int[] f7699k = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    private static final int[] f7700l = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};
    private static final int[] f7701m = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
    private static final int[] f7702n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public int f7703a;
    public String f7704b;
    public int f7705c;
    public int f7706d;
    public int f7707e;
    public int f7708f;
    public int f7709g;

    public static int m9307a(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = f7697i[i5];
        if (i2 == 2) {
            i5 = i6 / 2;
        } else if (i2 == 0) {
            i5 = i6 / 4;
        } else {
            i5 = i6;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? f7698j[i4 - 1] : f7699k[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? f7700l[i4 - 1] : f7701m[i4 - 1];
        } else {
            i4 = f7702n[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    public static boolean m9309a(int i, MpegAudioHeader mpegAudioHeader) {
        int i2 = 2;
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i3 = (i >>> 19) & 3;
        if (i3 == 1) {
            return false;
        }
        int i4 = (i >>> 17) & 3;
        if (i4 == 0) {
            return false;
        }
        int i5 = (i >>> 12) & 15;
        if (i5 == 0 || i5 == 15) {
            return false;
        }
        int i6 = (i >>> 10) & 3;
        if (i6 == 3) {
            return false;
        }
        int i7;
        int i8 = f7697i[i6];
        if (i3 == 2) {
            i8 /= 2;
        } else if (i3 == 0) {
            i8 /= 4;
        }
        int i9 = (i >>> 9) & 1;
        if (i4 == 3) {
            i7 = i3 == 3 ? f7698j[i5 - 1] : f7699k[i5 - 1];
            i6 = (((i7 * 12000) / i8) + i9) * 4;
            i9 = 384;
        } else {
            int i10;
            if (i3 == 3) {
                i5 = i4 == 2 ? f7700l[i5 - 1] : f7701m[i5 - 1];
                i7 = 1152;
            } else {
                i5 = f7702n[i5 - 1];
                i7 = i4 == 1 ? 576 : 1152;
                if (i4 == 1) {
                    i6 = i5;
                    i5 = i7;
                    i7 = 72000;
                    i7 = ((i7 * i6) / i8) + i9;
                    i9 = i5;
                    i10 = i7;
                    i7 = i6;
                    i6 = i10;
                }
            }
            i6 = i5;
            i5 = i7;
            i7 = 144000;
            i7 = ((i7 * i6) / i8) + i9;
            i9 = i5;
            i10 = i7;
            i7 = i6;
            i6 = i10;
        }
        String str = f7696h[3 - i4];
        if (((i >> 6) & 3) == 3) {
            i2 = 1;
        }
        mpegAudioHeader.m9308a(i3, str, i6, i8, i2, i7 * 1000, i9);
        return true;
    }

    private void m9308a(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.f7703a = i;
        this.f7704b = str;
        this.f7705c = i2;
        this.f7706d = i3;
        this.f7707e = i4;
        this.f7708f = i5;
        this.f7709g = i6;
    }
}
