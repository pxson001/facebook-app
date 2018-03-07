package com.facebook.messaging.send.service;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: react_sample */
public class ThreadPriority_SendQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return MessagingSendServiceModule.m3620a(ProductMethodAutoProvider.b(this), IdBasedProvider.a(this, 4083));
    }
}
