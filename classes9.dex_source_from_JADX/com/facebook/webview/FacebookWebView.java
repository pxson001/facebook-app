package com.facebook.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.invariants.Invariants;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.HorizontalScrollAwareView;
import com.facebook.inject.FbInjector;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.webview.BasicWebView.BasicWebChromeClient;
import com.facebook.webview.FacewebUriPalCall.JsVariable;
import com.facebook.webview.HorizontalScrollingFacewebUtil.UriDetector;
import com.facebook.webview.auth.AuthCallback;
import com.facebook.webview.auth.Authenticator;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: shoebox_moments_app_open */
public class FacebookWebView extends BasicWebView implements HorizontalScrollAwareView {
    private static final Class<?> f3506i = FacebookWebView.class;
    protected Map<String, UrlHandler> f3507e;
    protected FacebookJsBridge f3508f;
    public FbSharedPreferences f3509g;
    public PerformanceLogger f3510h;
    public boolean f3511j;
    public String f3512k;
    public WebViewUriRedirector f3513l;

    /* compiled from: shoebox_moments_app_open */
    public interface NativeCallHandler {
        void mo85a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall);
    }

    /* compiled from: shoebox_moments_app_open */
    public interface UrlHandler {
        void mo86a(Context context, FacebookWebView facebookWebView, Uri uri);
    }

    /* compiled from: shoebox_moments_app_open */
    public class FacebookWebViewClient extends AuthWebViewClient {
        public FacebookWebViewClient(Context context, Authenticator authenticator, AuthCallback authCallback, FbSharedPreferences fbSharedPreferences, NetAccessLogger netAccessLogger, TriState triState, SecureWebViewHelper secureWebViewHelper) {
            super(context, authenticator, authCallback, fbSharedPreferences, netAccessLogger, triState, secureWebViewHelper);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (webView instanceof FacebookWebView) {
                ((FacebookWebView) webView).m3310a("fbNativeReady", null);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            if (!(webView instanceof FacebookWebView)) {
                return false;
            }
            FacebookWebView facebookWebView = (FacebookWebView) webView;
            Uri parse = Uri.parse(str);
            UrlHandler a = facebookWebView.m3304a(parse.getScheme());
            if (a != null) {
                a.mo86a(this.f3470b, (FacebookWebView) webView, parse);
                return true;
            }
            Object obj;
            WebViewUriRedirector webViewUriRedirector = facebookWebView.f3513l;
            Preconditions.checkNotNull(webView);
            Preconditions.checkNotNull(parse);
            Intent b = webViewUriRedirector.m3332b(webView.getContext(), parse.toString());
            if (b == null) {
                obj = null;
            } else {
                webViewUriRedirector.f3522a.a(b, webView.getContext());
                obj = 1;
            }
            return obj != null;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (BuildConstants.i) {
                new StringBuilder().append("url ").append(str2).append(" failed (code: ").append(i).append("; description: ").append(str).append(")");
            }
        }
    }

    /* compiled from: shoebox_moments_app_open */
    public interface FileChooser {
        void m3290a(ValueCallback<Uri> valueCallback);

        void m3291a(ValueCallback<Uri> valueCallback, String str);

        boolean m3292a(ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams);

        void m3293b(ValueCallback<Uri> valueCallback, String str);
    }

    /* compiled from: shoebox_moments_app_open */
    public class RPCChromeClient extends BasicWebChromeClient {
        final /* synthetic */ FacebookWebView f3499c;

        protected RPCChromeClient(FacebookWebView facebookWebView) {
            this.f3499c = facebookWebView;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!(webView instanceof FacebookWebView)) {
                return false;
            }
            FacebookWebView facebookWebView = (FacebookWebView) webView;
            Uri parse = Uri.parse(str2);
            UrlHandler urlHandler = (UrlHandler) facebookWebView.f3507e.get(parse.getScheme());
            if (urlHandler == null) {
                return false;
            }
            urlHandler.mo86a(this.f3499c.getContext(), facebookWebView, parse);
            jsPromptResult.cancel();
            return true;
        }
    }

    /* compiled from: shoebox_moments_app_open */
    public class FileChooserRPCChromeClient extends RPCChromeClient {
        final /* synthetic */ FacebookWebView f3500b;
        private FileChooser f3501d;

        FileChooserRPCChromeClient(FacebookWebView facebookWebView, FileChooser fileChooser) {
            this.f3500b = facebookWebView;
            super(facebookWebView);
            this.f3501d = fileChooser;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            this.f3501d.m3290a(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            this.f3501d.m3291a((ValueCallback) valueCallback, str);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            this.f3501d.m3293b(valueCallback, str);
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            return this.f3501d.m3292a((ValueCallback) valueCallback, fileChooserParams);
        }
    }

    /* compiled from: shoebox_moments_app_open */
    public interface JsReturnHandler {
        void m3294a(FacebookWebView facebookWebView, String str, boolean z, String str2);
    }

    /* compiled from: shoebox_moments_app_open */
    public abstract class NativeUICallHandler implements NativeCallHandler {
        protected Handler f3505a;

        public abstract void m3296a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall);

        public NativeUICallHandler(Handler handler) {
            this.f3505a = handler;
        }

        public final void mo85a(Context context, final FacebookWebView facebookWebView, final FacewebPalCall facewebPalCall) {
            m3297a(facewebPalCall);
            HandlerDetour.a(this.f3505a, new Runnable(this) {
                final /* synthetic */ NativeUICallHandler f3504c;

                public void run() {
                    this.f3504c.m3296a(facebookWebView, facewebPalCall);
                }
            }, 1782164138);
        }

        public void m3297a(FacewebPalCall facewebPalCall) {
        }
    }

    private static <T extends View> void m3301a(Class<T> cls, T t) {
        m3302a((Object) t, t.getContext());
    }

    private static void m3302a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FacebookWebView) obj).m3300a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (PerformanceLogger) DelegatingPerformanceLogger.a(fbInjector), WebViewUriRedirector.m3329a(fbInjector));
    }

    public final boolean m3313a(Direction direction, int i, int i2) {
        boolean z;
        String url = getUrl();
        if (url == null) {
            z = false;
        } else {
            for (UriDetector a : HorizontalScrollingFacewebUtil.f3520b) {
                if (a.mo95a(url)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final void m3311a(String str, List<?> list, JsReturnHandler jsReturnHandler) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append("(");
        StringUtil.a(stringBuilder, ", ", FacebookJsBridge.f3493a, new Object[]{list});
        stringBuilder.append(");");
        m3305a(stringBuilder.toString(), jsReturnHandler);
    }

    protected final void m3307a(Context context, FacewebPalCall facewebPalCall) {
        this.f3508f.m3289a(context, this, facewebPalCall);
    }

    public FacebookWebView(Context context) {
        this(context, null);
    }

    public FacebookWebView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacebookWebView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Inject
    private void m3300a(FbSharedPreferences fbSharedPreferences, PerformanceLogger performanceLogger, WebViewUriRedirector webViewUriRedirector) {
        this.f3509g = fbSharedPreferences;
        this.f3510h = performanceLogger;
        this.f3513l = webViewUriRedirector;
    }

    public void setMobilePage(String str) {
        this.f3512k = str;
    }

    public String getMobilePage() {
        return this.f3512k;
    }

    protected FbSharedPreferences getFbSharedPreferences() {
        return this.f3509g;
    }

    protected NetAccessLogger getNetAccessLogger() {
        return this.f3481a;
    }

    public static WebViewUriRedirector getWebViewUriRedirector(FacebookWebView facebookWebView) {
        return facebookWebView.f3513l;
    }

    public final String m3305a(String str, @Nullable JsReturnHandler jsReturnHandler) {
        String formatStrLocaleSafe;
        String a = this.f3508f.m3287a(str, jsReturnHandler);
        String str2 = "__android_injected_function_" + a;
        this.f3482b.b(this, StringFormatUtil.formatStrLocaleSafe("javascript:var %1$s = function() { return %2$s;};", str2, str));
        Map hashMap = new HashMap();
        hashMap.put("callId", a);
        hashMap.put("exc", new JsVariable("__android_exception"));
        hashMap.put("retval", new JsVariable("__android_retval"));
        String a2 = FacewebUriPalCall.m3319a("fbrpc", "facebook", null, null, "call_return", hashMap);
        if (BuildConstants.i) {
            hashMap = new HashMap();
            hashMap.put("callId", a);
            hashMap.put("exc", new JsVariable("err"));
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("javascript:(function() { var __android_exception = null; var __android_retval; try { __android_retval = %1$s();} catch (err) { window.prompt(%2$s);throw err; }window.prompt(%3$s);%1$s = null;})()", str2, FacewebUriPalCall.m3319a("fbrpc", "facebook", null, null, "call_return", hashMap), a2);
        } else {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("javascript:(function() { var __android_exception = null; var __android_retval = null; try { __android_retval = %1$s();} catch (err) { __android_exception = true; }window.prompt(%2$s);%1$s = null;})()", str2, a2);
        }
        this.f3482b.b(this, formatStrLocaleSafe);
        return a;
    }

    public final void m3310a(String str, @Nullable String str2) {
        if (str2 == null || str2.equals("")) {
            str2 = "null";
        }
        m3303b(StringFormatUtil.formatStrLocaleSafe("(function() {var event = document.createEvent('Event');event.initEvent('%1$s', true, true);event.data = '%2$s';document.dispatchEvent(event);})();", str, new JsVariable(str2)));
    }

    public final void m3314b(String str, @Nullable JsReturnHandler jsReturnHandler) {
        m3305a(str, jsReturnHandler);
    }

    public final void m3309a(String str, UrlHandler urlHandler) {
        Invariants.a(((UrlHandler) this.f3507e.put(str, urlHandler)) == null);
    }

    public final UrlHandler m3304a(String str) {
        return (UrlHandler) this.f3507e.get(str);
    }

    public final void m3308a(String str, NativeCallHandler nativeCallHandler) {
        this.f3508f.m3288a(str, nativeCallHandler);
    }

    public void destroy() {
        if (this.f3508f != null) {
            this.f3508f.f3496d.clear();
        }
        try {
            super.destroy();
        } catch (Throwable e) {
            this.f3483c.a("webview_destroy_exception", e);
        }
    }

    public final boolean m3312a() {
        return this.f3511j;
    }

    public void setSyncFriendsOnDestroy(boolean z) {
        this.f3511j = z;
    }

    public static void m3299a(Context context, String str, Collection<SessionCookie> collection) {
        if (collection != null) {
            CookieManager cookieManager;
            if (VERSION.SDK_INT >= 21) {
                CookieManager instance = CookieManager.getInstance();
                instance.flush();
                cookieManager = instance;
            } else {
                CookieSyncManager.createInstance(context).sync();
                cookieManager = CookieManager.getInstance();
            }
            cookieManager.setAcceptCookie(true);
            for (SessionCookie sessionCookie : collection) {
                cookieManager.setCookie(str, sessionCookie.toString());
            }
        }
    }

    private void m3303b(String str) {
        this.f3482b.b(this, "javascript:" + str);
    }

    protected void mo89a(Context context) {
        super.mo89a(context);
        m3301a(FacebookWebView.class, (View) this);
        this.f3507e = Maps.c();
        this.f3508f = new FacebookJsBridge(f3506i);
        m3309a("fbrpc", this.f3508f.f3494b);
    }

    protected void setChromeClient(Context context) {
        setWebChromeClient(new RPCChromeClient(this));
    }

    public void setFileChooserChromeClient(FileChooser fileChooser) {
        setWebChromeClient(new FileChooserRPCChromeClient(this, fileChooser));
    }
}
