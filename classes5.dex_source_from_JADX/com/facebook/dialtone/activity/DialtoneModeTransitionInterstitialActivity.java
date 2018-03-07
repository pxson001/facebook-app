package com.facebook.dialtone.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.zero.common.constants.FbZeroTokenType;
import javax.inject.Inject;

/* compiled from: \\\" */
public class DialtoneModeTransitionInterstitialActivity extends FbFragmentActivity {
    private static final Interpolator f11832A = new LinearInterpolator();
    private static final Interpolator f11833B = new OvershootInterpolator(0.25f);
    private View f11834C;
    @Inject
    @ForUiThread
    Handler f11835p;
    @Inject
    DialtoneController f11836q;
    @Inject
    Lazy<FbErrorReporter> f11837r;
    @Inject
    AnalyticsLogger f11838s;
    @Inject
    Lazy<SecureContextHelper> f11839t;
    @Inject
    Lazy<FbSharedPreferences> f11840u;
    private View f11841v;
    private FbTextView f11842w;
    public View f11843x;
    public String f11844y;
    public String f11845z;

    /* compiled from: \\\" */
    class C11051 extends AnimatorListenerAdapter {
        final /* synthetic */ DialtoneModeTransitionInterstitialActivity f11827a;

        C11051(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
            this.f11827a = dialtoneModeTransitionInterstitialActivity;
        }

        public void onAnimationEnd(Animator animator) {
            DialtoneModeTransitionInterstitialActivity.m19860i(this.f11827a);
            if (this.f11827a.f11844y.equals("upgrade")) {
                this.f11827a.f11836q.a("dialtone_transition_interstitial_impression");
            }
        }
    }

    /* compiled from: \\\" */
    class C11062 extends AnimatorListenerAdapter {
        final /* synthetic */ DialtoneModeTransitionInterstitialActivity f11828a;

        C11062(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
            this.f11828a = dialtoneModeTransitionInterstitialActivity;
        }

        public void onAnimationEnd(Animator animator) {
            DialtoneModeTransitionInterstitialActivity.m19861j(this.f11828a);
        }
    }

    /* compiled from: \\\" */
    class C11073 extends AnimatorListenerAdapter {
        final /* synthetic */ DialtoneModeTransitionInterstitialActivity f11829a;

        C11073(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
            this.f11829a = dialtoneModeTransitionInterstitialActivity;
        }

        public void onAnimationEnd(Animator animator) {
            DialtoneModeTransitionInterstitialActivity.m19863l(this.f11829a);
        }
    }

    /* compiled from: \\\" */
    class C11094 extends AnimatorListenerAdapter {
        final /* synthetic */ DialtoneModeTransitionInterstitialActivity f11831a;

        /* compiled from: \\\" */
        class C11081 implements Runnable {
            final /* synthetic */ C11094 f11830a;

            C11081(C11094 c11094) {
                this.f11830a = c11094;
            }

            public void run() {
                if (this.f11830a.f11831a.f11844y.equals("downgrade")) {
                    DialtoneModeTransitionInterstitialActivity.m19862k(this.f11830a.f11831a);
                }
                DialtoneModeTransitionInterstitialActivity.m19854b(this.f11830a.f11831a, this.f11830a.f11831a.f11845z);
                this.f11830a.f11831a.finish();
            }
        }

        C11094(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
            this.f11831a = dialtoneModeTransitionInterstitialActivity;
        }

        public void onAnimationEnd(Animator animator) {
            this.f11831a.f11843x.setAlpha(1.0f);
            HandlerDetour.b(this.f11831a.f11835p, new C11081(this), 800, 1108055537);
        }
    }

    private static <T extends Context> void m19851a(Class<T> cls, T t) {
        m19852a((Object) t, (Context) t);
    }

