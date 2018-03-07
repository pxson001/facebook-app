package com.facebook.feed.util;

import com.facebook.content.event.FbEvent;
import com.facebook.feed.util.event.RefreshEvent$PullToRefreshEvent;
import com.facebook.feed.util.event.RefreshEvent$PullToRefreshEventSubscriber;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$PullToRefreshSubscriber extends RefreshEvent$PullToRefreshEventSubscriber {
    final /* synthetic */ MegaSoundEventsSubscriber f10669a;

    public MegaSoundEventsSubscriber$PullToRefreshSubscriber(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10669a = megaSoundEventsSubscriber;
    }

    public final void m11141b(FbEvent fbEvent) {
        String str;
        RefreshEvent$PullToRefreshEvent refreshEvent$PullToRefreshEvent = (RefreshEvent$PullToRefreshEvent) fbEvent;
        MegaSoundEventsSubscriber megaSoundEventsSubscriber = this.f10669a;
        if (refreshEvent$PullToRefreshEvent.f10671a >= 14000.0f) {
            str = "pull_to_refresh_fast";
        } else if (refreshEvent$PullToRefreshEvent.f10671a >= 7000.0f) {
            str = "pull_to_refresh_medium";
        } else {
            str = "pull_to_refresh_slow";
        }
        MegaSoundEventsSubscriber.b(megaSoundEventsSubscriber, str);
    }
}
