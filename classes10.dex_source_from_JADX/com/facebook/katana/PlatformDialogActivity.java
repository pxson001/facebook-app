package com.facebook.katana;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.WindowManager.BadTokenException;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceFragment;
import com.facebook.fbservice.ops.BlueServiceOperation;
import com.facebook.fbservice.ops.BlueServiceOperation.OnCompletedListener;
import com.facebook.fbservice.ops.BlueServiceOperation.State;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.dbl.FacebookLoginIntentManager;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.facebook.katana.service.AppSession.LogoutReason;
import com.facebook.katana.service.AppSessionListener;
import com.facebook.katana.service.FacebookPlatform;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.URLQueryBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.platform.server.protocol.GetAppPermissionsMethod.Params;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.webview.BasicWebView;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: via_chat_bar_active_chats_section */
public abstract class PlatformDialogActivity extends BaseFacebookActivity {
    public static String f654p = null;
    public static final Class<?> f655s = PlatformDialogActivity.class;
    public FacebookLoginIntentManager f656A;
    public boolean f657B = false;
    public final AppSessionListener f658C = new C00931(this);
    public String f659q = null;
    public PerformanceLogger f660r;
    private String f661t = null;
    public ProgressDialog f662u;
    public String f663v;
    public BasicWebView f664w;
    public NetAccessLogger f665x;
    public Locales f666y;
    private BlueServiceFragment f667z;

    /* compiled from: via_chat_bar_active_chats_section */
    class C00931 extends AppSessionListener {
        final /* synthetic */ PlatformDialogActivity f650a;

        C00931(PlatformDialogActivity platformDialogActivity) {
            this.f650a = platformDialogActivity;
        }

        public final void m681b(Throwable th) {
            PlatformDialogActivity.m690u(this.f650a);
            if (!this.f650a.isFinishing() && this.f650a.f657B) {
                this.f650a.f656A.b(this.f650a);
            }
        }
    }

    /* compiled from: via_chat_bar_active_chats_section */
    class C00942 extends OnCompletedListener {
        final /* synthetic */ PlatformDialogActivity f651a;

        public final void m683a(ServiceException serviceException) {
            if (serviceException.errorCode == ErrorCode.API_ERROR && ((ApiException) serviceException.getCause()).b().a() == 190) {
                AppSession a = AppSession.a(this.f651a);
                a.a(this.f651a.f658C);
                a.a(this.f651a, LogoutReason.FORCED_ERROR_INVALID_SESSION);
                return;
            }
            PlatformDialogActivity.m690u(this.f651a);
            BLog.b(PlatformDialogActivity.f655s, "Login failed due to error: %s", new Object[]{serviceException.getMessage()});
            Bundle bundle = new Bundle();
            bundle.putString("error", serviceException.getMessage());
            bundle.putString("error_code", serviceException.errorCode.name());
            this.f651a.m693d(bundle);
        }

        C00942(PlatformDialogActivity platformDialogActivity) {
            this.f651a = platformDialogActivity;
        }

        public final void m682a(OperationResult operationResult) {
            PlatformDialogActivity platformDialogActivity = this.f651a;
            if (AppSession.b(platformDialogActivity, false) == null) {
                platformDialogActivity.m693d(null);
                return;
            }
            platformDialogActivity.f663v = platformDialogActivity.f659q;
            platformDialogActivity.f660r.c(new MarkerConfig(3670023, PlatformDialogActivity.m688r(platformDialogActivity) + StringUtils.a(platformDialogActivity.f663v)).a("e2e", platformDialogActivity.getIntent().getStringExtra("e2e")));
            platformDialogActivity.f659q = FacebookPlatform.m1201a(platformDialogActivity, platformDialogActivity.f659q);
            SecureWebViewHelper.a(platformDialogActivity.hz_()).a(platformDialogActivity.f664w, platformDialogActivity.f659q);
        }
    }

    /* compiled from: via_chat_bar_active_chats_section */
    class PlatformDialogSpinner extends ProgressDialog {
        final /* synthetic */ PlatformDialogActivity f652a;

