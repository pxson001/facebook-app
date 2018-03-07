package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;

/* compiled from: optin_group_interstitial */
public class DynamicDefaultDiskStorageFactory implements DiskStorageFactory {
    public final DiskStorage mo2067a(DiskCacheConfig diskCacheConfig) {
        return new DynamicDefaultDiskStorage(diskCacheConfig.f10711a, diskCacheConfig.f10713c, diskCacheConfig.f10712b, diskCacheConfig.f10718h);
    }
}
