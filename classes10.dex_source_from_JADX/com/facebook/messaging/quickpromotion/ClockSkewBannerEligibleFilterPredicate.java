package com.facebook.messaging.quickpromotion;

import com.facebook.messaging.clockskew.EstimatedServerClock;
import com.facebook.messaging.clockskew.EstimatedServerClock.State;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.inject.Inject;

/* compiled from: registration_cp_suggestion_call_success */
public class ClockSkewBannerEligibleFilterPredicate extends AbstractContextualFilterPredicate {
    private final EstimatedServerClock f3729a;

    @Inject
    public ClockSkewBannerEligibleFilterPredicate(EstimatedServerClock estimatedServerClock) {
        this.f3729a = estimatedServerClock;
    }

    public final boolean m3539a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        if ((this.f3729a.g == State.SKEWED) == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
