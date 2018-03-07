package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

/* compiled from: me/permissions */
public class StoreManager {
    private LazySingletonMap<String, UnmanagedStore> f8168a = new LazySingletonMap(new 3(this));
    private LazySingletonMap<String, PersistentKeyValueStore> f8169b = new LazySingletonMap(new 4(this));
    private CallableLazySingletonMap<String, DiskCache> f8170c = new CallableLazySingletonMap();
    @DoNotStrip
    private final HybridData mHybridData;

    private native DiskCache createDiskCache(String str, DiskCacheConfig diskCacheConfig);

    private native PersistentKeyValueStore createPersistentKeyValueStore(String str);

    private native UnmanagedStore createUnmanagedStore(String str);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public final PersistentKeyValueStore m8460a(String str) {
        return (PersistentKeyValueStore) this.f8169b.m8485a(str);
    }

    public final DiskCache m8459a(DiskCacheConfig diskCacheConfig) {
        String name = diskCacheConfig.getName();
        return (DiskCache) this.f8170c.m8489a(name, new 2(this, name, diskCacheConfig));
    }

    @DoNotStrip
    private StoreManager(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
