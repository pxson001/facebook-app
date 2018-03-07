package com.facebook.quickpromotion.filter;

import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_supported_attachment_styles */
public class GooglePlayContextualFilterPredicate extends AbstractContextualFilterPredicate {
    private final GooglePlayIntentHelper f4699a;

    @Inject
    public GooglePlayContextualFilterPredicate(GooglePlayIntentHelper googlePlayIntentHelper) {
        this.f4699a = googlePlayIntentHelper;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4699a.b() == Boolean.parseBoolean(contextualFilter.value);
    }
}
