package com.facebook.http.common;

import android.os.Process;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: num_server_unseen_bumped_stories_in_last_result */
public class PriorityRequestHolder<T> {
    public final SettableFuture<T> f11886a;
    public final int f11887b;
    public final FbHttpRequest<?> f11888c;
    private final RequestPriority f11889d;
    private final RequestPriority f11890e;

    public final RequestPriority m17395a() {
        return this.f11890e != null ? this.f11890e : this.f11889d;
    }

    public PriorityRequestHolder(FbHttpRequest<?> fbHttpRequest) {
        this.f11888c = fbHttpRequest;
        this.f11887b = Process.getThreadPriority(Process.myTid());
        this.f11886a = SettableFuture.m1547f();
        this.f11889d = fbHttpRequest.m12235h();
        this.f11890e = null;
    }

    public PriorityRequestHolder(PriorityRequestHolder priorityRequestHolder, RequestPriority requestPriority) {
        this.f11888c = priorityRequestHolder.f11888c;
        this.f11887b = priorityRequestHolder.f11887b;
        this.f11886a = priorityRequestHolder.f11886a;
        this.f11889d = requestPriority;
        this.f11890e = null;
    }

    private PriorityRequestHolder(PriorityRequestHolder priorityRequestHolder, RequestPriority requestPriority, RequestPriority requestPriority2) {
        this.f11888c = priorityRequestHolder.f11888c;
        this.f11887b = priorityRequestHolder.f11887b;
        this.f11886a = priorityRequestHolder.f11886a;
        this.f11889d = requestPriority;
        this.f11890e = requestPriority2;
    }

    public final PriorityRequestHolder m17396b(RequestPriority requestPriority) {
        return new PriorityRequestHolder(this, this.f11889d, requestPriority);
    }
}
