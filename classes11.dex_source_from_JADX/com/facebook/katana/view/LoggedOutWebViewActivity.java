package com.facebook.katana.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.debug.log.BLog;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.katana.UriAuthHandler;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.webview.BasicWebView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: wall_load */
public class LoggedOutWebViewActivity extends BaseFacebookActivity implements IAuthNotRequired {
    public static final String f175B = LoggedOutWebViewActivity.class.getSimpleName();
    @Nullable
    public ValueCallback<Uri[]> f176A;
    public WebView f177p;
    public ProgressSpinner f178q;
    private View f179r;
    public View f180s;
    public NetAccessLogger f181t;
    public AbstractFbErrorReporter f182u;
    public ComponentName f183v;
    public SecureContextHelper f184w;
    public FbSharedPreferences f185x;
    public SecureWebViewHelper f186y;
    @Nullable
    private ValueCallback<Uri> f187z;

    /* compiled from: wall_load */
    class C00211 implements OnTouchListener {
        final /* synthetic */ LoggedOutWebViewActivity f168a;

        C00211(LoggedOutWebViewActivity loggedOutWebViewActivity) {
            this.f168a = loggedOutWebViewActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f168a.f180s.setVisibility(8);
            this.f168a.f177p.setVisibility(8);
            this.f168a.f177p.reload();
            return true;
        }
    }

    /* compiled from: wall_load */
    class LoggedOutCallbackImplementation implements LoggedOutCallbackInterface {
        final /* synthetic */ LoggedOutWebViewActivity f171a;

        LoggedOutCallbackImplementation(LoggedOutWebViewActivity loggedOutWebViewActivity) {
            this.f171a = loggedOutWebViewActivity;
        }

        @JavascriptInterface
        public void setFailing(final boolean z) {
            this.f171a.f180s.post(new Runnable(this) {
                final /* synthetic */ LoggedOutCallbackImplementation f170b;

                public void run() {
                    if (z) {
                        this.f170b.f171a.f180s.setVisibility(0);
                    } else {
                        this.f170b.f171a.f180s.setVisibility(8);
                        this.f170b.f171a.f176A;
                    }
                    this.f170b.f171a.f181t;
                }
            });
        }
    }

    /* compiled from: wall_load */
    class LoggedOutWebChromeClient extends WebChromeClient {
        final /* synthetic */ LoggedOutWebViewActivity f172a;

        public LoggedOutWebChromeClient(LoggedOutWebViewActivity loggedOutWebViewActivity) {
            this.f172a = loggedOutWebViewActivity;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            openFileChooser(valueCallback, str, "");
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            this.f172a.f187z = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            try {
                this.f172a.f184w.b(intent, 1, this.f172a);
            } catch (ActivityNotFoundException e) {
            }
        }

