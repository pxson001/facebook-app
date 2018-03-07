package com.facebook.messaging.quickpromotion;

import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reg_login_profile_pic */
public class SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate extends AbstractContextualFilterPredicate {
    private final FbSharedPreferences f3793a;
    private final SmsIntegrationState f3794b;
    private final Lazy<Clock> f3795c;

    @Inject
    public SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate(FbSharedPreferences fbSharedPreferences, SmsIntegrationState smsIntegrationState, Lazy<Clock> lazy) {
        this.f3793a = fbSharedPreferences;
        this.f3794b = smsIntegrationState;
        this.f3795c = lazy;
    }

    public final boolean m3597a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        String str = null;
        if (interstitialTrigger != null) {
            try {
                if (interstitialTrigger.a != null) {
                    str = interstitialTrigger.a.a("thread_type");
                }
            } catch (Throwable e) {
                BLog.c("SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate", e, "Failed to get type of thread", new Object[0]);
                return false;
            }
        }
        boolean z = this.f3794b.b() && str != null && Type.valueOf(str) == Type.SMS && !this.f3793a.a(SmsPrefKeys.F, false) && ((Clock) this.f3795c.get()).a() < this.f3793a.a(SmsPrefKeys.u, 0) + 86400000 && !this.f3793a.a(SmsPrefKeys.B, false);
        if (z == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
