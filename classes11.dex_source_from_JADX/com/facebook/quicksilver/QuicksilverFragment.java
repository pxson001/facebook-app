package com.facebook.quicksilver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicksilver.QuicksilverEndgameView.QuicksilverEndgameDelegate;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: SONG_DURATION */
public class QuicksilverFragment extends FbFragment {
    public static final String f11367e = QuicksilverFragment.class.getName();
    @Inject
    public QuicksilverJavascriptInterfaceProvider f11368a;
    public QuicksilverEndgameView al;
    public WebView am;
    public long an;
    public boolean ao;
    @Inject
    public AbstractFbErrorReporter f11369b;
    @Inject
    public FunnelLoggerImpl f11370c;
    @Inject
    public AnalyticsLogger f11371d;
    private String f11372f;
    private String f11373g;
    private String f11374h;
    public QuicksilverLoadingView f11375i;

    /* compiled from: SONG_DURATION */
    class C13741 implements QuicksilverEndgameDelegate {
        final /* synthetic */ QuicksilverFragment f11357a;

        C13741(QuicksilverFragment quicksilverFragment) {
            this.f11357a = quicksilverFragment;
        }

        public final void mo304a() {
            this.f11357a.al.setVisibility(4);
            this.f11357a.al.setScoreVisibility(false);
            QuicksilverFragment.m11701b(this.f11357a, "restart");
        }
    }

    /* compiled from: SONG_DURATION */
    public class C13802 {
        final /* synthetic */ QuicksilverFragment f11366a;

        /* compiled from: SONG_DURATION */
        class C13751 implements Runnable {
            final /* synthetic */ C13802 f11358a;

            C13751(C13802 c13802) {
                this.f11358a = c13802;
            }

            public void run() {
                this.f11358a.f11366a.al.setVisibility(0);
            }
        }

        /* compiled from: SONG_DURATION */
        class C13795 implements Runnable {
            final /* synthetic */ C13802 f11365a;

            C13795(C13802 c13802) {
                this.f11365a = c13802;
            }

            public void run() {
                this.f11365a.f11366a.f11370c.b(FunnelRegistry.R, "game_ready");
                this.f11365a.f11366a.m11695a("quicksilver_load_time", SystemClock.elapsedRealtime() - this.f11365a.f11366a.an);
                this.f11365a.f11366a.an = SystemClock.elapsedRealtime();
                this.f11365a.f11366a.ao = true;
                this.f11365a.f11366a.f11375i.setVisibility(8);
                this.f11365a.f11366a.am.setVisibility(0);
            }
        }

        C13802(QuicksilverFragment quicksilverFragment) {
            this.f11366a = quicksilverFragment;
        }

        public final void m11682a() {
            this.f11366a.o().runOnUiThread(new C13751(this));
        }

        public final void m11683a(final JSONObject jSONObject) {
            this.f11366a.o().runOnUiThread(new Runnable(this) {
                final /* synthetic */ C13802 f11360b;

                public void run() {
                    try {
                        this.f11360b.f11366a.al.setScore(QuicksilverFragment.m11698b(jSONObject));
                    } catch (Throwable e) {
                        this.f11360b.f11366a.al.setScoreVisibility(false);
                        this.f11360b.f11366a.f11369b.a(QuicksilverFragment.f11367e, "Invalid JSON content received by onScore: " + jSONObject, e);
                    }
                }
            });
        }

        public final void m11685b(final JSONObject jSONObject) {
            this.f11366a.o().runOnUiThread(new Runnable(this) {
                final /* synthetic */ C13802 f11362b;

                public void run() {
                    this.f11362b.f11366a.f11370c.b(FunnelRegistry.R, "loading_started");
                    this.f11362b.f11366a.m11695a("quicksilver_start_time", SystemClock.elapsedRealtime() - this.f11362b.f11366a.an);
                    this.f11362b.f11366a.an = SystemClock.elapsedRealtime();
                    try {
                        this.f11362b.f11366a.f11375i.m11711a(QuicksilverFragment.m11698b(jSONObject));
                    } catch (Throwable e) {
                        this.f11362b.f11366a.f11369b.a(QuicksilverFragment.f11367e, "Invalid JSON content received by onBeginLoad: " + jSONObject, e);
                    }
                }
            });
        }

