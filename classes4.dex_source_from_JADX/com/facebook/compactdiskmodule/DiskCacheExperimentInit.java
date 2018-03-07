package com.facebook.compactdiskmodule;

import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.compactdisk.DiskArea;
import com.facebook.compactdisk.DiskCache;
import com.facebook.compactdisk.DiskCacheConfig;
import com.facebook.compactdisk.ManagedConfig;
import com.facebook.compactdisk.StoreManagerFactory;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: memory_cache_visit */
public class DiskCacheExperimentInit implements INeedInit {
    private final Provider<TriState> f8146a;
    private final StoreManagerFactory f8147b;
    private DiskCache f8148c;

    @Inject
    public DiskCacheExperimentInit(Provider<TriState> provider, StoreManagerFactory storeManagerFactory) {
        this.f8146a = provider;
        this.f8147b = storeManagerFactory;
    }

    public void init() {
        if (this.f8146a.get() == TriState.YES) {
            DiskCacheConfig a = new DiskCacheConfig().m8448a(true).m8445a(DiskArea.CACHES).m8447a("disk_cache").m8446a(new ManagedConfig());
            this.f8148c = this.f8147b.m8453a(a).m8459a(a);
        }
    }
}
