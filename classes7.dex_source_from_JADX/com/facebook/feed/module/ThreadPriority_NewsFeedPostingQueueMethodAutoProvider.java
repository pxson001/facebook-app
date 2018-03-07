package com.facebook.feed.module;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractProvider;

/* compiled from: album_location_changed */
public class ThreadPriority_NewsFeedPostingQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return ThreadPriority.URGENT;
    }
}
