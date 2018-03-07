package com.facebook.messaging.browser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import java.net.URISyntaxException;
import java.util.Stack;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: object_participant_pics */
public class MessengerWebViewHelper {
    public final Context f8340a;
    public final SecureContextHelper f8341b;
    public final Stack<WebView> f8342c = new Stack();
    @Nullable
    public ProgressBar f8343d;
    @Nullable
    public DismissUrlHandler f8344e;
    @Nullable
    private String f8345f;

    /* compiled from: object_participant_pics */
    public interface DismissUrlHandler {
        void mo328a();
    }

    /* compiled from: object_participant_pics */
    public class MessengerWebViewChromeClient extends WebChromeClient {
        final /* synthetic */ MessengerWebViewHelper f8338a;

        public MessengerWebViewChromeClient(MessengerWebViewHelper messengerWebViewHelper) {
            this.f8338a = messengerWebViewHelper;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            ((WebViewTransport) message.obj).setWebView(this.f8338a.m8636a());
            message.sendToTarget();
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            if (this.f8338a.f8343d != null) {
                this.f8338a.f8343d.setProgress(i);
                this.f8338a.f8343d.setVisibility(i == 100 ? 8 : 0);
            }
        }

        public void onCloseWindow(WebView webView) {
            WebView webView2;
            MessengerWebViewHelper messengerWebViewHelper = this.f8338a;
            if (messengerWebViewHelper.f8342c.isEmpty()) {
                webView2 = null;
            } else {
                webView2 = (WebView) messengerWebViewHelper.f8342c.peek();
            }
            WebView webView3 = webView2;
            if (webView3 != null) {
                messengerWebViewHelper.f8342c.pop();
                MessengerWebViewHelper.m8635c(webView3);
            }
        }
    }

    /* compiled from: object_participant_pics */
    public class MessengerWebViewClient extends WebViewClient {
        final /* synthetic */ MessengerWebViewHelper f8339a;

        public MessengerWebViewClient(MessengerWebViewHelper messengerWebViewHelper) {
            this.f8339a = messengerWebViewHelper;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (URLUtil.isNetworkUrl(str)) {
                return false;
            }
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (this.f8339a.f8340a.getPackageManager().resolveActivity(parseUri, 0) == null) {
                    return false;
                }
                this.f8339a.f8341b.b(parseUri, this.f8339a.f8340a);
                return true;
            } catch (URISyntaxException e) {
                return false;
            }
        }

        public void onPageFinished(WebView webView, String str) {
            if (this.f8339a.f8344e != null && MessengerWebViewHelper.m8633a(this.f8339a, str)) {
                this.f8339a.f8344e.mo328a();
            }
        }
    }

    public static MessengerWebViewHelper m8634b(InjectorLike injectorLike) {
        return new MessengerWebViewHelper((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public MessengerWebViewHelper(Context context, SecureContextHelper secureContextHelper) {
        this.f8340a = context;
        this.f8341b = secureContextHelper;
        CookieSyncManager.createInstance(this.f8340a);
    }

    public final WebView m8636a() {
        WebView webView = new WebView(this.f8340a);
        webView.setWebViewClient(new MessengerWebViewClient(this));
        webView.setWebChromeClient(new MessengerWebViewChromeClient(this));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAppCacheEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setDatabaseEnabled(false);
        settings.setSaveFormData(false);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        webView.setLayoutParams(new LayoutParams(-1, -1));
        this.f8342c.push(webView);
        return webView;
    }

    public final void m8638b() {
        while (!this.f8342c.empty()) {
            m8635c((WebView) this.f8342c.pop());
        }
        this.f8343d = null;
        this.f8345f = null;
        this.f8344e = null;
    }

    public final void m8637a(String str, DismissUrlHandler dismissUrlHandler) {
        this.f8345f = str;
        this.f8344e = dismissUrlHandler;
    }

    public static boolean m8633a(MessengerWebViewHelper messengerWebViewHelper, String str) {
        if (Strings.isNullOrEmpty(messengerWebViewHelper.f8345f) || Strings.isNullOrEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Uri parse2 = Uri.parse(messengerWebViewHelper.f8345f);
            if (parse2.getPath() != null && !parse2.getPath().equalsIgnoreCase(parse.getPath())) {
                return false;
            }
            String[] split = parse2.getHost().split("[.]");
            String[] split2 = parse.getHost().split("[.]");
            if (split.length < 2 || split2.length < 2 || !split[split.length - 1].equalsIgnoreCase(split2[split2.length - 1]) || !split[split.length - 2].equalsIgnoreCase(split2[split2.length - 2])) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void m8635c(WebView webView) {
        webView.stopLoading();
        webView.setWebViewClient(null);
        webView.setWebChromeClient(null);
        webView.destroy();
    }
}
