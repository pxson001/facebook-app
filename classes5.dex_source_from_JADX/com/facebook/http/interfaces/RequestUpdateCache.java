package com.facebook.http.interfaces;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collection;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: directoryNode= */
public class RequestUpdateCache<S> {
    public final Object f5056a;
    @GuardedBy("mLock")
    public final Multimap<S, RequestUpdater> f5057b;

    public RequestUpdateCache() {
        this(-1);
    }

    public RequestUpdateCache(int i) {
        ArrayListMultimap arrayListMultimap;
        this.f5056a = new Object();
        if (i != -1) {
            arrayListMultimap = new ArrayListMultimap(i, i);
        } else {
            arrayListMultimap = ArrayListMultimap.t();
        }
        this.f5057b = arrayListMultimap;
    }

    public final void m9976a(final S s, final RequestUpdater requestUpdater) {
        Preconditions.checkNotNull(s);
        if (requestUpdater != null) {
            synchronized (this.f5056a) {
                this.f5057b.a(s, requestUpdater);
            }
            requestUpdater.a(new Runnable(this) {
                final /* synthetic */ RequestUpdateCache f5055c;

                public void run() {
                    synchronized (this.f5055c.f5056a) {
                        this.f5055c.f5057b.c(s, requestUpdater);
                    }
                }
            }, MoreExecutors.a());
        }
    }

    public final void m9975a(S s, RequestPriority requestPriority) {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(requestPriority);
        synchronized (this.f5056a) {
            Collection<RequestUpdater> c = this.f5057b.c(s);
        }
        if (c != null) {
            for (RequestUpdater a : c) {
                a.a(requestPriority);
            }
        }
    }
}