        PlatformDialogSpinner(PlatformDialogActivity platformDialogActivity) {
            this.f652a = platformDialogActivity;
            super(platformDialogActivity);
            requestWindowFeature(1);
            setCanceledOnTouchOutside(false);
            setMessage(platformDialogActivity.getResources().getText(2131233366));
        }

        public void onBackPressed() {
            dismiss();
            this.f652a.m693d(null);
        }
    }

    /* compiled from: via_chat_bar_active_chats_section */
    public class PlatformDialogWebViewClient extends WebViewClient {
        public final /* synthetic */ PlatformDialogActivity f653a;

        protected PlatformDialogWebViewClient(PlatformDialogActivity platformDialogActivity) {
            this.f653a = platformDialogActivity;
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            PlatformDialogActivity.m689t(this.f653a);
            FbInjector fbInjector = FbInjector.get(this.f653a);
            if (!((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector)).a(InternalHttpPrefKeys.j, true)) {
                sslErrorHandler.proceed();
            } else if (BuildConstants.i || TriState.YES == TriState_IsMeUserAnEmployeeMethodAutoProvider.b(fbInjector)) {
                Toast.makeText(this.f653a, 2131236458, 1).show();
            } else {
                this.f653a.getString(2131236459);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("fbconnect://success")) {
                if (this.f653a.getIntent().getBooleanExtra("return_via_intent_url", false)) {
                    String stringExtra = this.f653a.getIntent().getStringExtra("client_id");
                    String stringExtra2 = this.f653a.getIntent().getStringExtra("activity_id");
                    if (stringExtra2 == null) {
                        stringExtra2 = "";
                    }
                    StringBuilder append = new StringBuilder("fb").append(stringExtra).append(stringExtra2).append("://authorize");
                    stringExtra = Uri.parse(str).getEncodedFragment();
                    if (stringExtra != null) {
                        append.append("#").append(stringExtra);
                    }
                    this.f653a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(append.toString())));
                    return true;
                }
                this.f653a.m692c(PlatformDialogActivity.m686b(str.replace("fbconnect", "http")));
                return true;
            } else if (str.contains("touch")) {
                return false;
            } else {
                this.f653a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            PlatformDialogActivity.m689t(this.f653a);
            Bundle bundle = new Bundle();
            bundle.putString("error", str);
            bundle.putInt("error_code", i);
            bundle.putString("failing_url", str2);
            this.f653a.m693d(bundle);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            try {
                this.f653a.f662u.show();
            } catch (BadTokenException e) {
            } catch (IllegalStateException e2) {
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f653a.f660r.c(3670023, PlatformDialogActivity.m688r(this.f653a) + StringUtils.a(str));
            PlatformDialogActivity.m690u(this.f653a);
        }

        public void onLoadResource(WebView webView, String str) {
            this.f653a.f665x.a(str);
        }
    }

