package com.facebook.http.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.entity.mime.GzipCompressingEntity;
import com.facebook.http.entity.mime.Releasable;
import com.facebook.http.entity.mime.UnwrappableHttpEntityWrapper;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: removalListener */
public class MethodRunnerUtil {
    private static final Class<?> f7616a = MethodRunnerUtil.class;

    public static <T> FbHttpRequest<T> m12190a(String str, HttpUriRequest httpUriRequest, RequestPriority requestPriority, FallbackBehavior fallbackBehavior, ResponseHandler<T> responseHandler, ApiMethodRunnerParams apiMethodRunnerParams, @Nullable CallerContext callerContext, RequestIdempotency requestIdempotency) {
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.f7703c = str;
        newBuilder = newBuilder;
        newBuilder.f7702b = httpUriRequest;
        newBuilder = newBuilder;
        newBuilder.f7712l = requestPriority;
        newBuilder = newBuilder;
        newBuilder.f7706f = fallbackBehavior;
        newBuilder = newBuilder;
        newBuilder.f7707g = responseHandler;
        newBuilder = newBuilder;
        newBuilder.f7711k = requestIdempotency;
        Builder builder = newBuilder;
        FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger = apiMethodRunnerParams.f7559d;
        if (fbHttpRequestCancelTrigger != null) {
            builder.f7709i = fbHttpRequestCancelTrigger;
        }
        List list = apiMethodRunnerParams.f7560e;
        if (list != null) {
            builder.m12251a(list);
        }
        ApiMethodProgressListener apiMethodProgressListener = apiMethodRunnerParams.f7556a;
        if (apiMethodProgressListener != null && (apiMethodProgressListener instanceof HttpWireCallback)) {
            builder.f7718r = (HttpWireCallback) apiMethodProgressListener;
        }
        if (callerContext != null) {
            builder.f7704d = callerContext;
        }
        return builder.m12256a();
    }

    public static HttpEntity m12191a(HttpEntity httpEntity) {
        if ("application/x-www-form-urlencoded".equals(((Header) Preconditions.checkNotNull(httpEntity.getContentType(), "Unexpected entity with no Content-Type defined")).getValue())) {
            return new GzipCompressingEntity(httpEntity);
        }
        return httpEntity;
    }

    public static void m12192a(HttpUriRequest httpUriRequest) {
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
            while (entity instanceof UnwrappableHttpEntityWrapper) {
                entity = ((UnwrappableHttpEntityWrapper) entity).m12193a();
            }
            if (entity instanceof Releasable) {
                ((Releasable) entity).mo1674a();
            }
        }
    }
}
