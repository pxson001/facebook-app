package com.google.android.gms.internal;

import java.lang.reflect.Array;

public class zztf<M extends zzte<M>, T> {
    protected final int f6974a;
    protected final Class<T> f6975b;
    public final int f6976c;
    protected final boolean f6977d;

    private int m13009b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m13011c(Array.get(obj, i2));
            }
        }
        return i;
    }

    private void m13010b(Object obj, zztd com_google_android_gms_internal_zztd) {
        try {
            com_google_android_gms_internal_zztd.m12999b(this.f6976c);
            switch (this.f6974a) {
                case 10:
                    zztk com_google_android_gms_internal_zztk = (zztk) obj;
                    int b = zztn.m13047b(this.f6976c);
                    com_google_android_gms_internal_zztd.m12998a(com_google_android_gms_internal_zztk);
                    com_google_android_gms_internal_zztd.m13003e(b, 4);
                    return;
                case 11:
                    com_google_android_gms_internal_zztd.m13001b((zztk) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f6974a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private int m13011c(Object obj) {
        int i = this.f6976c >>> 3;
        switch (this.f6974a) {
            case 10:
                return (zztd.m12985h(i) * 2) + ((zztk) obj).m12903d();
            case 11:
                return zztd.m12978c(i, (zztk) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f6974a);
        }
    }

    private void m13012c(Object obj, zztd com_google_android_gms_internal_zztd) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m13010b(obj2, com_google_android_gms_internal_zztd);
            }
        }
    }

    final int m13013a(Object obj) {
        return this.f6977d ? m13009b(obj) : m13011c(obj);
    }

    final void m13014a(Object obj, zztd com_google_android_gms_internal_zztd) {
        if (this.f6977d) {
            m13012c(obj, com_google_android_gms_internal_zztd);
        } else {
            m13010b(obj, com_google_android_gms_internal_zztd);
        }
    }
}