    public static void m684a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlatformDialogActivity platformDialogActivity = (PlatformDialogActivity) obj;
        NetAccessLogger b = NetAccessLogger.b(fbInjector);
        Locales a = Locales.a(fbInjector);
        PerformanceLogger performanceLogger = (PerformanceLogger) DelegatingPerformanceLogger.a(fbInjector);
        FacebookLoginIntentManager b2 = FacebookLoginIntentManager.b(fbInjector);
        platformDialogActivity.f665x = b;
        platformDialogActivity.f666y = a;
        platformDialogActivity.f660r = performanceLogger;
        platformDialogActivity.f656A = b2;
    }

    protected abstract void mo25m();

    public final void m692c(Bundle bundle) {
        m685a(true, bundle);
    }

    public final void m693d(Bundle bundle) {
        m685a(false, bundle);
    }

    private void m685a(boolean z, Bundle bundle) {
        int i = z ? -1 : 0;
        if (bundle == null) {
            setResult(i);
        } else {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(i, intent);
        }
        finish();
    }

    protected final String m694j() {
        return this.f661t;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 0) {
            finish();
        }
        switch (i) {
            case 2210:
                m687p();
                return;
            default:
                return;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("calling_package", this.f661t);
    }

    private void m687p() {
        if (!isFinishing()) {
            Object obj;
            Params params;
            Bundle bundle;
            BlueServiceFragment blueServiceFragment = this.f667z;
            if (blueServiceFragment.e) {
                Object obj2;
                BlueServiceOperation blueServiceOperation = blueServiceFragment.a;
                if (blueServiceOperation.q == State.INIT || blueServiceOperation.q == State.COMPLETED) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    obj = 1;
                    if (obj == null) {
                        params = new Params(getIntent().getStringExtra("client_id"));
                        bundle = new Bundle();
                        bundle.putParcelable("app_info", params);
                        this.f662u.show();
                        this.f667z.a("platform_get_app_permissions", bundle);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                params = new Params(getIntent().getStringExtra("client_id"));
                bundle = new Bundle();
                bundle.putParcelable("app_info", params);
                this.f662u.show();
                this.f667z.a("platform_get_app_permissions", bundle);
            }
        }
    }

    protected void mo24b(Bundle bundle) {
        super.b(bundle);
        Class cls = PlatformDialogActivity.class;
        m684a((Object) this, (Context) this);
        if (bundle != null) {
            this.f661t = bundle.getString("calling_package");
        } else {
            this.f661t = m695l();
        }
        if (!isFinishing()) {
            setContentView(2130906326);
            this.f662u = new PlatformDialogSpinner(this);
            WebViewClient n = mo26n();
            this.f664w = (BasicWebView) findViewById(2131566146);
            this.f664w.setVerticalScrollBarEnabled(false);
            this.f664w.setHorizontalScrollBarEnabled(false);
            this.f664w.setWebViewClient(n);
            this.f664w.getSettings().setJavaScriptEnabled(true);
            CookieSyncManager.createInstance(this);
            String c = this.f666y.c();
            if (f654p == null || !c.equals(f654p)) {
                f654p = c;
                CookieManager.getInstance().setCookie("facebook.com", "locale=");
            }
            mo25m();
            if (this.f659q == null) {
                BLog.b("PlatformDialogActivity", "mUrl was not set in setupDialogURL(). Any class inheriting from PlatformDialogActivity MUST set mUrl in this method.");
            }
            this.f667z = BlueServiceFragment.a(this, "getAppPermission");
            this.f667z.b = new C00942(this);
        }
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1210049511);
        super.onResume();
        if (isFinishing()) {
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 840064342, a);
            return;
        }
        this.f657B = true;
        AppSession a2 = AppSession.a(this, false);
        if (a2 == null || a2.f != LoginStatus.STATUS_LOGGED_IN) {
            this.f656A.b(this);
        } else {
            m687p();
        }
        LogUtils.c(985906091, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 848116925);
        super.onPause();
        m690u(this);
        this.f657B = false;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1138576437, a);
    }

    public static Bundle m686b(String str) {
        try {
            URL url = new URL(str);
            Bundle a = URLQueryBuilder.a(url.getQuery());
            a.putAll(URLQueryBuilder.a(url.getRef()));
            return a;
        } catch (MalformedURLException e) {
            BLog.b("PlatformDialogActivity", "Caught malformed URL: " + str);
            return new Bundle();
        }
    }

    protected final String m695l() {
        ComponentName callingActivity = getCallingActivity();
        Object packageName = callingActivity != null ? callingActivity.getPackageName() : null;
        if (getIntent().getExtras() == null) {
            return null;
        }
        if ("com.facebook.katana".equals(packageName) || "com.facebook.wakizashi".equals(packageName)) {
            return getIntent().getExtras().getString("calling_package_key");
        }
        return null;
    }

    public static String m688r(PlatformDialogActivity platformDialogActivity) {
        return StringFormatUtil.a("%s:%s:", new Object[]{f655s.getSimpleName(), platformDialogActivity.getClass().getSimpleName()});
    }

    protected WebViewClient mo26n() {
        return new PlatformDialogWebViewClient(this);
    }

    public static void m689t(PlatformDialogActivity platformDialogActivity) {
        platformDialogActivity.f660r.a(3670023, m688r(platformDialogActivity) + StringUtils.a(platformDialogActivity.f663v));
    }

    public static void m690u(PlatformDialogActivity platformDialogActivity) {
        try {
            if (platformDialogActivity.f662u != null && platformDialogActivity.f662u.isShowing()) {
                platformDialogActivity.f662u.dismiss();
            }
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
    }
}
