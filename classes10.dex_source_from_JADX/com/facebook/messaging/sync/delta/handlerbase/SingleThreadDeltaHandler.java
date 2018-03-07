package com.facebook.messaging.sync.delta.handlerbase;

import android.os.Bundle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: profile_qr */
public abstract class SingleThreadDeltaHandler extends AbstractMessagesDeltaHandler {
    private static final String f4428a = SingleThreadDeltaHandler.class.getCanonicalName();
    private final Lazy<MessageSyncAnalyticsLogger> f4429b;

    public abstract Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId);

    protected SingleThreadDeltaHandler(Lazy<MessageSyncAnalyticsLogger> lazy) {
        this.f4429b = lazy;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ImmutableSet a = mo126a((DeltaWrapper) deltaWithSequenceId.a);
        Preconditions.checkNotNull(a);
        Preconditions.checkArgument(a.size() == 1, "Classes extending SingleThreadDeltaHandler should not ensure more than one thread.");
        ThreadKey threadKey = (ThreadKey) a.iterator().next();
        if (prefetchedSyncData.f4426c.contains(threadKey)) {
            ((MessageSyncAnalyticsLogger) this.f4429b.get()).a(((DeltaWrapper) deltaWithSequenceId.a).setField_, "thread_up_to_date");
            return new Bundle();
        } else if (prefetchedSyncData.f4427d.contains(threadKey)) {
            ((MessageSyncAnalyticsLogger) this.f4429b.get()).a(((DeltaWrapper) deltaWithSequenceId.a).setField_, "thread_non_existing");
            return new Bundle();
        } else {
            Bundle a2 = mo125a(prefetchedSyncData.m3994a(threadKey), (DeltaWithSequenceId) deltaWithSequenceId);
            if (a2.containsKey("threadSummary")) {
                ThreadSummary threadSummary = (ThreadSummary) a2.getParcelable("threadSummary");
                a2.remove("threadSummary");
                Builder builder = ImmutableMap.builder();
                Iterator it = prefetchedSyncData.f4425b.entrySet().iterator();
                while (it.hasNext()) {
                    Object obj;
                    Entry entry = (Entry) it.next();
                    if (((ThreadKey) entry.getKey()).equals(threadSummary.a)) {
                        obj = threadSummary;
                    } else {
                        ThreadSummary threadSummary2 = (ThreadSummary) entry.getValue();
                    }
                    builder.b(entry.getKey(), obj);
                }
                a2.putParcelable("updatedPrefetchData", new PrefetchedSyncData(builder.b(), prefetchedSyncData.f4426c, prefetchedSyncData.f4427d));
            }
            return a2;
        }
    }
}
