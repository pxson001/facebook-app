package com.facebook.katana.net;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.util.LoggerUtils;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.invariants.Invariants;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.entity.mime.StringEntityWithProgressListener;
import com.facebook.inject.FbInjector;
import com.facebook.katana.service.method.NetworkServiceOperation.NetworkServiceOperationHttpListener;
import com.facebook.katana.useragent.UserAgent;
import com.facebook.katana.useragent.UserAgent.AppForegroundMode;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* compiled from: relevant_comment */
public class HttpOperation implements Runnable {
    private static final Class<?> f7617c = HttpOperation.class;
    private static long f7618f = 0;
    public final HttpRequestBase f7619a;
    public final HttpContext f7620b;
    private long f7621d;
    private long f7622e;
    private final FbHttpRequestProcessor f7623g;
    private final String f7624h;
    public final NetworkServiceOperationHttpListener f7625i;
    public Thread f7626j;

    private HttpOperation(Context context, HttpRequestBase httpRequestBase, @Nullable HttpContext httpContext, NetworkServiceOperationHttpListener networkServiceOperationHttpListener, String str) {
        this.f7621d = 0;
        this.f7622e = 0;
        this.f7626j = null;
        this.f7623g = FbHttpRequestProcessor.m12260a(FbInjector.get(context));
        this.f7619a = httpRequestBase;
        this.f7620b = m12196a(httpContext);
        this.f7624h = (String) Preconditions.checkNotNull(str);
        this.f7625i = networkServiceOperationHttpListener;
    }

    public HttpOperation(Context context, Method method, String str, NetworkServiceOperationHttpListener networkServiceOperationHttpListener, boolean z, String str2) {
        this(context, method, str, networkServiceOperationHttpListener, z ? m12198c(context) : null, z ? m12195a(context) : null, null, null, str2);
    }

    private HttpOperation(Context context, Method method, String str, NetworkServiceOperationHttpListener networkServiceOperationHttpListener, String str2, String str3, @Nullable String str4, @Nullable HttpContext httpContext, String str5) {
        this(context, method == Method.GET ? new HttpGet(str) : new HttpPost(str), httpContext, networkServiceOperationHttpListener, str5);
        if (str2 != null) {
            this.f7619a.addHeader("User-Agent", str2);
        }
        if (str3 != null) {
            this.f7619a.addHeader("X-FB-Connection-Type", str3);
        }
        if (str4 != null) {
            this.f7619a.addHeader("Accept", str4);
        }
    }

    public HttpOperation(Context context, String str, String str2, String str3, NetworkServiceOperationHttpListener networkServiceOperationHttpListener, boolean z, String str4) {
        this(context, new HttpPost(str), null, networkServiceOperationHttpListener, str4);
        try {
            StringEntityWithProgressListener stringEntityWithProgressListener = new StringEntityWithProgressListener(str2);
            if (this.f7625i != null) {
                long contentLength = stringEntityWithProgressListener.getContentLength();
                if (contentLength > 0) {
                    stringEntityWithProgressListener.a(new UploadProgressListener(this, contentLength));
                }
            }
            ((HttpPost) this.f7619a).setEntity(stringEntityWithProgressListener);
            this.f7619a.addHeader("Content-Type", str3);
            if (z) {
                this.f7619a.addHeader("User-Agent", m12198c(context));
                this.f7619a.addHeader("X-FB-Connection-Type", m12195a(context));
            }
        } catch (Throwable e) {
            BLog.b(f7617c, "unsupported encoding", e);
        }
    }

    private static HttpContext m12196a(@Nullable HttpContext httpContext) {
        if (httpContext == null) {
            return new BasicHttpContext();
        }
        return httpContext;
    }

    public final void m12199b() {
        this.f7626j = ThreadInitDetour.a(this, 927190380);
        this.f7626j.setPriority(1);
        this.f7626j.start();
    }

    public void run() {
        Invariants.a(Looper.getMainLooper().getThread() != Thread.currentThread());
        this.f7621d = SystemClock.uptimeMillis();
        try {
            this.f7623g.m12267a(FbHttpRequest.newBuilder().m12250a(this.f7624h).m12246a(CallerContext.m9060a(getClass())).m12254a(this.f7619a).m12253a(new OperationResponseHandler(this)).m12256a());
        } catch (Exception e) {
            if (this.f7625i != null) {
                this.f7625i.a(0, null, null, e);
            }
        }
    }

    private static String m12198c(Context context) {
        String b = m12197b(context);
        return b != null ? b : UserAgent.m9521a(context, Boolean.valueOf(false));
    }

    public static String m12195a(Context context) {
        ConnectionStatusLogger b = LoggerUtils.m12201b(context);
        if (b != null) {
            return b.m12209b();
        }
        return null;
    }

    public static synchronized String m12197b(Context context) {
        String a;
        synchronized (HttpOperation.class) {
            if (AppStateManager.m2245a(FbInjector.get(context)).m2261i()) {
                a = UserAgent.m9522a(context, Boolean.valueOf(false), AppForegroundMode.Background);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - f7618f) > 21600000) {
                    f7618f = currentTimeMillis;
                    a = UserAgent.m9522a(context, Boolean.valueOf(false), AppForegroundMode.Foreground);
                } else {
                    a = null;
                }
            }
        }
        return a;
    }
}
