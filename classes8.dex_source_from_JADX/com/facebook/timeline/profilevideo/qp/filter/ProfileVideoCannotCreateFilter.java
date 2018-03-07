package com.facebook.timeline.profilevideo.qp.filter;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mLongitude */
public class ProfileVideoCannotCreateFilter extends AbstractContextualFilterPredicate {
    private final QeAccessor f9391a;

    @Inject
    public ProfileVideoCannotCreateFilter(QeAccessor qeAccessor) {
        this.f9391a = qeAccessor;
    }

    public final boolean mo222a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        if (interstitialTrigger == null || interstitialTrigger.a == null) {
            return false;
        }
        boolean a = this.f9391a.a(ExperimentsForTimelineAbTestModule.aS, false);
        boolean a2 = this.f9391a.a(ExperimentsForTimelineAbTestModule.aK, false);
        if (!a || a2 || interstitialTrigger.a.a("context_profile_has_profile_video") == null) {
            return false;
        }
        return true;
    }
}
