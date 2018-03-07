package com.facebook.feed.util.event;

import com.facebook.feed.rows.core.events.KeyedEvent;

/* compiled from: messageMetadata */
public class AwesomizerViewEvents {

    /* compiled from: messageMetadata */
    public class CardClosedEvent extends FeedEvent implements KeyedEvent<String> {
        public int f10419a;
        public boolean f10420b;
        public long f10421c;

        public CardClosedEvent(int i, boolean z, long j) {
            this.f10419a = i;
            this.f10420b = z;
            this.f10421c = j;
        }

        public final Object m16602c() {
            return String.valueOf(this.f10419a);
        }
    }
}
