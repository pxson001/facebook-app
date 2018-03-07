package com.facebook.http.common;

import android.os.SystemClock;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.interfaces.RequestStage;
import com.facebook.http.interfaces.RequestState;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.http.protocol.HttpWireCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultRedirectHandler;

/* compiled from: related_share_video_hide */
public class FbHttpRequest<T> {
    private static final Class<?> f7684a = FbHttpRequest.class;
    public final HttpUriRequest f7685b;
    public final String f7686c;
    @Nullable
    public final CallerContext f7687d;
    @Nullable
    public final String f7688e;
    public final FallbackBehavior f7689f;
    public final ResponseHandler<? extends T> f7690g;
    public final RedirectHandler f7691h;
    public final FbHttpRequestCancelTrigger f7692i;
    public final FbRequestState f7693j;
    public final RequestIdempotency f7694k;
    public final Optional<List<HttpFlowStatistics>> f7695l;
    @Nullable
    public final String f7696m;
    public final int f7697n;
    public final long f7698o;
    public final boolean f7699p;
    @Nullable
    public final HttpWireCallback f7700q;

    /* compiled from: related_share_video_hide */
    public class Builder<T> {
        private static final AtomicInteger f7701a = new AtomicInteger(0);
        public HttpUriRequest f7702b;
        public String f7703c;
        public CallerContext f7704d;
        public String f7705e;
        public FallbackBehavior f7706f = FallbackBehavior.FALLBACK_NOT_REQUIRED;
        public ResponseHandler<? extends T> f7707g;
        public RedirectHandler f7708h;
        public FbHttpRequestCancelTrigger f7709i;
        public FbRequestState f7710j;
        public RequestIdempotency f7711k = RequestIdempotency.CONSERVATIVE;
        public RequestPriority f7712l;
        public String f7713m;
        private List<HttpFlowStatistics> f7714n;
        public int f7715o;
        public long f7716p;
        public boolean f7717q;
        public HttpWireCallback f7718r;

        public final Builder<T> m12254a(HttpUriRequest httpUriRequest) {
            this.f7702b = httpUriRequest;
            return this;
        }

        public final Builder<T> m12250a(String str) {
            this.f7703c = str;
            return this;
        }

        public final Builder<T> m12246a(CallerContext callerContext) {
            this.f7704d = callerContext;
            return this;
        }

        public final Builder<T> m12257b(String str) {
            this.f7705e = str;
            return this;
        }

        public final Builder<T> m12253a(ResponseHandler<? extends T> responseHandler) {
            this.f7707g = responseHandler;
            return this;
        }

        public final Builder<T> m12252a(RedirectHandler redirectHandler) {
            this.f7708h = redirectHandler;
            return this;
        }

        public final Builder<T> m12247a(FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger) {
            this.f7709i = fbHttpRequestCancelTrigger;
            return this;
        }

        public final Builder<T> m12248a(RequestIdempotency requestIdempotency) {
            this.f7711k = requestIdempotency;
            return this;
        }

        public final Builder<T> m12249a(RequestPriority requestPriority) {
            this.f7712l = requestPriority;
            return this;
        }

        public final Builder m12251a(List<HttpFlowStatistics> list) {
            this.f7714n = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @VisibleForTesting
        final Builder<T> m12245a(long j) {
            this.f7716p = j;
            return this;
        }

        public final Builder<T> m12255a(boolean z) {
            this.f7717q = z;
            return this;
        }

        public final FbHttpRequest<T> m12256a() {
            if (this.f7709i == null) {
                this.f7709i = new FbHttpRequestCancelTrigger();
            }
            RedirectHandler redirectHandler = this.f7708h;
            if (redirectHandler == null) {
                redirectHandler = new DefaultRedirectHandler();
            }
            if (this.f7715o == 0) {
                this.f7715o = f7701a.incrementAndGet();
            }
            if (this.f7716p == 0) {
                this.f7716p = SystemClock.uptimeMillis();
            }
            if (this.f7710j == null) {
                this.f7710j = new FbRequestState(this.f7703c);
            }
            this.f7710j.m11637b(RequestPriority.NON_INTERACTIVE);
            if (this.f7712l != null) {
                this.f7710j.m11635a(this.f7712l);
            }
            return new FbHttpRequest(this.f7702b, this.f7703c, this.f7704d, this.f7705e, this.f7706f, this.f7707g, redirectHandler, this.f7709i, this.f7710j, this.f7711k, this.f7713m, this.f7715o, this.f7716p, this.f7717q, Optional.fromNullable(this.f7714n), this.f7718r);
        }
    }

    public final HttpUriRequest m12228a() {
        return this.f7685b;
    }

    public final String m12231b() {
        return this.f7686c;
    }

    public final boolean m12244r() {
        String str = this.f7686c;
        return this.f7699p || str.equals("image") || str.equals("getVideo-1RT") || str.equals("rangeRequestForVideo");
    }

    @Nullable
    public final CallerContext m12232c() {
        return this.f7687d;
    }

