package com.facebook.quickpromotion.filter;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;

/* compiled from: reaction_header_displayed */
public class UserRankContextualFilterPredicate extends AbstractContextualFilterPredicate {
    public final boolean mo222a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        if (interstitialTrigger == null || interstitialTrigger.a == null || !interstitialTrigger.a.a().contains("target_user_rank")) {
            return false;
        }
        try {
            if (Float.parseFloat(interstitialTrigger.a.a("target_user_rank")) >= Float.parseFloat(contextualFilter.value)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
