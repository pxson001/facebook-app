package com.facebook.quickpromotion.filter;

import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;

/* compiled from: reaction_header_interaction */
public class UnknownContextualFilterPredicate extends AbstractContextualFilterPredicate {
    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        return contextualFilter.passIfNotSupported;
    }
}
