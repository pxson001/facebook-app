package com.facebook.dialtone.switcher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.ViewStub;
import android.widget.CompoundButton;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneUiFeaturesAccessor;
import com.facebook.dialtone.gk.IsDialtoneEligibleGK;
import com.facebook.dialtone.switcher.DialtoneManualSwitcher.OnClickListener;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.datacheck.DataState;
import com.facebook.zero.datacheck.ZeroDataCheckerState;
import com.facebook.zero.datacheck.ZeroDataCheckerState.Listener;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.service.ZeroUpdateStatusManager;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: small_photo */
public class DialtoneManualSwitcherController {
    private static final Class<?> f4631a = DialtoneManualSwitcherController.class;
    private static DialtoneManualSwitcherController f4632w;
    private static final Object f4633x = new Object();
    public final Lazy<FbZeroFeatureVisibilityHelper> f4634b;
    public final Lazy<FbSharedPreferences> f4635c;
    public final Lazy<SecureContextHelper> f4636d;
    public final BaseFbBroadcastManager f4637e;
    private final Lazy<AnalyticsLogger> f4638f;
    private final Provider<Boolean> f4639g;
    public final Lazy<DialtoneController> f4640h;
    private final DialtoneUiFeaturesAccessor f4641i;
    @IsDialtoneEligibleGK
    private final Provider<TriState> f4642j;
    public final ZeroDialogController f4643k;
    private final XConfigReader f4644l;
    private final ZeroDataCheckerState f4645m;
    private final Lazy<ZeroUpdateStatusManager> f4646n;
    private final SelfRegistrableReceiverImpl f4647o;
    @Nullable
    private ViewStub f4648p;
    @GuardedBy("this")
    @Nullable
    private DialtoneManualSwitcher f4649q;
    private OnClickListener f4650r;
    private final Set<IndicatorVisibilityListener> f4651s = new HashSet();
    private final Set<IndicatorVisibilityListener> f4652t = new HashSet();
    @Nullable
    private Listener f4653u;
    public final GatekeeperStoreImpl f4654v;

    /* compiled from: small_photo */
    class C02341 implements OnClickListener {
        final /* synthetic */ DialtoneManualSwitcherController f4680a;

        C02341(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
            this.f4680a = dialtoneManualSwitcherController;
        }

        public final void mo1237a(CompoundButton compoundButton, Context context) {
            this.f4680a.m8384a("dialtone_switcher_button_click");
            if (compoundButton.isChecked()) {
                compoundButton.setChecked(false);
                String string = context.getResources().getString(2131232601);
                string = context.getResources().getString(2131232548, new Object[]{((FbSharedPreferences) this.f4680a.f4635c.get()).mo278a(ZeroPrefKeys.f2635j, string)});
                if (((FbZeroFeatureVisibilityHelper) this.f4680a.f4634b.get()).m7923a()) {
                    this.f4680a.m8384a("dialtone_switcher_enter_full_fb_upsell_dialog_impression");
                    this.f4680a.f4643k.m8433a(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE, context.getString(2131232547), string, new 1(this, compoundButton));
                    this.f4680a.f4643k.m8435a(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE, ((FragmentActivity) context).kO_());
                    return;
                }
                this.f4680a.m8384a("dialtone_switcher_enter_full_fb_dialog_impression");
                new FbAlertDialogBuilder(context).a(2131232547).b(string).a(2131232549, new 3(this, compoundButton)).b(2131230727, new 2(this)).b();
                return;
            }
            DialtoneManualSwitcher d = this.f4680a.m8419d();
            d.m8498h();
            d.m8488a(10000);
            ((DialtoneController) this.f4680a.f4640h.get()).mo1223c();
            ((DialtoneController) this.f4680a.f4640h.get()).mo1208a(context);
            this.f4680a.f4637e.m2955a("com.facebook.zero.ACTION_ZERO_INTERSTITIAL_REFRESH");
            this.f4680a.m8385a("dialtone_explicitly_entered", "dialtone_manual_switcher");
            DialtoneManualSwitcherController.m8404p(this.f4680a);
            this.f4680a.m8422f();
        }

