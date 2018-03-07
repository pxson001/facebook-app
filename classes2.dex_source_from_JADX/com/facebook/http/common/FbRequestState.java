package com.facebook.http.common;

import com.facebook.http.interfaces.ConnectionPrioritizerTrigger;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.interfaces.RequestStage;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.apache.http.conn.ConnectionReleaseTrigger;

/* compiled from: res */
public class FbRequestState {
    private static final Class<?> f7185a = FbRequestState.class;
    private final Object f7186b;
    private String f7187c;
    @Nullable
    private volatile ConnectionPrioritizerTrigger f7188d;
    @Nullable
    public volatile ConnectionReleaseTrigger f7189e;
    private volatile RequestPriority f7190f;
    private AtomicReference<RequestPriority> f7191g;
    @GuardedBy("mPriorityLock")
    private RequestPriority f7192h;
    public volatile RequestStage f7193i;
    public volatile boolean f7194j;
    public volatile Map<String, String> f7195k;

    public FbRequestState(String str) {
        this(str, null);
    }

    public FbRequestState(String str, @Nullable RequestPriority requestPriority) {
        this.f7186b = new Object();
        this.f7193i = RequestStage.CREATED;
        this.f7187c = (String) Preconditions.checkNotNull(str);
        this.f7190f = requestPriority;
        this.f7191g = new AtomicReference(null);
        this.f7194j = false;
    }

    public final RequestPriority m11633a() {
        if (this.f7190f != null) {
            return this.f7190f;
        }
        RequestPriority requestPriority = (RequestPriority) this.f7191g.get();
        if (requestPriority != null) {
            return requestPriority;
        }
        return RequestPriority.INTERACTIVE;
    }

    public final boolean m11638b() {
        return this.f7194j;
    }

    public final void m11636a(RequestPriority requestPriority, boolean z) {
        Preconditions.checkNotNull(requestPriority, "Cannot change priority to null");
        synchronized (this.f7186b) {
            RequestPriority requestPriority2 = this.f7190f;
            this.f7190f = requestPriority;
            if (!z) {
            } else if (this.f7188d == null) {
                this.f7192h = requestPriority;
            } else {
                m11632a(requestPriority, requestPriority2);
            }
        }
    }

    public final void m11639c() {
        synchronized (this.f7186b) {
            this.f7190f = RequestPriority.UNNECESSARY;
            if (this.f7189e == null) {
                return;
            }
            this.f7192h = null;
            this.f7189e.abortConnection();
        }
    }

    public final void m11634a(ConnectionPrioritizerTrigger connectionPrioritizerTrigger) {
        synchronized (this.f7186b) {
            this.f7188d = (ConnectionPrioritizerTrigger) Preconditions.checkNotNull(connectionPrioritizerTrigger);
            if (this.f7192h != null) {
                m11632a(this.f7192h, m11633a());
            }
        }
    }

    public final void m11635a(RequestPriority requestPriority) {
        if (requestPriority != null) {
            this.f7190f = requestPriority;
        }
    }

    public final void m11637b(@Nullable RequestPriority requestPriority) {
        if (requestPriority != null) {
            this.f7191g.compareAndSet(null, requestPriority);
        }
    }

    private void m11632a(RequestPriority requestPriority, RequestPriority requestPriority2) {
        synchronized (this.f7186b) {
            this.f7190f = requestPriority;
            this.f7192h = null;
            this.f7188d.mo1675a(requestPriority);
        }
    }

    public final Map<String, String> m11640e() {
        return this.f7195k;
    }
}
