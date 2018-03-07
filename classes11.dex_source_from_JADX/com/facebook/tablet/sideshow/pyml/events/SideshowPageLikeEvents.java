package com.facebook.tablet.sideshow.pyml.events;

import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.FeedEventSubscriber;

/* compiled from: onDrawerClose */
public class SideshowPageLikeEvents {

    /* compiled from: onDrawerClose */
    public abstract class PageLikeClickedEventSubscriber extends FeedEventSubscriber<PageLikeClickedEvent> {
        public final Class<PageLikeClickedEvent> m5979a() {
            return PageLikeClickedEvent.class;
        }
    }

    /* compiled from: onDrawerClose */
    public class PageLikeClickedEvent extends FeedEvent {
        public final String f4814a;
        public final boolean f4815b;
        public final String f4816c;

        public PageLikeClickedEvent(String str, boolean z, String str2) {
            this.f4814a = str;
            this.f4815b = z;
            this.f4816c = str2;
        }
    }
}
