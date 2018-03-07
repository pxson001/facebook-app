package com.facebook.feedplugins.storyset.funnel;

import android.util.LruCache;
import javax.inject.Inject;

/* compiled from: playback_stuck */
public class StorySetLruCache extends LruCache<String, Short> {
    private short f4463a = (short) 0;

    protected void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        this.f4463a = ((Short) obj2).shortValue();
    }

    @Inject
    public StorySetLruCache() {
        super(20);
    }

    public final synchronized short m4971a(String str) {
        Short sh;
        sh = (Short) get(str);
        if (sh == null) {
            sh = Short.valueOf(this.f4463a);
            this.f4463a = (short) (this.f4463a + 1);
            put(str, sh);
        }
        return sh.shortValue();
    }
}
