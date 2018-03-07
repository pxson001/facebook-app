package com.facebook.vault.protocol;

/* compiled from: thread_id IN (SELECT thread_id FROM #thread_fbid) AND timestamp >= %1$d AND timestamp <= %2$d */
public class VaultDeviceUpdateParams {
    public final long f1854a;
    public Long f1855b = null;
    public Boolean f1856c = null;
    public String f1857d = null;
    public Boolean f1858e = null;

    public VaultDeviceUpdateParams(long j) {
        this.f1854a = j;
    }

    public final void m1934a(long j) {
        this.f1855b = Long.valueOf(j);
    }

    public final void m1936a(boolean z) {
        this.f1856c = Boolean.valueOf(z);
    }

    public final void m1935a(String str) {
        this.f1857d = str;
    }

    public final void m1937b(boolean z) {
        this.f1858e = Boolean.valueOf(z);
    }
}
