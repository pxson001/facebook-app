package com.facebook.http.protocol;

import com.facebook.fbtrace.FbTraceNode;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.observer.HttpFlowStatistics;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.Header;

/* compiled from: renderingDepth */
public class ApiMethodRunnerParams {
    @Nullable
    public ApiMethodProgressListener f7556a;
    private HttpConfig f7557b = HttpConfig.DEFAULT;
    @Nullable
    public HttpRequestAbortHandler f7558c;
    @Nullable
    public FbHttpRequestCancelTrigger f7559d;
    @Nullable
    public List<HttpFlowStatistics> f7560e;
    @Nullable
    public RequestPriority f7561f;
    @Nullable
    public ImmutableList<Header> f7562g;
    public FbTraceNode f7563h = FbTraceNode.f7566a;
    public boolean f7564i = true;
    @Nullable
    public String f7565j;

    /* compiled from: renderingDepth */
    public enum HttpConfig {
        DEFAULT,
        PROD,
        BOOTSTRAP
    }

    public static ApiMethodRunnerParams m12144a(ApiMethodRunnerParams apiMethodRunnerParams) {
        ApiMethodRunnerParams apiMethodRunnerParams2 = new ApiMethodRunnerParams();
        apiMethodRunnerParams2.f7556a = apiMethodRunnerParams.f7556a;
        apiMethodRunnerParams2.f7557b = apiMethodRunnerParams.f7557b;
        apiMethodRunnerParams2.f7558c = apiMethodRunnerParams.f7558c;
        apiMethodRunnerParams2.f7559d = apiMethodRunnerParams.f7559d;
        apiMethodRunnerParams2.f7560e = apiMethodRunnerParams.f7560e;
        apiMethodRunnerParams2.f7561f = apiMethodRunnerParams.f7561f;
        apiMethodRunnerParams2.f7562g = apiMethodRunnerParams.f7562g;
        apiMethodRunnerParams2.f7563h = apiMethodRunnerParams.f7563h;
        apiMethodRunnerParams2.f7564i = apiMethodRunnerParams.f7564i;
        return apiMethodRunnerParams2;
    }

    public final ApiMethodProgressListener m12145a() {
        return this.f7556a;
    }

    public final void m12148a(ApiMethodProgressListener apiMethodProgressListener) {
        this.f7556a = apiMethodProgressListener;
    }

    public final void m12149a(HttpConfig httpConfig) {
        this.f7557b = (HttpConfig) Preconditions.checkNotNull(httpConfig);
    }

    public final HttpConfig m12152b() {
        return this.f7557b;
    }

    public final HttpRequestAbortHandler m12153c() {
        return this.f7558c;
    }

    public final void m12150a(HttpRequestAbortHandler httpRequestAbortHandler) {
        this.f7558c = httpRequestAbortHandler;
    }

    @Nullable
    public final List<HttpFlowStatistics> m12154e() {
        return this.f7560e;
    }

    @Nullable
    public final FbTraceNode m12155f() {
        return this.f7563h;
    }

    public final void m12146a(FbTraceNode fbTraceNode) {
        this.f7563h = fbTraceNode;
    }

    public final boolean m12156g() {
        return this.f7564i;
    }

    public final void m12147a(@Nullable RequestPriority requestPriority) {
        this.f7561f = requestPriority;
    }

    public final void m12151a(@Nullable ImmutableList<Header> immutableList) {
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Preconditions.checkArgument("X-".equalsIgnoreCase(((Header) immutableList.get(i)).getName().substring(0, 2)));
            }
        }
        this.f7562g = immutableList;
    }
}
