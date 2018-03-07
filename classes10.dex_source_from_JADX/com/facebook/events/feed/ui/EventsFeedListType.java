package com.facebook.events.feed.ui;

import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;

/* compiled from: com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY */
public class EventsFeedListType implements FeedListType {
    public static final EventsFeedListType f17454a = new EventsFeedListType();

    private EventsFeedListType() {
    }

    public final FeedListName m17803a() {
        return FeedListName.EVENTS;
    }

    public static EventsFeedListType m17802b() {
        return f17454a;
    }
}
