package com.facebook.messaging.quickpromotion;

import com.facebook.debug.log.BLog;
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

/* compiled from: reg_terms_contacts_v2 */
public class SmsTakeoverFullThreadViewBannerEligibleFilterPredicate extends AbstractContextualFilterPredicate {
    private final FbSharedPreferences f3791a;
    private final SmsIntegrationState f3792b;

    @Inject
    public SmsTakeoverFullThreadViewBannerEligibleFilterPredicate(FbSharedPreferences fbSharedPreferences, SmsIntegrationState smsIntegrationState) {
        this.f3791a = fbSharedPreferences;
        this.f3792b = smsIntegrationState;
    }

    public final boolean m3596a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        String str = null;
        if (interstitialTrigger != null) {
            try {
                if (interstitialTrigger.a != null) {
                    str = interstitialTrigger.a.a("thread_type");
                }
            } catch (Throwable e) {
                BLog.c("SmsTakeoverFullThreadViewBannerEligibleFilterPredicate", e, "Failed to get type of thread", new Object[0]);
                return false;
            }
        }
        boolean z = (str == null || Type.valueOf(str) != Type.SMS || this.f3791a.a(SmsPrefKeys.c) || this.f3791a.a(SmsPrefKeys.G, false) || !this.f3792b.d()) ? false : true;
        if (z == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
