package com.facebook.http.protocol;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: dialtone_not_in_region_flag */
public class HttpRequestAbortHandler {
    @GuardedBy("this")
    private HttpUriRequest f5082a;

    public final synchronized boolean m9994a() {
        boolean z;
        if (this.f5082a != null) {
            this.f5082a.abort();
            this.f5082a = null;
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized void m9993a(@Nullable HttpUriRequest httpUriRequest) {
        this.f5082a = httpUriRequest;
    }
}
