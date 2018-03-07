package com.facebook.quickpromotion.filter;

import com.facebook.common.time.Clock;
import com.facebook.quickpromotion.event.QuickPromotionEventManager;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_overlay_display_attempted */
public class SecondsSinceMeteredConnectionChangedFilter extends AbstractContextualFilterPredicate {
    private final QuickPromotionEventManager f4734a;
    private final Clock f4735b;

    @Inject
    public SecondsSinceMeteredConnectionChangedFilter(QuickPromotionEventManager quickPromotionEventManager, Clock clock) {
        this.f4735b = clock;
        this.f4734a = quickPromotionEventManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4734a.g + (Long.parseLong(contextualFilter.value) * 1000) >= this.f4735b.a();
    }
}