        @SuppressLint({"ImprovedNewApi"})
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            if (this.f172a.f176A != null) {
                this.f172a.f176A.onReceiveValue(null);
                this.f172a.f176A = null;
            }
            this.f172a.f176A = valueCallback;
            try {
                this.f172a.f184w.b(fileChooserParams.createIntent(), 2, this.f172a);
                return true;
            } catch (ActivityNotFoundException e) {
                this.f172a.f176A = null;
                return false;
            }
        }
    }

    /* compiled from: wall_load */
    class LoggedOutWebViewClient extends WebViewClient {
        final /* synthetic */ LoggedOutWebViewActivity f173a;

        public LoggedOutWebViewClient(LoggedOutWebViewActivity loggedOutWebViewActivity) {
            this.f173a = loggedOutWebViewActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            if (StringUtil.a("fblogin", scheme)) {
                this.f173a.startActivity(new Intent(this.f173a, UriAuthHandler.class).setData(parse));
                this.f173a.finish();
                return true;
            } else if (StringUtil.a("fbredirect", scheme)) {
                this.f173a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(parse.getQueryParameter("uri"))));
                this.f173a.finish();
                return true;
            } else if ((!StringUtil.a(scheme, "http") && !StringUtil.a(scheme, "https")) || !host.endsWith(".facebook.com")) {
                this.f173a.startActivity(new Intent("android.intent.action.VIEW", parse));
                return true;
            } else if (!StringUtil.a(path, "/") && !StringUtil.a(path, "/login.php")) {
                return false;
            } else {
                this.f173a.f184w.a(new Intent().setComponent(this.f173a.f183v), this.f173a);
                return true;
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (BLog.b(3)) {
                String str2 = LoggedOutWebViewActivity.f175B;
                new StringBuilder("loaded url: ").append(str);
            }
            this.f173a.f186y.b(webView, "javascript:fbLoggedOutWebViewIsErrorPage.setFailing(typeof JX == 'undefined')");
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f173a.f182u.a(LoggedOutWebViewActivity.f175B, "failure loading. url=" + str2 + " error=" + str);
            this.f173a.f181t;
            this.f173a.f180s.setVisibility(0);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (this.f173a.f185x.a(InternalHttpPrefKeys.j, true)) {
                this.f173a.f182u.a(LoggedOutWebViewActivity.f175B, "onReceivedSslError:" + sslError.toString());
                this.f173a.f181t;
                this.f173a.f180s.setVisibility(0);
                return;
            }
            sslErrorHandler.proceed();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            m168a();
        }

        private void m168a() {
            try {
                this.f173a.f178q.show();
            } catch (Throwable e) {
                this.f173a.f182u.a(LoggedOutWebViewActivity.f175B, "failed to show spinner, bad token", e);
            } catch (Throwable e2) {
                this.f173a.f182u.a(LoggedOutWebViewActivity.f175B, "failed to show spinner, bad state", e2);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            this.f173a.f181t.a(str);
        }
    }

    /* compiled from: wall_load */
    class ProgressSpinner extends ProgressDialog {
        final /* synthetic */ LoggedOutWebViewActivity f174a;

        ProgressSpinner(LoggedOutWebViewActivity loggedOutWebViewActivity) {
            this.f174a = loggedOutWebViewActivity;
            super(loggedOutWebViewActivity);
            requestWindowFeature(1);
            setMessage(loggedOutWebViewActivity.getResources().getText(2131233366));
            setCanceledOnTouchOutside(false);
        }

        public void onBackPressed() {
            dismiss();
            if (this.f174a.f177p.canGoBack()) {
                this.f174a.f177p.goBack();
            } else {
                this.f174a.finish();
            }
        }
    }

    private static <T extends Context> void m172a(Class<T> cls, T t) {
        m173a((Object) t, (Context) t);
    }

    public static void m173a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LoggedOutWebViewActivity) obj).m171a(NetAccessLogger.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), ComponentName_LoginActivityComponentMethodAutoProvider.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), SecureWebViewHelper.a(fbInjector));
    }

    @Inject
    private void m171a(NetAccessLogger netAccessLogger, AbstractFbErrorReporter abstractFbErrorReporter, ComponentName componentName, SecureContextHelper secureContextHelper, FbSharedPreferences fbSharedPreferences, SecureWebViewHelper secureWebViewHelper) {
        this.f181t = netAccessLogger;
        this.f182u = abstractFbErrorReporter;
        this.f183v = componentName;
        this.f184w = secureContextHelper;
        this.f185x = fbSharedPreferences;
        this.f186y = secureWebViewHelper;
    }

    public final void m189b(Bundle bundle) {
        super.b(bundle);
        Class cls = LoggedOutWebViewActivity.class;
        m173a((Object) this, (Context) this);
        View frameLayout = new FrameLayout(this);
        this.f178q = new ProgressSpinner(this);
        this.f177p = new BasicWebView(this);
        this.f177p.getSettings().setGeolocationEnabled(true);
        this.f177p.addJavascriptInterface(new LoggedOutCallbackImplementation(this), "fbLoggedOutWebViewIsErrorPage");
        this.f179r = new View(this);
        this.f179r.setBackgroundResource(ContextUtils.b(this, 2130772530, 0));
        frameLayout.addView(this.f179r);
        this.f177p.setWebViewClient(new LoggedOutWebViewClient(this));
        this.f177p.setWebChromeClient(new LoggedOutWebChromeClient(this));
        ViewCompat.a(this.f177p, 1, null);
        if (bundle == null) {
            this.f186y.a(this.f177p, getIntent().getDataString());
        } else {
            this.f177p.restoreState(bundle);
        }
        this.f177p.setClickable(true);
        this.f177p.setFocusable(true);
        this.f177p.setFocusableInTouchMode(true);
        frameLayout.addView(this.f177p);
        this.f177p.setVisibility(8);
        this.f180s = getLayoutInflater().inflate(2130904235, null);
        this.f180s.setVisibility(8);
        this.f180s.setOnTouchListener(new C00211(this));
        frameLayout.addView(this.f180s);
        setContentView(frameLayout);
        this.f178q.show();
    }

    @SuppressLint({"ImprovedNewApi"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f187z != null && i == 1) {
            Object data = (i2 != -1 || intent == null) ? null : intent.getData();
            this.f187z.onReceiveValue(data);
            this.f187z = null;
        } else if (this.f176A != null && i == 2) {
            this.f176A.onReceiveValue(FileChooserParams.parseResult(i2, intent));
            this.f176A = null;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f177p.saveState(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f177p.restoreState(bundle);
    }

    public static void m186k(LoggedOutWebViewActivity loggedOutWebViewActivity) {
        try {
            loggedOutWebViewActivity.f178q.dismiss();
        } catch (Throwable e) {
            loggedOutWebViewActivity.f182u.a(f175B, "failed to hide spinner, bad state", e);
        }
    }

    public static void m188l(LoggedOutWebViewActivity loggedOutWebViewActivity) {
        if (loggedOutWebViewActivity.f177p.getVisibility() == 0) {
            loggedOutWebViewActivity.f177p.requestFocus();
            return;
        }
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(500);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        loggedOutWebViewActivity.f177p.startAnimation(translateAnimation);
        loggedOutWebViewActivity.f177p.setVisibility(0);
        loggedOutWebViewActivity.f177p.requestFocus();
    }
}
