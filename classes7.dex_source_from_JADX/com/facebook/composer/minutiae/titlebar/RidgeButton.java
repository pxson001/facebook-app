package com.facebook.composer.minutiae.titlebar;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.audiofingerprinting.AudioFingerprintingSession;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.Callback;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.ErrorCode;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.minutiae.RidgeRuntimePermissionManager;
import com.facebook.composer.minutiae.RidgeRuntimePermissionManagerProvider;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsEventBuilder;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger.RidgeView;
import com.facebook.composer.minutiae.event.MinutiaeEventBus;
import com.facebook.composer.minutiae.event.MinutiaeEventSubscriber;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeDisabledEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeEnabledEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeFailedEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeRefreshEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeResultsFoundEvent;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.interstitial.MinutiaeInterstitialController$TriggerSurface;
import com.facebook.composer.minutiae.interstitial.RidgeInterstitialController;
import com.facebook.composer.minutiae.music.MusicMetadataHelper;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.soundwave.ControlledSoundWaveView;
import com.facebook.widget.soundwave.ControlledSoundWaveView.SoundWaveController;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.Random;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: third_party_app_uninstall */
public class RidgeButton extends CustomFrameLayout {
    public boolean f1786A;
    public State f1787B;
    @VisibleForTesting
    protected AnimatorListener f1788a;
    @VisibleForTesting
    protected Callback f1789b;
    private SoundWaveController f1790c;
    private ControlledSoundWaveView f1791d;
    private ProgressCircleAnimation f1792e;
    private ObjectAnimator f1793f;
    private ImageView f1794g;
    public String f1795h;
    private String f1796i;
    public String f1797j;
    public Random f1798k;
    public AudioFingerprintingSession f1799l;
    public MinutiaeEventBus f1800m;
    public RidgeOptInController f1801n;
    public InterstitialManager f1802o;
    public RidgeInterstitialController f1803p;
    public SecureContextHelper f1804q;
    public RidgeAnalyticsLogger f1805r;
    private MusicMetadataHelper f1806s;
    public ViewAccessibilityHelper f1807t;
    private FbEventSubscriberListManager f1808u;
    public Toaster f1809v;
    public RidgeRuntimePermissionManager f1810w;
    public OnGlobalLayoutListener f1811x;
    public String f1812y;
    public Optional<String> f1813z;

    /* compiled from: third_party_app_uninstall */
    class C01801 implements SoundWaveController {
        final /* synthetic */ RidgeButton f1779a;

        C01801(RidgeButton ridgeButton) {
            this.f1779a = ridgeButton;
        }

        public final double m1743a() {
            double nextFloat = 1.0d - (((double) this.f1779a.f1798k.nextFloat()) * 0.4000000059604645d);
            double min = Math.min((Math.abs(Math.sqrt(Math.pow(10.0d, this.f1779a.f1799l.m1020c() / 10.0d)) * 1000.0d) / 100.0d) + (((double) this.f1779a.f1798k.nextFloat()) * 0.4000000059604645d), nextFloat);
            return Double.isNaN(min) ? nextFloat : min;
        }

        public final int m1744b() {
            return 100;
        }
    }

    /* compiled from: third_party_app_uninstall */
    class C01812 implements OnGlobalLayoutListener {
        final /* synthetic */ RidgeButton f1780a;

        C01812(RidgeButton ridgeButton) {
            this.f1780a = ridgeButton;
        }

        public void onGlobalLayout() {
            this.f1780a.f1800m;
            this.f1780a.m1800f();
        }
    }

    /* compiled from: third_party_app_uninstall */
    class C01823 implements AnimatorListener {
        final /* synthetic */ RidgeButton f1781a;

