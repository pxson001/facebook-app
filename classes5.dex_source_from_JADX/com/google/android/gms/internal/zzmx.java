package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.google.android.gms.common.internal.zzw;

public final class zzmx extends LruCache<zza, Drawable> {

    public final class zza {
        public final int f6910a;
        public final int f6911b;

        public zza(int i, int i2) {
            this.f6910a = i;
            this.f6911b = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza com_google_android_gms_internal_zzmx_zza = (zza) obj;
            return com_google_android_gms_internal_zzmx_zza.f6910a == this.f6910a && com_google_android_gms_internal_zzmx_zza.f6911b == this.f6911b;
        }

        public final int hashCode() {
            return zzw.a(new Object[]{Integer.valueOf(this.f6910a), Integer.valueOf(this.f6911b)});
        }
    }

    public zzmx() {
        super(10);
    }
}
