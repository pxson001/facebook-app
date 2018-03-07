package com.facebook.quickpromotion.filter;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;

/* compiled from: redirect */
public abstract class AbstractContextualFilterPredicate {
    public boolean mo222a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        return mo217a(quickPromotionDefinition, contextualFilter);
    }

    public boolean mo217a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        return false;
    }

    public void mo219b(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
    }
}