        C01823(RidgeButton ridgeButton) {
            this.f1781a = ridgeButton;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f1781a.f1813z;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: third_party_app_uninstall */
    class C01844 implements OnClickListener {
        final /* synthetic */ RidgeButton f1783a;

        /* compiled from: third_party_app_uninstall */
        class C01831 implements RuntimePermissionsListener {
            final /* synthetic */ C01844 f1782a;

            C01831(C01844 c01844) {
                this.f1782a = c01844;
            }

            public final void m1745a() {
                this.f1782a.f1783a.f1810w;
                String str = "ridge_enabled";
                RidgeAnalyticsLogger.m1551a(str, this.f1782a.f1783a.f1812y).m1550a(this.f1782a.f1783a.f1805r.f1464a);
                this.f1782a.f1783a.f1801n.m1830h();
                this.f1782a.f1783a.f1800m.a(new RidgeEnabledEvent());
                this.f1782a.f1783a.f1807t.a(this.f1782a.f1783a, this.f1782a.f1783a.f1795h);
            }

            public final void m1746a(String[] strArr, String[] strArr2) {
                this.f1782a.f1783a.f1809v.a(new ToastBuilder(this.f1782a.f1783a.f1810w.f1454c));
                this.f1782a.f1783a.f1805r.m1556b(this.f1782a.f1783a.f1812y, RidgeView.RIDGE_BUTTON);
            }

            public final void m1747b() {
                this.f1782a.f1783a.f1805r.m1558c(this.f1782a.f1783a.f1812y, RidgeView.RIDGE_BUTTON);
            }
        }

        C01844(RidgeButton ridgeButton) {
            this.f1783a = ridgeButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1267007029);
            if (!this.f1783a.f1801n.m1827c()) {
                String str;
                Activity activity = (Activity) this.f1783a.getContext();
                Intent a2 = this.f1783a.f1803p.m1623a(this.f1783a.getContext());
                a2.putExtra("extra_composer_session_id", this.f1783a.f1812y);
                RidgeInterstitialController ridgeInterstitialController = this.f1783a.f1803p;
                String str2 = this.f1783a.f1812y;
                MinutiaeInterstitialController$TriggerSurface minutiaeInterstitialController$TriggerSurface = MinutiaeInterstitialController$TriggerSurface.FROM_RIDGE_BUTTON;
                RidgeAnalyticsLogger ridgeAnalyticsLogger = ridgeInterstitialController.f1566c;
                if (minutiaeInterstitialController$TriggerSurface != null) {
                    str = minutiaeInterstitialController$TriggerSurface.name;
                } else {
                    str = null;
                }
                boolean j = ridgeInterstitialController.f1565b.m1832j();
                boolean c = ridgeInterstitialController.f1565b.m1827c();
                RidgeAnalyticsEventBuilder a3 = RidgeAnalyticsLogger.m1551a("ridge_opt_in_displayed", str2);
                a3.f1462a.b("ridge_trigger_surface", str);
                a3 = a3;
                a3.f1462a.a("ridge_has_seen_interstitial", j);
                a3 = a3;
                a3.f1462a.a("ridge_did_opt_in", c);
                a3.m1550a(ridgeAnalyticsLogger.f1464a);
                ridgeInterstitialController.f1565b.f1852a.edit().putBoolean(MinutiaePrefKeys.f1618f, true).commit();
                this.f1783a.f1804q.a(a2, RidgeInterstitialController.m1622d(), activity);
                this.f1783a.f1802o.a().a(this.f1783a.f1803p.m1628b());
                activity.overridePendingTransition(2130968580, 0);
            } else if (this.f1783a.f1787B != State.DISABLED) {
                this.f1783a.f1805r.m1560j(this.f1783a.f1812y);
                this.f1783a.f1795h;
                this.f1783a.f1801n.m1831i();
                this.f1783a.f1800m.a(new RidgeDisabledEvent());
                this.f1783a.f1807t.a(this.f1783a, this.f1783a.f1797j);
            } else {
                this.f1783a.f1810w.m1536a(new C01831(this));
            }
            LogUtils.a(-64647907, a);
        }
    }

    /* compiled from: third_party_app_uninstall */
    class C01855 implements Callback {
        final /* synthetic */ RidgeButton f1784a;

        C01855(RidgeButton ridgeButton) {
            this.f1784a = ridgeButton;
        }

        public final void mo89a(String str) {
            this.f1784a.f1805r.m1555a(this.f1784a.f1812y, RidgeView.ACTIVITY_PICKER, (String) this.f1784a.f1813z.get());
            this.f1784a.getViewTreeObserver().addOnGlobalLayoutListener(this.f1784a.f1811x);
            this.f1784a.requestLayout();
        }

        public final void mo85a() {
            this.f1784a.f1813z;
            if (!this.f1784a.f1786A) {
                this.f1784a.f1800m.a(new RidgeFailedEvent(ErrorCode.LIBRARY_ERROR));
            }
            this.f1784a.f1805r.m1554a(this.f1784a.f1812y, RidgeView.ACTIVITY_PICKER);
        }

