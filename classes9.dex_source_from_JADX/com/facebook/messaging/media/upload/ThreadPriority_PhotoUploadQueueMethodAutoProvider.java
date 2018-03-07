package com.facebook.messaging.media.upload;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractProvider;

/* compiled from: layoutMeasurement */
public class ThreadPriority_PhotoUploadQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return ThreadPriority.NORMAL_NEW;
    }
}
