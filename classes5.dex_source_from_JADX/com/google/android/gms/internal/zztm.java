package com.google.android.gms.internal;

import java.util.Arrays;

public final class zztm {
    public final int f6987a;
    public final byte[] f6988b;

    zztm(int i, byte[] bArr) {
        this.f6987a = i;
        this.f6988b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zztm)) {
            return false;
        }
        zztm com_google_android_gms_internal_zztm = (zztm) obj;
        return this.f6987a == com_google_android_gms_internal_zztm.f6987a && Arrays.equals(this.f6988b, com_google_android_gms_internal_zztm.f6988b);
    }

    public final int hashCode() {
        return ((this.f6987a + 527) * 31) + Arrays.hashCode(this.f6988b);
    }
}
