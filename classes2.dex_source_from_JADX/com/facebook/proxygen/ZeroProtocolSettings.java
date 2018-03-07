package com.facebook.proxygen;

/* compiled from: ps_cpu_ms */
public class ZeroProtocolSettings {
    public String[] aeads;
    public final PersistentSSLCacheSettings cacheSettings;
    public final boolean enabled;
    public final boolean enforceExpiration;
    public String hostnamePolicy;
    public final boolean persistentCacheEnabled;
    public final boolean retryEnabled;
    public final boolean zeroRttEnabled;

    /* compiled from: ps_cpu_ms */
    public class Builder {
        public String[] aeads;
        public PersistentSSLCacheSettings cacheSettings;
        public boolean enabled;
        public boolean enforceExpiration = true;
        public String hostnamePolicy;
        public boolean persistentCacheEnabled = false;
        public boolean retryEnabled = false;
        public boolean zeroRttEnabled = true;
    }

    public ZeroProtocolSettings(boolean z, boolean z2, boolean z3, boolean z4, PersistentSSLCacheSettings persistentSSLCacheSettings, String[] strArr, String str, boolean z5) {
        this.enabled = z;
        this.enforceExpiration = z2;
        this.zeroRttEnabled = z3;
        this.persistentCacheEnabled = z4;
        this.cacheSettings = persistentSSLCacheSettings;
        this.aeads = strArr;
        this.hostnamePolicy = str;
        this.retryEnabled = z5;
    }
}
