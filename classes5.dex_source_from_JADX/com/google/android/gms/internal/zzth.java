package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zzth implements Cloneable {
    private zztf<?, ?> f6983a;
    private Object f6984b;
    public List<zztm> f6985c = new ArrayList();

    zzth() {
    }

    private byte[] m13025c() {
        byte[] bArr = new byte[m13026a()];
        m13027a(zztd.m12960a(bArr));
        return bArr;
    }

    final int m13026a() {
        if (this.f6984b != null) {
            return this.f6983a.m13013a(this.f6984b);
        }
        int i = 0;
        for (zztm com_google_android_gms_internal_zztm : this.f6985c) {
            i = ((zztd.m12975c(com_google_android_gms_internal_zztm.f6987a) + 0) + com_google_android_gms_internal_zztm.f6988b.length) + i;
        }
        return i;
    }

    final void m13027a(zztd com_google_android_gms_internal_zztd) {
        if (this.f6984b != null) {
            this.f6983a.m13014a(this.f6984b, com_google_android_gms_internal_zztd);
            return;
        }
        for (zztm com_google_android_gms_internal_zztm : this.f6985c) {
            com_google_android_gms_internal_zztd.m12999b(com_google_android_gms_internal_zztm.f6987a);
            com_google_android_gms_internal_zztd.m13002c(com_google_android_gms_internal_zztm.f6988b);
        }
    }

    public final zzth m13028b() {
        int i = 0;
        zzth com_google_android_gms_internal_zzth = new zzth();
        try {
            com_google_android_gms_internal_zzth.f6983a = this.f6983a;
            if (this.f6985c == null) {
                com_google_android_gms_internal_zzth.f6985c = null;
            } else {
                com_google_android_gms_internal_zzth.f6985c.addAll(this.f6985c);
            }
            if (this.f6984b != null) {
                if (this.f6984b instanceof zztk) {
                    com_google_android_gms_internal_zzth.f6984b = ((zztk) this.f6984b).mo846b();
                } else if (this.f6984b instanceof byte[]) {
                    com_google_android_gms_internal_zzth.f6984b = ((byte[]) this.f6984b).clone();
                } else if (this.f6984b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f6984b;
                    Object obj = new byte[bArr.length][];
                    com_google_android_gms_internal_zzth.f6984b = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.f6984b instanceof boolean[]) {
                    com_google_android_gms_internal_zzth.f6984b = ((boolean[]) this.f6984b).clone();
                } else if (this.f6984b instanceof int[]) {
                    com_google_android_gms_internal_zzth.f6984b = ((int[]) this.f6984b).clone();
                } else if (this.f6984b instanceof long[]) {
                    com_google_android_gms_internal_zzth.f6984b = ((long[]) this.f6984b).clone();
                } else if (this.f6984b instanceof float[]) {
                    com_google_android_gms_internal_zzth.f6984b = ((float[]) this.f6984b).clone();
                } else if (this.f6984b instanceof double[]) {
                    com_google_android_gms_internal_zzth.f6984b = ((double[]) this.f6984b).clone();
                } else if (this.f6984b instanceof zztk[]) {
                    zztk[] com_google_android_gms_internal_zztkArr = (zztk[]) this.f6984b;
                    Object obj2 = new zztk[com_google_android_gms_internal_zztkArr.length];
                    com_google_android_gms_internal_zzth.f6984b = obj2;
                    while (i < com_google_android_gms_internal_zztkArr.length) {
                        obj2[i] = com_google_android_gms_internal_zztkArr[i].mo846b();
                        i++;
                    }
                }
            }
            return com_google_android_gms_internal_zzth;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return m13028b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzth)) {
            return false;
        }
        zzth com_google_android_gms_internal_zzth = (zzth) obj;
        if (this.f6984b != null && com_google_android_gms_internal_zzth.f6984b != null) {
            return this.f6983a == com_google_android_gms_internal_zzth.f6983a ? !this.f6983a.f6975b.isArray() ? this.f6984b.equals(com_google_android_gms_internal_zzth.f6984b) : this.f6984b instanceof byte[] ? Arrays.equals((byte[]) this.f6984b, (byte[]) com_google_android_gms_internal_zzth.f6984b) : this.f6984b instanceof int[] ? Arrays.equals((int[]) this.f6984b, (int[]) com_google_android_gms_internal_zzth.f6984b) : this.f6984b instanceof long[] ? Arrays.equals((long[]) this.f6984b, (long[]) com_google_android_gms_internal_zzth.f6984b) : this.f6984b instanceof float[] ? Arrays.equals((float[]) this.f6984b, (float[]) com_google_android_gms_internal_zzth.f6984b) : this.f6984b instanceof double[] ? Arrays.equals((double[]) this.f6984b, (double[]) com_google_android_gms_internal_zzth.f6984b) : this.f6984b instanceof boolean[] ? Arrays.equals((boolean[]) this.f6984b, (boolean[]) com_google_android_gms_internal_zzth.f6984b) : Arrays.deepEquals((Object[]) this.f6984b, (Object[]) com_google_android_gms_internal_zzth.f6984b) : false;
        } else {
            if (this.f6985c != null && com_google_android_gms_internal_zzth.f6985c != null) {
                return this.f6985c.equals(com_google_android_gms_internal_zzth.f6985c);
            }
            try {
                return Arrays.equals(m13025c(), com_google_android_gms_internal_zzth.m13025c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m13025c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
