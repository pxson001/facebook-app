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

/* compiled from: \[([^\[\]])*\] */
public class DialtoneWifiInterstitialActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    FbSharedPreferences f11852p;
    @Inject
    DialtoneController f11853q;
    @Inject
    AnalyticsLogger f11854r;

    /* compiled from: \[([^\[\]])*\] */
    class C11111 implements OnClickListener {
        final /* synthetic */ DialtoneWifiInterstitialActivity f11851a;

        C11111(DialtoneWifiInterstitialActivity dialtoneWifiInterstitialActivity) {
            this.f11851a = dialtoneWifiInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1581237419);
            DialtoneWifiInterstitialActivity.m19879b(this.f11851a, "dialtone_wifi_interstitial_upgrade_button_click");
            this.f11851a.f11853q.a("dialtone_wifi_interstitial_upgrade_button_click");
            this.f11851a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 848191632, a);
        }
    }

    private static <T extends Context> void m19877a(Class<T> cls, T t) {
        m19878a((Object) t, (Context) t);
    }

    public static void m19878a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DialtoneWifiInterstitialActivity) obj).m19876a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    public final void m19880b(Bundle bundle) {
        super.b(bundle);
        Class cls = DialtoneWifiInterstitialActivity.class;
        m19878a((Object) this, (Context) this);
        setContentView(2130903896);
        FbTextView fbTextView = (FbTextView) a(2131559370);
        CharSequence string = getString(2131232574);
        fbTextView.setText(string);
        fbTextView.setContentDescription(string);
        fbTextView = (FbTextView) a(2131560983);
        String a = this.f11852p.a(DialtonePrefKeys.h, getString(2131232581));
        string = getString(2131232575, new Object[]{a});
        fbTextView.setText(string);
        fbTextView.setContentDescription(string);
        ((FbButton) a(2131560984)).setOnClickListener(new C11111(this));
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1526256487);
        super.onResume();
        m19879b(this, "dialtone_wifi_interstitial_impression");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 360583960, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -784858113);
        super.onPause();
        m19879b(this, "dialtone_wifi_interstitial_become_invisible");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 144944523, a);
    }

    public void onBackPressed() {
        this.f11853q.a("dialtone_wifi_interstitial_back_pressed");
        super.onBackPressed();
        m19879b(this, "dialtone_wifi_interstitial_back_pressed");
    }

    public final String am_() {
        return "dialtone_wifi_interstitial";
    }

    public static void m19879b(DialtoneWifiInterstitialActivity dialtoneWifiInterstitialActivity, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "dialtone";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.b("carrier_id", dialtoneWifiInterstitialActivity.f11852p.a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        dialtoneWifiInterstitialActivity.f11854r.a(honeyClientEvent);
    }

    private void m19876a(FbSharedPreferences fbSharedPreferences, DialtoneController dialtoneController, AnalyticsLogger analyticsLogger) {
        this.f11852p = fbSharedPreferences;
        this.f11853q = dialtoneController;
        this.f11854r = analyticsLogger;
    }
}
