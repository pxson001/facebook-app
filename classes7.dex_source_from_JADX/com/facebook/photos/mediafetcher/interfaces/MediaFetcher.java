package com.facebook.photos.mediafetcher.interfaces;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: last_active_messages_status */
public abstract class MediaFetcher<Q extends MediaQuery, E> {
    private static final String f10539a = MediaFetcher.class.getSimpleName();
    private final CopyOnWriteArrayList<MediaFetcherListener<E>> f10540b = new CopyOnWriteArrayList();
    private final Throwable f10541c;
    public ImmutableList<E> f10542d = RegularImmutableList.a;
    public Status f10543e = Status.DONE;
    private final DefaultAndroidThreadUtil f10544f;
    private final AbstractFbErrorReporter f10545g;

    /* compiled from: last_active_messages_status */
    public interface MediaFetcherListener<T> {
        void mo1487a(Status status);

        void mo1488a(ImmutableList<T> immutableList);
    }

    /* compiled from: last_active_messages_status */
    public enum Status {
        LOADING,
        ERROR,
        DONE,
        CLOSED
    }

    public abstract void mo597a(int i, Optional<String> optional);

    public abstract boolean mo599d();

    public final void m12400a(int i) {
        mo597a(i, Absent.INSTANCE);
    }

    protected MediaFetcher(Q q, AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter) {
        Preconditions.checkNotNull(q);
        this.f10544f = (DefaultAndroidThreadUtil) Preconditions.checkNotNull(androidThreadUtil);
        this.f10545g = fbErrorReporter;
        this.f10541c = new Throwable();
    }

    public final void m12402a(MediaFetcherListener<E> mediaFetcherListener) {
        Preconditions.checkState(this.f10543e != Status.CLOSED, "Calling method of closed() fetcher");
        this.f10540b.add(mediaFetcherListener);
    }

    public final void m12405b(MediaFetcherListener mediaFetcherListener) {
        this.f10540b.remove(mediaFetcherListener);
    }

    protected final void m12404a(ImmutableList<E> immutableList) {
        this.f10544f.a();
        Preconditions.checkState(this.f10543e != Status.CLOSED, "Calling method of closed() fetcher");
        this.f10542d = immutableList;
        Iterator it = this.f10540b.iterator();
        while (it.hasNext()) {
            try {
                ((MediaFetcherListener) it.next()).mo1488a((ImmutableList) immutableList);
            } catch (Throwable th) {
                this.f10545g.b(f10539a + "::notifyDataChanged", "Clients must not throw exceptions in listener callbacks", th);
            }
        }
    }

    public final void m12403a(Status status) {
        this.f10544f.a();
        Preconditions.checkState(this.f10543e != Status.CLOSED, "Calling method of closed() fetcher");
        this.f10543e = status;
        Iterator it = this.f10540b.iterator();
        while (it.hasNext()) {
            try {
                ((MediaFetcherListener) it.next()).mo1487a(status);
            } catch (Throwable th) {
                this.f10545g.b(f10539a + "::notifyStatusChanged", "Clients must not throw exceptions in listener callbacks", th);
            }
        }
    }

    public void mo598c() {
        this.f10544f.a();
        m12403a(Status.CLOSED);
        this.f10540b.clear();
    }

    protected void finalize() {
        super.finalize();
        if (this.f10543e != Status.CLOSED) {
            this.f10545g.b(f10539a + " finalized in wrong state: " + this.f10543e, "Client must always call close() when it's done with MediaFetcher", this.f10541c);
        }
    }
}
