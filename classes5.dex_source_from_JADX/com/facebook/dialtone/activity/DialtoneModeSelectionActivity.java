package com.facebook.dialtone.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.FbZeroTokenType;
import javax.inject.Inject;

/* compiled from: \\\\ */
public class DialtoneModeSelectionActivity extends FbFragmentActivity implements AnalyticsActivity, IAuthNotRequired {
    @Inject
    DialtoneController f11823p;
    @Inject
    SecureContextHelper f11824q;
    @Inject
    AnalyticsLogger f11825r;
    @Inject
    Lazy<FbSharedPreferences> f11826s;

    /* compiled from: \\\\ */
    class C11031 implements OnClickListener {
        final /* synthetic */ DialtoneModeSelectionActivity f11821a;

        C11031(DialtoneModeSelectionActivity dialtoneModeSelectionActivity) {
            this.f11821a = dialtoneModeSelectionActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -832690699);
            DialtoneModeSelectionActivity.m19844b(this.f11821a, "dialtone_mode_selection_interstitial_full_fb_button_click");
            if (this.f11821a.f11823p.a("dialtone_mode_selection_interstitial_full_fb_button_click")) {
                DialtoneModeSelectionActivity.m19846j(this.f11821a);
            }
            this.f11821a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1033648656, a);
        }
    }

    /* compiled from: \\\\ */
    class C11042 implements OnClickListener {
        final /* synthetic */ DialtoneModeSelectionActivity f11822a;

        C11042(DialtoneModeSelectionActivity dialtoneModeSelectionActivity) {
            this.f11822a = dialtoneModeSelectionActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -164954209);
            DialtoneModeSelectionActivity.m19844b(this.f11822a, "dialtone_mode_selection_interstitial_free_fb_button_click");
            this.f11822a.f11823p.c();
            if (!this.f11822a.f11823p.g()) {
                this.f11822a.f11823p.a(this.f11822a);
            }
            this.f11822a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -764455797, a);
        }
    }

    private static <T extends Context> void m19842a(Class<T> cls, T t) {
        m19843a((Object) t, (Context) t);
    }

    public static void m19843a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DialtoneModeSelectionActivity) obj).m19839a((DialtoneController) DialtoneControllerImpl.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 3078));
    }

    protected final void m19847b(Bundle bundle) {
        super.b(bundle);
        Class cls = DialtoneModeSelectionActivity.class;
        m19843a((Object) this, (Context) this);
        setContentView(2130903895);
        if (m19845i()) {
            TextView textView = (TextView) a(2131560972);
            CharSequence string = getString(2131232567);
            textView.setText(string);
            textView.setContentDescription(string);
        }
        a(2131560973).setOnClickListener(new C11031(this));
        a(2131560978).setOnClickListener(new C11042(this));
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2001468420);
        super.onResume();
        m19844b(this, "dialtone_mode_selection_interstitial_impression");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1142115356, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -462620239);
        super.onPause();
        m19844b(this, "dialtone_mode_selection_interstitial_become_invisible");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1740702685, a);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1000) {
            m19844b(this, "dialtone_mode_selection_interstitial_dismissed_by_other_interstitial");
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        m19844b(this, "dialtone_mode_selection_interstitial_back_pressed");
    }

    public final String am_() {
        return "dialtone_mode_selection_interstitial";
    }

    private void m19839a(DialtoneController dialtoneController, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, Lazy<FbSharedPreferences> lazy) {
        this.f11823p = dialtoneController;
        this.f11824q = secureContextHelper;
        this.f11825r = analyticsLogger;
        this.f11826s = lazy;
    }

    private boolean m19845i() {
        return getIntent().getBooleanExtra("dialtone_automode_with_confirmation", false);
    }

    public static void m19846j(DialtoneModeSelectionActivity dialtoneModeSelectionActivity) {
        dialtoneModeSelectionActivity.f11824q.a(new Intent(dialtoneModeSelectionActivity, DialtoneModeTransitionInterstitialActivity.class), dialtoneModeSelectionActivity);
    }

    public static void m19844b(DialtoneModeSelectionActivity dialtoneModeSelectionActivity, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "dialtone";
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.b("carrier_id", ((FbSharedPreferences) dialtoneModeSelectionActivity.f11826s.get()).a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        dialtoneModeSelectionActivity.f11825r.c(honeyClientEvent2);
    }
}
