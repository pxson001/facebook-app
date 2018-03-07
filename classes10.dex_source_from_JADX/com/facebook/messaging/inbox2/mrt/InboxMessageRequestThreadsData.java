package com.facebook.messaging.inbox2.mrt;

import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: send_null_threadkey */
public class InboxMessageRequestThreadsData {
    public final ImmutableList<ThreadSummary> f2853a;

    public InboxMessageRequestThreadsData(ImmutableList<ThreadSummary> immutableList) {
        this.f2853a = immutableList;
    }
}
