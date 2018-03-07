package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.feed.util.event.RefreshEvent$CollapseRefreshEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$CollapseRefreshSubscriber extends RefreshEvent$CollapseRefreshEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10670a;

    public MegaSoundEventsSubscriber$CollapseRefreshSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10670a = megaSoundEventsSubscriber;
    }

    public final void m11143b(FbEvent fbEvent) {
        MegaSoundEventsSubscriber.b(this.f10670a, "collapse_after_refresh");
    }
}
