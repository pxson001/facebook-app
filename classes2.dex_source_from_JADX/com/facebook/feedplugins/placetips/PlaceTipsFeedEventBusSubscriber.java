package com.facebook.feedplugins.placetips;

import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.util.event.AppiraterEvents$FeedFragmentResumedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PulsarScanTrigger;
import javax.inject.Inject;

/* compiled from: tos_seq */
public class PlaceTipsFeedEventBusSubscriber extends INeedInitForEventBusSubscription<AppiraterEvents$FeedFragmentResumedEvent, PulsarScanTrigger> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        ((PulsarScanTrigger) obj).mo2676a();
    }

    @Inject
    public PlaceTipsFeedEventBusSubscriber(FeedEventBus feedEventBus, Lazy<PulsarScanTrigger> lazy) {
        super(feedEventBus, lazy);
    }

    public final Class<AppiraterEvents$FeedFragmentResumedEvent> mo648a() {
        return AppiraterEvents$FeedFragmentResumedEvent.class;
    }
}
