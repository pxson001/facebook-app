package com.facebook.orca.server.module;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: nearby_friends_self_view_region_topic_id_empty */
public class ThreadPriority_MultiCacheThreadsQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return MessagesServiceModule.m6029a(ProductMethodAutoProvider.b(this));
    }
}
