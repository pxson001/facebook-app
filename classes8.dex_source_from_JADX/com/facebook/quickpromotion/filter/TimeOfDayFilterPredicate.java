package com.facebook.quickpromotion.filter;

import com.facebook.common.time.SystemClock;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import java.util.Calendar;
import javax.annotation.Nonnull;

/* compiled from: reaction_overlay_display_aborted */
public abstract class TimeOfDayFilterPredicate extends AbstractContextualFilterPredicate {
    private final SystemClock f4736a;

    protected abstract boolean mo223a(long j, long j2);

    public TimeOfDayFilterPredicate(SystemClock systemClock) {
        this.f4736a = systemClock;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        long parseLong = Long.parseLong(contextualFilter.value);
        long a = this.f4736a.a();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(a);
        instance.set(14, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(11, 0);
        return mo223a((a - instance.getTimeInMillis()) / 1000, parseLong);
    }
}
