package com.facebook.quickpromotion.filter;

import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;

/* compiled from: reaction_unit_ids */
public class DirectInstallEnabledFilterPredicate extends AbstractContextualFilterPredicate {
    public final boolean mo217a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return !Boolean.parseBoolean(contextualFilter.value);
    }
}
