package com.facebook.messaging.inbox2.data.common;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: session_ids */
public class InboxUnitSnapshot {
    public final DataFreshnessResult f2754a;
    public final InboxUnitsToFetch f2755b;
    public final long f2756c;
    public final ImmutableList<InboxUnit<?>> f2757d;

    public InboxUnitSnapshot(DataFreshnessResult dataFreshnessResult, InboxUnitsToFetch inboxUnitsToFetch, long j, ImmutableList<InboxUnit<?>> immutableList) {
        this.f2754a = dataFreshnessResult;
        this.f2755b = inboxUnitsToFetch;
        this.f2756c = j;
        this.f2757d = immutableList;
    }
}
