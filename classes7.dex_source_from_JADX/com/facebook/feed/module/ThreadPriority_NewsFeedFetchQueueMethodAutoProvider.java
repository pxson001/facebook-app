package com.facebook.feed.module;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractProvider;

/* compiled from: album_name */
public class ThreadPriority_NewsFeedFetchQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return ThreadPriority.URGENT;
    }
}