        public final void m11686c(final JSONObject jSONObject) {
            this.f11366a.o().runOnUiThread(new Runnable(this) {
                final /* synthetic */ C13802 f11364b;

                public void run() {
                    try {
                        this.f11364b.f11366a.f11375i.m11713b(QuicksilverFragment.m11698b(jSONObject));
                    } catch (Throwable e) {
                        this.f11364b.f11366a.f11369b.a(QuicksilverFragment.f11367e, "Invalid JSON content received by onProgressLoad: " + jSONObject, e);
                    }
                }
            });
        }

        public final void m11684b() {
            this.f11366a.o().runOnUiThread(new C13795(this));
        }
    }

    private static <T extends InjectableComponentWithContext> void m11692a(Class<T> cls, T t) {
        m11693a((Object) t, t.getContext());
    }

    private static void m11693a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuicksilverFragment quicksilverFragment = (QuicksilverFragment) obj;
        QuicksilverJavascriptInterfaceProvider quicksilverJavascriptInterfaceProvider = (QuicksilverJavascriptInterfaceProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuicksilverJavascriptInterfaceProvider.class);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        FunnelLoggerImpl a = FunnelLoggerImpl.a(fbInjector);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        quicksilverFragment.f11368a = quicksilverJavascriptInterfaceProvider;
        quicksilverFragment.f11369b = abstractFbErrorReporter;
        quicksilverFragment.f11370c = a;
        quicksilverFragment.f11371d = a2;
    }

    public final void m11709c(Bundle bundle) {
        super.c(bundle);
        m11692a(QuicksilverFragment.class, (InjectableComponentWithContext) this);
    }

    public final View m11707a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1427300443);
        View inflate = layoutInflater.inflate(2130906563, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2140405881, a);
        return inflate;
    }

    public final void m11708a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ao = false;
        this.f11370c.a(FunnelRegistry.R);
        this.f11370c.a(FunnelRegistry.R, this.f11372f);
        this.an = SystemClock.elapsedRealtime();
        m11704e();
        aq();
        ar();
        m11694a(this.f11373g);
    }

    public final void m11706H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1622620112);
        super.H();
        this.f11370c.b(FunnelRegistry.R);
        if (this.ao) {
            m11695a("quicksilver_play_time", SystemClock.elapsedRealtime() - this.an);
        }
        this.am.onPause();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1858243395, a);
    }

    private void m11695a(String str, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "quicksilver";
        this.f11371d.a(honeyClientEvent.b("app_id", this.f11372f).a("elapsed_time", j / 1000));
    }

    public final void m11705G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 230190855);
        super.G();
        this.am.onResume();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -293541351, a);
    }

    private void m11704e() {
        Intent intent = o().getIntent();
        this.f11372f = intent.getStringExtra("quicksilver_extra_app_id");
        this.f11373g = intent.getStringExtra("quicksilver_extra_game_url");
        this.f11374h = intent.getStringExtra("quicksilver_extra_splash_url");
    }

    private void aq() {
        this.am = (WebView) e(2131566523);
        WebSettings settings = this.am.getSettings();
        this.am.setWebViewClient(new WebViewClient());
        this.am.setWebChromeClient(new WebChromeClient());
        settings.setJavaScriptEnabled(true);
    }

    private void ar() {
        this.f11375i = (QuicksilverLoadingView) e(2131559308);
        this.f11375i.m11712a(this.f11374h);
        this.al = (QuicksilverEndgameView) e(2131566524);
        this.al.f11356d = new C13741(this);
        this.am.addJavascriptInterface(new QuicksilverJavascriptInterface(new C13802(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this.f11368a)), "QuicksilverAndroid");
    }

    public static int m11698b(JSONObject jSONObject) {
        return jSONObject.getInt("content");
    }

    private void m11694a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("Referer", str);
        this.am.loadUrl(str, hashMap);
    }

    public static void m11701b(QuicksilverFragment quicksilverFragment, String str) {
        quicksilverFragment.m11696a(str, "");
    }

    private void m11696a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put("content", str2);
            jSONObject.put("source", "android");
        } catch (Throwable e) {
            BLog.c(f11367e, e, "Unexpected exception while constructing JSONObject to be dispatched to Javascript.", new Object[0]);
        }
        this.am.loadUrl(StringFormatUtil.formatStrLocaleSafe("javascript:e = new Event('message');e.data = %s;window.dispatchEvent(e);", jSONObject));
    }
}
