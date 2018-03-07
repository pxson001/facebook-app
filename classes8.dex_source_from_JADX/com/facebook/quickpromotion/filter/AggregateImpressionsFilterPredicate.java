package com.facebook.quickpromotion.filter;

import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: red-eye */
public class AggregateImpressionsFilterPredicate extends AbstractContextualFilterPredicate {
    private final QuickPromotionCounters f4685a;

    @Inject
    public AggregateImpressionsFilterPredicate(QuickPromotionCounters quickPromotionCounters) {
        this.f4685a = quickPromotionCounters;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        long a;
        Preconditions.checkNotNull(contextualFilter.value);
        long parseLong = Long.parseLong(contextualFilter.value);
        long j = 0;
        for (String a2 : contextualFilter.b().keySet()) {
            a = ((long) this.f4685a.a(a2, QuickPromotionCounters$CounterType.IMPRESSION)) + j;
            if (a >= parseLong) {
                break;
            }
            j = a;
        }
        a = j;
        return a < parseLong;
    }
}
