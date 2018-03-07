package com.facebook.quickpromotion.filter;

import com.facebook.common.network.FbNetworkManager;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_supported_action_styles */
public class IsMeteredConnectionFilter extends AbstractContextualFilterPredicate {
    private final FbNetworkManager f4700a;

    @Inject
    public IsMeteredConnectionFilter(FbNetworkManager fbNetworkManager) {
        this.f4700a = fbNetworkManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4700a.h() == Boolean.parseBoolean(contextualFilter.value);
    }
}
