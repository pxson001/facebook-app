package com.facebook.compactdisk;

import java.util.concurrent.Callable;

/* compiled from: transliterator_word_transliterated */
class StoreManager$2 implements Callable<DiskCache> {
    final /* synthetic */ String f1198a;
    final /* synthetic */ DiskCacheConfig f1199b;
    final /* synthetic */ StoreManager f1200c;

    StoreManager$2(StoreManager storeManager, String str, DiskCacheConfig diskCacheConfig) {
        this.f1200c = storeManager;
        this.f1198a = str;
        this.f1199b = diskCacheConfig;
    }

    public Object call() {
        return StoreManager.a(this.f1200c, this.f1198a, this.f1199b);
    }
}
