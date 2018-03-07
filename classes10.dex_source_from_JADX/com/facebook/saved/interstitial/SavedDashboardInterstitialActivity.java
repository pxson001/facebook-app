package com.facebook.saved.interstitial;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import javax.inject.Inject;

/* compiled from: invalid_payload */
public class SavedDashboardInterstitialActivity extends FbFragmentActivity {
    @Inject
    public SaveAnalyticsLogger f9185p;
    private Button f9186q;

    /* compiled from: invalid_payload */
    class C13951 implements OnClickListener {
        final /* synthetic */ SavedDashboardInterstitialActivity f9184a;

        C13951(SavedDashboardInterstitialActivity savedDashboardInterstitialActivity) {
            this.f9184a = savedDashboardInterstitialActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1735251610);
            this.f9184a.finish();
            SavedDashboardInterstitialActivity.m9202k(this.f9184a);
            Logger.a(2, EntryType.UI_INPUT_END, -146324365, a);
        }
    }

    private static <T extends Context> void m9198a(Class<T> cls, T t) {
        m9199a((Object) t, (Context) t);
    }

    public static void m9199a(Object obj, Context context) {
        ((SavedDashboardInterstitialActivity) obj).f9185p = SaveAnalyticsLogger.a(FbInjector.get(context));
    }

    public final void m9203b(Bundle bundle) {
        super.b(bundle);
        Class cls = SavedDashboardInterstitialActivity.class;
        m9199a((Object) this, (Context) this);
        m9201j();
        setContentView(2130906943);
        this.f9186q = (Button) a(2131567224);
        m9200i();
        SaveAnalyticsLogger saveAnalyticsLogger = this.f9185p;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_dashboard_nux_imp");
        honeyClientEvent.c = "saved_dashboard";
        saveAnalyticsLogger.a.a(honeyClientEvent.b("event_id", SafeUUIDGenerator.a().toString()));
    }

    public void onBackPressed() {
        super.onBackPressed();
        m9202k(this);
    }

    private void m9196a(SaveAnalyticsLogger saveAnalyticsLogger) {
        this.f9185p = saveAnalyticsLogger;
    }

    private void m9200i() {
        this.f9186q.setOnClickListener(new C13951(this));
    }

    private void m9201j() {
        overridePendingTransition(2130968580, 0);
    }

    public static void m9202k(SavedDashboardInterstitialActivity savedDashboardInterstitialActivity) {
        savedDashboardInterstitialActivity.overridePendingTransition(0, 2130968582);
    }
}
