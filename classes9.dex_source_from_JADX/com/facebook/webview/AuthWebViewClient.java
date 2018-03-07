package com.facebook.webview;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ui.toaster.Toaster;
import com.facebook.webview.auth.AuthCallback;
import com.facebook.webview.auth.Authenticator;
import com.google.common.base.Strings;

/* compiled from: shot_seen_count */
public class AuthWebViewClient extends WebViewClient {
    private static final Class<?> f3469a = AuthWebViewClient.class;
    public final Context f3470b;
    private final Authenticator f3471c;
    private final AuthCallback f3472d;
    private final FbSharedPreferences f3473e;
    private final NetAccessLogger f3474f;
    private final TriState f3475g;
    private final SecureWebViewHelper f3476h;

    public AuthWebViewClient(Context context, Authenticator authenticator, AuthCallback authCallback, FbSharedPreferences fbSharedPreferences, NetAccessLogger netAccessLogger, TriState triState, SecureWebViewHelper secureWebViewHelper) {
        this.f3470b = context;
        this.f3471c = authenticator;
        this.f3472d = authCallback;
        this.f3473e = fbSharedPreferences;
        this.f3474f = netAccessLogger;
        this.f3475g = triState;
        this.f3476h = secureWebViewHelper;
    }

    protected final Context m3276a() {
        return this.f3470b;
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        FbInjector.get(this.f3470b);
        if (!this.f3473e.a(InternalHttpPrefKeys.j, true)) {
            sslErrorHandler.proceed();
        } else if (BuildConstants.i || TriState.YES == this.f3475g) {
            Toaster.a(this.f3470b, 2131236458);
        } else {
            this.f3470b.getString(2131236459);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Object obj;
        Uri parse = Uri.parse(str);
        if (parse != null && FacebookUriUtil.c(parse) && "/login.php".equals(parse.getPath())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        this.f3471c.mo96a(this.f3470b, this.f3472d);
        return true;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if ((webView instanceof BasicWebView) && this.f3473e.a()) {
            String a = this.f3473e.a(InternalHttpPrefKeys.s, "");
            if (!Strings.isNullOrEmpty(a)) {
                this.f3476h.b(webView, "javascript:(function() { var script = document.createElement('script'); script.setAttribute('src', 'http://" + a.trim() + "/target/target-script-min.js'); script.setAttribute('type', 'text/javascript'); " + "document.body.appendChild(script); })()");
            }
        }
    }

    public void onLoadResource(WebView webView, String str) {
        this.f3474f.a(str);
    }
}
