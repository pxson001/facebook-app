package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

class zza {
    final String f7059a;
    final String f7060b;
    final String f7061c;
    final String f7062d;
    final long f7063e;
    final long f7064f;
    final String f7065g;
    final String f7066h;
    final long f7067i;
    final long f7068j;
    final boolean f7069k;

    zza(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, long j3, long j4, boolean z) {
        zzx.a(str);
        zzx.b(j >= 0);
        this.f7059a = str;
        this.f7060b = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = null;
        }
        this.f7061c = str3;
        this.f7062d = str4;
        this.f7063e = j;
        this.f7064f = j2;
        this.f7065g = str5;
        this.f7066h = str6;
        this.f7067i = j3;
        this.f7068j = j4;
        this.f7069k = z;
    }

    public final zza m13069a(long j) {
        return new zza(this.f7059a, this.f7060b, this.f7061c, this.f7062d, this.f7063e, this.f7064f, this.f7065g, this.f7066h, this.f7067i, j, this.f7069k);
    }

    public final zza m13070a(zzo com_google_android_gms_measurement_internal_zzo, long j) {
        zzx.a(com_google_android_gms_measurement_internal_zzo);
        long j2 = this.f7063e + 1;
        if (j2 > 2147483647L) {
            com_google_android_gms_measurement_internal_zzo.o().a("Bundle index overflow");
            j2 = 0;
        }
        return new zza(this.f7059a, this.f7060b, this.f7061c, this.f7062d, j2, j, this.f7065g, this.f7066h, this.f7067i, this.f7068j, this.f7069k);
    }

    public final zza m13071a(String str, long j) {
        return new zza(this.f7059a, this.f7060b, str, this.f7062d, this.f7063e, this.f7064f, this.f7065g, this.f7066h, j, this.f7068j, this.f7069k);
    }

    public final zza m13072a(String str, String str2) {
        return new zza(this.f7059a, str, this.f7061c, str2, this.f7063e, this.f7064f, this.f7065g, this.f7066h, this.f7067i, this.f7068j, this.f7069k);
    }

    public final zza m13073a(boolean z) {
        return new zza(this.f7059a, this.f7060b, this.f7061c, this.f7062d, this.f7063e, this.f7064f, this.f7065g, this.f7066h, this.f7067i, this.f7068j, z);
    }

    public final zza m13074b(String str, String str2) {
        return new zza(this.f7059a, this.f7060b, this.f7061c, this.f7062d, this.f7063e, this.f7064f, str, str2, this.f7067i, this.f7068j, this.f7069k);
    }
}
