package com.facebook.messaging.cache;

import com.facebook.debug.log.BLog;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: is_first_sequence */
public class ThreadSummariesCache {
    private final ThreadsCacheLock f10019a;
    private final Map<ThreadKey, ThreadSummary> f10020b = Maps.c();
    private final Map<String, ThreadSummary> f10021c = Maps.c();
    private final Map<ThreadKey, ThreadLocalState> f10022d = Maps.c();

    public ThreadSummariesCache(ThreadsCacheLock threadsCacheLock) {
        this.f10019a = threadsCacheLock;
    }

    public final void m10463a(ThreadSummary threadSummary) {
        this.f10019a.m10459b();
        this.f10020b.put(threadSummary.a, threadSummary);
        this.f10021c.put(threadSummary.b, threadSummary);
    }

    public final void m10464a(Iterable<ThreadSummary> iterable) {
        for (ThreadSummary a : iterable) {
            m10463a(a);
        }
    }

    public final ThreadSummary m10460a(ThreadKey threadKey) {
        this.f10019a.m10459b();
        ThreadSummary threadSummary = (ThreadSummary) this.f10020b.remove(threadKey);
        if (threadSummary != null) {
            this.f10021c.remove(threadSummary.b);
        }
        return threadSummary;
    }

    @Nullable
    public final ThreadSummary m10465b(ThreadKey threadKey) {
        this.f10019a.m10459b();
        return (ThreadSummary) this.f10020b.get(threadKey);
    }

    public final boolean m10467c(ThreadKey threadKey) {
        this.f10019a.m10459b();
        return this.f10020b.containsKey(threadKey);
    }

    @Nullable
    public final ThreadSummary m10461a(String str) {
        this.f10019a.m10459b();
        return (ThreadSummary) this.f10021c.get(str);
    }

    final ThreadLocalState m10468d(ThreadKey threadKey) {
        this.f10019a.m10459b();
        if (threadKey == null) {
            BLog.c("ThreadSummariesCache", "ensuring null threadId ThreadLocalState");
        }
        ThreadLocalState threadLocalState = (ThreadLocalState) this.f10022d.get(threadKey);
        if (threadLocalState != null) {
            return threadLocalState;
        }
        threadLocalState = new ThreadLocalState(threadKey);
        this.f10022d.put(threadKey, threadLocalState);
        return threadLocalState;
    }

    public final void m10462a() {
        this.f10019a.m10459b();
        for (ThreadLocalState c : this.f10022d.values()) {
            c.c();
        }
    }

    public final void m10466b() {
        this.f10019a.m10459b();
        this.f10020b.clear();
        this.f10021c.clear();
        this.f10022d.clear();
    }
}
