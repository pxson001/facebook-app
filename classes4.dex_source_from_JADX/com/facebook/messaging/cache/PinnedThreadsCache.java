package com.facebook.messaging.cache;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

@VisibleForTesting
/* compiled from: is_fb_employee */
public class PinnedThreadsCache {
    private final ThreadsCacheLock f10026a;
    private List<ThreadKey> f10027b = Lists.a();
    private long f10028c = 0;
    private boolean f10029d;
    private boolean f10030e;

    public PinnedThreadsCache(ThreadsCacheLock threadsCacheLock) {
        this.f10026a = threadsCacheLock;
    }

    public final void m10478a(Iterable<ThreadKey> iterable) {
        this.f10026a.m10459b();
        this.f10027b = Lists.a(iterable);
    }

    public final void m10477a(ThreadKey threadKey) {
        this.f10026a.m10459b();
        if (!this.f10027b.contains(threadKey)) {
            this.f10027b.add(threadKey);
        }
    }

    public final boolean m10482b(ThreadKey threadKey) {
        this.f10026a.m10459b();
        return this.f10027b.remove(threadKey);
    }

    public final void m10476a(long j) {
        this.f10026a.m10459b();
        this.f10028c = j;
    }

    public final ImmutableList<ThreadKey> m10475a() {
        this.f10026a.m10459b();
        return ImmutableList.copyOf(this.f10027b);
    }

    public final long m10480b() {
        this.f10026a.m10459b();
        return this.f10028c;
    }

    public final void m10479a(boolean z) {
        this.f10026a.m10459b();
        this.f10029d = z;
    }

    public final void m10481b(boolean z) {
        this.f10026a.m10459b();
        this.f10030e = z;
    }

    public final boolean m10483c() {
        this.f10026a.m10459b();
        return this.f10030e;
    }

    public final void m10484d() {
        this.f10026a.m10459b();
        this.f10027b = Lists.a();
        this.f10029d = false;
        this.f10030e = false;
        this.f10028c = -1;
    }
}
