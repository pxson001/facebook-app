package com.facebook.quickpromotion.filter;

import com.facebook.common.time.Clock;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_hscroll_component_impression */
public class TimeSinceImpressionFilter extends AbstractContextualFilterPredicate {
    private final QuickPromotionCounters f4742a;
    private final Clock f4743b;

    @Inject
    public TimeSinceImpressionFilter(QuickPromotionCounters quickPromotionCounters, Clock clock) {
        this.f4742a = quickPromotionCounters;
        this.f4743b = clock;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        return this.f4743b.a() >= this.f4742a.d(quickPromotionDefinition, QuickPromotionCounters$CounterType.IMPRESSION) + (Long.parseLong(contextualFilter.value) * 1000);
    }
}
