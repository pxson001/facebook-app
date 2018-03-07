package com.facebook.quickpromotion.filter;

import com.facebook.common.time.Clock;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.inject.Inject;

/* compiled from: reaction_info_row_icon_size */
public class TimeSinceDismissFilter extends AbstractContextualFilterPredicate {
    private final QuickPromotionCounters f4739a;
    private final Clock f4740b;

    @Inject
    public TimeSinceDismissFilter(QuickPromotionCounters quickPromotionCounters, Clock clock) {
        this.f4739a = quickPromotionCounters;
        this.f4740b = clock;
    }

    public final boolean mo217a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        return this.f4740b.a() >= this.f4739a.d(quickPromotionDefinition, QuickPromotionCounters$CounterType.DISMISSAL) + (Long.parseLong(contextualFilter.value) * 1000);
    }
}
