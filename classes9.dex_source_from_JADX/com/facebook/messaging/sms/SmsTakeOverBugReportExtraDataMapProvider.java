package com.facebook.messaging.sms;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.provider.Telephony.Sms;
import com.facebook.bugreporter.BugReportExtraDataMapProvider;
import com.facebook.inject.Lazy;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.reportaproblem.base.bugreport.file.BugReportUiDataProvider;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: complete_create_account */
public class SmsTakeOverBugReportExtraDataMapProvider implements BugReportExtraDataMapProvider, BugReportUiDataProvider {
    private final Context f17482a;
    public final FbSharedPreferences f17483b;
    private final Lazy<SmsIntegrationState> f17484c;
    private final Lazy<SmsTakeoverMultiverseExperimentHelper> f17485d;
    private final Lazy<MmsSmsErrorCache> f17486e;

    @Inject
    public SmsTakeOverBugReportExtraDataMapProvider(Context context, FbSharedPreferences fbSharedPreferences, Lazy<SmsIntegrationState> lazy, Lazy<SmsTakeoverMultiverseExperimentHelper> lazy2, Lazy<MmsSmsErrorCache> lazy3) {
        this.f17482a = context;
        this.f17483b = fbSharedPreferences;
        this.f17484c = lazy;
        this.f17485d = lazy2;
        this.f17486e = lazy3;
    }

    @TargetApi(19)
    public final Map<String, String> m17466c() {
        Builder a = ImmutableMap.builder().a(m17463a());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append("  sms_in_readonly_mode: ").append(this.f17483b.a(SmsPrefKeys.b, false)).append('\n');
        stringBuilder.append("  messenger_been_sms_default_app: ").append(this.f17483b.a(SmsPrefKeys.B, false)).append('\n');
        stringBuilder.append("  sms_hide_inbox_filter: ").append(this.f17483b.a(SmsPrefKeys.I, false)).append('\n');
        stringBuilder.append("  sms_anonymous_promo: ").append(this.f17483b.a(SmsPrefKeys.d, false)).append('\n');
        return a.a(ImmutableBiMap.b("SmsTakeoverPrefKeys", stringBuilder.toString())).b();
    }

    private ImmutableMap<String, String> m17463a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append("  IsDefaultSmsApp: ").append(((SmsIntegrationState) this.f17484c.get()).d()).append('\n');
        stringBuilder.append("  DefaultSmsApp: ").append(m17464e()).append('\n');
        stringBuilder.append("  IsInReadonlyMode: ").append(((SmsIntegrationState) this.f17484c.get()).b()).append('\n');
        stringBuilder.append("  IsOptInEnabled: ").append(((SmsTakeoverMultiverseExperimentHelper) this.f17485d.get()).b()).append('\n');
        stringBuilder.append("  HasSeenNux: ").append(((SmsTakeoverMultiverseExperimentHelper) this.f17485d.get()).c()).append('\n');
        StringBuilder append = stringBuilder.append("  HasSeenAnyOptin: ");
        SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper = (SmsTakeoverMultiverseExperimentHelper) this.f17485d.get();
        boolean z = false;
        if (smsTakeoverMultiverseExperimentHelper.c() || smsTakeoverMultiverseExperimentHelper.c.a(SmsPrefKeys.r, false)) {
            z = true;
        }
        append.append(z).append('\n');
        stringBuilder.append("  SmsRecentFailureCode: ").append(((MmsSmsErrorCache) this.f17486e.get()).m17417a()).append('\n');
        return ImmutableBiMap.b("SmsTakeoverInfo", stringBuilder.toString());
    }

    public final Map<String, String> m17467d() {
        return null;
    }

    public final Map<String, String> m17465a(Activity activity) {
        return null;
    }

    private String m17464e() {
        try {
            return Sms.getDefaultSmsPackage(this.f17482a);
        } catch (Throwable th) {
            return "Error getting default SMS App: " + th.getMessage();
        }
    }
}