    public static void m19852a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DialtoneModeTransitionInterstitialActivity) obj).m19848a(Handler_ForUiThreadMethodAutoProvider.b(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), AnalyticsLoggerMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedSingletonScopeProvider.b(fbInjector, 3078));
    }

    protected final void m19864b(Bundle bundle) {
        super.b(bundle);
        Class cls = DialtoneModeTransitionInterstitialActivity.class;
        m19852a((Object) this, (Context) this);
        setContentView(2130903907);
        this.f11834C = a(2131561025);
        this.f11841v = a(2131560971);
        this.f11842w = (FbTextView) a(2131561026);
        this.f11843x = a(2131561027);
        this.f11845z = getIntent().getStringExtra("follow_up_intent");
        this.f11844y = getIntent().getStringExtra("action");
        this.f11844y = this.f11844y == null ? "upgrade" : this.f11844y;
        if (this.f11844y.equals("upgrade")) {
            this.f11841v.setBackgroundResource(2130839635);
            this.f11842w.setText(2131232545);
        } else if (this.f11844y.equals("downgrade")) {
            this.f11841v.setBackgroundResource(2130840417);
            this.f11842w.setText(2131232546);
        } else {
            ((AbstractFbErrorReporter) this.f11837r.get()).a("dialtone".toString(), "Invalid transition mode for Dialtone.");
            finish();
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("dialtone_transition_interstitial_impression");
        honeyClientEvent.c = "dialtone";
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.b("ref", getIntent().getStringExtra("ref"));
        honeyClientEvent2.b("carrier_id", ((FbSharedPreferences) this.f11840u.get()).a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        honeyClientEvent2.b("action", this.f11844y);
        this.f11838s.a(honeyClientEvent2);
        this.f11834C.setAlpha(0.0f);
        this.f11841v.setAlpha(0.0f);
        this.f11842w.setAlpha(0.0f);
        this.f11843x.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11834C, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(f11832A);
        ofFloat.addListener(new C11051(this));
        ofFloat.setDuration(400).start();
    }

    private void m19848a(Handler handler, DialtoneController dialtoneController, Lazy<FbErrorReporter> lazy, AnalyticsLogger analyticsLogger, Lazy<SecureContextHelper> lazy2, Lazy<FbSharedPreferences> lazy3) {
        this.f11835p = handler;
        this.f11836q = dialtoneController;
        this.f11837r = lazy;
        this.f11838s = analyticsLogger;
        this.f11839t = lazy2;
        this.f11840u = lazy3;
    }

    public static void m19854b(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity, String str) {
        if (!StringUtil.a(str) && FacebookUriUtil.g(Uri.parse(str))) {
            ((SecureContextHelper) dialtoneModeTransitionInterstitialActivity.f11839t.get()).a(new Intent().setData(Uri.parse(str)), dialtoneModeTransitionInterstitialActivity);
        }
    }

    public static void m19860i(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(dialtoneModeTransitionInterstitialActivity.f11841v, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(400);
        ofFloat.addListener(new C11062(dialtoneModeTransitionInterstitialActivity));
        ofFloat.start();
    }

    public static void m19861j(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(dialtoneModeTransitionInterstitialActivity.f11841v, "translationY", new float[]{(float) (-dialtoneModeTransitionInterstitialActivity.getResources().getDimensionPixelSize(2131428059))});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(f11833B);
        ofFloat.addListener(new C11073(dialtoneModeTransitionInterstitialActivity));
        ofFloat.start();
    }

    public static void m19862k(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
        if (dialtoneModeTransitionInterstitialActivity.f11836q.c()) {
            dialtoneModeTransitionInterstitialActivity.f11836q.a(dialtoneModeTransitionInterstitialActivity);
        }
    }

    public static void m19863l(DialtoneModeTransitionInterstitialActivity dialtoneModeTransitionInterstitialActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(dialtoneModeTransitionInterstitialActivity.f11842w, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(f11832A);
        ofFloat.addListener(new C11094(dialtoneModeTransitionInterstitialActivity));
        ofFloat.start();
    }
}
