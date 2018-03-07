package com.facebook.proxygen;

/* compiled from: publish_edit_post */
public class PersistentSSLCacheSettings {
    public int cacheCapacity;
    public boolean enableCrossDomainTickets;
    public String filename;
    public int syncInterval;

    /* compiled from: publish_edit_post */
    public class Builder {
        public int cacheCapacity = 50;
        public boolean enableCrossDomainTickets = false;
        public String filename;
        public int syncInterval = 150;

        public Builder(String str) {
            this.filename = str;
        }

        public PersistentSSLCacheSettings build() {
            return new PersistentSSLCacheSettings(this.filename, this.cacheCapacity, this.syncInterval, this.enableCrossDomainTickets);
        }
    }

    public PersistentSSLCacheSettings(String str, int i, int i2, boolean z) {
        this.filename = str;
        this.cacheCapacity = i;
        this.syncInterval = i2;
        this.enableCrossDomainTickets = z;
    }
}
