package com.facebook.video.commercialbreak;

import android.util.LruCache;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker.MessageListener;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import javax.inject.Inject;

/* compiled from: platform_webdialogs_save_parcel */
public class CommercialBreakMessageSubscriberPool extends LruCache<String, CommercialBreakMessageSubscriber> {
    private final CommercialBreakMessageSubscriberProvider f4528a;

    protected void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        CommercialBreakMessageSubscriber commercialBreakMessageSubscriber = (CommercialBreakMessageSubscriber) obj2;
        if (commercialBreakMessageSubscriber != null) {
            commercialBreakMessageSubscriber.b.a(commercialBreakMessageSubscriber.i);
        }
    }

    @Inject
    public CommercialBreakMessageSubscriberPool(CommercialBreakMessageSubscriberProvider commercialBreakMessageSubscriberProvider, CommercialBreakConfig commercialBreakConfig) {
        super(commercialBreakConfig.f4318c);
        this.f4528a = commercialBreakMessageSubscriberProvider;
    }

    public final synchronized void m5037a(String str, MessageListener messageListener) {
        CommercialBreakMessageSubscriber commercialBreakMessageSubscriber = (CommercialBreakMessageSubscriber) get(str);
        if (commercialBreakMessageSubscriber == null) {
            commercialBreakMessageSubscriber = this.f4528a.m5038a(str);
            put(str, commercialBreakMessageSubscriber);
        }
        commercialBreakMessageSubscriber.a(messageListener);
    }
}
