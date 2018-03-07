package com.facebook.quickpromotion.filter;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceState;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reaction_page_error */
public class RtcPresenceContextualFilterPredicate extends AbstractContextualFilterPredicate {
    private final RtcPresenceHandler f4727a;

    @Inject
    public RtcPresenceContextualFilterPredicate(RtcPresenceHandler rtcPresenceHandler) {
        this.f4727a = rtcPresenceHandler;
    }

    public final boolean mo222a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        if (interstitialTrigger == null || interstitialTrigger.a == null) {
            return false;
        }
        RtcPresenceState a = this.f4727a.a(UserKey.b(interstitialTrigger.a.a("target_user_id")));
        Preconditions.checkNotNull(contextualFilter.value);
        if (a.f7823a == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
