package com.facebook.dialtone.cachemanager;

import com.facebook.dialtone.common.AbstractDialtoneStateChangedListener;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: messenger_status_thread */
public class DialtoneCacheManagerStateChangedListener extends AbstractDialtoneStateChangedListener {
    private final ExecutorService f13749a;
    public final Lazy<DialtoneCacheManager> f13750b;

    @Inject
    public DialtoneCacheManagerStateChangedListener(ExecutorService executorService, Lazy<DialtoneCacheManager> lazy) {
        this.f13750b = lazy;
        this.f13749a = executorService;
    }

    public final void b_(boolean z) {
        if (z) {
            ExecutorDetour.a(this.f13749a, new 1(this), -720061650);
        }
    }
}
