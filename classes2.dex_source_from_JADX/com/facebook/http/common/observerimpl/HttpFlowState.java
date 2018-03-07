package com.facebook.http.common.observerimpl;

import com.facebook.debug.http.DebugHttpFlowObserver;
import com.facebook.http.observer.FbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.Stage;
import com.facebook.http.observer.responsebody.FbHttpFlowObserverWithResponseStream;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import javax.annotation.Nullable;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: null_state_module_cache_tag */
public class HttpFlowState {
    private HttpContext f12014a;
    private HttpRequest f12015b;
    public HttpFlowStatistics f12016c;
    public final Set<FbHttpFlowObserver> f12017d;
    private final Set<FbHttpFlowObserverWithResponseStream> f12018e;
    public HttpResponse f12019f;
    private FinalState f12020g;
    private Stage f12021h;

    /* compiled from: null_state_module_cache_tag */
    enum FinalState {
        REPORTED_SUCCESS,
        REPORTED_FAILURE
    }

    @VisibleForTesting
    public HttpFlowState(HttpContext httpContext, HttpRequest httpRequest, Set<FbHttpFlowObserver> set) {
        this.f12014a = httpContext;
        this.f12015b = httpRequest;
        this.f12017d = set;
        Builder builder = ImmutableSet.builder();
        for (FbHttpFlowObserver fbHttpFlowObserver : this.f12017d) {
            if (fbHttpFlowObserver instanceof DebugHttpFlowObserver) {
                builder.m4813c((DebugHttpFlowObserver) fbHttpFlowObserver);
            }
        }
        this.f12018e = builder.m4812b();
    }

    public final void m17712a(HttpResponse httpResponse, HttpContext httpContext) {
        this.f12019f = httpResponse;
        for (FbHttpFlowObserver a : this.f12017d) {
            a.mo2285a(httpResponse, httpContext);
        }
        if (this.f12019f.getEntity() != null) {
            this.f12019f.setEntity(new ResponseTrackingEntity(this, this.f12019f.getEntity()));
            return;
        }
        m17710a(null);
        m17714b();
    }

    @Nullable
    public final InputStream m17710a(@Nullable InputStream inputStream) {
        for (DebugHttpFlowObserver a : this.f12018e) {
            inputStream = a.m17800a(inputStream);
        }
        return inputStream;
    }

    public final boolean m17713a() {
        if (this.f12020g == null) {
            boolean z;
            if (this.f12021h == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
        } else if (this.f12020g == FinalState.REPORTED_FAILURE) {
            Preconditions.checkState(this.f12021h != null);
        }
        if (this.f12020g != null) {
            return true;
        }
        return false;
    }

    public final void m17714b() {
        Preconditions.checkState(!m17713a());
        try {
            for (FbHttpFlowObserver b : this.f12017d) {
                b.mo2282b(this.f12019f, this.f12014a);
            }
        } finally {
            this.f12020g = FinalState.REPORTED_SUCCESS;
        }
    }

    public final void m17711a(IOException iOException) {
        Preconditions.checkState(!m17713a());
        try {
            for (FbHttpFlowObserver a : this.f12017d) {
                a.mo2281a(Stage.READ_RESPONSE_BODY, this.f12015b, this.f12019f, this.f12014a, iOException);
            }
        } finally {
            this.f12020g = FinalState.REPORTED_FAILURE;
            this.f12021h = Stage.READ_RESPONSE_BODY;
        }
    }

    public final void m17715b(IOException iOException) {
        Preconditions.checkState(!m17713a());
        try {
            for (FbHttpFlowObserver a : this.f12017d) {
                a.mo2281a(Stage.HTTP_CLIENT_EXECUTE, this.f12015b, this.f12019f, this.f12014a, iOException);
            }
        } finally {
            this.f12020g = FinalState.REPORTED_FAILURE;
            this.f12021h = Stage.HTTP_CLIENT_EXECUTE;
        }
    }
}
