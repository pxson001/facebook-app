package com.facebook.messaging.quickpromotion;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.messaging.photoreminders.PhotoRemindersNuxTriggerManager;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_account_creation_error */
public class PhotoRemindersNuxEligibleFilterPredicate extends AbstractContextualFilterPredicate {
    private PhotoRemindersNuxTriggerManager f3747a;

    @Inject
    public PhotoRemindersNuxEligibleFilterPredicate(PhotoRemindersNuxTriggerManager photoRemindersNuxTriggerManager) {
        this.f3747a = photoRemindersNuxTriggerManager;
    }

    public final boolean m3554a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        return Boolean.parseBoolean(contextualFilter.value) == this.f3747a.m3398a();
    }
}
