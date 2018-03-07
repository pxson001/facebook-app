package com.facebook.auth.login;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractProvider;

/* compiled from: task_tag */
public class ThreadPriority_AuthQueueMethodAutoProvider extends AbstractProvider<ThreadPriority> {
    public Object get() {
        return ThreadPriority.URGENT;
    }
}
