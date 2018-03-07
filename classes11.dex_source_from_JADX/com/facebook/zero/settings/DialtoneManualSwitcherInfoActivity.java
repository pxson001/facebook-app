package com.facebook.zero.settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.text.Html;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.title.IndicatorBarController;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.IndicatorVisibilityListener;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.InfoDismissalReason;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.settings.FreeFacebookSettingsActivity.FreeFacebookPreference;
import com.facebook.zero.ui.ZeroIndicatorController;
import com.facebook.zero.ui.ZeroIndicatorController.Listener;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Ljava/lang/CharSequence; */
public class DialtoneManualSwitcherInfoActivity extends FreeFacebookSettingsActivity {
    private Listener f14011G;
    private IndicatorVisibilityListener f14012H;
    private String f14013I;
    @Inject
    ZeroIndicatorController f14014p;
    @Inject
    Lazy<IndicatorBarController> f14015q;
    @Inject
    DialtoneManualSwitcherController f14016r;
    @Inject
    FbZeroFeatureVisibilityHelper f14017s;
    @Inject
    Provider<TriState> f14018t;
    @Inject
    Lazy<FbSharedPreferences> f14019u;
    @Inject
    AnalyticsLogger f14020v;

    /* compiled from: Ljava/lang/CharSequence; */
    class C16372 implements Listener {
        final /* synthetic */ DialtoneManualSwitcherInfoActivity f13995a;

        C16372(DialtoneManualSwitcherInfoActivity dialtoneManualSwitcherInfoActivity) {
            this.f13995a = dialtoneManualSwitcherInfoActivity;
        }

        public final void m15116a() {
            DialtoneManualSwitcherInfoActivity.m15143b(this.f13995a, ZeroFeatureKey.FB4A_INDICATOR);
        }

        public final void m15117b() {
            DialtoneManualSwitcherInfoActivity.m15143b(this.f13995a, ZeroFeatureKey.FB4A_INDICATOR);
        }
    }

    /* compiled from: Ljava/lang/CharSequence; */
    class C16383 implements IndicatorVisibilityListener {
        final /* synthetic */ DialtoneManualSwitcherInfoActivity f13996a;

        C16383(DialtoneManualSwitcherInfoActivity dialtoneManualSwitcherInfoActivity) {
            this.f13996a = dialtoneManualSwitcherInfoActivity;
        }

        public final void m15118a() {
            DialtoneManualSwitcherInfoActivity.m15143b(this.f13996a, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
        }

        public final void m15119b() {
            DialtoneManualSwitcherInfoActivity.m15143b(this.f13996a, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
        }
    }

    private static <T extends Context> void m15140a(Class<T> cls, T t) {
        m15141a((Object) t, (Context) t);
    }

    public static void m15141a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DialtoneManualSwitcherInfoActivity) obj).m15139a(ZeroIndicatorController.b(fbInjector), IdBasedLazy.a(fbInjector, 614), DialtoneManualSwitcherController.a(fbInjector), FbZeroFeatureVisibilityHelper.a(fbInjector), IdBasedProvider.a(fbInjector, 818), IdBasedSingletonScopeProvider.b(fbInjector, 3078), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    private void m15139a(ZeroIndicatorController zeroIndicatorController, Lazy<IndicatorBarController> lazy, DialtoneManualSwitcherController dialtoneManualSwitcherController, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, Provider<TriState> provider, Lazy<FbSharedPreferences> lazy2, AnalyticsLogger analyticsLogger) {
        this.f14014p = zeroIndicatorController;
        this.f14015q = lazy;
        this.f14016r = dialtoneManualSwitcherController;
        this.f14017s = fbZeroFeatureVisibilityHelper;
        this.f14018t = provider;
        this.f14019u = lazy2;
        this.f14020v = analyticsLogger;
    }

    protected final void mo429i() {
        Class cls = DialtoneManualSwitcherInfoActivity.class;
        m15141a((Object) this, (Context) this);
        setContentView(2130903904);
        this.f14013I = ((FbSharedPreferences) this.f14019u.get()).a(ZeroPrefKeys.j, "your carrier");
        final ImageView imageView = (ImageView) findViewById(2131561014);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ DialtoneManualSwitcherInfoActivity f13994b;

            public void onGlobalLayout() {
                if (VERSION.SDK_INT < 16) {
                    imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                float measuredWidth = ((float) (imageView.getMeasuredWidth() - imageView.getDrawable().getBounds().width())) / 2.0f;
                Matrix imageMatrix = imageView.getImageMatrix();
                imageMatrix.postTranslate(measuredWidth, 0.0f);
                imageView.setImageMatrix(imageMatrix);
                imageView.invalidate();
            }
        });
        this.F = imageView;
        m15145k();
    }

