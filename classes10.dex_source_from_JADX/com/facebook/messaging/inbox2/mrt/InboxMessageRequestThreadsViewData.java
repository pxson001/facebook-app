package com.facebook.messaging.inbox2.mrt;

import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: send_media_item */
public class InboxMessageRequestThreadsViewData {
    public final ImmutableList<ThreadSummary> f2854a;

    public InboxMessageRequestThreadsViewData(ImmutableList<ThreadSummary> immutableList) {
        this.f2854a = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }
}
