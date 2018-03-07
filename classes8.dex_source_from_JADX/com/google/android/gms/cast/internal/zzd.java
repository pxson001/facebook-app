package com.google.android.gms.cast.internal;

import android.text.TextUtils;

public abstract class zzd {
    public final String f10058a;
    public zzn f10059b;
    public final zzl f10060f;

    protected zzd(String str, String str2, String str3) {
        zzf.m11921a(str);
        this.f10058a = str;
        this.f10060f = new zzl(str2);
        if (!TextUtils.isEmpty(str3)) {
            String str4;
            zzl com_google_android_gms_cast_internal_zzl = this.f10060f;
            if (TextUtils.isEmpty(str3)) {
                str4 = null;
            } else {
                str4 = String.format("[%s] ", new Object[]{str3});
            }
            com_google_android_gms_cast_internal_zzl.f10180f = str4;
        }
    }

    public void mo640a(long j, int i) {
    }

    public void mo641a(String str) {
    }

    protected final void m11808a(String str, long j, String str2) {
        this.f10060f.m11954a("Sending text message: %s to: %s", str, str2);
        this.f10059b.mo646a(this.f10058a, str, j);
    }

    public void mo639c() {
    }

    protected final long m11810e() {
        return this.f10059b.mo645a();
    }
}
