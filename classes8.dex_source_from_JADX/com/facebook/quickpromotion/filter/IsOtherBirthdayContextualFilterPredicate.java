package com.facebook.quickpromotion.filter;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;

/* compiled from: reaction_stories */
public class IsOtherBirthdayContextualFilterPredicate extends AbstractContextualFilterPredicate {
    public final boolean mo222a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        if (interstitialTrigger == null || interstitialTrigger.a == null || Boolean.valueOf(interstitialTrigger.a.a("target_user_is_birthday")).booleanValue() != Boolean.valueOf(contextualFilter.value).booleanValue()) {
            return false;
        }
        return true;
    }
}
