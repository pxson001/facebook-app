package com.facebook.crudolib.net;

import com.facebook.crudolib.appstrictmode.CloseGuard;
import com.facebook.crudolib.netengine.HttpEngineRequest$Builder;
import com.facebook.crudolib.netengine.HttpEngineRequestBody;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngineRequest;
import com.facebook.saved2.network.Saved2DataFetcher.FetchFreshSavedItemsCallback;
import javax.annotation.Nullable;

/* compiled from: TrailingComments */
public class AppRequest {
    public final String f24012a;
    private final HttpEngineRequest$Builder f24013b;
    @Nullable
    public final ResponseInterceptor f24014c;
    @Nullable
    public final ChainableRequestMutator f24015d;
    public final CancelTrigger f24016e;
    public final FetchFreshSavedItemsCallback f24017f;
    private volatile boolean f24018g;
    @Nullable
    private volatile CloseGuard f24019h;
    @Nullable
    private volatile FbHttpEngineRequest f24020i;

    /* compiled from: TrailingComments */
    public class Builder {
        public final HttpEngineRequest$Builder f24007a;
        @Nullable
        public String f24008b;
        @Nullable
        public ResponseInterceptor f24009c;
        @Nullable
        public ChainableRequestMutator f24010d;
        @Nullable
        public FetchFreshSavedItemsCallback f24011e;

        public Builder(HttpEngineRequest$Builder httpEngineRequest$Builder) {
            this.f24007a = httpEngineRequest$Builder;
        }
    }

    public AppRequest(Builder builder) {
        if (builder.f24008b == null) {
            throw new IllegalStateException("Must set friendlyName");
        }
        this.f24012a = builder.f24008b;
        this.f24013b = builder.f24007a;
        this.f24014c = builder.f24009c;
        this.f24015d = builder.f24010d;
        if (builder.f24011e == null) {
            throw new IllegalStateException("Must set callback");
        }
        this.f24017f = builder.f24011e;
        this.f24019h = CloseGuard.a(null, "release");
        this.f24016e = new CancelTrigger();
    }

    public final String m25954a() {
        return this.f24012a;
    }

    final HttpEngineRequest$Builder m25955d() {
        m25958j();
        if (this.f24020i == null) {
            return this.f24013b;
        }
        throw new IllegalStateException("must be called before AppRequest.buildRequest");
    }

    final FbHttpEngineRequest m25956f() {
        m25958j();
        if (this.f24020i != null) {
            return this.f24020i;
        }
        throw new IllegalStateException("must call AppRequest.buildRequest");
    }

    final void m25957g() {
        m25958j();
        if (this.f24020i != null) {
            throw new IllegalStateException("Request has already been built.");
        }
        this.f24020i = this.f24013b.mo1112a();
    }

    final void m25958j() {
        if (this.f24018g) {
            throw new IllegalStateException("Request has already been executed and may not be re-used");
        }
    }

    final void m25959k() {
        if (!this.f24018g) {
            if (this.f24020i != null) {
                HttpEngineRequestBody httpEngineRequestBody = this.f24020i.f24062b;
                if (httpEngineRequestBody instanceof Releasable) {
                    ((Releasable) httpEngineRequestBody).mo1125c();
                }
            }
            CloseGuard.a(this.f24019h);
            this.f24018g = true;
        }
    }

    protected void finalize() {
        try {
            CloseGuard.b(this.f24019h);
            if (!this.f24018g) {
                m25959k();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
