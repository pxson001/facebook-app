package com.facebook.livephotos.exoplayer;

import android.annotation.TargetApi;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: pagination_design */
public final class MediaFormat {
    public final String f6846a;
    public final String f6847b;
    public final int f6848c;
    public final int f6849d;
    public final long f6850e;
    public final List<byte[]> f6851f;
    public final boolean f6852g;
    public final int f6853h;
    public final int f6854i;
    public final int f6855j;
    public final int f6856k;
    public final int f6857l;
    public final float f6858m;
    public final int f6859n;
    public final int f6860o;
    public final int f6861p;
    public final int f6862q;
    public final String f6863r;
    public final long f6864s;
    private int f6865t;
    public android.media.MediaFormat f6866u;

    public static MediaFormat m8739a(String str, String str2, int i, int i2, long j, int i3, int i4, List<byte[]> list, int i5, float f) {
        return new MediaFormat(str, str2, i, i2, j, i3, i4, i5, f, -1, -1, null, Long.MAX_VALUE, list, false, -1, -1, -1, -1);
    }

    public static MediaFormat m8740a(String str, String str2, int i, int i2, long j, int i3, int i4, List<byte[]> list, String str3) {
        return new MediaFormat(str, str2, i, i2, j, -1, -1, -1, -1.0f, i3, i4, str3, Long.MAX_VALUE, list, false, -1, -1, -1, -1);
    }

    public static MediaFormat m8742a(String str, String str2, int i, long j, String str3) {
        return m8743a(str, str2, i, j, str3, Long.MAX_VALUE);
    }

    public static MediaFormat m8743a(String str, String str2, int i, long j, String str3, long j2) {
        return new MediaFormat(str, str2, i, -1, j, -1, -1, -1, -1.0f, -1, -1, str3, j2, null, false, -1, -1, -1, -1);
    }

    public static MediaFormat m8744a(String str, String str2, int i, long j, List<byte[]> list, String str3) {
        return new MediaFormat(str, str2, i, -1, j, -1, -1, -1, -1.0f, -1, -1, str3, Long.MAX_VALUE, list, false, -1, -1, -1, -1);
    }

    private static MediaFormat m8741a(String str, String str2, int i, long j) {
        return new MediaFormat(str, str2, i, -1, j, -1, -1, -1, -1.0f, -1, -1, null, Long.MAX_VALUE, null, false, -1, -1, -1, -1);
    }

    public static MediaFormat m8738a() {
        return m8741a(null, "application/id3", -1, -1);
    }

    private MediaFormat(String str, String str2, int i, int i2, long j, int i3, int i4, int i5, float f, int i6, int i7, String str3, long j2, List<byte[]> list, boolean z, int i8, int i9, int i10, int i11) {
        this.f6846a = str;
        this.f6847b = Assertions.m9294a(str2);
        this.f6848c = i;
        this.f6849d = i2;
        this.f6850e = j;
        this.f6853h = i3;
        this.f6854i = i4;
        this.f6857l = i5;
        this.f6858m = f;
        this.f6859n = i6;
        this.f6860o = i7;
        this.f6863r = str3;
        this.f6864s = j2;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f6851f = list;
        this.f6852g = z;
        this.f6855j = i8;
        this.f6856k = i9;
        this.f6861p = i10;
        this.f6862q = i11;
    }

    public final MediaFormat m8746a(int i) {
        return new MediaFormat(this.f6846a, this.f6847b, this.f6848c, i, this.f6850e, this.f6853h, this.f6854i, this.f6857l, this.f6858m, this.f6859n, this.f6860o, this.f6863r, this.f6864s, this.f6851f, this.f6852g, this.f6855j, this.f6856k, this.f6861p, this.f6862q);
    }

    public final MediaFormat m8747a(int i, int i2) {
        return new MediaFormat(this.f6846a, this.f6847b, this.f6848c, this.f6849d, this.f6850e, this.f6853h, this.f6854i, this.f6857l, this.f6858m, this.f6859n, this.f6860o, this.f6863r, this.f6864s, this.f6851f, this.f6852g, this.f6855j, this.f6856k, i, i2);
    }

    public final String toString() {
        return "MediaFormat(" + this.f6846a + ", " + this.f6847b + ", " + this.f6848c + ", " + this.f6849d + ", " + this.f6853h + ", " + this.f6854i + ", " + this.f6857l + ", " + this.f6858m + ", " + this.f6859n + ", " + this.f6860o + ", " + this.f6863r + ", " + this.f6850e + ", " + this.f6852g + ", " + this.f6855j + ", " + this.f6856k + ", " + this.f6861p + ", " + this.f6862q + ")";
    }

    public final int hashCode() {
        int i = 0;
        if (this.f6865t == 0) {
            int hashCode = (this.f6863r == null ? 0 : this.f6863r.hashCode()) + (((((((((((((((this.f6852g ? 1231 : 1237) + (((((((((((((((((this.f6847b == null ? 0 : this.f6847b.hashCode()) + (((this.f6846a == null ? 0 : this.f6846a.hashCode()) + 527) * 31)) * 31) + this.f6848c) * 31) + this.f6849d) * 31) + this.f6853h) * 31) + this.f6854i) * 31) + this.f6857l) * 31) + Float.floatToRawIntBits(this.f6858m)) * 31) + ((int) this.f6850e)) * 31)) * 31) + this.f6855j) * 31) + this.f6856k) * 31) + this.f6861p) * 31) + this.f6862q) * 31) + this.f6859n) * 31) + this.f6860o) * 31);
            while (i < this.f6851f.size()) {
                hashCode = Arrays.hashCode((byte[]) this.f6851f.get(i)) + (hashCode * 31);
                i++;
            }
            this.f6865t = hashCode;
        }
        return this.f6865t;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaFormat mediaFormat = (MediaFormat) obj;
        if (this.f6852g != mediaFormat.f6852g || this.f6848c != mediaFormat.f6848c || this.f6849d != mediaFormat.f6849d || this.f6853h != mediaFormat.f6853h || this.f6854i != mediaFormat.f6854i || this.f6857l != mediaFormat.f6857l || this.f6858m != mediaFormat.f6858m || this.f6855j != mediaFormat.f6855j || this.f6856k != mediaFormat.f6856k || this.f6861p != mediaFormat.f6861p || this.f6862q != mediaFormat.f6862q || this.f6859n != mediaFormat.f6859n || this.f6860o != mediaFormat.f6860o || !Util.m9365a(this.f6846a, mediaFormat.f6846a) || !Util.m9365a(this.f6863r, mediaFormat.f6863r) || !Util.m9365a(this.f6847b, mediaFormat.f6847b) || this.f6851f.size() != mediaFormat.f6851f.size()) {
            return false;
        }
        for (int i = 0; i < this.f6851f.size(); i++) {
            if (!Arrays.equals((byte[]) this.f6851f.get(i), (byte[]) mediaFormat.f6851f.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    public static final void m8745a(android.media.MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }
}
