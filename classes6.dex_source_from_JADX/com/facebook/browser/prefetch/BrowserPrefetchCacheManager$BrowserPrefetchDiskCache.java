package com.facebook.browser.prefetch;

import android.annotation.TargetApi;
import android.util.LruCache;
import java.io.File;

@TargetApi(12)
/* compiled from: processPhoto Exception */
class BrowserPrefetchCacheManager$BrowserPrefetchDiskCache extends LruCache<String, BrowserPrefetchCacheManager$CacheEntry> {
    final /* synthetic */ BrowserPrefetchCacheManager f7411a;

    protected void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        BrowserPrefetchCacheManager$CacheEntry browserPrefetchCacheManager$CacheEntry = (BrowserPrefetchCacheManager$CacheEntry) obj2;
        this.f7411a.j.remove(browserPrefetchCacheManager$CacheEntry.f7413b);
        File file = new File(browserPrefetchCacheManager$CacheEntry.f7414c);
        if (file.exists() && !file.delete()) {
            this.f7411a.f.a(BrowserPrefetchCacheManager.a + ".BrowserPrefetchDiskCache.entryRemoved", "Failed delete existing cache file for " + str);
        }
    }

    protected int sizeOf(Object obj, Object obj2) {
        return ((BrowserPrefetchCacheManager$CacheEntry) obj2).f7412a;
    }

    public BrowserPrefetchCacheManager$BrowserPrefetchDiskCache(BrowserPrefetchCacheManager browserPrefetchCacheManager, int i) {
        this.f7411a = browserPrefetchCacheManager;
        super(i);
    }
}
