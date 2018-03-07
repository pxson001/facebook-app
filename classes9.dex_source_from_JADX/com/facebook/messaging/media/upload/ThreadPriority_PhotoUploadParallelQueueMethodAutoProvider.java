package com.facebook.messaging.media.upload;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractProvider;

/* compiled from: leaveGroup() not supported yet */
public class ThreadPriority_PhotoUploadParallelQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return ThreadPriority.NORMAL_NEW;
    }
}
