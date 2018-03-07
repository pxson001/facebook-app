package com.facebook.video.server;

import android.net.Uri;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.video.server.AsyncWriter.Handler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.BufferedHttpEntity;

/* compiled from: Resource with no length is too large! ( */
public class NetworkAsyncWriter implements AsyncWriter {
    public static final String f395a = NetworkAsyncWriter.class.getName();
    private static final List<String> f396l = ImmutableList.of("application/vnd.apple.mpegurl");
    private final Uri f397b;
    public final DefaultNetworkProcessor f398c;
    private final CallerContext f399d;
    private final String f400e;
    private final AbstractFbErrorReporter f401f;
    private final LoggedInUserSessionManager f402g;
    private final ObjectMapper f403h;
    public final TimeoutStreamHelper f404i;
    @GuardedBy("this")
    private RequestPriority f405j;
    @GuardedBy("this")
    private final Set<FbHttpRequest<?>> f406k = new HashSet();

    public NetworkAsyncWriter(Uri uri, DefaultNetworkProcessor defaultNetworkProcessor, CallerContext callerContext, RequestPriority requestPriority, String str, AbstractFbErrorReporter abstractFbErrorReporter, LoggedInUserSessionManager loggedInUserSessionManager, ObjectMapper objectMapper, TimeoutStreamHelper timeoutStreamHelper) {
        this.f397b = uri;
        this.f398c = defaultNetworkProcessor;
        this.f399d = callerContext;
        this.f405j = requestPriority;
        this.f400e = str;
        this.f401f = abstractFbErrorReporter;
        this.f402g = loggedInUserSessionManager;
        this.f403h = objectMapper;
        this.f404i = timeoutStreamHelper;
    }

    public final void mo7a(long j, long j2, Handler handler) {
        FbHttpRequest b = m355b(j, j2, handler);
        m352a(b);
        ListenableFuture listenableFuture = this.f398c.a.b(b).b;
        if (listenableFuture == null) {
            BLog.a(f395a, "No future returned from request procesor ?!");
            m357b(this, b);
            return;
        }
        Futures.a(listenableFuture, new 1(this, b, handler));
    }

    private synchronized FbHttpRequest<Void> m355b(long j, long j2, Handler handler) {
        FbHttpRequest<Void> a;
        boolean z = true;
        synchronized (this) {
            HttpUriRequest httpGet = new HttpGet(this.f397b.toString());
            String str = "bytes=" + j + "-";
            if (j2 > 0) {
                str = str + (j2 - 1);
            }
            httpGet.setHeader("Range", str);
            m354a(httpGet);
            HttpClientParams.setRedirecting(httpGet.getParams(), true);
            if (j != 0) {
                z = false;
            }
            ResponseHandlerImpl responseHandlerImpl = new ResponseHandlerImpl(this, z, j2 > 0 ? j2 - j : -1, handler);
            a = FbHttpRequest.newBuilder().a(httpGet).a(this.f399d).a(this.f400e).a(true).a(RequestIdempotency.RETRY_SAFE).a(this.f405j).a(responseHandlerImpl).a();
            responseHandlerImpl.a(a);
        }
        return a;
    }

    public static void m353a(NetworkAsyncWriter networkAsyncWriter, HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Content-Length") == null) {
            Header firstHeader = httpResponse.getFirstHeader("Content-Type");
            if (firstHeader != null && f396l.contains(firstHeader.getValue())) {
                HttpEntity bufferedHttpEntity = new BufferedHttpEntity(httpResponse.getEntity());
                httpResponse.setEntity(bufferedHttpEntity);
                long contentLength = bufferedHttpEntity.getContentLength();
                if (contentLength > 20480) {
                    networkAsyncWriter.f401f.a(f395a, "Resource with no length is too large! (" + contentLength + " bytes) " + networkAsyncWriter.f397b);
                }
                httpResponse.setHeader("Content-Length", String.valueOf(contentLength));
            }
        }
    }

    private void m354a(HttpUriRequest httpUriRequest) {
        if (FacebookUriUtil.c(Uri.parse(httpUriRequest.getURI().toString()))) {
            String str;
            ViewerContext a = this.f402g.a();
            if (a == null) {
                str = null;
            } else {
                str = SessionCookie.b(this.f403h, a.mSessionCookiesString);
            }
            if (str != null) {
                httpUriRequest.addHeader("Cookie", str);
            }
        }
    }

    private synchronized void m352a(FbHttpRequest<?> fbHttpRequest) {
        this.f406k.add(fbHttpRequest);
    }

    public static synchronized void m357b(NetworkAsyncWriter networkAsyncWriter, FbHttpRequest fbHttpRequest) {
        synchronized (networkAsyncWriter) {
            networkAsyncWriter.f406k.remove(fbHttpRequest);
        }
    }

    public final synchronized void m360a(RequestPriority requestPriority) {
        this.f405j = requestPriority;
        if (!this.f406k.isEmpty()) {
            for (FbHttpRequest a : this.f406k) {
                this.f398c.a(a, requestPriority);
            }
        }
    }

    private static String m351a(Header header) {
        int lastIndexOf = header.getValue().lastIndexOf(47);
        if (lastIndexOf >= 0) {
            return header.getValue().substring(lastIndexOf + 1).trim();
        }
        return null;
    }

    private static String m356b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Length");
        if (firstHeader != null) {
            return firstHeader.getValue();
        }
        return null;
    }

    private static FileMetadata m358c(HttpResponse httpResponse) {
        String b;
        Header firstHeader;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        switch (statusCode) {
            case 200:
                b = m356b(httpResponse);
                break;
            case 206:
                firstHeader = httpResponse.getFirstHeader("Content-Range");
                if (firstHeader != null) {
                    b = m351a(firstHeader);
                    break;
                }
                throw new BadResponseException("No Content-Range header");
            case 416:
                firstHeader = httpResponse.getFirstHeader("Content-Range");
                if (firstHeader != null) {
                    b = m351a(firstHeader);
                } else {
                    b = null;
                }
                if (b == null) {
                    b = m356b(httpResponse);
                    break;
                }
                break;
            default:
                throw new BadResponseException("Bad status code " + statusCode);
        }
        long j = -1;
        try {
            j = Long.parseLong(b);
        } catch (NumberFormatException e) {
        }
        if (j < 0) {
            throw new BadResponseException(StringFormatUtil.formatStrLocaleSafe("Invalid length value: %s (status %d)", b, Integer.valueOf(statusCode)));
        }
        firstHeader = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader != null || j <= 0) {
            FileMetadata fileMetadata = new FileMetadata(j, firstHeader != null ? firstHeader.getValue() : null);
            firstHeader = httpResponse.getFirstHeader("Cache-Control");
            if (firstHeader != null) {
                fileMetadata.a("Cache-Control", firstHeader.getValue());
            }
            return fileMetadata;
        }
        throw new BadResponseException("No Content-Type header");
    }
}
