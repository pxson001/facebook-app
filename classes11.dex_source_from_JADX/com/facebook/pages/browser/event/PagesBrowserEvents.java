package com.facebook.pages.browser.event;

/* compiled from: stretch */
public class PagesBrowserEvents {

    /* compiled from: stretch */
    public class PageLikedEvent extends PagesBrowserEvent {
        public final String f1290a;
        public final boolean f1291b;

        public PageLikedEvent(String str, boolean z) {
            this.f1290a = str;
            this.f1291b = z;
        }
    }

    /* compiled from: stretch */
    public abstract class PageLikedEventSubscriber extends PagesBrowserEventSubscriber<PageLikedEvent> {
        public final Class<PageLikedEvent> m1937a() {
            return PageLikedEvent.class;
        }
    }
}
