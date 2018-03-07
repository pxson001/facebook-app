package com.facebook.pages.fb4a.admin_activity.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.BoostedComponentModule;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.Event;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.datastore.AuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.graphql.enums.GraphQLBoostedActionStatus;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLInterfaces.FetchPageActivityQuery.ActivityAdminInfo;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityAdminInfoModel;
import com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment.UpdateViewListener;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsSummarySwitcher.InsightsSwitcherState;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsSummarySwitcher.InsightsSwitcherStateListener;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsUniController.InsightsUniCard;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.webview.BasicWebView;
import com.facebook.widget.CustomFrameLayout;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: quicksilver_extra_splash_url */
public class PageActivityInsightsWithUniButtonCardView extends CustomFrameLayout implements InsightsUniCard {
    LayoutParams f2811a = new LayoutParams(-1, 0);
    private final InsightsSwitcherStateListener f2812b = new C03721(this);
    private final WebChromeClient f2813c = new C03732(this);
    private PageActivityInsightsSummarySwitcher f2814d;
    private PageActivityInsightsSwitcherIndicator f2815e;
    private BasicWebView f2816f;
    private BasicWebView f2817g;
    private TextView f2818h;
    public PagesAnalytics f2819i;
    public AdInterfacesHelper f2820j;
    private SecureWebViewHelper f2821k;
    public Lazy<FbErrorReporter> f2822l;
    private LoggedInUserSessionManager f2823m;
    private ObjectMapper f2824n;
    private FbSharedPreferences f2825o;
    private AdInterfacesExternalLogger f2826p;
    private long f2827q;
    private InsightsGraphWebViewData f2828r = new InsightsGraphWebViewData(this);
    private InsightsGraphWebViewData f2829s = new InsightsGraphWebViewData(this);
    private boolean f2830t;
    private boolean f2831u = true;

    /* compiled from: quicksilver_extra_splash_url */
    class C03721 implements InsightsSwitcherStateListener {
        final /* synthetic */ PageActivityInsightsWithUniButtonCardView f2792a;

        C03721(PageActivityInsightsWithUniButtonCardView pageActivityInsightsWithUniButtonCardView) {
            this.f2792a = pageActivityInsightsWithUniButtonCardView;
        }

        public final void mo73a(InsightsSwitcherState insightsSwitcherState) {
            this.f2792a.m3786a(insightsSwitcherState);
        }
    }

    /* compiled from: quicksilver_extra_splash_url */
    class C03732 extends WebChromeClient {
        final /* synthetic */ PageActivityInsightsWithUniButtonCardView f2793a;

        C03732(PageActivityInsightsWithUniButtonCardView pageActivityInsightsWithUniButtonCardView) {
            this.f2793a = pageActivityInsightsWithUniButtonCardView;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            jsPromptResult.cancel();
            return true;
        }
    }

    /* compiled from: quicksilver_extra_splash_url */
    class C03754 implements OnTouchListener {
        final /* synthetic */ PageActivityInsightsWithUniButtonCardView f2797a;

