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

/* compiled from: region_id */
public class C0584x62f2bcbd extends AbstractContextualFilterPredicate {
    private final FbSharedPreferences f3788a;
    private final SmsIntegrationState f3789b;
    private final Lazy<Clock> f3790c;

    @Inject
    public C0584x62f2bcbd(FbSharedPreferences fbSharedPreferences, SmsIntegrationState smsIntegrationState, Lazy<Clock> lazy) {
        this.f3788a = fbSharedPreferences;
        this.f3789b = smsIntegrationState;
        this.f3790c = lazy;
    }

    public final boolean m3595a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        String str = null;
        if (interstitialTrigger != null) {
            try {
                if (interstitialTrigger.a != null) {
                    str = interstitialTrigger.a.a("thread_type");
                }
            } catch (Throwable e) {
                BLog.c("SmsTakeoverDelayedReadOnlyThreadViewBannerEligibleFilterPredicate", e, "Failed to get type of thread", new Object[0]);
                return false;
            }
        }
        boolean z = this.f3789b.b() && str != null && Type.valueOf(str) == Type.SMS && !this.f3788a.a(SmsPrefKeys.E, false) && (((Clock) this.f3790c.get()).a() > this.f3788a.a(SmsPrefKeys.u, 0) + 86400000 || this.f3788a.a(SmsPrefKeys.B, false));
        if (z == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
