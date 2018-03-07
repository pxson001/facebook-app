package com.facebook.pages.common.job_sequencer;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: share_preview_only */
public class SequencedJob<T> {
    private final Priority f1639a;
    public final String f1640b;
    private final List<Long> f1641c;
    public final long f1642d;
    private Callable<T> f1643e;
    private boolean f1644f = true;
    private List<FutureCallbackHolder> f1645g;

    /* compiled from: share_preview_only */
    public final class Builder<T> {
        public Priority f1630a = Priority.CAN_WAIT;
        public String f1631b = "default_group_id";
        public List<Long> f1632c = new ArrayList();
        public long f1633d = 0;
        public Callable<T> f1634e = null;
        public boolean f1635f = true;
        public List<FutureCallbackHolder> f1636g = new ArrayList();

        public final Builder m2452a(Priority priority) {
            this.f1630a = priority;
            return this;
        }

        public final Builder m2454a(String str) {
            this.f1631b = str;
            return this;
        }

        public final Builder m2453a(@Nullable ImmutableSet<SequencerSignal> immutableSet) {
            this.f1632c.add(Long.valueOf(SequencedJob.m2457a((ImmutableSet) immutableSet)));
            return this;
        }

        public final Builder m2455a(Callable<T> callable, boolean z) {
            this.f1634e = callable;
            this.f1635f = z;
            return this;
        }

        public final SequencedJob<T> m2456a() {
            return new SequencedJob(this);
        }
    }

    /* compiled from: share_preview_only */
    class FutureCallbackHolder<T> {
        public final FutureCallback<T> f1637a;
        public final boolean f1638b;
    }

    /* compiled from: share_preview_only */
    public enum Priority {
        INTERACTIVE,
        CAN_WAIT
    }

    public SequencedJob(Builder builder) {
        this.f1639a = builder.f1630a;
        this.f1640b = builder.f1631b;
        this.f1641c = builder.f1632c;
        this.f1642d = builder.f1633d;
        this.f1643e = builder.f1634e;
        this.f1644f = builder.f1635f;
        this.f1645g = builder.f1636g;
    }

    public final boolean m2460a(long j) {
        if (this.f1643e == null) {
            return false;
        }
        for (Long longValue : this.f1641c) {
            long longValue2 = longValue.longValue();
            if (longValue2 == (longValue2 & j)) {
                return true;
            }
        }
        return false;
    }

    public final ListenableFuture<T> m2459a(ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2) {
        ListenableFuture<T> a = this.f1644f ? listeningExecutorService.a(this.f1643e) : listeningExecutorService2.a(this.f1643e);
        for (FutureCallbackHolder futureCallbackHolder : this.f1645g) {
            Executor executor;
            FutureCallback futureCallback = futureCallbackHolder.f1637a;
            if (futureCallbackHolder.f1638b) {
                executor = listeningExecutorService;
            } else {
                executor = listeningExecutorService2;
            }
            Futures.a(a, futureCallback, executor);
        }
        return a;
    }

    public final Priority m2458a() {
        return this.f1639a;
    }

    public final String m2461b() {
        return this.f1640b;
    }

    public static long m2457a(@Nullable ImmutableSet<SequencerSignal> immutableSet) {
        if (immutableSet == null || immutableSet.isEmpty()) {
            return 0;
        }
        Iterator it = immutableSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((long) (1 << ((SequencerSignal) it.next()).ordinal())) | j;
        }
        return j;
    }
}
