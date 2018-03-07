package com.facebook.offlinemode.common;

import javax.annotation.Nullable;

/* compiled from: feed_type */
public class OfflineQueryBehavior {
    public static final OfflineQueryBehavior f11813a = new OfflineQueryBehavior();
    public static final OfflineQueryBehavior f11814b = new OfflineQueryBehavior();
    public static final OfflineQueryBehavior f11815c = new FakeResult(null);

    /* compiled from: feed_type */
    public final class FakeResult extends OfflineQueryBehavior {
        @Nullable
        public final Object f11816d;

        public FakeResult(@Nullable Object obj) {
            this.f11816d = obj;
        }
    }
}