        public final void mo88a(ImmutableList<? extends MinutiaeTaggableSuggestions> immutableList, String str) {
            this.f1784a.f1800m.a(new RidgeResultsFoundEvent(immutableList));
            this.f1784a.f1805r.m1559c(this.f1784a.f1812y, RidgeView.ACTIVITY_PICKER, str);
            this.f1784a.m1760a(str);
            this.f1784a.f1809v;
        }

        public final void mo87a(ErrorCode errorCode, String str) {
            this.f1784a.f1800m.a(new RidgeFailedEvent(errorCode));
            this.f1784a.m1760a(str);
            this.f1784a.f1813z;
        }

        public final void mo86a(double d) {
        }
    }

    /* compiled from: third_party_app_uninstall */
    class C01866 extends MinutiaeEventSubscriber<RidgeRefreshEvent> {
        final /* synthetic */ RidgeButton f1785a;

        C01866(RidgeButton ridgeButton) {
            this.f1785a = ridgeButton;
        }

        public final void m1754b(FbEvent fbEvent) {
            if (this.f1785a.f1787B != State.DISABLED) {
                this.f1785a.f1795h;
                this.f1785a.f1810w;
            }
        }

        public final Class m1753a() {
            return RidgeRefreshEvent.class;
        }
    }

    /* compiled from: third_party_app_uninstall */
    public enum State {
        LISTENING,
        SUCCESS,
        FAILURE,
        DISABLED
    }

    private static <T extends View> void m1758a(Class<T> cls, T t) {
        m1759a((Object) t, t.getContext());
    }

