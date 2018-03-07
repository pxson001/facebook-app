package com.facebook.timeline.profilevideo.qp.filter;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mLocationInfo */
public class ProfileVideoCannotViewFilter extends AbstractContextualFilterPredicate {
    private final QeAccessor f9392a;

    @Inject
    public ProfileVideoCannotViewFilter(QeAccessor qeAccessor) {
        this.f9392a = qeAccessor;
    }

    public final boolean mo222a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        if (interstitialTrigger == null || interstitialTrigger.a == null || this.f9392a.a(ExperimentsForTimelineAbTestModule.aS, false) || interstitialTrigger.a.a("context_profile_has_profile_video") == null) {
            return false;
        }
        return true;
    }
}
