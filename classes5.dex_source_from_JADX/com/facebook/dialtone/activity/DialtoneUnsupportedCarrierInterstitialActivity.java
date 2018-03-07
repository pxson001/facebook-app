package com.facebook.dialtone.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.FbZeroTokenType;
import javax.inject.Inject;

/* compiled from: \\/ */
public class DialtoneUnsupportedCarrierInterstitialActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    FbSharedPreferences f11847p;
    @Inject
    DialtoneController f11848q;
    @Inject
    AnalyticsLogger f11849r;

    /* compiled from: \\/ */
    class C11101 implements OnClickListener {
        final /* synthetic */ DialtoneUnsupportedCarrierInterstitialActivity f11846a;

        C11101(DialtoneUnsupportedCarrierInterstitialActivity dialtoneUnsupportedCarrierInterstitialActivity) {
            this.f11846a = dialtoneUnsupportedCarrierInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1817428766);
            DialtoneUnsupportedCarrierInterstitialActivity.m19869b(this.f11846a, "dialtone_ineligible_interstitial_upgrade_button_click");
            this.f11846a.f11848q.a("dialtone_ineligible_interstitial_upgrade_button_click");
            this.f11846a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1207925640, a);
        }
    }

    private static <T extends Context> void m19867a(Class<T> cls, T t) {
        m19868a((Object) t, (Context) t);
    }

    public static void m19868a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DialtoneUnsupportedCarrierInterstitialActivity) obj).m19866a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    public final void m19870b(Bundle bundle) {
        CharSequence string;
        super.b(bundle);
        Class cls = DialtoneUnsupportedCarrierInterstitialActivity.class;
        m19868a((Object) this, (Context) this);
        setContentView(2130903896);
        FbTextView fbTextView = (FbTextView) a(2131559370);
        if (getIntent().getExtras().getBoolean("dialtone_wrong_carrier_flag")) {
            String a = this.f11847p.a(DialtonePrefKeys.h, getString(2131232581));
            string = getString(2131232576, new Object[]{a});
        } else if (getIntent().getExtras().getBoolean("dialtone_not_in_region_flag")) {
            string = getString(2131232579);
        } else {
            string = getString(2131232578);
        }
        fbTextView.setText(string);
        fbTextView.setContentDescription(string);
        fbTextView = (FbTextView) a(2131560983);
        string = getString(2131232577);
        fbTextView.setText(string);
        fbTextView.setContentDescription(string);
        ((FbButton) a(2131560984)).setOnClickListener(new C11101(this));
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -559565053);
        super.onResume();
        m19869b(this, "dialtone_ineligible_interstitial_impression");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 419633355, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1703865846);
        super.onPause();
        m19869b(this, "dialtone_ineligible_interstitial_become_invisible");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1782939466, a);
    }

    public void onBackPressed() {
        this.f11848q.a("dialtone_ineligible_interstitial_back_pressed");
        super.onBackPressed();
        m19869b(this, "dialtone_ineligible_interstitial_back_pressed");
    }

    public final String am_() {
        return "dialtone_ineligible_interstitial";
    }

    public static void m19869b(DialtoneUnsupportedCarrierInterstitialActivity dialtoneUnsupportedCarrierInterstitialActivity, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "dialtone";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.b("carrier_id", dialtoneUnsupportedCarrierInterstitialActivity.f11847p.a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        dialtoneUnsupportedCarrierInterstitialActivity.f11849r.a(honeyClientEvent);
    }

    private void m19866a(FbSharedPreferences fbSharedPreferences, DialtoneController dialtoneController, AnalyticsLogger analyticsLogger) {
        this.f11847p = fbSharedPreferences;
        this.f11848q = dialtoneController;
        this.f11849r = analyticsLogger;
    }
}
