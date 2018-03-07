package com.facebook.proxygen;

import java.util.concurrent.Executor;

/* compiled from: spring is required */
public class MQTTClientFactory extends NativeHandleImpl {
    private final EventBase mEventbase;
    private final Executor mExecutor;
    private PersistentSSLCacheSettings mPersistentDNSCacheSettings;
    private PersistentSSLCacheSettings mPersistentSSLCacheSettings;
    private final MQTTClientSettings mSettings;

    private native void init(EventBase eventBase, Executor executor, int i, int i2, boolean z, boolean z2, PersistentSSLCacheSettings persistentSSLCacheSettings, PersistentSSLCacheSettings persistentSSLCacheSettings2);

    public native void close();

    public MQTTClientFactory(EventBase eventBase, Executor executor, MQTTClientSettings mQTTClientSettings) {
        this.mSettings = mQTTClientSettings;
        this.mEventbase = eventBase;
        this.mExecutor = executor;
    }

    public void init() {
        init(this.mEventbase, this.mExecutor, this.mSettings.connectTimeout, this.mSettings.pingRespTimeout, this.mSettings.veryfyCertificates, this.mSettings.zlibCompression, this.mPersistentSSLCacheSettings, this.mPersistentDNSCacheSettings);
    }

    public MQTTClientFactory setPersistentDNSCacheSettings(PersistentSSLCacheSettings persistentSSLCacheSettings) {
        this.mPersistentDNSCacheSettings = persistentSSLCacheSettings;
        return this;
    }

    public MQTTClientFactory setPersistentSSLCacheSettings(PersistentSSLCacheSettings persistentSSLCacheSettings) {
        this.mPersistentSSLCacheSettings = persistentSSLCacheSettings;
        return this;
    }

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
