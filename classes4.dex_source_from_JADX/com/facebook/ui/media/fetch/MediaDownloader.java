package com.facebook.ui.media.fetch;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.DisplayPhoto;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.inject.ForAppContext;
import com.facebook.ui.media.fetch.MediaDownloadRequest.Scheme;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;

/* compiled from: recent_video_search_cache_tag */
public class MediaDownloader {
    private static final Class<?> f3581a = MediaDownloader.class;
    private final FbHttpRequestProcessor f3582b;
    private final Context f3583c;
    private final String f3584d;
    private final WebRequestCounters f3585e;
    private final AnalyticsLogger f3586f;
    private final TimeWindowThrottlingPolicy f3587g;
    private final NetworkDataLogUtils f3588h;
    private final CdnHttpRequestHandler f3589i;
    private final ConnectionStatusLogger f3590j;

    public MediaDownloader(@ForAppContext Context context, FbHttpRequestProcessor fbHttpRequestProcessor, String str, WebRequestCounters webRequestCounters, AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, NetworkDataLogUtils networkDataLogUtils, CdnHttpRequestHandler cdnHttpRequestHandler, ConnectionStatusLogger connectionStatusLogger) {
        this.f3583c = context;
        this.f3582b = fbHttpRequestProcessor;
        this.f3584d = str;
        this.f3585e = webRequestCounters;
        this.f3586f = analyticsLogger;
        this.f3587g = timeWindowThrottlingPolicy;
        this.f3588h = networkDataLogUtils;
        this.f3589i = cdnHttpRequestHandler;
        this.f3590j = connectionStatusLogger;
    }

    public <T> T mo304a(MediaDownloadRequest<T> mediaDownloadRequest) {
        switch (mediaDownloadRequest.f3575c) {
            case CONTENT:
                return m3971f(mediaDownloadRequest);
            case FILE:
                return m3972g(mediaDownloadRequest);
            default:
                return m3970e(mediaDownloadRequest);
        }
    }

    private <T> HttpUriRequest m3968c(MediaDownloadRequest<T> mediaDownloadRequest) {
        HttpUriRequest a = mediaDownloadRequest.mo288a();
        a.addHeader("X-FB-Connection-Type", this.f3590j.b());
        Iterator it = mediaDownloadRequest.f3579g.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            a.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        return a;
    }

    private <T> FbHttpRequest<T> m3969d(MediaDownloadRequest<T> mediaDownloadRequest) {
        MediaRedirectHandler mediaRedirectHandler = new MediaRedirectHandler(mediaDownloadRequest.f3574b, this.f3585e);
        HttpUriRequest c = m3968c(mediaDownloadRequest);
        HttpClientParams.setRedirecting(c.getParams(), true);
        this.f3585e.b(mediaDownloadRequest.f3574b.toString());
        MediaResponseHandler mediaResponseHandler = new MediaResponseHandler(mediaDownloadRequest.f3574b, mediaDownloadRequest.f3580h, this.f3584d, this.f3585e, this.f3586f, this.f3587g, this.f3588h, this.f3589i);
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.c = this.f3584d;
        newBuilder = newBuilder;
        newBuilder.d = mediaDownloadRequest.f3577e;
        newBuilder = newBuilder;
        newBuilder.e = "MediaDownloader";
        newBuilder = newBuilder;
        newBuilder.b = c;
        newBuilder = newBuilder;
        newBuilder.q = true;
        newBuilder = newBuilder;
        newBuilder.k = RequestIdempotency.RETRY_SAFE;
        newBuilder = newBuilder;
        newBuilder.l = mediaDownloadRequest.f3578f;
        newBuilder = newBuilder;
        newBuilder.h = mediaRedirectHandler;
        newBuilder = newBuilder;
        newBuilder.g = mediaResponseHandler;
        Builder builder = newBuilder;
        builder.i = mediaDownloadRequest.f3576d;
        return builder.a();
    }

    public final <T> HttpFutureWrapper<T> m3974b(MediaDownloadRequest<T> mediaDownloadRequest) {
        Scheme scheme = mediaDownloadRequest.f3575c;
        if (scheme == Scheme.HTTP || scheme == Scheme.HTTPS) {
            return this.f3582b.b(m3969d(mediaDownloadRequest));
        }
        throw new UnsupportedOperationException("Only http and https supported");
    }

    private <T> T m3970e(MediaDownloadRequest<T> mediaDownloadRequest) {
        return this.f3582b.a(m3969d(mediaDownloadRequest));
    }

    private <T> T m3971f(MediaDownloadRequest<T> mediaDownloadRequest) {
        InputStream a;
        Uri b = mediaDownloadRequest.m3962b();
        if ("com.android.contacts".equals(b.getAuthority())) {
            a = m3966a(b);
        } else {
            a = m3967b(b);
        }
        try {
            T a2 = mediaDownloadRequest.m3963e().a(a, -1, CdnHeaderResponse.NOT_IN_GK);
            return a2;
        } finally {
            a.close();
        }
    }

    private InputStream m3966a(Uri uri) {
        new StringBuilder("Downloading contact photo from: ").append(uri);
        if (uri.getPath().startsWith(DisplayPhoto.CONTENT_URI.getPath())) {
            return m3967b(uri);
        }
        InputStream openContactPhotoInputStream = Contacts.openContactPhotoInputStream(this.f3583c.getContentResolver(), uri);
        if (openContactPhotoInputStream != null) {
            return openContactPhotoInputStream;
        }
        throw new FileNotFoundException("Contact photo not found: " + uri);
    }

    private InputStream m3967b(Uri uri) {
        new StringBuilder("Downloading media from generic content resolver: ").append(uri);
        InputStream openInputStream = this.f3583c.getContentResolver().openInputStream(uri);
        if (openInputStream != null) {
            return openInputStream;
        }
        throw new FileNotFoundException("Media not found: " + uri);
    }

    private static <T> T m3972g(MediaDownloadRequest<T> mediaDownloadRequest) {
        File file = new File(mediaDownloadRequest.m3962b().getPath());
        InputStream fileInputStream = new FileInputStream(file);
        try {
            T a = mediaDownloadRequest.m3963e().a(fileInputStream, file.length(), CdnHeaderResponse.NOT_IN_GK);
            return a;
        } finally {
            fileInputStream.close();
        }
    }
}
