package com.google.android.gms.internal;

public final class zztg implements Cloneable {
    private static final zzth f6978a = new zzth();
    private boolean f6979b;
    private int[] f6980c;
    private zzth[] f6981d;
    private int f6982e;

    zztg() {
        this(10);
    }

    private zztg(int i) {
        this.f6979b = false;
        int c = m13015c(i);
        this.f6980c = new int[c];
        this.f6981d = new zzth[c];
        this.f6982e = 0;
    }

    private int m13015c(int i) {
        return m13016d(i * 4) / 4;
    }

    private static int m13016d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private void m13017d() {
        int i = this.f6982e;
        int[] iArr = this.f6980c;
        zzth[] com_google_android_gms_internal_zzthArr = this.f6981d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzth com_google_android_gms_internal_zzth = com_google_android_gms_internal_zzthArr[i3];
            if (com_google_android_gms_internal_zzth != f6978a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    com_google_android_gms_internal_zzthArr[i2] = com_google_android_gms_internal_zzth;
                    com_google_android_gms_internal_zzthArr[i3] = null;
                }
                i2++;
            }
        }
        this.f6979b = false;
        this.f6982e = i2;
    }

    private int m13018e(int i) {
        int i2 = 0;
        int i3 = this.f6982e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f6980c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    final int m13019a() {
        if (this.f6979b) {
            m13017d();
        }
        return this.f6982e;
    }

    final zzth m13020a(int i) {
        int e = m13018e(i);
        return (e < 0 || this.f6981d[e] == f6978a) ? null : this.f6981d[e];
    }

    final void m13021a(int i, zzth com_google_android_gms_internal_zzth) {
        int e = m13018e(i);
        if (e >= 0) {
            this.f6981d[e] = com_google_android_gms_internal_zzth;
            return;
        }
        e ^= -1;
        if (e >= this.f6982e || this.f6981d[e] != f6978a) {
            if (this.f6979b && this.f6982e >= this.f6980c.length) {
                m13017d();
                e = m13018e(i) ^ -1;
            }
            if (this.f6982e >= this.f6980c.length) {
                int c = m13015c(this.f6982e + 1);
                Object obj = new int[c];
                Object obj2 = new zzth[c];
                System.arraycopy(this.f6980c, 0, obj, 0, this.f6980c.length);
                System.arraycopy(this.f6981d, 0, obj2, 0, this.f6981d.length);
                this.f6980c = obj;
                this.f6981d = obj2;
            }
            if (this.f6982e - e != 0) {
                System.arraycopy(this.f6980c, e, this.f6980c, e + 1, this.f6982e - e);
                System.arraycopy(this.f6981d, e, this.f6981d, e + 1, this.f6982e - e);
            }
            this.f6980c[e] = i;
            this.f6981d[e] = com_google_android_gms_internal_zzth;
            this.f6982e++;
            return;
        }
        this.f6980c[e] = i;
        this.f6981d[e] = com_google_android_gms_internal_zzth;
    }

    final zzth m13022b(int i) {
        if (this.f6979b) {
            m13017d();
        }
        return this.f6981d[i];
    }

    public final boolean m13023b() {
        return m13019a() == 0;
    }

    public final zztg m13024c() {
        int i = 0;
        int a = m13019a();
        zztg com_google_android_gms_internal_zztg = new zztg(a);
        System.arraycopy(this.f6980c, 0, com_google_android_gms_internal_zztg.f6980c, 0, a);
        while (i < a) {
            if (this.f6981d[i] != null) {
                com_google_android_gms_internal_zztg.f6981d[i] = this.f6981d[i].m13028b();
            }
            i++;
        }
        com_google_android_gms_internal_zztg.f6982e = a;
        return com_google_android_gms_internal_zztg;
    }

    public final /* synthetic */ Object clone() {
        return m13024c();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zztg)) {
            return false;
        }
        zztg com_google_android_gms_internal_zztg = (zztg) obj;
        if (m13019a() != com_google_android_gms_internal_zztg.m13019a()) {
            return false;
        }
        int i;
        int[] iArr = this.f6980c;
        int[] iArr2 = com_google_android_gms_internal_zztg.f6980c;
        int i2 = this.f6982e;
        Object obj2 = null;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                break;
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            zzth[] com_google_android_gms_internal_zzthArr = this.f6981d;
            zzth[] com_google_android_gms_internal_zzthArr2 = com_google_android_gms_internal_zztg.f6981d;
            i2 = this.f6982e;
            obj2 = null;
            for (i = 0; i < i2; i++) {
                if (!com_google_android_gms_internal_zzthArr[i].equals(com_google_android_gms_internal_zzthArr2[i])) {
                    break;
                }
            }
            obj2 = 1;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f6979b) {
            m13017d();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.f6982e; i2++) {
            i = (((i * 31) + this.f6980c[i2]) * 31) + this.f6981d[i2].hashCode();
        }
        return i;
    }
}
