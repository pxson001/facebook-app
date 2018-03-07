package com.facebook.quickpromotion.filter;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_images */
public class TimeSinceForegroundFilterPredicate extends AbstractContextualFilterPredicate {
    private final AppStateManager f4741a;

    @Inject
    public TimeSinceForegroundFilterPredicate(AppStateManager appStateManager) {
        this.f4741a = appStateManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4741a.e() >= Long.parseLong(contextualFilter.value) * 1000;
    }
}
