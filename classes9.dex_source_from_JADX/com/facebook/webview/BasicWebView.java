package com.facebook.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.common.carrier.CarrierMonitor;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.config.server.ServerConfig;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.dialtone.handler.DialtoneHttpRequestHandler;
import com.facebook.http.onion.OnionWebView;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.MainProcessModule;
import com.facebook.katana.orca.FbandroidProductionConfig;
import com.facebook.zero.ZeroAwareSecureUrlHelper;
import com.facebook.zero.common.SecureUrlHelper;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: shot */
public class BasicWebView extends OnionWebView {
    public static String f3480i = null;
    public NetAccessLogger f3481a;
    public SecureWebViewHelper f3482b;
    public AbstractFbErrorReporter f3483c;
    protected DialtoneHttpRequestHandler f3484d;
    private ConnectionStatusLogger f3485e;
    private CarrierMonitor f3486f;
    private String f3487g;
    private SecureUrlHelper f3488h;

    /* compiled from: shot */
    class C03191 implements OnLongClickListener {
        final /* synthetic */ BasicWebView f3477a;

        C03191(BasicWebView basicWebView) {
            this.f3477a = basicWebView;
        }

        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* compiled from: shot */
    public class BasicWebChromeClient extends WebChromeClient {
        private static final Class<?> f3478b = BasicWebChromeClient.class;
        protected String f3479a;

        public BasicWebChromeClient() {
            this("console");
        }

        private BasicWebChromeClient(String str) {
            this.f3479a = str;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            new StringBuilder().append(this.f3479a).append(": ").append(consoleMessage.toString());
            return true;
        }
    }

    private static <T extends View> void m3278a(Class<T> cls, T t) {
        m3279a((Object) t, t.getContext());
    }

    private static void m3279a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BasicWebView) obj).m3277a(ConnectionStatusLogger.a(fbInjector), CarrierMonitor.a(fbInjector), MainProcessModule.a((ServerConfig) FbandroidProductionConfig.a(fbInjector)), SecureWebViewHelper.a(fbInjector), NetAccessLogger.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), DialtoneHttpRequestHandler.a(fbInjector), (SecureUrlHelper) ZeroAwareSecureUrlHelper.a(fbInjector));
    }

    public BasicWebView(Context context) {
        this(context, null, 0);
    }

    public BasicWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BasicWebView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo89a(context);
    }

    @Inject
    private void m3277a(ConnectionStatusLogger connectionStatusLogger, CarrierMonitor carrierMonitor, String str, SecureWebViewHelper secureWebViewHelper, NetAccessLogger netAccessLogger, AbstractFbErrorReporter abstractFbErrorReporter, DialtoneHttpRequestHandler dialtoneHttpRequestHandler, SecureUrlHelper secureUrlHelper) {
        this.f3485e = connectionStatusLogger;
        this.f3486f = carrierMonitor;
        this.f3487g = str;
        this.f3482b = secureWebViewHelper;
        this.f3481a = netAccessLogger;
        this.f3483c = abstractFbErrorReporter;
        this.f3484d = dialtoneHttpRequestHandler;
        this.f3488h = secureUrlHelper;
    }

    protected void mo89a(Context context) {
        m3278a(BasicWebView.class, (View) this);
        if (VERSION.SDK_INT >= 14) {
            setHapticFeedbackEnabled(false);
            setLongClickable(true);
            setOnLongClickListener(new C03191(this));
        }
        WebSettings settings = getSettings();
        if (f3480i == null) {
            f3480i = settings.getUserAgentString();
        }
        settings.setUserAgentString(f3480i + " " + this.f3487g);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable e) {
            this.f3483c.a("basicwebview_tts_npe", e);
        }
        setChromeClient(context);
    }

    public void loadUrl(String str) {
        resumeTimers();
        super.loadUrl(this.f3488h.a(str), getAdditionalHttpHeaders());
    }

    public void loadUrl(String str, Map<String, String> map) {
        resumeTimers();
        Map a = Maps.a(map.size() + 1);
        a.putAll(map);
        a.putAll(getAdditionalHttpHeaders());
        super.loadUrl(this.f3488h.a(str), a);
    }

    private Map<String, String> getAdditionalHttpHeaders() {
        Map map;
        Map<String, String> c = Maps.c();
        c.put("X-FB-Connection-Type", this.f3485e.b());
        c.put("x-fb-net-hni", this.f3486f.a());
        c.put("x-fb-sim-hni", this.f3486f.b());
        c.put("x-fb-net-sid", this.f3486f.c());
        DialtoneHttpRequestHandler dialtoneHttpRequestHandler = this.f3484d;
        if (!((Boolean) dialtoneHttpRequestHandler.a.get()).booleanValue() || (((Boolean) dialtoneHttpRequestHandler.c.get()).booleanValue() && !((Boolean) dialtoneHttpRequestHandler.b.get()).booleanValue())) {
            map = null;
        } else {
            map = dialtoneHttpRequestHandler.d;
        }
        Map map2 = map;
        if (map2 != null) {
            c.putAll(map2);
        }
        return c;
    }

    protected String getBaseUserAgent() {
        return f3480i;
    }

    protected void setUserAgentString(String str) {
        getSettings().setUserAgentString(str);
    }

    protected void setChromeClient(Context context) {
        setWebChromeClient(new BasicWebChromeClient());
    }
}