        public final void mo1236a(Context context) {
            if (this.f4680a.f4654v.m2189a(835, false)) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(FBLinks.bS));
                ((SecureContextHelper) this.f4680a.f4636d.get()).mo662a(intent, context);
                this.f4680a.m8384a("dialtone_switcher_info_button_click");
                return;
            }
            String str = "/zero/toggle/settings/";
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, str);
            Intent intent2 = new Intent();
            intent2.setData(Uri.parse(formatStrLocaleSafe));
            intent2.putExtra("target_fragment", FragmentConstants$ContentFragmentType.FACEWEB_FRAGMENT.ordinal());
            intent2.putExtra("mobile_page", str);
            ((SecureContextHelper) this.f4680a.f4636d.get()).mo662a(intent2, context);
            this.f4680a.m8384a("dialtone_switcher_info_button_click");
        }

        public final void mo1235a() {
            this.f4680a.m8414a(InfoDismissalReason.EXPLICIT);
        }
    }

    /* compiled from: small_photo */
    class C02354 implements ActionReceiver {
        final /* synthetic */ DialtoneManualSwitcherController f4681a;

        C02354(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
            this.f4681a = dialtoneManualSwitcherController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1693000258);
            DialtoneManualSwitcherController.m8400l(this.f4681a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -684519364, a);
        }
    }

    /* compiled from: small_photo */
    class C02363 implements ActionReceiver {
        final /* synthetic */ DialtoneManualSwitcherController f4682a;

        C02363(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
            this.f4682a = dialtoneManualSwitcherController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -854960934);
            DialtoneManualSwitcherController.m8401m(this.f4682a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -255406226, a);
        }
    }

    /* compiled from: small_photo */
    class C02372 implements ActionReceiver {
        final /* synthetic */ DialtoneManualSwitcherController f4683a;

        C02372(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
            this.f4683a = dialtoneManualSwitcherController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 882351461);
            this.f4683a.m8414a(InfoDismissalReason.NAVIGATION);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 512151132, a);
        }
    }

    /* compiled from: small_photo */
    class C02385 implements Listener {
        final /* synthetic */ DialtoneManualSwitcherController f4722a;

        C02385(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
            this.f4722a = dialtoneManualSwitcherController;
        }

        public final void mo1249a(DataState dataState, DataState dataState2) {
            this.f4722a.m8388b(dataState2);
        }
    }

    /* compiled from: small_photo */
    public enum InfoDismissalReason {
        NAVIGATION("navigation"),
        EXPLICIT("explicit"),
        OTHER("other");
        
        String mReason;

        private InfoDismissalReason(String str) {
            this.mReason = str;
        }

        public final String toString() {
            return this.mReason;
        }
    }

    /* compiled from: small_photo */
    public interface IndicatorVisibilityListener {
        void mo1260a();

        void mo1261b();
    }

    private static DialtoneManualSwitcherController m8386b(InjectorLike injectorLike) {
        return new DialtoneManualSwitcherController(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3754), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), LocalFbBroadcastManager.m2946a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1086), IdBasedProvider.m1811a(injectorLike, 4034), DialtoneUiFeaturesAccessor.m4677a(injectorLike), IdBasedProvider.m1811a(injectorLike, 664), FbZeroDialogController.m8472b(injectorLike), XConfigReader.m2681a(injectorLike), ZeroDataCheckerState.m8439a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11847), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    public static DialtoneManualSwitcherController m8378a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DialtoneManualSwitcherController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f4633x) {
                DialtoneManualSwitcherController dialtoneManualSwitcherController;
                if (a2 != null) {
                    dialtoneManualSwitcherController = (DialtoneManualSwitcherController) a2.mo818a(f4633x);
                } else {
                    dialtoneManualSwitcherController = f4632w;
                }
                if (dialtoneManualSwitcherController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m8386b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f4633x, b3);
                        } else {
                            f4632w = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = dialtoneManualSwitcherController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DialtoneManualSwitcherController(Lazy<FbZeroFeatureVisibilityHelper> lazy, Lazy<FbSharedPreferences> lazy2, Lazy<SecureContextHelper> lazy3, FbBroadcastManager fbBroadcastManager, Lazy<AnalyticsLogger> lazy4, Lazy<DialtoneController> lazy5, Provider<Boolean> provider, DialtoneUiFeaturesAccessor dialtoneUiFeaturesAccessor, Provider<TriState> provider2, ZeroDialogController zeroDialogController, XConfigReader xConfigReader, ZeroDataCheckerState zeroDataCheckerState, Lazy<ZeroUpdateStatusManager> lazy6, GatekeeperStore gatekeeperStore) {
        this.f4634b = lazy;
        this.f4635c = lazy2;
        this.f4636d = lazy3;
        this.f4637e = fbBroadcastManager;
        this.f4638f = lazy4;
        this.f4639g = provider;
        this.f4640h = lazy5;
        this.f4641i = dialtoneUiFeaturesAccessor;
        this.f4642j = provider2;
        this.f4643k = zeroDialogController;
        this.f4644l = xConfigReader;
        this.f4645m = zeroDataCheckerState;
        this.f4646n = lazy6;
        this.f4654v = gatekeeperStore;
        this.f4650r = new C02341(this);
        this.f4647o = this.f4637e.m2951a().mo506a("com.facebook.zero.ZERO_RATING_STATE_CHANGED", new C02354(this)).mo506a("com.facebook.feed.util.NEWS_FEED_NEW_STORIES", new C02363(this)).mo506a("com.facebook.zero.ZERO_NEW_ACTIVITY", new C02372(this)).mo503a();
    }

    private void m8397j() {
        if (this.f4653u == null) {
            this.f4653u = new C02385(this);
        }
    }

    private void m8383a(DataState dataState) {
        m8388b(dataState);
    }

    private void m8388b(DataState dataState) {
        int a = this.f4644l.m2683a(DialtoneManualSwitcherXConfig.f4694d, 10);
        if (!((DialtoneController) this.f4640h.get()).mo1221b() && ((TriState) this.f4642j.get()).asBoolean(false) && dataState == DataState.FREE_TIER_ONLY && ((DialtoneController) this.f4640h.get()).mo1227f() != null && this.f4649q != null && this.f4641i.m4682a(ZeroFeatureKey.DIALTONE_SWITCHER_ZERO_BALANCE_REMINDER) && ((FbSharedPreferences) this.f4635c.get()).mo276a(DialtonePrefKeys.f2472B, 0) <= a) {
            this.f4649q.m8490a(this.f4635c, this.f4638f, this.f4646n);
        }
    }

    private synchronized void m8399k() {
        long a = 86400000 * ((long) this.f4644l.m2683a(DialtoneManualSwitcherXConfig.f4695e, 3));
        if (!(((DialtoneController) this.f4640h.get()).mo1221b() || ((DialtoneController) this.f4640h.get()).mo1227f() == null || this.f4649q == null || !this.f4641i.m4682a(ZeroFeatureKey.DIALTONE_OPTOUT_REMINDER) || ((FbSharedPreferences) this.f4635c.get()).mo286a(DialtonePrefKeys.f2475E, false))) {
            Long valueOf = Long.valueOf(((FbSharedPreferences) this.f4635c.get()).mo277a(DialtonePrefKeys.f2476F, 0));
            if (valueOf.longValue() != 0 && SystemClock.m1506b().mo211a() - valueOf.longValue() >= a) {
                this.f4649q.m8489a(this.f4635c, this.f4638f);
                ((FbSharedPreferences) this.f4635c.get()).edit().putBoolean(DialtonePrefKeys.f2475E, true).commit();
            }
        }
    }

    public final void m8411a() {
        this.f4647o.m3296b();
        if (this.f4641i.m4682a(ZeroFeatureKey.DIALTONE_SWITCHER_ZERO_BALANCE_REMINDER)) {
            m8397j();
            this.f4645m.m8461a(this.f4653u);
        }
        m8400l(this);
    }

    public final void m8415b() {
        this.f4647o.m3297c();
        ZeroDataCheckerState zeroDataCheckerState = this.f4645m;
        Listener listener = this.f4653u;
        if (listener != null) {
            zeroDataCheckerState.f4671o.remove(listener);
        }
    }

    public final synchronized void m8412a(ViewStub viewStub) {
        this.f4648p = viewStub;
    }

    public final synchronized DialtoneManualSwitcher m8417c() {
        if (this.f4649q == null) {
            if (this.f4648p == null) {
                throw new IllegalStateException("mDialtoneManualSwitcherStub should not be null");
            }
            this.f4649q = (DialtoneManualSwitcher) this.f4648p.inflate();
            this.f4649q.setInfoBannerHeight(2131428113);
            this.f4649q.setOnClickListener(this.f4650r);
            this.f4649q.setCarrierName(((FbSharedPreferences) this.f4635c.get()).mo278a(ZeroPrefKeys.f2635j, "your carrier"));
            this.f4648p = null;
        }
        return this.f4649q;
    }

    public final synchronized DialtoneManualSwitcher m8419d() {
        return this.f4649q;
    }

    public final synchronized void m8413a(@Nullable IndicatorVisibilityListener indicatorVisibilityListener) {
        this.f4651s.add(indicatorVisibilityListener);
    }

    public final synchronized void m8416b(@Nullable IndicatorVisibilityListener indicatorVisibilityListener) {
        this.f4652t.add(indicatorVisibilityListener);
    }

    public final synchronized void m8418c(@Nullable IndicatorVisibilityListener indicatorVisibilityListener) {
        this.f4651s.remove(indicatorVisibilityListener);
    }

    public final synchronized void m8420d(@Nullable IndicatorVisibilityListener indicatorVisibilityListener) {
        this.f4652t.remove(indicatorVisibilityListener);
    }

    final boolean m8421e() {
        return ((TriState) this.f4642j.get()).asBoolean(false) && this.f4641i.m4682a(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
    }

    public static void m8400l(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
        if (((Boolean) dialtoneManualSwitcherController.f4639g.get()).booleanValue()) {
            dialtoneManualSwitcherController.m8402n();
        } else {
            dialtoneManualSwitcherController.m8403o();
        }
    }

    public final void m8422f() {
        DialtoneManualSwitcher c = m8417c();
        Context f;
        Intent intent;
        if (((DialtoneController) this.f4640h.get()).mo1221b()) {
            c.m8495e();
            f = ((DialtoneController) this.f4640h.get()).mo1227f();
            if (VERSION.SDK_INT >= 21 && f != null) {
                f.getWindow().setStatusBarColor(f.getResources().getColor(2131362577));
            }
            if (!(!((FbZeroFeatureVisibilityHelper) this.f4634b.get()).m7924a(ZeroFeatureKey.DIALTONE_SWITCHER_NUX) || f == null || ((FbSharedPreferences) this.f4635c.get()).mo286a(DialtonePrefKeys.f2503z, false))) {
                intent = new Intent(f, DialtoneManualSwitcherNuxActivity.class);
                intent.setFlags(67108864);
                ((SecureContextHelper) this.f4636d.get()).mo662a(intent, f);
            }
            ((FbSharedPreferences) this.f4635c.get()).edit().mo1275a(DialtonePrefKeys.f2476F, 0).putBoolean(DialtonePrefKeys.f2475E, false).commit();
        } else {
            c.m8494d();
            f = ((DialtoneController) this.f4640h.get()).mo1227f();
            if (VERSION.SDK_INT >= 21 && f != null) {
                f.getWindow().setStatusBarColor(f.getResources().getColor(2131362578));
            }
            if (!(!this.f4641i.m4682a(ZeroFeatureKey.SWITCH_TO_DIALTONE) || f == null || ((FbSharedPreferences) this.f4635c.get()).mo286a(DialtonePrefKeys.f2471A, false))) {
                intent = new Intent();
                intent.setData(Uri.parse("dialtone://switch_to_dialtone"));
                intent.putExtra("ref", "force_switch_to_dialtone");
                ((SecureContextHelper) this.f4636d.get()).mo662a(intent, f);
            }
            m8388b(this.f4645m.m8459a());
            m8399k();
            if (((FbSharedPreferences) this.f4635c.get()).mo277a(DialtonePrefKeys.f2476F, 0) == 0) {
                ((FbSharedPreferences) this.f4635c.get()).edit().mo1275a(DialtonePrefKeys.f2476F, SystemClock.f762a.mo211a()).commit();
            }
        }
        m8405q();
    }

    public static int m8393g() {
        return 2131428113;
    }

    public static void m8401m(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
        DialtoneManualSwitcher d = dialtoneManualSwitcherController.m8419d();
        if (d != null) {
            d.mo1243g();
        }
    }

    private void m8402n() {
        if (((FbZeroFeatureVisibilityHelper) this.f4634b.get()).m7924a(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE)) {
            m8417c().m8493c();
            m8422f();
            m8384a("dialtone_switcher_impression");
            m8407s();
            return;
        }
        m8403o();
    }

    private void m8403o() {
        DialtoneManualSwitcher d = m8419d();
        if (d != null) {
            m8414a(InfoDismissalReason.OTHER);
            d.mo1242b();
            m8408t();
        }
    }

    public final synchronized boolean m8423h() {
        boolean z;
        if (this.f4649q == null) {
            z = false;
        } else {
            z = this.f4649q.m8491a();
        }
        return z;
    }

    public final synchronized boolean m8424i() {
        boolean z;
        if (this.f4649q == null) {
            z = false;
        } else {
            z = this.f4649q.m8500j();
        }
        return z;
    }

    public static void m8404p(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
        ((FbSharedPreferences) dialtoneManualSwitcherController.f4635c.get()).edit().putBoolean(DialtonePrefKeys.f2474D, false).commit();
    }

    private synchronized void m8405q() {
        if (!(this.f4649q == null || ((FbSharedPreferences) this.f4635c.get()).mo286a(DialtonePrefKeys.f2474D, false))) {
            if (this.f4649q.m8500j()) {
                this.f4649q.m8499i();
            } else {
                int a = this.f4644l.m2683a(DialtoneManualSwitcherXConfig.f4693c, 10);
                int a2 = ((FbSharedPreferences) this.f4635c.get()).mo276a(DialtonePrefKeys.f2502y, 0);
                if (a2 < a) {
                    m8406r();
                    a2++;
                    ((FbSharedPreferences) this.f4635c.get()).edit().mo1274a(DialtonePrefKeys.f2502y, a2).commit();
                    if (a2 == a) {
                        m8384a("dialtone_switcher_info_impression_cap_reached");
                    }
                }
            }
        }
    }

    private void m8406r() {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("dialtone_switcher_info_banner_impression");
        honeyClientEvent.m5087a("dialtone_state", this.f4649q.m8496f());
        honeyClientEvent.m5090b("carrier_id", ((FbSharedPreferences) this.f4635c.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        AnalyticsLogger analyticsLogger = (AnalyticsLogger) this.f4638f.get();
        honeyClientEvent.f3099c = "dialtone";
        analyticsLogger.mo526a(honeyClientEvent);
        this.f4649q.m8501k();
        m8409u();
    }

    public final synchronized void m8414a(InfoDismissalReason infoDismissalReason) {
        if (this.f4649q != null) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("dialtone_switcher_info_banner_dismissal");
            honeyClientEvent.m5086a("dismissal_reason", (Object) infoDismissalReason);
            honeyClientEvent.m5087a("dialtone_state", this.f4649q.m8496f());
            honeyClientEvent.m5090b("carrier_id", ((FbSharedPreferences) this.f4635c.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
            ((AnalyticsLogger) this.f4638f.get()).mo526a(honeyClientEvent.m5094g("dialtone"));
            if (infoDismissalReason.equals(InfoDismissalReason.EXPLICIT)) {
                ((FbSharedPreferences) this.f4635c.get()).edit().putBoolean(DialtonePrefKeys.f2474D, true).commit();
            }
            this.f4649q.m8502l();
            m8410v();
        }
    }

    private void m8407s() {
        for (IndicatorVisibilityListener a : this.f4651s) {
            a.mo1260a();
        }
    }

    private void m8408t() {
        for (IndicatorVisibilityListener b : this.f4651s) {
            b.mo1261b();
        }
    }

    private void m8409u() {
        for (IndicatorVisibilityListener a : this.f4652t) {
            a.mo1260a();
        }
    }

    private void m8410v() {
        for (IndicatorVisibilityListener b : this.f4652t) {
            b.mo1261b();
        }
    }

    private void m8384a(String str) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "dialtone";
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        honeyAnalyticsEvent.m5090b("carrier_id", ((FbSharedPreferences) this.f4635c.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        ((AnalyticsLogger) this.f4638f.get()).mo526a(honeyAnalyticsEvent);
    }

    private void m8385a(String str, String str2) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "dialtone";
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        honeyAnalyticsEvent.m5090b("ref", str2);
        honeyAnalyticsEvent.m5090b("carrier_id", ((FbSharedPreferences) this.f4635c.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        ((AnalyticsLogger) this.f4638f.get()).mo526a(honeyAnalyticsEvent);
    }
}
