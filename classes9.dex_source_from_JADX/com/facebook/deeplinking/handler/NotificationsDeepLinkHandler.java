package com.facebook.deeplinking.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.StringUtil;
import com.facebook.deeplinking.DeepLinkingUtils;
import com.facebook.deeplinking.logging.DeepLinkLoggingUtils;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Lazy;
import java.net.URI;
import java.net.URL;
import java.util.Set;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.BasicHttpParams;

/* compiled from: phone_number_to_confirm */
public class NotificationsDeepLinkHandler implements DeepLinkHandler {
    private static final String f6620a = NotificationsDeepLinkHandler.class.getSimpleName();
    private final FbHttpRequestProcessor f6621b;
    private final AbstractFbErrorReporter f6622c;
    private final DeepLinkingUtils f6623d;
    private final Lazy<Set<DeepLinkHandler>> f6624e;
    private final DeepLinkLoggingUtils f6625f;

    /* compiled from: phone_number_to_confirm */
    class C06841 implements ResponseHandler<String> {
        final /* synthetic */ NotificationsDeepLinkHandler f6619a;

        C06841(NotificationsDeepLinkHandler notificationsDeepLinkHandler) {
            this.f6619a = notificationsDeepLinkHandler;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            return null;
        }
    }

    @Inject
    public NotificationsDeepLinkHandler(FbHttpRequestProcessor fbHttpRequestProcessor, FbErrorReporter fbErrorReporter, DeepLinkingUtils deepLinkingUtils, DeepLinkLoggingUtils deepLinkLoggingUtils, Lazy<Set<DeepLinkHandler>> lazy) {
        this.f6621b = fbHttpRequestProcessor;
        this.f6622c = fbErrorReporter;
        this.f6623d = deepLinkingUtils;
        this.f6625f = deepLinkLoggingUtils;
        this.f6624e = lazy;
    }

    public final Intent mo269a(Context context, Uri uri) {
        if (StringUtil.a(uri.getPath(), "/n/")) {
            try {
                m6937a(uri.toString());
            } catch (Throwable e) {
                this.f6622c.a(SoftError.a(f6620a + ".handleDeepLinkUri", "Error logging notification click").a(e).g());
            }
            String[] split = uri.getQuery().split("&");
            Builder buildUpon = uri.buildUpon();
            int length = split.length;
            String str = null;
            for (int i = 0; i < length; i++) {
                int indexOf = split[i].indexOf(61);
                if (indexOf >= 0) {
                    buildUpon.appendQueryParameter(split[i].substring(0, indexOf), split[i].substring(indexOf + 1));
                } else if (str == null) {
                    str = split[i];
                } else {
                    this.f6622c.a(SoftError.a(f6620a + ".handleDeepLinkUri", "Error parsing notification URL (found a second key with no value): " + uri).g());
                }
            }
            buildUpon.query("");
            if (str != null) {
                buildUpon.path(str);
                Uri build = buildUpon.build();
                for (DeepLinkHandler a : (Set) this.f6624e.get()) {
                    Intent a2 = a.mo269a(context, build);
                    if (a2 != null) {
                        this.f6625f.m6946a(build, a2.getData());
                        return a2;
                    }
                }
            }
        }
        return null;
    }

    private void m6937a(String str) {
        URL url = new URL(str);
        HttpUriRequest httpGet = new HttpGet(new URI(url.getProtocol(), url.getAuthority(), url.getPath(), url.getQuery(), url.getRef()));
        httpGet.setParams(new BasicHttpParams().setParameter("http.protocol.handle-redirects", Boolean.valueOf(true)));
        FbHttpRequest.Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.c = "DeepLinkNotificationUrlRequest";
        newBuilder = newBuilder;
        newBuilder.d = CallerContext.a(getClass());
        newBuilder = newBuilder;
        newBuilder.b = httpGet;
        newBuilder = newBuilder;
        newBuilder.l = RequestPriority.NON_INTERACTIVE;
        newBuilder = newBuilder;
        newBuilder.g = new C06841(this);
        this.f6621b.a(newBuilder.a());
    }
}