    private boolean m15142a(ZeroFeatureKey zeroFeatureKey) {
        ZeroFeatureKey b = this.f14017s.b();
        if (b == null || (b.equals(zeroFeatureKey) && (b.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE) || b.equals(ZeroFeatureKey.FB4A_INDICATOR)))) {
            return true;
        }
        return false;
    }

    public static void m15143b(DialtoneManualSwitcherInfoActivity dialtoneManualSwitcherInfoActivity, ZeroFeatureKey zeroFeatureKey) {
        if (!dialtoneManualSwitcherInfoActivity.m15142a(zeroFeatureKey)) {
            return;
        }
        if (zeroFeatureKey.equals(ZeroFeatureKey.FB4A_INDICATOR)) {
            ((IndicatorBarController) dialtoneManualSwitcherInfoActivity.f14015q.get()).b();
        } else if (zeroFeatureKey.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE)) {
            ((IndicatorBarController) dialtoneManualSwitcherInfoActivity.f14015q.get()).a(dialtoneManualSwitcherInfoActivity.f14016r);
        }
    }

    private void m15145k() {
        if (this.f14018t.get() == TriState.YES) {
            ((IndicatorBarController) this.f14015q.get()).f = (ViewStub) a(2131561010);
            this.f14014p.n = ((IndicatorBarController) this.f14015q.get()).a;
            this.f14016r.a((ViewStub) a(2131561006));
        }
        this.f14011G = new C16372(this);
        this.f14012H = new C16383(this);
    }

    protected final FreeFacebookPreference mo428b(final boolean z) {
        Resources resources = getResources();
        final FreeFacebookPreference freeFacebookPreference = new FreeFacebookPreference(resources.getString(2131232616, new Object[]{"Facebook Flex"}), resources.getString(2131232617, new Object[]{"Facebook Flex"}), Html.fromHtml(resources.getString(2131232963, new Object[]{"Facebook Flex"}) + "<br/><br/>" + resources.getString(2131232964, new Object[]{"Facebook Flex"})), Html.fromHtml(resources.getString(2131232965, new Object[]{this.f14013I, "Facebook Flex"})), z);
        freeFacebookPreference.f14037d = m15130a(freeFacebookPreference);
        freeFacebookPreference.f14038e = m15136j();
        freeFacebookPreference.f14043j = new OnCheckedChangeListener(this) {
            final /* synthetic */ DialtoneManualSwitcherInfoActivity f13999c;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i = 0;
                if (z != freeFacebookPreference.f14039f) {
                    boolean z2;
                    if (this.f13999c.f14004E != null) {
                        this.f13999c.f14004E.setVisibility(0);
                    }
                    FreeFacebookSettingsActivity freeFacebookSettingsActivity = this.f13999c;
                    FreeFacebookPreference freeFacebookPreference = freeFacebookPreference;
                    if (freeFacebookPreference.f14039f) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    freeFacebookSettingsActivity.m15132a(freeFacebookPreference, z2);
                    ImageView imageView = this.f13999c.f14005F;
                    if (z) {
                        i = 8;
                    }
                    imageView.setVisibility(i);
                    if (z) {
                        DialtoneManualSwitcherInfoActivity.m15144b(this.f13999c, "flex_settings_screen_optin");
                    } else {
                        DialtoneManualSwitcherInfoActivity.m15144b(this.f13999c, "flex_settings_screen_optout");
                    }
                }
            }
        };
        return freeFacebookPreference;
    }

    protected final CharSequence mo427a(String str, @Nullable String str2) {
        Resources resources = getResources();
        if (StringUtil.a(str2)) {
            return Html.fromHtml(resources.getString(2131232965, new Object[]{this.f14013I, "Facebook Flex"}) + "<br/><br/>" + str);
        }
        return Html.fromHtml(resources.getString(2131232965, new Object[]{this.f14013I, "Facebook Flex"}) + "<br/><br/>" + str + "<br/><br/><font color=#b2b2b2>" + str2 + " </font>");
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1727524846);
        super.onStop();
        if (this.f14016r != null) {
            this.f14016r.a(InfoDismissalReason.NAVIGATION);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1448615576, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2115221434);
        super.onPause();
        this.f14014p.b();
        this.f14014p.o = null;
        this.f14016r.b();
        this.f14016r.c(this.f14012H);
        if (this.f14017s.b() != null) {
            ((IndicatorBarController) this.f14015q.get()).e();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1881061377, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 74793217);
        super.onResume();
        m15144b(this, "flex_settings_screen_impression");
        ZeroIndicatorController zeroIndicatorController = this.f14014p;
        zeroIndicatorController.o = this.f14011G;
        zeroIndicatorController.p = ZeroFeatureKey.FB4A_INDICATOR;
        this.f14014p.a();
        this.f14016r.a(this.f14012H);
        this.f14016r.a();
        if (this.f14017s.b() != null) {
            ((IndicatorBarController) this.f14015q.get()).c();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 550644804, a);
    }

    public static void m15144b(DialtoneManualSwitcherInfoActivity dialtoneManualSwitcherInfoActivity, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "dialtone";
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.b("carrier_id", ((FbSharedPreferences) dialtoneManualSwitcherInfoActivity.f14019u.get()).a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        dialtoneManualSwitcherInfoActivity.f14020v.a(honeyClientEvent2);
    }
}
