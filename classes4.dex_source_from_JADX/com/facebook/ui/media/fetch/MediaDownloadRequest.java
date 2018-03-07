package com.facebook.ui.media.fetch;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.io.IOException;
import java.net.URI;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: recipient */
public class MediaDownloadRequest<T> {
    private static final ImmutableMap<String, Scheme> f3573a = ImmutableMap.of("https", Scheme.HTTPS, "http", Scheme.HTTP, "content", Scheme.CONTENT, "file", Scheme.FILE);
    public final Uri f3574b;
    public final Scheme f3575c;
    public final FbHttpRequestCancelTrigger f3576d;
    public final CallerContext f3577e;
    public final RequestPriority f3578f;
    public final ImmutableMap<String, String> f3579g;
    public final DownloadResultResponseHandler<T> f3580h;

    /* compiled from: recipient */
    public enum Scheme {
        HTTPS,
        HTTP,
        CONTENT,
        FILE,
        UNSUPPORTED
    }

    public MediaDownloadRequest(Uri uri, DownloadResultResponseHandler<T> downloadResultResponseHandler, CallerContext callerContext) {
        this(uri, (DownloadResultResponseHandler) downloadResultResponseHandler, new FbHttpRequestCancelTrigger(), callerContext);
    }

    public MediaDownloadRequest(Uri uri, DownloadResultResponseHandler<T> downloadResultResponseHandler, CallerContext callerContext, RequestPriority requestPriority) {
        this(uri, downloadResultResponseHandler, new FbHttpRequestCancelTrigger(), callerContext, requestPriority, RegularImmutableBiMap.a);
    }

    public MediaDownloadRequest(Uri uri, DownloadResultResponseHandler<T> downloadResultResponseHandler, FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger, CallerContext callerContext) {
        this(uri, downloadResultResponseHandler, fbHttpRequestCancelTrigger, callerContext, RequestPriority.DEFAULT_PRIORITY, RegularImmutableBiMap.a);
    }

    public MediaDownloadRequest(Uri uri, DownloadResultResponseHandler<T> downloadResultResponseHandler, CallerContext callerContext, ImmutableMap<String, String> immutableMap) {
        this(uri, downloadResultResponseHandler, new FbHttpRequestCancelTrigger(), callerContext, RequestPriority.DEFAULT_PRIORITY, immutableMap);
    }

    private MediaDownloadRequest(Uri uri, DownloadResultResponseHandler<T> downloadResultResponseHandler, FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger, CallerContext callerContext, RequestPriority requestPriority, ImmutableMap<String, String> immutableMap) {
        this.f3574b = (Uri) Preconditions.checkNotNull(uri);
        Scheme scheme = (Scheme) f3573a.get(uri.getScheme());
        if (scheme == null) {
            scheme = Scheme.UNSUPPORTED;
        }
        this.f3575c = scheme;
        this.f3580h = (DownloadResultResponseHandler) Preconditions.checkNotNull(downloadResultResponseHandler);
        this.f3576d = (FbHttpRequestCancelTrigger) Preconditions.checkNotNull(fbHttpRequestCancelTrigger);
        this.f3577e = (CallerContext) Preconditions.checkNotNull(callerContext);
        this.f3578f = requestPriority;
        this.f3579g = immutableMap;
    }

    public HttpUriRequest mo288a() {
        try {
            return new HttpGet(URI.create(this.f3574b.toString()));
        } catch (IllegalArgumentException e) {
            throw new IOException("Invalid URI: " + this.f3574b);
        }
    }

    public final Uri m3962b() {
        return this.f3574b;
    }

    public final DownloadResultResponseHandler<T> m3963e() {
        return this.f3580h;
    }

    public final CallerContext m3964f() {
        return this.f3577e;
    }
}
