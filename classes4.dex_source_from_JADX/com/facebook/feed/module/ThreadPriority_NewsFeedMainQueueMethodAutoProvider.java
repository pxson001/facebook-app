package com.facebook.feed.module;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractProvider;

/* compiled from: profileImageSmall */
public class ThreadPriority_NewsFeedMainQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return ThreadPriority.FOREGROUND;
    }
}
