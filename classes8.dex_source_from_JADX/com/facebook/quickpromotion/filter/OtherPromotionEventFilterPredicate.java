package com.facebook.quickpromotion.filter;

import com.facebook.common.time.Clock;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_profile_image_size_small */
public class OtherPromotionEventFilterPredicate extends AbstractContextualFilterPredicate {
    public final QuickPromotionCounters f4716a;
    public final Clock f4717b;

    /* compiled from: reaction_profile_image_size_small */
    enum StoryboardEvents {
        IMPRESSION,
        PRIMARY_ACTION,
        SECONDARY_ACTION,
        DISMISS_ACTION,
        UNKNOWN;

        public static StoryboardEvents fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: reaction_profile_image_size_small */
    enum StoryboardMetrics {
        SECONDS_SINCE_GREATER_THAN,
        SECONDS_SINCE_LESS_THAN,
        COUNT_AT_LEAST,
        COUNT_AT_MOST,
        UNKNOWN;

        public static StoryboardMetrics fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    @Inject
    public OtherPromotionEventFilterPredicate(QuickPromotionCounters quickPromotionCounters, Clock clock) {
        this.f4716a = quickPromotionCounters;
        this.f4717b = clock;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        String str = contextualFilter.value;
        if (contextualFilter.b().get("event_count") == null) {
            return contextualFilter.passIfNotSupported;
        }
        QuickPromotionCounters$CounterType quickPromotionCounters$CounterType;
        long parseLong = Long.parseLong((String) contextualFilter.b().get("event_count"));
        String str2 = (String) contextualFilter.b().get("metric");
        switch (StoryboardEvents.fromString((String) contextualFilter.b().get("event"))) {
            case IMPRESSION:
                quickPromotionCounters$CounterType = QuickPromotionCounters$CounterType.IMPRESSION;
                break;
            case PRIMARY_ACTION:
                quickPromotionCounters$CounterType = QuickPromotionCounters$CounterType.PRIMARY_ACTION;
                break;
            case SECONDARY_ACTION:
                quickPromotionCounters$CounterType = QuickPromotionCounters$CounterType.SECONDARY_ACTION;
                break;
            case DISMISS_ACTION:
                quickPromotionCounters$CounterType = QuickPromotionCounters$CounterType.DISMISS_ACTION;
                break;
            default:
                return contextualFilter.passIfNotSupported;
        }
        switch (StoryboardMetrics.fromString(str2)) {
            case SECONDS_SINCE_GREATER_THAN:
                boolean z;
                if (this.f4717b.a() - this.f4716a.b(str, quickPromotionCounters$CounterType) >= 1000 * parseLong) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            case SECONDS_SINCE_LESS_THAN:
                return m4580b(quickPromotionCounters$CounterType, str, parseLong);
            case COUNT_AT_LEAST:
                return m4581c(quickPromotionCounters$CounterType, str, parseLong);
            case COUNT_AT_MOST:
                return m4582d(quickPromotionCounters$CounterType, str, parseLong);
            default:
                return contextualFilter.passIfNotSupported;
        }
    }

    private boolean m4580b(QuickPromotionCounters$CounterType quickPromotionCounters$CounterType, String str, long j) {
        return this.f4717b.a() - this.f4716a.b(str, quickPromotionCounters$CounterType) <= 1000 * j;
    }

    private boolean m4581c(QuickPromotionCounters$CounterType quickPromotionCounters$CounterType, String str, long j) {
        return ((long) this.f4716a.a(str, quickPromotionCounters$CounterType)) >= j;
    }

    private boolean m4582d(QuickPromotionCounters$CounterType quickPromotionCounters$CounterType, String str, long j) {
        return ((long) this.f4716a.a(str, quickPromotionCounters$CounterType)) <= j;
    }
}