    public final ResponseHandler<? extends T> m12233f() {
        return this.f7690g;
    }

    public final RedirectHandler m12234g() {
        return this.f7691h;
    }

    public final void m12229a(RequestStage requestStage) {
        this.f7693j.f7193i = requestStage;
    }

    public final void m12230a(boolean z) {
        this.f7693j.f7194j = z;
    }

    public final RequestPriority m12235h() {
        return this.f7693j.m11633a();
    }

    public final FbRequestState m12236i() {
        return this.f7693j;
    }

    public final RequestIdempotency m12237j() {
        return this.f7694k;
    }

    public final long m12238l() {
        return this.f7698o;
    }

    public final StringBuilder m12227a(StringBuilder stringBuilder) {
        String str;
        StringBuilder append = stringBuilder.append(this.f7697n).append(" [").append(FbHttpUtils.a(m12235h())).append("] [").append(this.f7693j.f7193i.toChar()).append("] ");
        if (m12244r()) {
            str = "(big) ";
        } else {
            str = "";
        }
        append.append(str).append(this.f7686c).append("__").append(FbHttpUtils.b(this));
        return stringBuilder;
    }

    public final int m12239m() {
        return this.f7697n;
    }

    public final boolean m12240n() {
        return this.f7699p;
    }

    @Nullable
    public final HttpWireCallback m12241o() {
        return this.f7700q;
    }

    public final Optional<List<HttpFlowStatistics>> m12242p() {
        return this.f7695l;
    }

    public final long m12243q() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.f7698o;
        if (uptimeMillis < 0) {
            return 0;
        }
        return uptimeMillis;
    }

    public String toString() {
        return m12227a(new StringBuilder()).toString();
    }

    public static <T> Builder<T> newBuilder() {
        return new Builder();
    }

    public static <T> Builder<T> m12226a(FbHttpRequest<T> fbHttpRequest) {
        Builder<T> builder = new Builder();
        builder.f7704d = fbHttpRequest.f7687d;
        Builder<T> builder2 = builder;
        builder2.f7709i = fbHttpRequest.f7692i;
        builder2 = builder2;
        builder2.f7710j = fbHttpRequest.f7693j;
        builder2 = builder2;
        builder2.f7705e = fbHttpRequest.f7688e;
        builder2 = builder2;
        builder2.f7706f = fbHttpRequest.f7689f;
        builder2 = builder2;
        builder2.f7703c = fbHttpRequest.f7686c;
        builder2 = builder2;
        builder2.f7702b = fbHttpRequest.f7685b;
        builder2 = builder2;
        builder2.f7711k = fbHttpRequest.f7694k;
        builder2 = builder2;
        builder2.f7713m = fbHttpRequest.f7696m;
        builder2 = builder2;
        builder2.f7708h = fbHttpRequest.f7691h;
        builder2 = builder2;
        builder2.f7707g = fbHttpRequest.f7690g;
        builder2 = builder2;
        builder2.f7715o = fbHttpRequest.f7697n;
        builder2 = builder2;
        builder2.f7716p = fbHttpRequest.f7698o;
        builder2 = builder2;
        builder2.f7717q = fbHttpRequest.f7699p;
        builder2.f7718r = fbHttpRequest.f7700q;
        if (fbHttpRequest.f7695l.isPresent()) {
            builder.m12251a((List) fbHttpRequest.f7695l.get());
        }
        return builder;
    }

    private FbHttpRequest(HttpUriRequest httpUriRequest, String str, @Nullable CallerContext callerContext, @Nullable String str2, FallbackBehavior fallbackBehavior, ResponseHandler<? extends T> responseHandler, RedirectHandler redirectHandler, FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger, RequestState requestState, RequestIdempotency requestIdempotency, @Nullable String str3, int i, long j, boolean z, Optional<List<HttpFlowStatistics>> optional, @Nullable HttpWireCallback httpWireCallback) {
        this.f7685b = (HttpUriRequest) Preconditions.checkNotNull(httpUriRequest);
        this.f7686c = (String) Preconditions.checkNotNull(str);
        this.f7689f = (FallbackBehavior) Preconditions.checkNotNull(fallbackBehavior);
        this.f7687d = callerContext;
        this.f7690g = (ResponseHandler) Preconditions.checkNotNull(responseHandler);
        this.f7688e = str2;
        this.f7691h = redirectHandler;
        this.f7692i = (FbHttpRequestCancelTrigger) Preconditions.checkNotNull(fbHttpRequestCancelTrigger);
        this.f7693j = (FbRequestState) Preconditions.checkNotNull(requestState);
        this.f7694k = (RequestIdempotency) Preconditions.checkNotNull(requestIdempotency);
        this.f7696m = str3;
        this.f7697n = i;
        this.f7698o = j;
        this.f7699p = z;
        this.f7695l = (Optional) Preconditions.checkNotNull(optional);
        this.f7700q = httpWireCallback;
    }
}
