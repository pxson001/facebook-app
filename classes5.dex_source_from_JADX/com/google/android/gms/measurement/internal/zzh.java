package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

class zzh {
    final String f7080a;
    final String f7081b;
    final long f7082c;
    final long f7083d;
    final long f7084e;

    zzh(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        zzx.a(str);
        zzx.a(str2);
        zzx.b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        zzx.b(z);
        this.f7080a = str;
        this.f7081b = str2;
        this.f7082c = j;
        this.f7083d = j2;
        this.f7084e = j3;
    }

    final zzh m13079a(long j) {
        return new zzh(this.f7080a, this.f7081b, this.f7082c + 1, this.f7083d + 1, j);
    }
}
