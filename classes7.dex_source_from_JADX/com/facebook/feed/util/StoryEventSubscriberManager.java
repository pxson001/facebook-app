package com.facebook.feed.util;

import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: Tab layout should be a subclass of TextView and pager adapter should be a subclass of IconAndTextPagerAdapter */
public class StoryEventSubscriberManager {
    public final FbEventSubscriberListManager f22335a;
    public final FeedEventBus f22336b;
    public boolean f22337c;

    public static StoryEventSubscriberManager m24938a(InjectorLike injectorLike) {
        return new StoryEventSubscriberManager(FbEventSubscriberListManager.a(injectorLike), FeedEventBus.a(injectorLike));
    }

    @Inject
    public StoryEventSubscriberManager(FbEventSubscriberListManager fbEventSubscriberListManager, FeedEventBus feedEventBus) {
        this.f22335a = fbEventSubscriberListManager;
        this.f22336b = feedEventBus;
    }

    public final void m24940a(FbEventSubscriber... fbEventSubscriberArr) {
        if (!this.f22337c) {
            this.f22335a.a(fbEventSubscriberArr);
            m24939d();
            this.f22337c = true;
        }
    }

    public final void m24941b() {
        m24939d();
    }

    private void m24939d() {
        this.f22335a.a(this.f22336b);
    }
}
