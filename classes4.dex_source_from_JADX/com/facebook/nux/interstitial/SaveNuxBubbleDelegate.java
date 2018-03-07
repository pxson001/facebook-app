package com.facebook.nux.interstitial;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: profile_user_tile_view */
public class SaveNuxBubbleDelegate extends BaseNuxDelegate {
    private final SaveAnalyticsLogger f4093a;
    public NuxItemInfo f4094b;

    /* compiled from: profile_user_tile_view */
    public interface NuxItemInfo {
        boolean mo332a();

        String mo333b();

        String mo334c();

        String mo335d();

        CurationSurface mo336e();

        CurationMechanism mo337f();
    }

    @Inject
    public SaveNuxBubbleDelegate(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, Clock clock, InterstitialManager interstitialManager, SaveAnalyticsLogger saveAnalyticsLogger) {
        super(objectMapper, abstractFbErrorReporter, fbSharedPreferences, interstitialManager, clock);
        this.f4093a = saveAnalyticsLogger;
    }

    public final void mo330a() {
        super.mo330a();
        this.f4093a.a(this.f4094b.mo333b(), this.f4094b.mo334c(), this.f4094b.mo335d(), this.f4094b.mo336e(), this.f4094b.mo337f());
    }

    public final boolean mo331a(InterstitialTrigger interstitialTrigger) {
        if (this.f4094b == null || this.f4094b.mo332a()) {
            return false;
        }
        return super.mo331a(interstitialTrigger);
    }
}
