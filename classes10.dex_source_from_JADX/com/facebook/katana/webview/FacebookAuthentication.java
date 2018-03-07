package com.facebook.katana.webview;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.toaster.Toaster;
import com.facebook.webview.auth.AuthCallback;
import com.facebook.webview.auth.Authenticator;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_page_like_fail */
public class FacebookAuthentication implements Authenticator {
    public static final Class<?> f1250a = FacebookAuthentication.class;
    private static volatile FacebookAuthentication f1251g;
    protected boolean f1252b = true;
    protected boolean f1253c = false;
    protected Set<AuthCallback> f1254d = Sets.a();
    public WebView f1255e;
    public final NetAccessLogger f1256f;

    /* compiled from: timeline_page_like_fail */
    public class FacewebAuthenticationWebViewClient extends WebViewClient {
        protected final Context f1247a;
        protected final String f1248b;
        final /* synthetic */ FacebookAuthentication f1249c;

        public FacewebAuthenticationWebViewClient(FacebookAuthentication facebookAuthentication, Context context, String str) {
            this.f1249c = facebookAuthentication;
            this.f1247a = context;
            this.f1248b = Uri.parse(str).getPath();
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            FbInjector fbInjector = FbInjector.get(this.f1247a);
            if (!((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector)).a(InternalHttpPrefKeys.j, true)) {
                sslErrorHandler.proceed();
            } else if (BuildConstants.i || TriState.YES == TriState_IsMeUserAnEmployeeMethodAutoProvider.b(fbInjector)) {
                Toaster.a(this.f1247a, 2131236458);
            } else {
                this.f1247a.getString(2131236459);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            new StringBuilder("authentication error: ").append(str);
            synchronized (this.f1249c) {
                this.f1249c.f1253c = false;
                Set<AuthCallback> set = this.f1249c.f1254d;
                this.f1249c.f1254d = new HashSet();
            }
            for (AuthCallback c : set) {
                c.c();
            }
        }

        public void onPageFinished(WebView webView, String str) {
            boolean z = false;
            if (str != null && FacebookAuthentication.m1285a(str, this.f1248b)) {
                this.f1249c.f1252b = true;
                z = true;
            }
            synchronized (FacebookAuthentication.class) {
                this.f1249c.f1253c = false;
                Set<AuthCallback> set = this.f1249c.f1254d;
                this.f1249c.f1254d = new HashSet();
            }
            for (AuthCallback authCallback : set) {
                if (z) {
                    authCallback.a();
                } else {
                    authCallback.b();
                }
            }
            this.f1249c.f1255e.destroy();
            this.f1249c.f1255e = null;
        }

        public void onLoadResource(WebView webView, String str) {
            this.f1249c.f1256f.a(str);
        }
    }

    public static com.facebook.katana.webview.FacebookAuthentication m1284a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1251g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.webview.FacebookAuthentication.class;
        monitor-enter(r1);
        r0 = f1251g;	 Catch:{ all -> 0x003a }
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
        r0 = m1287b(r0);	 Catch:{ all -> 0x0035 }
        f1251g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1251g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.webview.FacebookAuthentication.a(com.facebook.inject.InjectorLike):com.facebook.katana.webview.FacebookAuthentication");
    }

    private static FacebookAuthentication m1287b(InjectorLike injectorLike) {
        return new FacebookAuthentication(NetAccessLogger.b(injectorLike));
    }

    @Inject
    public FacebookAuthentication(NetAccessLogger netAccessLogger) {
        this.f1256f = netAccessLogger;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1288a(android.content.Context r5, com.facebook.webview.auth.AuthCallback r6) {
        /*
        r4 = this;
        r3 = 0;
        r0 = com.facebook.katana.service.AppSession.b(r5, r3);
        r1 = com.facebook.katana.webview.FacebookAuthentication.class;
        monitor-enter(r1);
        if (r6 == 0) goto L_0x000f;
    L_0x000a:
        r2 = r4.f1254d;	 Catch:{ all -> 0x0058 }
        r2.add(r6);	 Catch:{ all -> 0x0058 }
    L_0x000f:
        r2 = r4.f1253c;	 Catch:{ all -> 0x0058 }
        if (r2 != 0) goto L_0x0015;
    L_0x0013:
        if (r0 != 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
    L_0x0016:
        return;
    L_0x0017:
        r0 = 1;
        r4.f1253c = r0;	 Catch:{ all -> 0x0058 }
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        r4.f1252b = r3;
        r0 = r4.f1255e;
        com.facebook.debug.asserts.Assert.b(r0);
        r0 = new com.facebook.webview.BasicWebView;
        r0.<init>(r5);
        r4.f1255e = r0;
        r0 = r4.f1255e;
        r0 = r0.getSettings();
        r0.setJavaScriptEnabled(r3);
        r0 = r4.f1255e;
        r1 = new com.facebook.katana.webview.FacebookAuthentication$FacewebAuthenticationWebViewClient;
        r2 = com.facebook.katana.constants.Constants.URL.p(r5);
        r1.<init>(r4, r5, r2);
        r0.setWebViewClient(r1);
        r0 = com.facebook.katana.constants.Constants.URL.p(r5);
        r1 = com.facebook.katana.service.FacebookPlatform.m1201a(r5, r0);
        r0 = com.facebook.inject.FbInjector.get(r5);
        r0 = com.facebook.content.SecureWebViewHelper.a(r0);
        r0 = (com.facebook.content.SecureWebViewHelper) r0;
        r2 = r4.f1255e;
        r0.a(r2, r1);
        goto L_0x0016;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.webview.FacebookAuthentication.a(android.content.Context, com.facebook.webview.auth.AuthCallback):void");
    }

    static boolean m1285a(String str, String str2) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!StringUtil.a(scheme, "http") && !StringUtil.a(scheme, "https")) {
            return false;
        }
        scheme = parse.getHost();
        if (scheme.startsWith("m.") && scheme.endsWith(".facebook.com")) {
            return StringUtil.a(parse.getPath(), str2);
        }
        return false;
    }

    public static boolean matchUrlLiberally(String str, String str2) {
        boolean z = true;
        if (str.equals(str2)) {
            return true;
        }
        Uri parse = Uri.parse(str);
        Uri parse2 = Uri.parse(str2);
        String scheme = parse.getScheme();
        String scheme2 = parse2.getScheme();
        boolean z2 = StringUtil.a(scheme, "http") || StringUtil.a(scheme, "https");
        if (!(StringUtil.a(scheme2, "http") || StringUtil.a(scheme2, "https"))) {
            z = false;
        }
        if ((z2 && r2) || StringUtil.a(scheme, scheme2)) {
            return m1281a(parse).equals(m1281a(parse2));
        }
        return false;
    }

    private static Uri m1281a(Uri uri) {
        return uri.buildUpon().scheme("http").query(null).fragment(null).build();
    }
}
