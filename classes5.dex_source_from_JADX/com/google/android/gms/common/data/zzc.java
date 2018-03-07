package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc {
    public final DataHolder f6488a;
    public int f6489b;
    public int f6490c;

    public zzc(DataHolder dataHolder, int i) {
        this.f6488a = (DataHolder) zzx.a(dataHolder);
        boolean z = i >= 0 && i < this.f6488a.f6477c;
        zzx.a(z);
        this.f6489b = i;
        this.f6490c = this.f6488a.m12161a(this.f6489b);
    }

    public final boolean m12174a(String str) {
        return this.f6488a.f6475a.containsKey(str);
    }

    protected final int m12175b(String str) {
        return this.f6488a.m12164b(str, this.f6489b, this.f6490c);
    }

    protected final String m12176d(String str) {
        return this.f6488a.m12165c(str, this.f6489b, this.f6490c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc com_google_android_gms_common_data_zzc = (zzc) obj;
        return zzw.a(Integer.valueOf(com_google_android_gms_common_data_zzc.f6489b), Integer.valueOf(this.f6489b)) && zzw.a(Integer.valueOf(com_google_android_gms_common_data_zzc.f6490c), Integer.valueOf(this.f6490c)) && com_google_android_gms_common_data_zzc.f6488a == this.f6488a;
    }

    protected final byte[] m12177f(String str) {
        return this.f6488a.m12168f(str, this.f6489b, this.f6490c);
    }

    protected final boolean m12178g(String str) {
        return this.f6488a.m12170g(str, this.f6489b, this.f6490c);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6489b), Integer.valueOf(this.f6490c), this.f6488a});
    }
}
