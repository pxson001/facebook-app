package com.facebook.messaging.send.service;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: received bad faceweb data */
public class ThreadPriority_PendingSendQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return MessagingSendServiceModule.m3621b(ProductMethodAutoProvider.b(this), IdBasedProvider.a(this, 4083));
    }
}
