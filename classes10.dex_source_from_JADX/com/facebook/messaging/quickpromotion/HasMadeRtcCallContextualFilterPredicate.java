package com.facebook.messaging.quickpromotion;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.rtc.models.RecentCallsDb;
import com.facebook.rtc.models.RecentCallsDb.6;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_contacts_terms_accept */
public class HasMadeRtcCallContextualFilterPredicate extends AbstractContextualFilterPredicate {
    private final RecentCallsDb f3732a;

    @Inject
    public HasMadeRtcCallContextualFilterPredicate(RecentCallsDb recentCallsDb) {
        this.f3732a = recentCallsDb;
    }

    public final boolean m3542a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        ImmutableList immutableList;
        RecentCallsDb recentCallsDb = this.f3732a;
        if (recentCallsDb.h != null) {
            immutableList = recentCallsDb.h;
        } else {
            ExecutorDetour.a(recentCallsDb.e, new 6(recentCallsDb, 5), 253803325);
            immutableList = null;
        }
        ImmutableList a = RecentCallsDb.a(immutableList);
        if (a == null) {
            return false;
        }
        if ((!a.isEmpty()) == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