    private static void m1759a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RidgeButton) obj).m1756a(AudioFingerprintingSession.m1015b(injectorLike), MinutiaeEventBus.m1583a(injectorLike), RidgeOptInController.m1822b(injectorLike), InterstitialManager.a(injectorLike), RidgeInterstitialController.m1621b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), RidgeAnalyticsLogger.m1552a(injectorLike), MusicMetadataHelper.m1645b(injectorLike), ViewAccessibilityHelper.a(injectorLike), (RidgeRuntimePermissionManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RidgeRuntimePermissionManagerProvider.class), Toaster.b(injectorLike));
    }

    public RidgeButton(Context context) {
        super(context);
        m1767g();
    }

    public RidgeButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1767g();
    }

    public RidgeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1767g();
    }

    @Inject
    private void m1756a(AudioFingerprintingSession audioFingerprintingSession, MinutiaeEventBus minutiaeEventBus, RidgeOptInController ridgeOptInController, InterstitialManager interstitialManager, RidgeInterstitialController ridgeInterstitialController, SecureContextHelper secureContextHelper, RidgeAnalyticsLogger ridgeAnalyticsLogger, MusicMetadataHelper musicMetadataHelper, ViewAccessibilityHelper viewAccessibilityHelper, RidgeRuntimePermissionManagerProvider ridgeRuntimePermissionManagerProvider, Toaster toaster) {
        this.f1799l = audioFingerprintingSession;
        this.f1800m = minutiaeEventBus;
        this.f1801n = ridgeOptInController;
        this.f1804q = secureContextHelper;
        this.f1802o = interstitialManager;
        this.f1803p = ridgeInterstitialController;
        this.f1805r = ridgeAnalyticsLogger;
        this.f1806s = musicMetadataHelper;
        this.f1807t = viewAccessibilityHelper;
        this.f1810w = ridgeRuntimePermissionManagerProvider.m1537a((Activity) ContextUtils.a(getContext(), Activity.class));
        this.f1809v = toaster;
    }

    private void m1767g() {
        setContentView(2130906899);
        this.f1791d = (ControlledSoundWaveView) c(2131567094);
        this.f1792e = (ProgressCircleAnimation) c(2131558407);
        this.f1794g = (ImageView) c(2131567095);
        this.f1795h = getResources().getString(2131234701);
        this.f1797j = getResources().getString(2131234699);
        this.f1796i = getResources().getString(2131234700);
        m1758a(RidgeButton.class, (View) this);
        this.f1798k = new Random();
        this.f1790c = new C01801(this);
        m1769h();
        m1771i();
        this.f1786A = true;
        this.f1808u = new FbEventSubscriberListManager();
        m1773j();
        this.f1795h;
    }

    private void m1769h() {
        this.f1811x = new C01812(this);
        this.f1788a = new C01823(this);
        setOnClickListener(new C01844(this));
        this.f1793f = ObjectAnimator.ofInt(this.f1792e, "arcAngle", new int[]{0, 360});
        this.f1793f.setInterpolator(new LinearInterpolator());
        this.f1793f.setDuration(15000);
        this.f1793f.addListener(this.f1788a);
    }

    private void m1771i() {
        this.f1789b = new C01855(this);
    }

    private void m1773j() {
        this.f1808u.a(new FbEventSubscriber[]{new C01866(this)});
    }

    public void setComposerSessionId(String str) {
        this.f1812y = str;
    }

    public final void m1797a() {
        this.f1808u.a(this.f1800m);
        m1775k();
    }

    public final void m1798b() {
        this.f1808u.b(this.f1800m);
        m1776l();
    }

    private void m1775k() {
        if (this.f1801n.m1827c() && this.f1801n.m1828e() && this.f1787B == State.DISABLED) {
            this.f1810w;
        }
    }

    private void m1776l() {
        if (this.f1787B == State.LISTENING) {
            this.f1795h;
        }
    }

    private void m1760a(String str) {
        this.f1805r.m1557b(this.f1812y, RidgeView.ACTIVITY_PICKER, str);
    }

    public static void m1779m(RidgeButton ridgeButton) {
        if (VERSION.SDK_INT >= 16) {
            ridgeButton.getViewTreeObserver().removeOnGlobalLayoutListener(ridgeButton.f1811x);
        } else {
            ridgeButton.getViewTreeObserver().removeGlobalOnLayoutListener(ridgeButton.f1811x);
        }
    }

    public final void m1799e() {
        if (this.f1801n.m1827c() && this.f1801n.m1828e()) {
            this.f1787B = State.SUCCESS;
            m1783o();
        }
    }

    public final void m1800f() {
        this.f1791d.a(this.f1790c);
        this.f1792e.f1776c = 0;
        this.f1793f.addUpdateListener(this.f1792e);
        this.f1793f.start();
        this.f1791d.setVisibility(0);
        this.f1794g.setVisibility(8);
        setContentDescription(this.f1795h);
    }

    private void m1781n() {
        m1784p();
        this.f1791d.b();
        this.f1791d.setVisibility(8);
        this.f1794g.setVisibility(0);
        setContentDescription(this.f1797j);
    }

    private void m1783o() {
        m1784p();
        this.f1791d.a(new float[]{0.5f, 1.0f, 0.8f, 0.5f, 0.3f});
        this.f1791d.setVisibility(0);
        this.f1794g.setVisibility(8);
        setContentDescription(this.f1796i);
    }

    private void m1784p() {
        this.f1800m;
        if (this.f1793f.isRunning()) {
            this.f1793f.removeAllUpdateListeners();
            this.f1793f.cancel();
        }
        this.f1792e.f1776c = 0;
        this.f1792e.invalidate();
    }

    public static void m1787q(RidgeButton ridgeButton) {
        if (ridgeButton.f1787B != State.DISABLED) {
            ridgeButton.f1787B = State.DISABLED;
            ridgeButton.m1781n();
            ridgeButton.f1799l.m1019b();
        }
    }

    public static void m1789r(RidgeButton ridgeButton) {
        if (ridgeButton.f1810w.f1453b.a(RidgeRuntimePermissionManager.f1452a) && ridgeButton.f1787B != State.LISTENING) {
            ridgeButton.f1787B = State.LISTENING;
            ridgeButton.f1813z = ridgeButton.f1799l.m1016a(ridgeButton.f1789b, ridgeButton.f1806s.m1651b());
            ridgeButton.f1786A = false;
        }
    }

    public static void m1791s(RidgeButton ridgeButton) {
        if (ridgeButton.f1787B == State.LISTENING) {
            ridgeButton.f1787B = State.SUCCESS;
            ridgeButton.m1783o();
        }
    }

    public static void m1793t(RidgeButton ridgeButton) {
        if (ridgeButton.f1787B == State.LISTENING) {
            ridgeButton.f1787B = State.FAILURE;
            ridgeButton.m1783o();
            if (ridgeButton.f1813z.isPresent()) {
                ridgeButton.f1799l.m1018a();
            }
        }
    }

    public State getState() {
        return this.f1787B;
    }
}
