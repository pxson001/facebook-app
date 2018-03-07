package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zztk {
    public volatile int f6915b = -1;

    public static final <T extends zztk> T m12896a(T t, byte[] bArr) {
        return m12898b(t, bArr, 0, bArr.length);
    }

    public static void m12897a(zztk com_google_android_gms_internal_zztk, byte[] bArr, int i, int i2) {
        try {
            zztd a = zztd.m12961a(bArr, i, i2);
            com_google_android_gms_internal_zztk.mo845a(a);
            a.m12989a();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    private static <T extends zztk> T m12898b(T t, byte[] bArr, int i, int i2) {
        try {
            zztc a = zztc.m12929a(bArr, i, i2);
            t.mo844a(a);
            a.m12938a(0);
            return t;
        } catch (zztj e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    protected int mo843a() {
        return 0;
    }

    public abstract zztk mo844a(zztc com_google_android_gms_internal_zztc);

    public void mo845a(zztd com_google_android_gms_internal_zztd) {
    }

    public zztk mo846b() {
        return (zztk) super.clone();
    }

    public /* synthetic */ Object clone() {
        return mo846b();
    }

    public final int m12903d() {
        int a = mo843a();
        this.f6915b = a;
        return a;
    }

    public String toString() {
        return zztl.m13040a(this);
    }
}
