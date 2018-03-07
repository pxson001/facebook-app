package com.facebook.feed.autoplay;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;

/* compiled from: nearbyAlertFilter */
public abstract class VideoViewController<V> {
    public final String f10133a;

    public abstract void mo1035a(V v);

    public abstract void mo1037b(V v);

    public VideoViewController(String str) {
        this.f10133a = str;
    }

    public final String m15807a() {
        return this.f10133a;
    }

    public void mo1036a(V v, EventTriggerType eventTriggerType) {
        mo1035a(v);
    }
}
