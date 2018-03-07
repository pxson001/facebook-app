package com.facebook.prefetch.feed.scheduler;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: no_pin */
public class NewsFeedPrefetchBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    public static final String f7090a = NewsFeedPrefetchBroadcastReceiver.class.getSimpleName();

    public NewsFeedPrefetchBroadcastReceiver() {
        super("com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchBroadcastReceiver.INITIATE_BACKGROUND_FETCH", new InitiateFetchReceiver());
    }
}
