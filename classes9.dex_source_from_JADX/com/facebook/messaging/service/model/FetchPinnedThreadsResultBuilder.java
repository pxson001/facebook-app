package com.facebook.messaging.service.model;

import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: countries */
public class FetchPinnedThreadsResultBuilder {
    public List<ThreadSummary> f17104a = RegularImmutableList.a;
    public boolean f17105b;
    public long f17106c = 0;
    public long f17107d = -1;

    FetchPinnedThreadsResultBuilder() {
    }

    public final FetchPinnedThreadsResultBuilder m17094a(List<ThreadSummary> list) {
        this.f17104a = list;
        return this;
    }

    public final FetchPinnedThreadsResultBuilder m17095a(boolean z) {
        this.f17105b = z;
        return this;
    }

    public final FetchPinnedThreadsResultBuilder m17093a(long j) {
        this.f17106c = j;
        return this;
    }

    public final FetchPinnedThreadsResultBuilder m17096b(long j) {
        this.f17107d = j;
        return this;
    }

    public final FetchPinnedThreadsResult m17097e() {
        return new FetchPinnedThreadsResult(this);
    }
}
