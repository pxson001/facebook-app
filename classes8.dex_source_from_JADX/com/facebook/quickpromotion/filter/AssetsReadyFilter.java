package com.facebook.quickpromotion.filter;

import com.facebook.quickpromotion.asset.QuickPromotionAssetManagerImpl;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: readable_card_type */
public class AssetsReadyFilter extends AbstractContextualFilterPredicate {
    private final QuickPromotionAssetManagerImpl f4691a;

    @Inject
    public AssetsReadyFilter(QuickPromotionAssetManagerImpl quickPromotionAssetManagerImpl) {
        this.f4691a = quickPromotionAssetManagerImpl;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        return Boolean.parseBoolean(contextualFilter.value) ? this.f4691a.a(quickPromotionDefinition) : true;
    }

    public final void mo219b(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        super.mo219b(quickPromotionDefinition, contextualFilter);
        this.f4691a.b(quickPromotionDefinition);
    }
}
