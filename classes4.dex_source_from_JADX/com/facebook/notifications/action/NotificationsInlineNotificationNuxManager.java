package com.facebook.notifications.action;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.facebook.notifications.nux.NotificationsInlineNotificationNuxBuilder;
import com.facebook.notifications.nux.NotificationsInlineNotificationNuxController;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.notifications.widget.SwitchableNotificationView;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

@ContextScoped
/* compiled from: exp_name */
public class NotificationsInlineNotificationNuxManager {
    private static NotificationsInlineNotificationNuxManager f12654r;
    private static final Object f12655s = new Object();
    public Clock f12656a;
    public final NotificationsJewelExperimentController f12657b;
    public final FbSharedPreferences f12658c;
    public final OnSharedPreferenceChangeListener f12659d;
    public final InterstitialManager f12660e;
    public final NotificationsInlineActionsHelper f12661f;
    private final NotificationsInlineNotificationNuxBuilder f12662g;
    private final DefaultNotificationsRenderer f12663h;
    public final NotificationsRowWithActionHelper f12664i;
    public boolean f12665j;
    public boolean f12666k;
    public Runnable f12667l;
    public InterstitialController f12668m;
    public boolean f12669n = false;
    public boolean f12670o = false;
    public View f12671p;
    private ScaleAnimation f12672q;

    /* compiled from: exp_name */
    class C05981 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ NotificationsInlineNotificationNuxManager f12685a;

        C05981(NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager) {
            this.f12685a = notificationsInlineNotificationNuxManager;
        }

        public final void m13496a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            if (fbSharedPreferences.a(prefKey, false)) {
                this.f12685a.f12666k = true;
                if (this.f12685a.f12667l != null) {
                    this.f12685a.f12667l.run();
                }
            }
        }
    }

    private static NotificationsInlineNotificationNuxManager m13474b(InjectorLike injectorLike) {
        return new NotificationsInlineNotificationNuxManager((Clock) SystemClockMethodAutoProvider.a(injectorLike), NotificationsJewelExperimentController.m8058b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InterstitialManager.a(injectorLike), NotificationsInlineActionsHelper.m13381a(injectorLike), new NotificationsInlineNotificationNuxBuilder(NotificationsJewelExperimentController.m8058b(injectorLike)), DefaultNotificationsRenderer.m13481a(injectorLike), NotificationsRowWithActionHelper.m13438a(injectorLike));
    }

    public static NotificationsInlineNotificationNuxManager m13472a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationsInlineNotificationNuxManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12655s) {
                NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager;
                if (a2 != null) {
                    notificationsInlineNotificationNuxManager = (NotificationsInlineNotificationNuxManager) a2.a(f12655s);
                } else {
                    notificationsInlineNotificationNuxManager = f12654r;
                }
                if (notificationsInlineNotificationNuxManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m13474b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12655s, b3);
                        } else {
                            f12654r = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationsInlineNotificationNuxManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NotificationsInlineNotificationNuxManager(Clock clock, NotificationsJewelExperimentController notificationsJewelExperimentController, FbSharedPreferences fbSharedPreferences, InterstitialManager interstitialManager, NotificationsInlineActionsHelper notificationsInlineActionsHelper, NotificationsInlineNotificationNuxBuilder notificationsInlineNotificationNuxBuilder, DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsRowWithActionHelper notificationsRowWithActionHelper) {
        boolean z;
        this.f12656a = clock;
        this.f12657b = notificationsJewelExperimentController;
        this.f12658c = fbSharedPreferences;
        this.f12660e = interstitialManager;
        this.f12661f = notificationsInlineActionsHelper;
        this.f12662g = notificationsInlineNotificationNuxBuilder;
        this.f12663h = defaultNotificationsRenderer;
        this.f12664i = notificationsRowWithActionHelper;
        this.f12665j = this.f12658c.a(NotificationsPreferenceConstants.f7722K, 0) == 0;
        if (this.f12668m == null) {
            this.f12668m = this.f12660e.a(new InterstitialTrigger(Action.NOTIFICATIONS_ADAPTER_CREATION), NotificationsInlineNotificationNuxController.class);
        }
        if (this.f12668m == null || this.f12658c.a(NotificationsPreferenceConstants.f7721J, false)) {
            z = true;
        } else {
            z = false;
        }
        this.f12666k = z;
        this.f12659d = new C05981(this);
    }

    public final View m13475a(int i, View view, ViewGroup viewGroup) {
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a = this.f12662g.m13480a();
        SwitchableNotificationView switchableNotificationView = view == null ? (SwitchableNotificationView) this.f12663h.m13486a(viewGroup) : (SwitchableNotificationView) view;
        switchableNotificationView.a.a(a.mo822k(), this.f12657b.m8059c(), 2130841044, 2130839634);
        switchableNotificationView.setLongClickable(true);
        switchableNotificationView.setOnLongClickListener(new 2(this, a, viewGroup, switchableNotificationView, i));
        m13473a(viewGroup.getContext(), switchableNotificationView);
        this.f12669n = true;
        if (this.f12665j && this.f12670o) {
            m13477e();
            m13478h();
        }
        return switchableNotificationView;
    }

    public final boolean m13476c() {
        return !this.f12666k;
    }

    public final void m13477e() {
        this.f12665j = false;
        this.f12658c.edit().a(NotificationsPreferenceConstants.f7722K, this.f12656a.a()).commit();
        if (this.f12668m != null) {
            this.f12660e.a().a(this.f12668m.b());
        }
    }

    public final void m13478h() {
        if (this.f12671p != null && this.f12672q != null) {
            this.f12671p.startAnimation(this.f12672q);
        }
    }

    private void m13473a(Context context, SwitchableNotificationView switchableNotificationView) {
        this.f12671p = LayoutInflater.from(context).inflate(2130905493, null);
        this.f12672q = new ScaleAnimation(1.0f, 1000.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f12672q.setDuration(700);
        this.f12672q.setFillAfter(true);
        this.f12672q.setAnimationListener(new 3(this));
        this.f12671p.setAlpha(0.0f);
        switchableNotificationView.addView(this.f12671p);
        switchableNotificationView.setOnTouchListener(new 4(this));
    }
}
