package com.facebook.video.pubsub;

import android.util.LruCache;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.video.pubsub.LiveStreamingSubscriber.InterruptedMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: oxygen_map_marker_draw_time */
public class LiveStreamingSubscriberPool extends LruCache<String, LiveStreamingSubscriber> {
    private final String f5622a = LiveStreamingSubscriberPool.class.getSimpleName();
    private final SkywalkerSubscriptionConnector f5623b;
    private final ObjectMapper f5624c;

    protected void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        LiveStreamingSubscriber liveStreamingSubscriber = (LiveStreamingSubscriber) obj2;
        if (liveStreamingSubscriber != null) {
            liveStreamingSubscriber.d.a(liveStreamingSubscriber.c);
        }
    }

    public LiveStreamingSubscriberPool(int i, SkywalkerSubscriptionConnector skywalkerSubscriptionConnector, ObjectMapper objectMapper) {
        super(i);
        this.f5623b = skywalkerSubscriptionConnector;
        this.f5624c = objectMapper;
    }

    public final synchronized void m6108a(String str) {
        if (!Strings.isNullOrEmpty(str) && ((LiveStreamingSubscriber) get(str)) == null) {
            LiveStreamingSubscriber liveStreamingSubscriber = new LiveStreamingSubscriber(str, this.f5623b, this.f5624c);
            liveStreamingSubscriber.b();
            super.put(str, liveStreamingSubscriber);
        }
    }

    @Nullable
    public final synchronized InterruptedMessage m6109b(String str) {
        LiveStreamingSubscriber liveStreamingSubscriber;
        liveStreamingSubscriber = (LiveStreamingSubscriber) super.get(str);
        return liveStreamingSubscriber != null ? liveStreamingSubscriber.a() : null;
    }
}
