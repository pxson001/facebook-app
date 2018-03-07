package com.facebook.messaging.quickpromotion;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.messaging.photoreminders.PhotoRemindersGatingUtil;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_account_creation_needs_completion */
public class PhotoRemindersEverEnabledFilterPredicate extends AbstractContextualFilterPredicate {
    private PhotoRemindersGatingUtil f3746a;

    @Inject
    public PhotoRemindersEverEnabledFilterPredicate(PhotoRemindersGatingUtil photoRemindersGatingUtil) {
        this.f3746a = photoRemindersGatingUtil;
    }

    public final boolean m3553a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        return Boolean.parseBoolean(contextualFilter.value) == this.f3746a.d();
    }
}
