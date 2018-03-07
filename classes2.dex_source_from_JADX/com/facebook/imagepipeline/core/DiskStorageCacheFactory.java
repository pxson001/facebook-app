package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageCache.Params;

/* compiled from: org.apache.harmony.xnet.provider.jsse.NativeCrypto */
public class DiskStorageCacheFactory {
    private DiskStorageFactory f10825a;

    public DiskStorageCacheFactory(DiskStorageFactory diskStorageFactory) {
        this.f10825a = diskStorageFactory;
    }

    public final DiskStorageCache m16052a(DiskCacheConfig diskCacheConfig) {
        DiskStorage a = this.f10825a.mo2067a(diskCacheConfig);
        return new DiskStorageCache(a, diskCacheConfig.f10717g, new Params(diskCacheConfig.f10716f, diskCacheConfig.f10715e, diskCacheConfig.f10714d), diskCacheConfig.f10719i, diskCacheConfig.f10718h, diskCacheConfig.f10720j);
    }
}
