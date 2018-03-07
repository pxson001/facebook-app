package com.facebook.platform.webdialogs;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

@Singleton
/* compiled from: front_camera */
public class PlatformWebDialogsDownloader {
    private static volatile PlatformWebDialogsDownloader f11331h;
    private final Context f11332a;
    private final FbHttpRequestProcessor f11333b;
    private final Provider<ViewerContext> f11334c;
    private final AbstractFbErrorReporter f11335d;
    private final ObjectMapper f11336e;
    private final Provider<String> f11337f;
    private String f11338g;

    @TargetApi(17)
    /* compiled from: front_camera */
    class DefaultWebViewUserAgentStringProvider {
        static String m12130a(Context context) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (NullPointerException e) {
                return "AppleWebKit/533.1";
            }
        }
    }

    public static com.facebook.platform.webdialogs.PlatformWebDialogsDownloader m11778a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11331h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.PlatformWebDialogsDownloader.class;
        monitor-enter(r1);
        r0 = f11331h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11780b(r0);	 Catch:{ all -> 0x0035 }
        f11331h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11331h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.PlatformWebDialogsDownloader.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.PlatformWebDialogsDownloader");
    }

    private static PlatformWebDialogsDownloader m11780b(InjectorLike injectorLike) {
        return new PlatformWebDialogsDownloader((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), IdBasedProvider.a(injectorLike, 372), IdBasedProvider.a(injectorLike, 4455), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlatformWebDialogsDownloader(Context context, FbErrorReporter fbErrorReporter, FbHttpRequestProcessor fbHttpRequestProcessor, Provider<ViewerContext> provider, Provider<String> provider2, ObjectMapper objectMapper) {
        this.f11332a = context;
        this.f11335d = fbErrorReporter;
        this.f11333b = fbHttpRequestProcessor;
        this.f11334c = provider;
        this.f11336e = objectMapper;
        this.f11337f = provider2;
    }

    public final HttpResponse m11781a(String str, CallerContext callerContext, ResponseHandler<HttpResponse> responseHandler) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(callerContext);
        String str2 = (String) Iterables.a(Splitter.on('#').split(str), null);
        String a = callerContext.a();
        HttpUriRequest httpGet = new HttpGet(str2);
        ViewerContext viewerContext = (ViewerContext) this.f11334c.get();
        if (viewerContext != null) {
            str2 = viewerContext.c();
            if (Strings.isNullOrEmpty(str2)) {
                this.f11335d.a(a, "ViewerContext does not have a cookie string");
            } else {
                ImmutableList a2 = SessionCookie.m12036a(this.f11336e, str2);
                if (a2 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int size = a2.size();
                    for (int i = 0; i < size; i++) {
                        stringBuilder.append(((SessionCookie) a2.get(i)).toString()).append(";");
                    }
                    httpGet.addHeader("Cookie", stringBuilder.toString());
                } else {
                    this.f11335d.a(a, StringFormatUtil.formatStrLocaleSafe("Unable to de-serialize SessionCookie list from: %s", str2));
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder((String) this.f11337f.get());
        if (this.f11338g == null) {
            this.f11338g = m11779a(this.f11332a);
        }
        if (this.f11338g != null) {
            stringBuilder2.insert(0, " ");
            stringBuilder2.insert(0, this.f11338g);
        }
        httpGet.setHeader("User-Agent", stringBuilder2.toString());
        try {
            return (HttpResponse) this.f11333b.a(FbHttpRequest.newBuilder().a(a).a(callerContext).a(httpGet).a(responseHandler).a());
        } catch (Throwable e) {
            BLog.b(a, e, "Network error when downloading manifest from url: %s", new Object[]{str});
            return null;
        }
    }

    public static ErrorCode m11777a(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine == null) {
            return ErrorCode.CONNECTION_FAILURE;
        }
        ErrorCode errorCode = ErrorCode.NO_ERROR;
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
            return errorCode;
        }
        errorCode = ErrorCode.CONNECTION_FAILURE;
        if (statusCode < 400 || statusCode > 599) {
            return errorCode;
        }
        return statusCode <= 499 ? ErrorCode.HTTP_400_OTHER : ErrorCode.HTTP_500_CLASS;
    }

    private static String m11779a(Context context) {
        if (VERSION.SDK_INT >= 17) {
            return DefaultWebViewUserAgentStringProvider.m12130a(context);
        }
        return "AppleWebKit/533.1";
    }
}
