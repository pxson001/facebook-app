package com.facebook.feedback.logging;

import android.util.LruCache;
import javax.inject.Inject;

/* compiled from: headers */
public class FeedDiscoveryLruCache extends LruCache<String, Short> {
    private short f21134a = (short) 0;

    protected void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        this.f21134a = ((Short) obj2).shortValue();
    }

    @Inject
    public FeedDiscoveryLruCache() {
        super(150);
    }

    public final synchronized short m28905a(String str) {
        Short sh;
        sh = (Short) get(str);
        if (sh == null) {
            sh = Short.valueOf(this.f21134a);
            this.f21134a = (short) (this.f21134a + 1);
            put(str, sh);
        }
        return sh.shortValue();
    }
}