        C03754(PageActivityInsightsWithUniButtonCardView pageActivityInsightsWithUniButtonCardView) {
            this.f2797a = pageActivityInsightsWithUniButtonCardView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: quicksilver_extra_splash_url */
    class InsightsGraphJSBridge {
        final /* synthetic */ PageActivityInsightsWithUniButtonCardView f2804a;
        public InsightsGraphWebViewData f2805b;
        private Handler f2806c = new Handler(Looper.getMainLooper());

        public InsightsGraphJSBridge(PageActivityInsightsWithUniButtonCardView pageActivityInsightsWithUniButtonCardView, InsightsGraphWebViewData insightsGraphWebViewData) {
            this.f2804a = pageActivityInsightsWithUniButtonCardView;
            this.f2805b = insightsGraphWebViewData;
        }

        @JavascriptInterface
        @DoNotStrip
        public void onHeightChanged(final int i) {
            HandlerDetour.a(this.f2806c, new Runnable(this) {
                final /* synthetic */ InsightsGraphJSBridge f2803b;

                public void run() {
                    this.f2803b.f2805b.f2807a = true;
                    this.f2803b.f2805b.f2808b = i;
                    this.f2803b.f2805b.f2809c = new LayoutParams(-1, this.f2803b.f2804a.m3782a(i));
                    PageActivityInsightsWithUniButtonCardView.m3800f(this.f2803b.f2804a);
                }
            }, -1950842519);
        }
    }

    /* compiled from: quicksilver_extra_splash_url */
    class InsightsGraphWebViewData {
        boolean f2807a;
        int f2808b;
        LayoutParams f2809c;
        final /* synthetic */ PageActivityInsightsWithUniButtonCardView f2810d;

        public InsightsGraphWebViewData(PageActivityInsightsWithUniButtonCardView pageActivityInsightsWithUniButtonCardView) {
            this.f2810d = pageActivityInsightsWithUniButtonCardView;
        }
    }

    private static <T extends View> void m3790a(Class<T> cls, T t) {
        m3791a((Object) t, t.getContext());
    }

    private static void m3791a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageActivityInsightsWithUniButtonCardView) obj).m3785a(PagesAnalytics.a(fbInjector), SecureWebViewHelper.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), LoggedInUserSessionManager.a(fbInjector), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), AdInterfacesHelper.a(fbInjector), AdInterfacesExternalLogger.a(fbInjector));
    }

    public PageActivityInsightsWithUniButtonCardView(Context context) {
        super(context);
        m3784a();
    }

    public PageActivityInsightsWithUniButtonCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3784a();
    }

    public PageActivityInsightsWithUniButtonCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3784a();
    }

    private void m3784a() {
        int i = 0;
        setContentView(2130905955);
        m3790a(PageActivityInsightsWithUniButtonCardView.class, (View) this);
        this.f2814d = (PageActivityInsightsSummarySwitcher) c(2131565324);
        this.f2815e = (PageActivityInsightsSwitcherIndicator) c(2131565325);
        this.f2816f = (BasicWebView) c(2131565326);
        this.f2817g = (BasicWebView) c(2131565327);
        this.f2818h = (TextView) c(2131565316);
        String str = this.f2823m.a().mSessionCookiesString;
        if (str != null) {
            ImmutableList a = SessionCookie.a(this.f2824n, str);
            if (a != null) {
                String a2 = StringFormatUtil.a(m3799e() ? "https://%s/" : "http://%s/", new Object[]{InternalHttpPrefKeys.r});
                CookieManager instance = CookieManager.getInstance();
                int size = a.size();
                while (i < size) {
                    instance.setCookie(a2, ((SessionCookie) a.get(i)).toString());
                    i++;
                }
                CookieSyncManager.getInstance().sync();
            }
        }
        m3789a(this.f2816f, this.f2828r);
        m3789a(this.f2817g, this.f2829s);
    }

    @Inject
    private void m3785a(PagesAnalytics pagesAnalytics, SecureWebViewHelper secureWebViewHelper, Lazy<FbErrorReporter> lazy, AuthDataStore authDataStore, ObjectMapper objectMapper, FbSharedPreferences fbSharedPreferences, AdInterfacesHelper adInterfacesHelper, AdInterfacesExternalLogger adInterfacesExternalLogger) {
        this.f2819i = pagesAnalytics;
        this.f2821k = secureWebViewHelper;
        this.f2822l = lazy;
        this.f2823m = authDataStore;
        this.f2824n = objectMapper;
        this.f2825o = fbSharedPreferences;
        this.f2820j = adInterfacesHelper;
        this.f2826p = adInterfacesExternalLogger;
    }

    public final void mo74a(long j, @Nullable ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional) {
        if (m3792a((ActivityAdminInfoModel) activityAdminInfo)) {
            GraphQLBoostedActionStatus a = activityAdminInfo.m2746c() != null ? activityAdminInfo.m2746c().m2714a() : null;
            Event event = (a == GraphQLBoostedActionStatus.ERROR || a == GraphQLBoostedActionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? Event.EVENT_RENDER_FAIL_ENTRY_POINT : Event.EVENT_RENDER_CREATE_ENTRY_POINT;
            this.f2826p.a(BoostedComponentModule.PROMOTE_PAGE_MOBILE_MODULE, event, String.valueOf(j), "pages_manager_activity_tab");
            this.f2827q = j;
            this.f2814d.m3769a(activityAdminInfo.m2748g(), j);
            m3794b();
            m3797c(j, activityAdminInfo, optional);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f2828r.f2807a = false;
        this.f2829s.f2807a = false;
        this.f2830t = false;
        this.f2831u = false;
        m3794b();
    }

    private boolean m3792a(ActivityAdminInfoModel activityAdminInfoModel) {
        if (activityAdminInfoModel != null && activityAdminInfoModel.m2748g() != null) {
            return true;
        }
        setVisibility(8);
        return false;
    }

    private void m3794b() {
        this.f2821k.a(this.f2816f, StringFormatUtil.a("https://m.facebook.com/pages/insights/chart/?page_id=%s&chart=weeklylike", new Object[]{String.valueOf(this.f2827q)}));
        this.f2821k.a(this.f2817g, StringFormatUtil.a("https://m.facebook.com/pages/insights/chart/?page_id=%s&chart=weeklypostreach", new Object[]{String.valueOf(this.f2827q)}));
    }

    public final void m3802b(long j, ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional) {
        if (m3792a((ActivityAdminInfoModel) activityAdminInfo)) {
            this.f2814d.m3769a(activityAdminInfo.m2748g(), j);
            m3797c(j, activityAdminInfo, optional);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "BadMethodUse-java.lang.String.length"})
    private void m3789a(BasicWebView basicWebView, final InsightsGraphWebViewData insightsGraphWebViewData) {
        basicWebView.getSettings().setJavaScriptEnabled(true);
        basicWebView.setWebChromeClient(this.f2813c);
        basicWebView.setHorizontalScrollBarEnabled(false);
        basicWebView.setVerticalScrollBarEnabled(false);
        basicWebView.addJavascriptInterface(new InsightsGraphJSBridge(this, insightsGraphWebViewData), "JSBridge");
        basicWebView.setWebViewClient(new WebViewClient(this) {
            Exception f2794a = null;
            final /* synthetic */ PageActivityInsightsWithUniButtonCardView f2796c;

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str == null || !str.startsWith("fbpageinsightschart://")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                try {
                    int parseInt = Integer.parseInt(str.substring(22, str.length()));
                    insightsGraphWebViewData.f2807a = true;
                    insightsGraphWebViewData.f2808b = parseInt;
                    insightsGraphWebViewData.f2809c = new LayoutParams(-1, this.f2796c.m3782a(parseInt));
                    PageActivityInsightsWithUniButtonCardView.m3800f(this.f2796c);
                    ((AbstractFbErrorReporter) this.f2796c.f2822l.get()).a(this.f2796c.getClass().getSimpleName(), "JavascriptInterface wasn't added successfully, additional exception: " + (this.f2794a == null ? "none" : this.f2794a.toString()));
                    return true;
                } catch (Exception e) {
                    this.f2794a = e;
                    ((AbstractFbErrorReporter) this.f2796c.f2822l.get()).a(this.f2796c.getClass().getSimpleName(), "JavascriptInterface wasn't added successfully, additional exception: " + (this.f2794a == null ? "none" : this.f2794a.toString()));
                    return true;
                } catch (Throwable th) {
                    ((AbstractFbErrorReporter) this.f2796c.f2822l.get()).a(this.f2796c.getClass().getSimpleName(), "JavascriptInterface wasn't added successfully, additional exception: " + (this.f2794a == null ? "none" : this.f2794a.toString()));
                    return true;
                }
            }
        });
        basicWebView.setOnTouchListener(new C03754(this));
    }

    private void m3797c(long j, ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional) {
        if (activityAdminInfo.mT_()) {
            this.f2818h.setVisibility(0);
            this.f2818h.setText(activityAdminInfo.m2747d());
            final long j2 = j;
            final ActivityAdminInfoModel activityAdminInfoModel = activityAdminInfo;
            final Optional<? extends WebViewLaunchedListener> optional2 = optional;
            this.f2818h.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PageActivityInsightsWithUniButtonCardView f2801d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -839123449);
                    this.f2801d.f2819i.a(j2, activityAdminInfoModel.m2747d(), "pages_manager_activity_tab");
                    if (!this.f2801d.f2820j.b() && optional2.isPresent()) {
                        ((UpdateViewListener) optional2.get()).m3741a();
                    }
                    this.f2801d.f2820j.a(view.getContext(), j2);
                    Logger.a(2, EntryType.UI_INPUT_END, -593037711, a);
                }
            });
            return;
        }
        this.f2818h.setVisibility(8);
    }

    private boolean m3799e() {
        return this.f2825o.a(InternalHttpPrefKeys.j, true);
    }

    public static void m3800f(PageActivityInsightsWithUniButtonCardView pageActivityInsightsWithUniButtonCardView) {
        if (pageActivityInsightsWithUniButtonCardView.f2828r.f2807a && pageActivityInsightsWithUniButtonCardView.f2829s.f2807a && !pageActivityInsightsWithUniButtonCardView.f2830t) {
            pageActivityInsightsWithUniButtonCardView.f2830t = true;
            pageActivityInsightsWithUniButtonCardView.f2814d.f2772c = pageActivityInsightsWithUniButtonCardView.f2812b;
            pageActivityInsightsWithUniButtonCardView.f2815e.setVisibility(0);
            if (pageActivityInsightsWithUniButtonCardView.f2831u) {
                pageActivityInsightsWithUniButtonCardView.f2814d.setSwitcherState(InsightsSwitcherState.WEEKLY_LIKE);
            } else {
                pageActivityInsightsWithUniButtonCardView.m3795b(pageActivityInsightsWithUniButtonCardView.f2814d.f2773d);
            }
        }
    }

    private void m3786a(InsightsSwitcherState insightsSwitcherState) {
        this.f2815e.setSwitcherState(insightsSwitcherState);
        m3795b(insightsSwitcherState);
    }

    private void m3795b(InsightsSwitcherState insightsSwitcherState) {
        if (insightsSwitcherState == InsightsSwitcherState.WEEKLY_LIKE) {
            this.f2817g.setLayoutParams(this.f2811a);
            this.f2816f.setLayoutParams(this.f2828r.f2809c);
            return;
        }
        this.f2816f.setLayoutParams(this.f2811a);
        this.f2817g.setLayoutParams(this.f2829s.f2809c);
    }

    @SuppressLint({"DeprecatedMethod"})
    private int m3782a(int i) {
        float f = getContext().getResources().getDisplayMetrics().density * 180.0f;
        float scale = ((float) i) * this.f2816f.getScale();
        if (((double) scale) <= ((double) f) * 0.75d || ((double) scale) >= ((double) f) * 1.25d) {
            return (int) (((double) f) + 0.5d);
        }
        return (int) (((double) scale) + 0.5d);
    }
}
